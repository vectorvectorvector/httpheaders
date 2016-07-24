<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$("#send").click(function() {
			//alert("点击");
			$.ajax({
				url : "http://localhost:8080/HeadersTest/HeaderServlet",
				type : 'post',
				data:{
					"username":"lineme",
					"password":"line"
				},
				dataType : 'text',
				headers:{
					"accept-language":"zh-CN,en-US;q=0.8,zh-HK;q=0.6",
					"Accept-Encoding":"gzip",
					"content-encoding":"gzip",
					"content-length":"100"
				},
				success : function(result) {
					//alert(result);
					$("#result").html(result);
				},
				error : function() {
					alert("error");
				}
			});
		});
	});

	/* /* $document.ready(function() { */
	function myajax() {
		/* $("#send").click(function() {*/
		alert("点击");
		$.ajax({
			url : 'http://localhost:8080/HeadersTest/HeaderServlet',// 跳转到 action  
			data : {
				selRollBack : selRollBack,
				selOperatorsCode : selOperatorsCode,
				PROVINCECODE : PROVINCECODE,
				pass2 : pass2
			},
			type : 'post',
			cache : false,
			dataType : 'html',
			success : function(data) {
				alert(data);
			},
			error : function() {
				alert("异常！");
			}
		})
		//});
	}//); */
</script>

</head>
<body>
	<form action="" method="post">
		<input type="button" id="send" value="Ajax请求" >
	</form>
	<span id="result"></span>
</body>
</html>