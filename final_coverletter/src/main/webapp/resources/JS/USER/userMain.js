window.onload = function() {
	var pwform = $('#pwform').serialize();
	document.getElementById('userUpdate').onclick = function() {
		$('#modal').modal('show');
		
		}
	
	 document.addEventListener('DOMContentLoaded', function() {
	        var calendarEl = document.getElementById('calendar');

	        var calendar = new FullCalendar.Calendar(calendarEl, {
	          plugins: [ 'interaction', 'dayGrid' ,'timeGrid'],
	         
	          header: {
	        	  left: 'prevYear,prev,next,nextYear today',
	        	  center: 'title',
	        	  right: 'dayGridMonth,timeGridWeek,timeGridDay'
	          },
	          buttonText: {
	        	   today : "오늘",
	        	   month : "월",
	        	   week : "주",
	        	   day : "일",
	        	   },
	          locale: 'ko',
	          navLinks: true,
	          selectable: true,
	          selectMirror: true,
	          select: function(arg) {
	            var title = prompt('추가할 내용:');
	            if (title) {
	              calendar.addEvent({
	                title: title,
	                start: arg.start,
	                end: arg.end,
	                allDay: arg.allDay
	              })
	            }
	            calendar.unselect()
	          },
	          editable: true,
	          eventLimit: true,
	          events: [
	              {
	                title: 'All Day Event',
	                start: '2020-02-01'
	              },
	              {
	                  title: 'Event',
	                  start: '2020-03-23 12:00',
	                  end: '2020-03-23 12:30'
	                }
	             ],
	             eventClick: function(arg) {
	                 if (confirm('삭제하시겠습니까?')) {
	                   arg.event.remove()
	                 }
	               }
	        });
	        calendar.render();
	      });
	 
	 document.getElementById('soo').onclick = function() {
			        $.ajax({
			            url: 'USER_PwChange.do', 
			            type: 'POST', 
			            data: {"email" : "abc@naver.com",
			            	   "pw" : $("#pw").val(),
			            	   "pwConfirm" : $("#pwConfirm").val()			            		
			            },
			            success: function(data){
			            	if(data=="true"){
			                 alert('비밀번호 변경 성공')
			            	}else if(data=="false"){
			            		alert('비밀번호 변경 실패')
			            	}else if(data =="cancle"){
			            		alert("비밀번호를 확인해주세요.")
			            	}
			            }
			        });
			}
}

/*-----------------------chart.js : IT 역량------------------------*/
function createITChart() {
	var ctx = document.getElementById('ITChart').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : itChartLabel,
			datasets : [ {
				data : itChartData,
				backgroundColor : [ '#c6f1a2', '#a8d966', '#43a367', '#385380',
						'#fbf27c' ],
				barPercentage : 0.5
			} ]
		},
		options : {
			responsive : false,
			scales : {
				xAxes : [ {
					gridLines : {
						display : true
					},
					ticks : {
						display : true
					}
				} ],
				yAxes : [ {
					gridLines : {
						display : true
					},
					ticks : {
						min : 0,
						max : 10,
						display : true
					}
				} ],
				legend : {
					display : false
				}
			}
		}
	});
}

/*-----------------------chart.js : 나의 스펙------------------------*/
function createMYChart() {
	var ctx = document.getElementById('MyChart').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'radar',
		data : {
			labels : myChartLabel,
			datasets : [ {
				data : myChartData,
				backgroundColor : 'rgba(255,240,92, 0.07)',
				borderColor : '#f6d186',
				borderCapStyle : 'round',
			} ]
		},
		options : {
			responsive : false,
			legend : {
				display : false
			}
		}
	});
}
