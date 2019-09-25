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

<style type="text/css">
#gsqdkj {
	float: right;
}

#lite {
	position: absolute;
	top: 150px;
	left: 180px;
	z-index: 5;
	cursor: hand;
}
</style>


</head>
<body>
	<div id="lite">
		<br> <br> <a href="">刷新</a><br> <br> <br> <br>
		<br>
		<button class="btn" onClick="copytiqu()">提取</button>
		<div id="tiqu">${tiqu}</div>

		<script>
			function copytiqu() {
				var mima = new ClipboardJS('.btn', {
					target : function() {
						return document.getElementById('tiqu');
					}
				});
			}
		</script>

		<br> <br>

		<button class="btn" onClick="copymima()">${newmima}</button>
		<div id="mima">${mima}</div>

		<script>
			function copymima() {
				var mima = new ClipboardJS('.btn', {
					target : function() {
						return document.getElementById('mima');
					}
				});
			}
		</script>




		<!-- 		<button class="btn" onClick="copytype()">类型</button> -->
		<%-- 		<div id="type">${type}</div> --%>

		<script>
			function copytype() {
				var mima = new ClipboardJS('.btn', {
					target : function() {
						return document.getElementById('type');
					}
				});
			}
		</script>

		<span>${time }</span> <br> <br> <br> <br>

	</div>


	<iframe id="gsqdkj" name="baidupan" src="${pan }" width="1200"
		height="750" frameborder="0"></iframe>




</body>
</html>