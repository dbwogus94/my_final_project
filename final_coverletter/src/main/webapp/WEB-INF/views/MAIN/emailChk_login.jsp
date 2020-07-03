<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 체크</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/CSS/MAIN/emailChk.css?ver=1">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/emailChk_login.js?ver=3"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<%
int RandomNumber=(int)(Math.floor(Math.random() * (9999-1000+1)) + 1000);
%>
<body>
	


   <form name="a" action="USER_mailSend.do" method="post" target="iframe2">
   <input type="hidden" id="number" name="number" value="<%=RandomNumber%>" >
   
   <fieldset id="feilde">
   <legend>이메일입력</legend>
   <div class="email-box">
   <input type="text" id="emailCheck" placeholder="email@google.com" >
   <input type="button" class="btn" id="validateID" value="아이디/비밀번호찾기" onclick="validate();" >
   <span id="errormessage"></span>
   </div>
   </fieldset>
   
   <fieldset id="feildeID" style="display: none;">
   <legend>이메일입력</legend>
   <div class="email-box">
   <input type="email" id="EmailID" name="EmailName" >
   <input class="btn" type="submit" value="인증코드전송"  id="submit"><br>
   <input type="text" id="EmailCode" placeholder="인증코드 작성" >
   <input class="btn" type="button" value="확인하기" id="chk2" onclick="EmailChk2(<%=RandomNumber%>);">
   <input class="btn" type="button"  id="chk" value="인증성공" onclick="EmailChk();" style="display: none;" ><br>
   </div>
   </fieldset>
   
   </form>
</body>
<iframe name="iframe2" style="display: none;"></iframe>
</html>