<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/JS/BOARD/boardDetail.js"></script>
<link href="${pageContext.request.contextPath}/resources/CSS/BOARD/boardDetail.css" rel="stylesheet">

<!-- include modal -->
<script type="text/javascript"
   src="https://getbootstrap.com/docs/4.3/components/modal"></script>
<script
   src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
   src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
   
</head>
<body>

<!-- 모달 영역 -->
   <div class="modal" tabindex="-1" role="dialog" id="modal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
   <div class="modal fade" id="myModal" tabindex="-1">
      <div class="modal-dialog" role="document">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title" id="myModalLabel">모달 타이틀</h4>
            </div>
            <div class="modal-body">모달 내용</div>
            <div class="modal-footer">
               <button type="button" class="btn btn-basic">예</button>
               <button type="button" class="btn btn-basic" data-dismiss="modal">아니오</button>
            </div>
         </div>
      </div>
      <div class="modal-body">
        <p>Modal body text goes here.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>