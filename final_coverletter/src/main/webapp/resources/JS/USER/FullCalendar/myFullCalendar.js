document.addEventListener('DOMContentLoaded', function() {
	$.ajax({
		url:"USER_getFullCalendarData.do",
		type:"post",
		data:"json",
		success : function(res){
			createFullCalendar(res.data)
		}, 
		error : function(){
			alert("통신실패, 관리자에게 문의하세요.")
		} 
	});
});


function createFullCalendar(data) {
		var calendarEl = document.getElementById('calendar');

		var calendar = new FullCalendar.Calendar(calendarEl, {
			plugins : [ 'interaction', 'dayGrid', 'timeGrid' ],

			header : {
				left : 'prevYear,prev,next,nextYear today',
				center : 'title',
				//right : 'dayGridMonth,timeGridWeek,timeGridDay'
				right : 'dayGridMonth'
			},
			buttonText : {
				today : "오늘",
				//month : "월",
				//week : "주",
				//day : "일",
			},
			locale : 'ko',
			navLinks : true,
			//selectable: true,
			selectMirror : true,
			select : function(arg) {
				var title = prompt('추가할 내용:');
				if (title) {
					calendar.addEvent({
						title : title,
						start : arg.start,
						end : arg.end,
						allDay : arg.allDay
					})
				}
				calendar.unselect()
			},
			editable : true,
			eventLimit : true,
			events : data,
			eventClick : function(arg) {
				if (confirm('이동하시겠습니까?')) {
					//alert(arg.event.title)
					for(var i = 0; i<data.length; i++){
						if(data[i].title == arg.event.title){
							location.href="JOB_jobDetail.do?companyseq="+data[i].companyseq
						}
					}
					//arg.event.remove() //arg는 해당 이벤트 발생 일정 삭제 
				}
			}
		});
		calendar.render();
	}




