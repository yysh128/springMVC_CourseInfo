<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>

	<sf:form method="post"
		action="${pageContext.request.contextPath}/doCreate"
		acceptCharset="UTF-8"
		modelAttribute="offer">
		<table class="formtable">
			<sf:input type="hidden" value="2022" path="year" />
			<sf:input type="hidden" value="1" path="semester" />

			<tr>
				<td>교과목명</td>
				<td><sf:input type="text" path="name" /> <br /> <sf:errors
						path="name" class="error" /></td>
			</tr>
			<tr>
				<td>교과구분</td>
				<td><sf:input type="text" path="subject" /><br /> <sf:errors
						path="subject" class="error" /></td>
			</tr>
			<tr>
				<td>담당교수</td>
				<td><sf:input type="text" path="professor" /><br /> <sf:errors
						path="professor" class="error" /></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><sf:input type="text" value="" path="credit" /><br/> <sf:errors
						path="credit" class="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수강신청"></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>