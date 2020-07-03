package com.job.coverletter.Elastic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ElasicrowAPI {

	private String host = "localhost";
	private int port = 9200;

	/**
	 * 엘라스틱서치에서 제공하는 api를 이용한 전송메소드
	 * 
	 * @param method
	 * @param url
	 * @param obj
	 * @param jsonData
	 * @return
	 */
	
	// 검색에 사용하기 위해 get방식의 _search 명령어 + 쿼리(json)사용 예정
	// 키값을 map으로 받아서 json으로 변환시켜서 적용해야함
	// 결과로 받은 json을 키에 따른 companyDto로 받아서 list에 넣어 컨트롤러에 전달

	// 자바카페 플러그인 얻어서 적용하고 싶음 + nori플러그인 튜닝해야함
	// 검색을 어떻게 설정할지 계획해야함
	// 결과에 따른 페이징해야함 받는 결과를 페이지로 쪼개서 뷰에서 비동기로 연결할지 생각중
	public Map<String, Object> callElasticApi_GET(String method, String url, Map<String, String> map, String jsonData) {
		Map<String, Object> result = new HashMap<String, Object>();

		// json으로 들어온 파라미터가 있을 경우 실행 안함 
		if(jsonData.equals("") || jsonData == null) {
			// map를 json으로 변환
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			jsonData = gson.toJson(map);	// map.put("id", "asd12sdnwe=="); 키와 값을  >>> {"id":"asd12sdnwe=="}
		}
		
		try (RestClient restClient = RestClient.builder(new HttpHost(host, port, "http")).build()) { // 자동으로 닫아준다.
			//Map<String, String> params = Collections.singletonMap("pretty", "true");

			// 엘라스틱서치에서 제공하는 response 객체
			Response response = null;					// 응답받을 객체
			Request request = new Request(method, url); // (get, url:/index/_search) 
			
			if (method.equals("GET")) {
				// 받아온 데이터를 json으로 보내고 application/json으로 읽게 요청설정
				HttpEntity entity = new NStringEntity(jsonData, ContentType.APPLICATION_JSON); 
				// 설정 적용
				request.setEntity(entity);
				//request.addParameter("pretty", "true"); 
				response = restClient.performRequest(request);
		
				// 앨라스틱서치에서 리턴되는 응답코드를 받는다
				int statusCode = response.getStatusLine().getStatusCode();
				// 엘라스틱서치에서 리턴되는 응답메시지를 받는다
				String responseBody = EntityUtils.toString(response.getEntity());
				
				// 결과 map에 추가
				result.put("resultCode", statusCode);
				result.put("resultBody", responseBody);
			} else {
				result.put("resultCode", 0);
				result.put("resultBody", "GET요청이 아닙니다.");
			}
		} catch (Exception e) {
			//요청 실패시 결과를 map에 추가 
			result.put("resultCode", -1);
			result.put("resultBody", e.toString());
		}

		return result;
	}

	
	// 가장기본적인 get post put delete 사용용도 
	public Map<String, Object> callElasticApi(String method, String url, Object dto, String jsonData) { 
		// 결과를 답을 map선언																							
		Map<String, Object> result = new HashMap<String, Object>();
        String jsonString = "";
        
        //json형태의 파라미터가 아니라면 받은 객체(dto)를 gson으로 만들어주자.	>>> post, put에 사용함
        if (jsonData == null) {
            Gson gson = new Gson();
            jsonString = gson.toJson(dto);
        } else {
            jsonString = jsonData;
        }
		// 엘라스틱서치에서 제공하는 restClient를 통해 엘라스틱서치에 접속한다
		try (RestClient restClient = RestClient.builder(new HttpHost(host, port)).build()) { // 자동으로 닫아준다.
			Map<String, String> params = Collections.singletonMap("pretty", "true");

			// 엘라스틱서치에서 제공하는 response 객체
			Response response = null;
			Request request = new Request(method, url); // method=(GET, POST, HEAD, etc) "get", "/"

			// 기본적인 GET DELETE는 json을 사용하지 않는다  
			if (method.equals("GET") || method.equals("DELETE")) {
				request.addParameter("pretty", "true"); // 요청시 옵션 : 응답시 이쁜모양(보기좋게 만든 json구조말함)으로 응답요청, true??
				response = restClient.performRequest(request); // 응답 = 요청실행

				// POST, PUT는 수정이기 때문에 보낼 값을 json타입으로 설정해야함
			} else {
				// HttpEntity entity = new NStringEntity("{\"json\":\"text\"}",ContentType.APPLICATION_JSON); // Gson 사용
				HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);	// 해당 json값을(내가 설정함) , "application/json" 으로 읽어달라는 요청 설정후 보낸다.
				request.addParameter("pretty", "true"); 		// 요청시 옵션
				request.setEntity(entity); 						// 요청시 옵션 >>> entity구조를, application/json로 읽어달라고 지정해서 요청

				response = restClient.performRequest(request); // 응답 = 요청실행
			}

			// 앨라스틱서치에서 리턴되는 응답코드를 받는다
			int statusCode = response.getStatusLine().getStatusCode();
			// 엘라스틱서치에서 리턴되는 응답메시지를 받는다
			String responseBody = EntityUtils.toString(response.getEntity());
			result.put("resultCode", statusCode);
			result.put("resultBody", responseBody);

		} catch (Exception e) {
			result.put("resultCode", -1);
			result.put("resultBody", e.toString());
		}
		return result;
	}

}
