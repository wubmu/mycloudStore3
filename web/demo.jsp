<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/11/21
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login2.action" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="123">
</form>
<form action="login1.action" method="post">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="123">
</form>
新建文件夹
<form action="createFile.action">
    <input type="text" name="name">
    <input type="submit">
</form>
<a href="download.action?filePath=d:/123.docx&contType=application/msword">下载</a>
<a href="down.action?fileName=123&path=D:\123.docx&contType=application/msword" methods="post">下载down</a>
<a href="D:\123.docx">瞎子</a>
<a href="down.action?fileName=123&contentType=123">demo</a>
</body>
</html>
