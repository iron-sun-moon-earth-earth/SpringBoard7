<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>view/commonException.jsp</h1>
	<h2>예외가 발생했습니다. 관리자에게 문의 하세요!</h2>
	
	<h3><a href="/board/listPage">게시판으로 돌아가기</a></h3>
	
	${e }
	
</body>
</html>