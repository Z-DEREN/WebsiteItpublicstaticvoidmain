<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>one</title>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/products.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/js/myajax2.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/layui/css/layui.css">
<script
	src="${pageContext.request.contextPath }/statics/dist/js/jquery-1.12.4.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/ajax2/myajax2.js"></script>
<script src="${pageContext.request.contextPath }/statics/layui/layui.js"></script>
<script
	src="${pageContext.request.contextPath }/statics/js/clipboard.min.js"></script>
	
	<script
	src="${pageContext.request.contextPath }/jsp/tools/ButtonEnter/indexHome.js"></script>

<style type="text/css">



</style>


<script type="text/javascript">
	$(function(){
		$("#loginbtn").click(function(){
			var loginName = $("#loginName");
			var password = $("#password");
			var msg = "";
			if(loginName.val() == ""){
				msg = "登录名不能为空!";
				loginName.focus();
			}else if(password.val() == ""){
				msg = "密码不能为空!";
				password.focus();
			}
			if(msg != ""){
				alert(msg);
			}else{
				$("#loginform").submit();
			} 
		})
	})
</script>







</head>
<body>
	<div id="lite">
	
		<input type="submit" name="b1" value="提交" onClick="bt_submit_onclick()">
	
		<span style="margin: 0 0 0 100px;"><a href="${pageContext.request.contextPath }/button/button">按钮1</a></span><br>
		<br> <br> <br> <br> <br> <a
			href="${pageContext.request.contextPath }/button/button">按钮1</a><br>
		<br> <br> <br> <br> <br> <a
			href="${pageContext.request.contextPath }/button/button">按钮1</a><br>
		<br> <br> <br> <br> <br> <a
			href="${pageContext.request.contextPath }/button/button">按钮1</a><br>
		<br> <br> <br> <br> <br> <a
			href="${pageContext.request.contextPath }/button/button">按钮1</a><br>
	</div>






</body>
</html>