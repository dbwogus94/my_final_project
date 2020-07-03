<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/MAIN/join.js?ver=2"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/MAIN/join.css" rel="stylesheet">
</head>

<body>
   <%@ include file="../ALL/header_logout.jsp"%>

   <div class="container" style="height: 800px;">
   

         <f:form action="USER_joinRes.do" method="post" modelAttribute="joinUserDto" onsubmit="return confirmSubmit()">
         
            <h1 id="hello">환영합니다 😊 </h1>
            <table id="jointable">
               
               <tbody>
                  <tr>
                     <td id="info" colspan="2" align="right">* 값은 필수입니다.</td>
                  <tr>
                     <th>이 메 일*</th>
                     <td class="joininfo">
                     <f:input class="form-control" path="joinemail" id="joinemail" readonly="true" placeholder="이메일을 입력을 위해 클릭하세요." onclick="checkid();"/>
                     </td>
                  </tr>
                  <tr>
                   <th></th>
                     <td colspan="2" align="left" id="idcheck" >
                        <f:errors path="joinemail" />
                     </td>
                  </tr>
                  <tr>
                     <th>이    름*</th>
                     <td class="joininfo">
                     <f:input class="form-control" id="joinname" path="joinname"  placeholder="이름을 입력하세요" />
                     </td>
                     
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="namecheck" >
                        <f:errors path="joinname" />
                     </td>
                  </tr>
                  <tr>
                     <th>비밀번호*</th>
                     <td class="joininfo"><f:password class="form-control" id="joinpw" path="joinpw"  placeholder="비밀번호를 입력하세요"/></td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="pwcheck"  >
                        <f:errors path="joinpw" />
                     </td>
                  </tr>
                  <tr>             
                     <th>비밀번호 확인*</th>
                     <td class="joininfo"><input class="form-control" type="password" name="joinpw2" placeholder="비밀번호를 확인하세요"/></td>
                  </tr>
                  <tr>
                  <th></th>
                     <td colspan="2" align="left" id="pwcheck2" >
                        
                     </td>
                  </tr>
                  <tr>
                     <th>생년월일*</th>
                     <td class="joininfo">
                        <f:input class="form-control" path="joinbirth" id="joinbirth"  placeholder="yyyynnmm 숫자만입력해주세요" maxlength="8"/>
                     </td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="birthcheck" >
                        <f:errors path="joinbirth"/>
                     </td>
                  </tr>
                  <tr>
                     <th>성   별*</th>
                     <td><f:radiobutton path="joinsex" class="joinsex" id="joinsexF" value="F" label="여"/>
                       
                        <f:radiobutton  path="joinsex" class="joinsex" id="joinsexM" value="M" label="남"/>
                                   
                     </td>
                  </tr>
                   <tr>
                   <th></th>
                     <td colspan="2" align="left" id="sexcheck" >
                        <f:errors path="joinsex"/>
                     </td>
                  </tr>
               </tbody>
                  <tr>
                     <td colspan="2" align="center" >
                        <button id="join" type="submit" class="btn" >회원가입</button>
                     </td>
                  </tr>
            </table>
            </f:form>

      </div>
</body>
</html>