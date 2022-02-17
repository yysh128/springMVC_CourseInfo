<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 이수 학점 조회</title>
<link rel="stylesheet" type="text/css" href="${ pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<table class="table" border="1">
		<thead>
			<tr>
				<th>년도</th>
				<th>학기</th>
				<th>취득 학점</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="offer" items="${ offers }">
				<tr>
					<td><c:out value="${ offer.year }"></c:out></td>
					<td><c:out value="${ offer.semester }"></c:out></td>
					<td><c:out value="${ offer.credit }"></c:out></td>
					<td><a
						href="${ pageContext.request.contextPath }/link/${ offer.year }-${offer.semester}">링크</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th>총계</th>
				<th></th>
				<th><c:out value="${ totalCredits }"></c:out></th>
				<th></th>
			</tr>
		</tfoot>
	</table>
</body>
</html>