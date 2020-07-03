$(function() {

	$("#paybtn").click(
			function() {

				var joinemail = $("#joinemail").val();
				var quantity = $("#quantity").val();
				
				if (quantity == null || quantity == "") {
					$("#chkQuantity").html("후원 금액을 입력해주세요.");
				} else {

					console.log(joinemail);
					console.log(quantity);

					location.href = "MAIN_payReady.do?quantity=" + quantity
							+ "&joinemail=" + joinemail;

				}

			});
	$("#quantity").on('keyup', function(e) {
		$(this).val(($(this).val().replace(/[^0-9]/g, '')));
		$("#chkQuantity").html("");
	});
});

// function onlyNumber(obj) {
// $(obj).keyup(function(){
// addCommas($(this).val().replace(/[^0-9]/g,""));
// $("#chkQuantity").html("");
// });
// }

