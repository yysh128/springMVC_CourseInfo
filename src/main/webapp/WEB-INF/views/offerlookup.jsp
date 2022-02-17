<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강 신청 조회</title>
</head>
<body>
	<table class="table" border="1">
		<thead>
			<tr>
				<th>년도</th>
				<th>학기</th>
				<th>교과목명</th>
				<th>교과구분</th>
				<th>담당교수</th>
				<th>학점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${ offers }">
				<tr>
					<td><c:out value="${ offer.year }"></c:out></td>
					<td><c:out value="${ offer.semester }"></c:out></td>
					<td><c:out value="${ offer.name }"></c:out></td>
					<td><c:out value="${ offer.subject}"></c:out></td>
					<td><c:out value="${ offer.professor }"></c:out></td>
					<td><c:out value="${ offer.credit }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>