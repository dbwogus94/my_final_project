<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- google -->
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id" content="839009669697-6ce1f5skpnk0s544iik3a5im8dktj7lc.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<!-- kakao -->
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<!-- include bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/CSS/ALL/header_logout.css">

<title>Insert title here</title>
</head>
<body>
   <div id="headerwap">
         <div id="logo">
         	<img alt="logo" src="${pageContext.request.contextPath}/resources/IMG/logo.png" onclick="location.href='MAIN_main.do'">
         </div>
            <div id="menu1">
               <span><a href="">공채캘린더</a></span> 
               <span><a href="JOB_jobSearch.do">채용검색</a> </span>
            </div>
            <div id="menu2">
               
               <span><a href="USER_login.do">로그인</a></span>
               <span >|</span>
               <span><a href="USER_join.do">회원가입</a></span>
            </div>    
   </div>

   
   <!-- body css적용 확인용
   <div id="container">
      <div class="side">a</div>
      <div id="center">b</div>
      <div class="side">a</div>
   </div>
     -->
    


</body>
</html>