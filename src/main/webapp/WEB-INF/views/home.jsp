<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	이 홈페이지는 학사 정보를 조회 할 수 있는 홈페이지입니다. 학사 정보를 조회하려면 로그인을 해야합니다. <br/>
	학사 정보에는 학기별 이수 학점 조회, 수강 신청하기, 수강 신청 조회가 있습니다.
	<p> <a href="${pageContext.request.contextPath}/offers"> 학기별 이수 학점 조회</a></p>
	<p> <a href="${pageContext.request.contextPath}/createoffer"> 수강 신청하기</a></p>
</body>
</html>
