<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>MD5</title>





<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">


<script
	src="${pageContext.request.contextPath }/statics/dist/js/jquery-1.12.4.js"></script>


<script
	src="${pageContext.request.contextPath }/statics/ajax2/myajax2.js"></script>

<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/clipboard.min.js"></script>




</head>
<body>

	<div>
		<span>加密内容:<input type="text" name="pass" id="pass"></span><br>
		<span>加密盐值:<input type="text" name="salt" id="salt"></span> <br>
		<span>hash值:<input type="text" name="Hash" id="hash"></span><br>


		<button id="submit">查询</button>



	</div>

	<div>
		<ul>
			<li>11111111111111111</li>
			<li>11111111111111111</li>
			<li>11111111111111111</li>
			<li>11111111111111111</li>
		</ul>
	</div>
	<div id="box"></div>




	<script type="text/javascript">
		$("#submit")
				.click(

						function() {

							var md5 = {
								'pass' : $("input[name='pass']").val(),
								'salt' : $("input[name='salt']").val(),
								'hash' : $("input[name='Hash']").val()
							}

							$
									.ajax({
										//几个参数需要注意一下
										type : "POST",//方法类型
										dataType : "json",//预期服务器返回的数据类型
										url : '${pageContext.request.contextPath }/7f138a09169b250e9dcb378140907378/8917cb5abfba22a861af3c21404b6ba7',//url
										data : JSON.stringify(md5),
										contentType : "application/json;charset=utf-8",
										success : function(result) {
											delect();
											addBox(result);
										}
									});
						});

		function delect() {
			document.getElementById("box").innerHTML = "";
		}

		function addBox(result) {
			//result是一个集合,所以需要先遍历

			for ( var p in result.data) {//遍历json对象的每个key/value对,p为key

				// 				alert(p + " " + result.data[p].md5);

				$("#box").append(
						"<div class='p1 p'>" + result.data[p].md5 + "</div>" +

						"<div class='p1 p'>" + result.data[p].md5salt
								+ "</div>");
			}

		}
	</script>


</body>
</html>