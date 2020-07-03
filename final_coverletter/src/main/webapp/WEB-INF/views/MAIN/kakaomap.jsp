<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오맵</title>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/MAIN/kakaomap.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/MAIN/kakaomap.css"
	rel="stylesheet">
</head>
<body>
	<c:choose>
		<c:when test="${empty login }">
			<%@ include file="../ALL/header_logout.jsp"%>
		</c:when>
		<c:otherwise>
			<%@ include file="../ALL/header_login.jsp"%>
		</c:otherwise>
	</c:choose>
	<div class="container">


		<div class="all">

			<div class="left" id="kakaoMap-left">

				<div class="location" id="location">회사위치</div>

				<div class=info>
					<div id="img">
						<img class="img" src="${kakaomap_selectOne.imgurl}" />
					</div>

					<br>
					<div class="companyname">${kakaomap_selectOne.companyname }</div>
				</div>
				


				<div class="information">

					<div>
						<div class="title">설립일</div>
						<div class="content">${kakaomap_selectOne.incorporation }</div>
					</div>
					<div>
						<div class="title">홈페이지</div>
						<div class="content">${kakaomap_selectOne.homepage}</div>
					</div>
					<div>
						<div class="title">위치</div>
						<div class="content">${kakaomap_selectOne.location}</div>
					</div>
					<div>
						<div class="title">산업분야</div>
						<div class="content">${kakaomap_selectOne.mainfield}</div>
					</div>
				</div>






			</div>


			<div class="right" id="kakaoMap-right">

				<div id="map" style="width: 750px; height: 750px;"></div>
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d22781bca038bd72392c4a948603664f&libraries=services,clusterer,drawing"></script>
				<script>
					var container = document.getElementById('map');
					var options = {
						center : new kakao.maps.LatLng(33.450701, 126.570667),
						level : 3
					};
					var map = new kakao.maps.Map(container, options);
					
					var geocoder = new kakao.maps.services.Geocoder();

					// 주소로 좌표를 검색합니다
					geocoder.addressSearch('경기도 성남시 분당구 삼평동 판교로 242', function(result, status) {

					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {

					        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });

					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
					        });
					        infowindow.open(map, marker);

					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        map.setCenter(coords);
					    } 
					});    
					
				 
				</script>
 

			</div>


		</div>




	</div>


</body>
</html>