<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>자유 게시판</title>
<style>
/* 테이블 레이아웃에 대한 CSS 스타일 */
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #006bb3;
  color: white;
}
</style>
<script>
	// 삭제 확인을 처리하는 JavaScript 함수
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?"); // 삭제 확인을 위한 확인 대화상자
		if(a) location.href='deleteok/' + id; // 확인되면 삭제 액션 URL로 이동
	}
</script>
</head>
<body>
<h1>나만의 일기장</h1>
<button type="button" onclick="location.href='login/logout'">로그아웃</button>

<!-- 게시물 목록을 표시하는 테이블 -->
<table id="list" width="90%">
<tr>
	<th>Id</th>
	<th>제목</th>
	<th>작성자</th>
	<th>내용</th>
	<th>등록일</th>
	<th>수정</th>
	<th>삭제</th>
</tr>

<!-- 게시물 목록을 순회하며 각 게시물을 테이블 행으로 표시 -->
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.seq}</td>
		<td>${u.title}</td>
		<td>${u.writer}</td>
		<td>${u.content}</td>
		<td>${u.regdate}</td>
		<td><a href="editpost/${u.seq}">수정</a></td>
		<td><a href="javascript:delete_ok('${u.seq}')">삭제</a></td>
	</tr>
</c:forEach>
</table>

<!-- 새로운 게시물 추가 버튼 -->
<br/><button type="button" onclick="location.href='add'">새로운 글 작성</button>
</body>
</html>