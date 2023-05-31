<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<!-- 출력: 서버의 시간 정보 -->
	<P>The time on the server is ${serverTime}.</P>

	<!-- 링크: 일기장으로 이동 
<a>: 하이퍼링크를 생성하는 태그입니다. href 속성은 링크의 대상 URL을 지정합니다.
-->
	<p>
		<a href="list">일기장으로 이동</a>
	</p>
</body>
</html>