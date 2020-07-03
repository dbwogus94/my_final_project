<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
</head>
<body>
	<script type="text/javascript">
	$(function(){
		var pay = ${kakao};
		var key = pay.next_redirect_pc_url;
		window.open(key,"","width=800px, height=600px");
		self.close();
		console.log(key);
		console.log(typeof(key));
	});
</script>

	
</body>
</html>