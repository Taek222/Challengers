<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${userInfo}</title>
</head>
<body>
<h1> ${pageNm}.jsp 입니다</h1>
사용자 ID : ${userInfo}
<form action="/user/filesave" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile" />
    <button type="submit"> 파일업로드</button>
</form>
</body>
</html>