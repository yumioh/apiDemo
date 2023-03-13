<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="com.lab15.*, java.io.File" %>
<%@ page import ="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 결과</title>
</head>
<body>
<%
	String filename = "";
	int sizeLimit = 100 * 1024 * 1024; // 한번에 올릴 수 있는 파일 용량 100M

	//	상대경로를 절대경로로 가져와야
	String realPath = request.getServletContext().getRealPath("upload");
	System.out.println(realPath);

	//upload 폴더가 없는 경우 폴더를 만들어라
	File dir = new File(realPath);
	if (!dir.exists()) dir.mkdirs();

	MultipartRequest multpartRequest = null;
	multpartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8",new DefaultFileRenamePolicy());
    //request,파일저장경로,용량,인코딩타입,중복파일명에 대한 기본 정책


	String title = multpartRequest.getParameter("title");
    //form내의 input name="title" 인 요소의 값을 가져옴

	filename = multpartRequest.getFilesystemName("photo");
    //form내의 input name="photo" 인 요소의 값을 가져옴
%>
제목 : <%=title %><br />
파일명 : <%=filename%><br />
<img src="${pageContext.request.contextPath }/upload/<%=filename%>">
  <!-- 실제 저장된 로컬 경로(ex - C:\Users\...\resources\image)가 아닌 서버 경로(ex - FileUpload/resources/image)를 통해 접근해야 한다.-->
</body>
</html>