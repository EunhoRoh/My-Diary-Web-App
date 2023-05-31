<!-- 게시물을 수정하기 위한 폼을 표시하는 JSP 파일 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 스프링 프레임워크의 폼 태그 라이브러리를 사용하기 위한 디렉티브입니다. -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page
	import="com.mycom.myapp.board.BoardDAO, com.mycom.myapp.board.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit Form</title>
</head>
<body>

	<h1>Edit Form</h1>
	<!-- 게시물 수정을 위한 폼을 생성하는 태그입니다. action 속성은 폼이 제출될 때 호출될 서버 측의 액션을 지정합니다. -->
	<form action="../editok" method="post">
		<input type="hidden" name="seq" value="${u.seq}" />

		<!-- Title 입력란 -->
		<table id="edit">
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" value="${u.title}" /></td>
			</tr>

			<!-- Writer 입력란 -->
			<tr>
				<td>Writer:</td>
				<td><input type="text" name="writer" value="${u.writer}" /></td>
			</tr>

			<!-- Content 입력란 -->
			<!--  여러 줄의 텍스트를 입력할 수 있는 텍스트 영역입니다. -->
			<tr>
				<td>Content:</td>
				<td><textarea cols="50" rows="5" name="content">${u.content}</textarea></td>
			</tr>

			<!-- 수정 버튼 및 취소 버튼 -->
			<tr>
				<td colspan="2"><input type="submit" value="Edit Post" /> <input
					type="button" value="Cancel" onclick="history.back()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>