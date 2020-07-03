package com.job.coverletter.Elastic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.bytes.BytesReference;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.job.coverletter.controller.JobController;
import com.job.coverletter.model.company.dto.CompanyDto;

public class ElasicHighLeverTemplat {
	
	private String host = "localhost";
	private int port1 = 9200;
	private int port2 = 9201;
	private Logger logger = LoggerFactory.getLogger(ElasicHighLeverTemplat.class);
	
	public String callSearchQuery(CompanyDto dto) {
		String[] valueArray = {dto.getBusiness(), dto.getLanguages(), dto.getLocation(), dto.getLocation(), 
				   dto.getTarget(), dto.getEnddate(), dto.getSalary()};
		String[] keyArray = {"business", "languages", "locaton", "target", 
				 "enddate", "totalmember", "salary"};
		SearchTemplateResponse response = null;
		SearchResponse searchResponse = null;
		
		SearchTemplateRequest request = new SearchTemplateRequest();
		request.setRequest(new SearchRequest("nlpdb-2020.80.20.temp")); 	// index 추가
		request.setScriptType(ScriptType.INLINE);							// 템플릿 설정 타입
		
		// DSL 쿼리문 적용(키에 대한 값 비어있음) 
		request.setScript(getGETQueryJson(dto)); 
		
		System.out.println("쿼리 : " +getGETQueryJson(dto));
		
		// DSL 쿼리문 값 적용
		Map<String, Object> scriptParams = new HashMap<>();
		scriptParams.put("size", 10);
		scriptParams.put("from", dto.getFrom());
		//scriptParams.put("_source", "[companyseq, imgurl, business, enddate, oneintro, mainfield, languages, companyname, location, salary, target]");
		
		for(int i = 0; i < valueArray.length; i++) {
			if(valueArray[i] != null) {
				scriptParams.put(keyArray[i], valueArray[i]);
			}
		}
		request.setScriptParams(scriptParams); 
        
		
		try(RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port1, "http")))){
			//request
			//동기 실행
			response = client.searchTemplate(request, RequestOptions.DEFAULT);
			searchResponse = response.getResponse();
			System.out.println("결과: " + searchResponse);
			//System.out.println(response.toString());
			
		} catch (IOException e) {
			logger.info("Elastic Error");
			e.printStackTrace();
		};
		return searchResponse.toString();
	}

	
	public String getGETQueryJson(CompanyDto dto) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();

		String[] keyArray = {"business", "languages", "locaton", "target", 
							 "enddate", "totalmember", "salary"};
		String[] valueArray = {dto.getBusiness(), dto.getLanguages(), dto.getLocation(), dto.getLocation(), 
							   dto.getTarget(), dto.getEnddate(), dto.getSalary()};
		
		List<String> keywords = new ArrayList<String>();
		
		for(int i = 0; i < 7; i++) {
			if(!((valueArray[i] == null))) {
				//String keywordJson = "{\"match\": {\""+ keyArray[i] + "\": \"" + valueArray[i] + "\"}}";
				String keywordJson = "{\"match\": {\""+ keyArray[i] + "\":" + "\"{{" + keyArray[i] + "}}\"}}";
				keywords.add(keywordJson);
			}
		}
		String must = "{" + "\"must\"" + ":" + keywords.toString() + "}";
		
		String bool = "{" + "\"bool\"" + ":" + must + "}";
		
		Map<String,String> desc = new HashMap<String,String>();
		desc.put("companyseq", "desc");
		String descJson = gson.toJson(desc);
		
		List<String> sortList = new ArrayList<String>();
		sortList.add(descJson);
		
//		String query = "{" + "\"query\"" + ":" + bool + "," + "\"from\"" + ":" + "{{from}}" + "," + "\"size\"" + ":" + "{{size}}" + ", " 
//		+ "\"_source\"" + ":" + "\"{{_source}}\"" +"}";
		String query = "{" + "\"query\"" + ":" + bool + "," + "\"from\"" + ":" + "{{from}}" + "," + "\"size\"" + ":" + "{{size}}" + "}";
				
		
		return query;
	}
	
	public static void main(String[] args) {
//	
//		ElasicHighLeverTemplat test = new ElasicHighLeverTemplat();
//		CompanyDto dto = new CompanyDto();
//		dto.setBusiness("개발자");
//		dto.setLanguages("java");
//		dto.setFrom("0");
//		
//		String a = test.getGETQueryJson(dto);
//		System.out.println(a);
//		
//		test.callSearchQuery(dto);
		
		
		//List<String> sortList = new ArrayList<String>();
		//sortList.add(descJson);
		
		
		
		
		
	}
}
