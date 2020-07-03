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
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.job.coverletter.model.company.dto.CompanyDto;

public class ElasticHighLeverAPI {
	
	private String host = "localhost";
	private int port1 = 9200;
	private int port2 = 9201;
	
	public Map<String, Object> callSearchQuery(Map<String, String> map, CompanyDto dto) {
		String fieldName = "languages";
		
//		SearchRequest request = new SearchRequest(); 
//		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 
//		searchSourceBuilder.query(QueryBuilders.matchAllQuery()); 
//		request.source(searchSourceBuilder); 
		
		SearchSourceBuilder sourceBuilder  = new SearchSourceBuilder();
		sourceBuilder.query(QueryBuilders.matchQuery("languages", "java"));
		sourceBuilder.query(QueryBuilders.matchQuery("business", "웹개발"));
		
		//MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(fieldName, "java");
		//sourceBuilder.query(matchQueryBuilder);
		sourceBuilder.from(2);
        sourceBuilder.size(3);
        sourceBuilder.sort(new FieldSortBuilder("companyseq").order(SortOrder.DESC));


		SearchRequest request = new SearchRequest();
		request.indices("nlpdb-2020.80.20.temp");
		request.source(sourceBuilder);
        
        
        SearchResponse response = null;
        SearchHits searchHits = null;
		
		try(RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port1, "http")))){

			//request
			//동기 실행
			response = client.search(request, RequestOptions.DEFAULT);
			
			RestStatus status = response.status();
			TimeValue took = response.getTook();
			System.out.println("took: " + took);
			Boolean terminatedEarly = response.isTerminatedEarly();
			System.out.println("terminatedEarly: " + terminatedEarly);
			boolean timedOut = response.isTimedOut();
			
			
			int totalShards = response.getTotalShards();
			System.out.println("totalShards: " + totalShards);
			int successfulShards = response.getSuccessfulShards();
			System.out.println("successfulShards: " + successfulShards);
			int failedShards = response.getFailedShards();
			System.out.println("failedShards: " + failedShards);
			
			
			System.out.println(response);
			searchHits = response.getHits();
			 for( SearchHit hit : searchHits) {
				 String sourceAsString = hit.getSourceAsString();
				 System.out.println(sourceAsString);
				 Map<String, Object> sourceAsMap = hit.getSourceAsMap();
				 //System.out.println(sourceAsMap);
				 
	         }
			
		} catch (IOException e) {
			e.printStackTrace();
		};
		return null;
	}

	
	public String getGetQueryJson(CompanyDto dto) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();

		String[] keyArray = {"business", "languages", "locaton", "target", 
							 "enddate", "totalmember", "salary"};
		String[] valueArray = {dto.getBusiness(), dto.getLanguages(), dto.getLocation(), dto.getLocation(), 
							   dto.getTarget(), dto.getEnddate(), dto.getSalary()};
		
		List<String> keywords = new ArrayList<String>();
		
		//String keywordJson01 = "{\"match\": {\""+ "languages" +"\": \" " + "java" + "\"}}"; 
		
		for(int i = 0; i < 7; i++) {
			if(!(valueArray[i].equals("")) || (valueArray[i] == null)) {
				String keywordJson = "{\"match\": {\""+ keyArray[i] + "\": \" " + valueArray[i] + "\"}}";
				keywords.add(keywordJson);
			}
		}
		String must = "{" + "\"must\"" + ":" + keywords.toString() + "}";
		
		String bool = "{" + "\"bool\"" + ":" + must + "}";
		
		String query = "{" + "\"query\"" + ":" + bool + "}";
		
		Map<String,String> desc = new HashMap<String,String>();
		desc.put("companyseq", "desc");
		String descJson = gson.toJson(desc);
		
		List<String> sortList = new ArrayList<String>();
		sortList.add(descJson);
		
		List<String> source = new ArrayList<String>();
		source.add("companyseq");
		source.add("imgurl");
		source.add("business");
		source.add("enddate");
		source.add("oneintro");
		source.add("mainfield");
		source.add("languages");
		source.add("companyname");
		source.add("location");
		source.add("salary");
		source.add("target");
		
		String search = "{" + "\"from\"" + ":" + dto.getFrom() + "," + "\"size\"" + ":" + "10" + ", " + "\"_source\"" + ":" + source.toString() +","
				+ "\"sort\"" + ":" + sortList.toString() + "," + query + "}" ;
		
		//String search = query;

		return search;
	}
	
	public static void main(String[] args) {
		CompanyDto dto = new CompanyDto();
		dto.setBusiness("웹프로그래머");
		dto.setLanguages("java");
		dto.setFrom("0");
		
		ElasticHighLeverAPI test = new ElasticHighLeverAPI();
		test.callSearchQuery(null, dto);
		
		
	}
	
	
	
}
