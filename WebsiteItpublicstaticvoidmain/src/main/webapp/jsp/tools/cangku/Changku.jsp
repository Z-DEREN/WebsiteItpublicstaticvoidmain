<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">



<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/86D133B2DC9C804FD8509092BEC16334/86D133B2DC9C804FD8509092BEC16334.css">
<title>index</title>
</head>
<body>

	<div class="zD88C478F1B226D6D37BD48509331348B">
		<p id="List"></p>
	</div>

</body>
<script type="text/javascript">
	var listtype = "";
	listtype = "${TypeList}";
	var text ="";
	var arraytype = listtype.split(",");
	for (i = 0; i < arraytype.length; i++) {
		text += "<a href=\"${pageContext.request.contextPath }/ButtonEnter/9938fba0d33f9e1f62dc082fae371a68/"+arraytype[i]+"\">"+ arraytype[i] + "</a><br>";
	}
	document.getElementById("List").innerHTML = text;
</script>
</html>