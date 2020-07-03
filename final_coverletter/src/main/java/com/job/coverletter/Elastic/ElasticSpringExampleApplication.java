package com.job.coverletter.Elastic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.job.coverletter.model.company.dto.CompanyDto;
import com.job.coverletter.model.joinUser.dto.JoinUserDto;

public class ElasticSpringExampleApplication {

	@Autowired
	ElasicrowAPI elasticApi = new ElasicrowAPI();

	private final String ELASTIC_INDEX = "nlpdb-2020.80.20.temp";
	private final String ELASTIC_TYPE = "_doc";
/*	
	public void 엘라스틱서치_POST_전송() {
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE;
		CompanyDto weather = new CompanyDto();
		Map<String, Object> result = elasticApi.callElasticApi("POST", url, weather, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}
	public void 엘라스틱서치_PUT_전송() {
		String id = "122345";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
		CompanyDto weather = new CompanyDto();
		Map<String, Object> result = elasticApi.callElasticApi("PUT", url, weather, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}
	public void 앨라스틱서치_GET_전송() {
		String id = "30";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE+"/"+id;
		Map<String, Object> result = elasticApi.callElasticApi_GET("GET", url, null, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}
	public void 앨라스틱서치_DELETE_전송() {
		String id = "";
		String url = ELASTIC_INDEX + "/" + ELASTIC_TYPE + "/" + id;
		Map<String, Object> result = elasticApi.callElasticApi("DELETE", url, null, null);
		System.out.println(result.get("resultCode"));
		System.out.println(result.get("resultBody"));
	}
*/
	
	
	public String jabSearchRes(CompanyDto searchKeyWord){
		
		String url = ELASTIC_INDEX + "/_search";			// 주소 뒷부분
		
		String json = getGetQueryJson(searchKeyWord);
		
		//List<CompanyDto> companyList = new ArrayList<CompanyDto>();
		//Map<String, String> query = new HashMap<String, String>();  
	 
		//elastic 요청
		Map<String, Object> result = elasticApi.callElasticApi_GET("GET", url, null, json);
		System.out.println(result.get("resultCode"));
		String jsonString = (String) result.get("resultBody");
		//System.out.println(jsonString);
		return jsonString;		
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
			if(!(valueArray[i].equals("") || valueArray[i] == null)) {
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

		return search;
	}
	
	
	
	public static void main(String[] args) {
		ElasticSpringExampleApplication test = new ElasticSpringExampleApplication();
		
//		CompanyDto dto = new CompanyDto();
//		dto.setBusiness("웹프로그래머");
//		dto.setLanguages("java");
//		
//		System.out.println(test.getGetQueryJson(dto, 0));
//		
//		JoinUserDto dto = new JoinUserDto();
//		dto.setJoinemail("uesr@gmail.com");
//		dto.setJoinpw("1234a");
//		dto.setJoinname("유저1");
//		dto.setJoinsex("m");
//		dto.setJoinseq(1);
//		String user = new Gson().toJson(dto);
//		System.out.println(user);		
		
		
//		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//		
//		String keywordJson01 = "{\"match\": {\""+ "languages" +"\": \" " + "java" + "\"}}"; 
//		String keywordJson02 = "{\"match\": {\""+ "business" +"\": \" " + "개발" + "\"}}"; 
//		List<String> keywords = new ArrayList<String>();
//		keywords.add(keywordJson01);
//		keywords.add(keywordJson02);
//		
//		String must = "{" + "\"must\"" + ":" + keywords.toString() + "}";
//		
//		String bool = "{" + "\"bool\"" + ":" + must + "}";
//		
//		String query = "{" + "\"query\"" + ":" + bool + "}";
//		
//		Map<String,String> desc = new HashMap<String,String>();
//		desc.put("companyseq", "desc");
//		String descJson = gson.toJson(desc);
//		
//		List<String> sortList = new ArrayList<String>();
//		sortList.add(descJson);
//		
//		
//		List<String> source = new ArrayList<String>();
//		source.add("companyseq");
//		source.add("imgurl");
//		source.add("business");
//		source.add("enddate");
//		source.add("oneintro");
//		source.add("mainfield");
//		source.add("languages");
//		source.add("companyname");
//		source.add("location");
//		source.add("salary");
//		source.add("target");
//		
//		
//		
//		String from = "{" + "\"from\"" + ":" + "0" + "," + "\"size\"" + "10" + "," + "\"_source\"" + ":" + source.toString() +","
//				+ "\"sort\"" + ":" + sortList.toString() + "," + query + "}" ;
//		System.out.println(from);
//		
		
		
	}
	
	

}
