<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포트폴리오 입력</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
   src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
<script type="text/javascript"
   src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/USER/userPFwrite.js"></script>
<link
   href="${pageContext.request.contextPath}/resources/CSS/USER/userPFwrite.css?ver=2"
   rel="stylesheet">


</head>
<body>
   <%@ include file="../ALL/header_login.jsp"%>
   
   <div class="container">
   
      <div class="center" id="center">
      <f:form name="PFform" action="PFinsert.do" method="post" modelAttribute="MultiRowTarget" enctype="multipart/form-data"> 
         <div id="pdfwrap">
            <div id="PFinfo">
               <h1 id="item">포트폴리오 필수항목</h1>
               <table class="PFtable">
                  <tr>
                     <th>프로젝트명</th>
                     <td class="PFinfo"><f:input type="text" path="targets[0].title"/></td>
                  </tr>
               
                  <tr>
                     <th>수행기간</th>
                     <td class="PFinfo"><f:input type="text" path="targets[0].question"/></td>
                  </tr>
                  <tr>
                     <th>개발목표</th>
                     <td class="PFinfo"><f:textarea rows="7" cols="60" path="targets[0].subtitle"/></td>
                  </tr>
                  <tr>
                     <th>개발환경</th>
                     <td class="PFinfo"><f:textarea rows="7" cols="60" path="targets[0].content"/></td>
                  </tr>
                  <tr>
                     <th>구현기능</th>
                     <td class="PFinfo"><f:textarea rows="7" cols="60" path="targets[0].functions"/></td>
                  </tr>
                  <tr>
                     <th>담당역할</th>
                     <td class="PFinfo"><f:textarea rows="7" cols="60" path="targets[0].positions"/></td>
                  </tr>
                  <tr>
                     <th>참여도 / 기여도</th>
                     <td class="PFinfo"><f:input type="text" path="targets[0].participation"/></td>
                  </tr>
               </table>
               
            </div>





            <div id="PFdetail">
               <div id="PFbtn">
                  <!-- <input type="button"  id="minus" onclick="minus(e);" style="float: left;  border: 0;" > -->
<!--                      <input type="button" id="minus" value="삭제" onclick="minus(e);" style="float: left;  border: 0;"> -->
                       <img alt="minus" onclick="plus(this);" src="resources/IMG/plus.jpg" style="width: 20px; height: 20px; margin-right: 20px;">
                       <img alt="minus" onclick="minus(this);" src="resources/IMG/minusbutton.png" style="width: 20px; height: 20px; margin-right: 20px;">
                  <f:input multiple="multiple" type="file" class="input_img" path="targets[0].fileUpload"/>
               </div>

               <div id="PFcenter" style="display: flex;">
                  <div class="margin" style="flex: 0.1;"></div>
                  <div id="main" style="flex: 2; display: flex;">
                     <div id="photo" style="flex: 2;">
                        <div class="img_wrap" >
                           	화면이미지첨부 <img style="width: 100%; height: 100%;"/>
                        </div>
                     </div>
                     <div id="between" style="flex: 0.1;"></div>
                     <fieldset id="function" style="flex: 2;">
                        <legend class="le">기능설명</legend>
                        <f:textarea rows="10" cols="60" id="functioninfo" path="targets[0].functioninfo"/>
                     </fieldset>
                  </div>
                  <div class="margin" style="flex: 0.1;"></div>
               </div>

               <div id="PFlast">
                  <fieldset id="viewinfo">
                     <legend class="le">화면설명</legend>
                     <f:textarea rows="8" cols="90" id="viewinfo1" path="targets[0].viewinfo"/>
                  </fieldset>
               </div>
            </div>
            <div id="filed"></div>
            
         </div>
         <input type="submit" id="create_pdf1" value="저장하기">
         <input type="button" id="create_pdf2" value="PDF다운로드" onclick="pdfprint();"/>
      </f:form>
         <button id="plus" onclick="plus();">
            <img id="plusbtn" alt="plusbtn" src="resources/IMG/plus.jpg">
         </button>
      </div>
   </div>
</body>
<script type="text/javascript">

</script>

</html>