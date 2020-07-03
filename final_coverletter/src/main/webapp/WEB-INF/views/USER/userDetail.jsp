<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인적사항 입력</title>
<!-- include JQeury/CSS/JS -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/jquery-3.4.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/userDetail.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/JS/USER/rSlider.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/CSS/USER/userDetail.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

</head>
	
<body>
	<%@ include file="../ALL/header_login.jsp"%>

	<div class="container">
		<f:form action="USER_detailRes.do" method="post" modelAttribute="totalDto">
			<div class="center">
				<div id="profile">
					<h3>1. 인적사항</h3>
					<div class="col-md-1" id="photo">사진업로드</div>
					<div id="p_up">
							<f:input path="joinname" id="small" cssClass="col-md-4 form-control" placeholder ="이름"/>
							<f:input path="joinbirth" id="big" cssClass="col-md-4 form-control" placeholder ="생년월일(yyyyMMdd)"/>
							<f:select path="joinsex" id="small" cssClass="col-md-4 form-control">
								<f:option value="성별"></f:option>
								<f:option value="남성"></f:option>
								<f:option value="여성"></f:option>
								<f:option value="중성"></f:option>
							</f:select>
							<f:input path="joinemail" id="big" cssClass="col-md-4 form-control" placeholder ="이메일" readonly="true"/>
					</div>

					<div>
						<div id="check1">
							<f:errors path="joinname" />
						</div>
						<div id="check2">
							<f:errors path="joinbirth" />
						</div>
						<div id="check3">
							<f:errors path="joinsex" />
						</div>
						<div id="check4">
							<f:errors path="joinemail" />
						</div>
					</div>


					<div id="p_down">
					<f:select path="mililtary" id="small" cssClass="col-md-4 form-control">
						<f:option value="병역"></f:option>
						<f:option value="미필"></f:option>
						<f:option value="군필"></f:option>
						<f:option value="면제"></f:option>
						<f:option value="해당없음"></f:option>
					</f:select> 
					<f:input path="phone" id="big" cssClass="col-md-4 form-control" placeholder ="전화번호(010-1234-5678)"/>
					<f:input path="address" id="bigbig" cssClass="col-md-4 form-control" placeholder ="주소" onclick="Address();" readonly="readonly" />
					</div>
					<div>
						<div id="check5">
							<f:errors path="mililtary" />
						</div>
						<div id="check6">
							<f:errors path="phone" />
						</div>
						<div id="check7">
							<f:errors path="address" />
						</div>
					</div>
				</div>

				<div>
					<h3>2. 학력</h3>
					<div>
						<div>
							<div id="default2">

								<div>
									<f:select path="career" id="small" cssClass="col-md-4 form-control" onchange="careerfunc(this)">
										<f:option value="학력구분"></f:option>
										<f:option value="대졸"></f:option>
										<f:option value="전문대졸"></f:option>
										<f:option value="고졸"></f:option>
									</f:select> 
									<f:input path="schoolname" id="big2" placeholder="학교명" cssClass="col-md-4 form-control"/>
									<f:input path="admission" id="big1" placeholder="입학년월(13.03)" cssClass="col-md-4 form-control"/>
									<f:input path="graduate" id="big1" placeholder="졸업년월(20.03)" cssClass="col-md-4 form-control"/>
								</div>
								<div>
									<div id="check8">
										<f:errors path="career" />
									</div>
									<div id="check9">
										<f:errors path="schoolname" />
									</div>
									<div id="check10">
										<f:errors path="admission" />
									</div>
									<div id="check11">
										<f:errors path="graduate" />
									</div>
								</div>
								<div>
									<f:input path="major" id="bigbig1" placeholder="전공명" cssClass="col-md-4 form-control"/>
									<f:input path="grade" id="bigbig1" placeholder="학점 /4.5" cssClass="col-md-4 form-control"/>
								</div>
								
								<div id="check12">
							<f:errors path="major" />
						</div>
						<div id="check13">
							<f:errors path="grade" />
						</div>
							</div>
							<div id="field2"></div>
							<div id="custom_button2">
								<button type="button" id="button2" onclick="add_div(this.id);">
									 <span class="glyphicon glyphicon-plus"></span>
								</button>
								<button type="button" onclick="remove_div(this);">
									 <span class="glyphicon glyphicon-minus"></span>
								</button>
							</div>
						</div>
					</div>
				</div>

				<div>
					<h3 id="h3">3. IT역량(가장 자신있는 기술을 5개 입력)</h3>
					<span id="essential">   * 필수입력</span> <br> <br>
					<div id="itdiv" class="row">
						<f:input path="itskill1" id="small" placeholder="기술1" cssClass="col-md-4 form-control"/>
						<div class="container1" class="col-md-4">
							<div class="slider-container" style="width: 300px;">
								<f:input path="itscore1" id="slider1" cssClass="slider"/>
							</div>
						</div>
							<div>
								<div id="check14"><f:errors path="itskill1" /></div>
								<div id="check19"><f:errors path="itscore1" /></div>
							</div>
						<f:input path="itskill2" id="small" placeholder="기술2" cssClass="col-md-4 form-control"/>
						<div class="container1">
							<div class="slider-container" style="width: 300px;">
								<f:input path="itscore2" id="slider2" cssClass="slider"/>
							</div>
						</div>
							<div>
								<div id="check15"><f:errors path="itskill2" /></div>
								<div id="check20"><f:errors path="itscore2" /></div>
							</div>
						<f:input path="itskill3" id="small" placeholder="기술3" cssClass="col-md-4 form-control"/>
						<div class="container1">
							<div class="slider-container" style="width: 300px;">
								<f:input path="itscore3" id="slider3" cssClass="slider"/>
							</div>
						</div>
							<div>
								<div id="check16"><f:errors path="itskill3" /></div>
								<div id="check21"><f:errors path="itscore3" /></div>
							</div>
						<f:input path="itskill4" id="small" placeholder="기술4" cssClass="col-md-4 form-control"/>
						<div class="container1">
							<div class="slider-container" style="width: 300px;">
								<f:input path="itscore4" id="slider4" cssClass="slider"/>
							</div>
						</div>
							<div>
								<div id="check17"><f:errors path="itskill4" /></div>
								<div id="check22"><f:errors path="itscore4" /></div>
							</div>
						<f:input path="itskill5" id="small" placeholder="기술5" cssClass="col-md-4 form-control"/>
						<div class="container1">
							<div class="slider-container" style="width: 300px;">
								<f:input path="itscore5" id="slider5" cssClass="slider"/>
							</div>
						</div>
							<div>
								<div id="check18"><f:errors path="itskill5" /></div>
								<div id="check23"><f:errors path="itscore5" /></div>
							</div>
					</div>

				</div>
			</div>

			<br />

			<div>
				<h3>4. 자격증</h3>
				<div id="default4">
					<f:input path="certificate" id="msmall" placeholder="자격증명" cssClass="col-md-4 form-control"/>
					<f:input path="organization" id="mbig" placeholder="발행기관" cssClass="col-md-4 form-control"/>
					<f:input path="regdate" id="msmall" placeholder="취득일자(yy.MM.dd)" cssClass="col-md-4 form-control"/>
				</div>
				<div id="field4" class="test"></div>
				<div class="btn333" id="custom_button4">
					<button id="button4" type="button" onclick="add_div(this.id);">
						 <span class="glyphicon glyphicon-plus"></span>
					</button>
					<button type="button" onclick="remove_div(this);">
						 <span class="glyphicon glyphicon-minus"></span>
					</button>
				</div>
			</div>

			<div>
				<h3>5. 어학점수</h3>
				<div id="default5">
					<f:input path="languagename" id="msmall" placeholder="공인시험명" cssClass="col-md-4 form-control"/>
					<f:input path="languagescore" id="mbig" placeholder="공인시험명" cssClass="col-md-4 form-control"/>
					<f:input path="languageregdate" id="msmall" placeholder="취득일자(yy.MM.dd)" cssClass="col-md-4 form-control"/>
				</div>
				<div id="field5"></div>
				<div class="btn333" id="custom_button5">
					<button type="button" id="button5" onclick="add_div(this.id);">
					 <span class="glyphicon glyphicon-plus"></span>
					</button>
					<button type="button" onclick="remove_div(this);">
						 <span class="glyphicon glyphicon-minus"></span>
					</button>
				</div>

			</div>

			<div>
				<h3>6. 공모전 참여이력</h3>
				<div id="default6">
					<f:input path="contest" id="msmall" placeholder="공모전명" cssClass="col-md-4 form-control"/>
					<f:input path="Startorganization" id="mbig" placeholder="시행기관" cssClass="col-md-4 form-control"/>
					<f:input path="prize" id="msmall" placeholder="수상이력" cssClass="col-md-4 form-control"/>
				</div>
				<div id="field6"></div>
				<div class="btn333" id="custom_button6">
					<button type="button" id="button6" onclick="add_div(this.id);">
					 <span class="glyphicon glyphicon-plus"></span>
					</button>
					<button type="button" onclick="remove_div(this);">
						 <span class="glyphicon glyphicon-minus"></span>
					</button>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-12">
					<input type="submit" class="btn btn-success" id="submit_btn" value="저장하기">
				</div>
			</div>
			<br/>
		</f:form>

	</div>
</body>
</html>