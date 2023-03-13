<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=chrome">
<title>주문서 업로드</title>
</head>
<body>
<form action="fileUpload.jsp" name="fileForm" method="post" enctype="multipart/form-data">
	작성자: <input type="text" name="user"><br>
	제목: <input type="text" name="title"><br>
	파일명: <input type="file" name="uploadFile"><br>
	<input type="submit" value="upload">
</form>
</body>
</html>