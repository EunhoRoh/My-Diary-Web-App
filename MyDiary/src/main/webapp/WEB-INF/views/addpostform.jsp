<%-- 이 지시자는 JSP 페이지의 속성을 설정합니다. 여기서는 페이지의 언어를 자바로 지정하고, 콘텐츠 유형을 텍스트/HTML로 지정하며, 문자 인코딩을 UTF-8로 설정합니다. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Add New Post</h1>
	<%--이 태그는 사용자가 데이터를 입력하고 제출할 수 있는 폼을 정의합니다. action 속성은 폼이 제출될 URL을 지정하고, 
method 속성은 폼의 제출 방식을 지정합니다. 여기서는 "addok" URL로 POST 방식으로 제출됩니다. --%>
	<form action="addok" method="post">
		<%--이 태그는 테이블을 정의합니다. 폼 내부에 데이터를 입력할 수 있는 필드를 테이블 형태로 배치합니다. --%>
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Writer:</td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td>Content:</td>
				<td><textarea cols="50" rows="5" name="content"></textarea></td>
			</tr>
		</table>
		<%--이 태그는 "목록보기" 버튼을 생성합니다. 버튼을 클릭하면 "list" URL로 이동합니다. --%>
		<button type="button" onclick="location.href='list">목록보기</button>
		<%--이 태그는 "등록하기" 버튼을 생성합니다. 버튼을 클릭하면 폼 데이터가 서버로 제출됩니다. --%>
		<button type="submit">등록하기</button>
	</form>

</body>
</html>