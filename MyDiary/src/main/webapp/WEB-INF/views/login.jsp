<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
/* CSS 스타일 */
img, label {
	display: inline-block;
}

label {
	width: 130px
}

button {
	background-color: blue;
	color: white;
	font-size: 15px
}
</style>
</head>
<body>
	<div style='width: 100%; text-align: center; padding-top: 100px'>
		<img src='../img/diary.jpeg' height="250">
		<!-- 이미지 표시 -->
		<form method="post" action="loginOk">
			<div>
				<label>User ID: </label>
				<!-- 사용자 ID 입력 레이블 -->
				<input type='text' name='userid' />
				<!-- 사용자 ID 입력 필드 -->
			</div>
			<div>
				<label>Password: </label>
				<!-- 비밀번호 입력 레이블 -->
				<input type='password' name='password' />
				<!-- 비밀번호 입력 필드 -->
			</div>
			<button type='submit'>login</button>
			<!-- 로그인 버튼 -->
		</form>
	</div>
</body>
</html>