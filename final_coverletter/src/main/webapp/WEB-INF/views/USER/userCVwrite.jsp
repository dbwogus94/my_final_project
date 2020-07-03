<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자기소개서 상세보기</title>
<%@ include file="../ALL/header_login.jsp"%>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/USER/userCVwrite.js"></script>
<link
   href="${pageContext.request.contextPath}/resources/CSS/USER/userCVwrite.css"
   rel="stylesheet">
   
<!-- include cross origin -->
<script type="text/javascript"
   src="${pageContext.request.contextPath}/resources/JS/jquery.ajax-cross-origin.min.js"></script>   
   
<!-- include -->   
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/annyang/2.6.0/annyang.min.js"></script>
</head>
<body>
<!-- toast 영역 -->
  <div class="toast">
    <div class="toast-header">
      <strong class="mr-auto">자기소개서 작성 T I P ! 🌿</strong>
      <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    <div class="toast-body">
      Hello, world! This is a toast message.
    </div>
  </div>
<!-- toast 영역 끝 -->   

<f:form action="USER_userCVinsert.do" method="post" modelAttribute="MultiRowTarget">
         <f:input type="hidden" path="targets[0].joinemail" value="a"/>
   <!-- 자소서 제목 영역 -->
   <div class="container title-container">
      <div id="title-area">
         <h1>자기소개서 작성</h1>
         
         <!-- 제목 title -->
         <div>
            <span class="title-font">제&nbsp;&nbsp; 목 <span class="star">*</span></span> 
            <f:input
               type="text" id="title" path="targets[0].title" class="form-control"
               placeholder="제목을 입력하세요."/>
         </div>
      </div>
   </div>
   <!-- 자소서 제목 영역 끝-->
   
   <!-- 자소서 작성 영역 -->
   <div class="container cv-container">
      <div id="cv-area">
         <div id="input-grp">
            <div>
               <span class="title-font">소제목 <span class="star">*</span></span> 
               <f:input 
                  type="text" id="subtitle" path="targets[0].subtitle" class="form-control"
                  placeholder="소제목을 입력하세요."/>
            </div>
            <div>
               <span class="title-font">항&nbsp;&nbsp;&nbsp;&nbsp;목 <span class="star">*</span></span> 
               <!-- 자소서 질문 영역 -->
               <f:select
                  id="question" path="targets[0].question" class="form-control toast-question">
                  <optgroup label="기본" id="one">
                     <f:option value="자기소개"></f:option>
                     <f:option value="지원동기"></f:option>
                     <f:option value="입사 후 포부"></f:option>
                     <f:option value="입사 후 계획"></f:option>
                     <f:option value="회사를 선택한 이유와 회사에서 이루고 싶은 꿈"></f:option>
                  </optgroup>
                  <optgroup label="개인" id="two">
                     <f:option value="성장과정"></f:option>
                     <f:option value="가치관"></f:option>
                     <f:option value="좌우명"></f:option>
                     <f:option value="성격의 장단점"></f:option>
                     <f:option value="역량과 핵심가치"></f:option>
                     <f:option value="취미와 특기"></f:option>
                  </optgroup>
                  <optgroup label="직무역량" id="three">
                     <f:option value="가장 자신있는 기술"></f:option>
                     <f:option value="프로젝트 진행 사례"></f:option>
                  </optgroup>
                  <optgroup label="경험과 사례" id="four">
                     <f:option value="학창시절 팀워크를 발휘한 경험"></f:option>
                     <f:option value="교외활동과 동아리 활동 사례"></f:option>
                     <f:option value="대학생활 중 가장 뛰어난 성과를 이뤄냈던 경험"></f:option>
                     <f:option value="지원 직무와 관련된 경험"></f:option>
                     <f:option value="위기 극복 사례"></f:option>
                     <f:option value="실패 경험 사례"></f:option>
                     <f:option value="가장 큰 성취 경험"></f:option>                  
                  </optgroup>
                  <optgroup label="기타" id="five">
                     <f:option value="가장 감명깊게 읽은 책과 그 이유"></f:option>
                     <f:option value="즐겨찾는 인터넷 사이트와 그 이유"></f:option>
                     <f:option value="최근 사회 이슈 중 중요하다고 생각하는 한 가지를 선택하여 자신의 견해를 기술하세요."></f:option>
                  </optgroup>
               </f:select>
               <!-- 자소서 질문 영역 끝 -->
            </div>
            
            <!-- 글자수 영역 -->
            <div class="count-area">
               <p class="count-text">공백 포함 <span class="count-span" id="cntArea-a">0</span>자 / 공백 미포함 <span class="count-span" id="cntArea-b">0</span>자 </p>
            </div>
            <!-- 글자수 영역 끝 -->
            
            <div class="row" class="">
               <div class="col-md-6">
                  <fieldset class="cv-box">
                     <legend class="legend title-font">작성</legend>
                     <f:textarea class="textarea" onkeydown="contentCnt(this);" id="content" path="targets[0].content"></f:textarea>
                  </fieldset>
                  
                  <button class="btn cv-btn" type="button" onclick="speech_to_text();">음성입력</button>
               </div>
               <div class="col-md-6">
                  <fieldset class="cv-box">
                     <legend class="legend title-font">검사</legend>
                     <div class="cv-spell"></div>
                  </fieldset>
                  
                  <button class="btn cv-btn" type="button" onclick="spellCheck(this);" id="spell-check">맞춤법검사</button>
               </div>
            </div>
         </div>
         <!-- CLONE button 영역 -->
         <div class="clone-btn-grp" id="">
            <button class="add-btn" onclick="add();" type="button">
               <span class="glyphicon glyphicon-plus"></span>
            </button>
            <button class="remove-btn" onclick="remove(this)" type="button">
               <span class="glyphicon glyphicon-minus"></span>
            </button>
         </div>
      </div>
   </div>
   <!-- 자소서 작성 영역 끝-->
   <!-- submit 영역 -->
   <div class="container submit-container">
      <div class="submit-area">
         <input type="submit" class="btn" value="저장" >
         <button class="btn" onclick="location.href='JOB_jobCenter.do'" type="button">돌아가기</button>
      </div>
   </div>
   </f:form>   
   
   <!-- 로딩 영역 -->
      <div class="modal" tabindex="-1" role="dialog" id="myModal">
       <div class="modal-body">
           <div class="loader">맞춤법 검사 중입니다...</div>
         </div>
      </div>
   
</body>
</html>