<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/11/19
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>
    <link href="themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="js/plugins/sortable.js" type="text/javascript"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="js/locales/fr.js" type="text/javascript"></script>
    <script src="js/locales/es.js" type="text/javascript"></script>
    <script src="themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="themes/fa/theme.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script src="js/bootstrap-table.js"></script>
    <link href="css/bootstrap-table.css" rel="stylesheet" />
    <script src="js/locale/bootstrap-table-zh-CN.js"></script>
</head>
<body>
<%--<div class="container">--%>
    <%--<button value="发送" type="button" onclick="deleteFile()">哈哈</button>--%>
    <%--<form action="deleteFile.action" method="post">--%>
<%--<s:iterator var="file" value="#session.list">--%>
    <%--<tr>--%>
    <%--<td><input type="checkbox" name="selectAll" value="${file.filePath}"></td>--%>
    <%--<td>${file.fileName}</td>--%>
    <%--</tr>--%>
<%--</s:iterator>--%>

    </form>
</div>
<button value="发送" type="button" onclick="deleteFile()">哈哈</button>
<form action="deleteFile.action" method="post">
    <input name="selectAll" value="12311111123">
    <input name="selectAll" value="12311111123">

</form>
<%--<div class="container">--%>
    <%--<button value="发送" type="button" onclick="deleteFile()">哈哈</button>--%>
    <%--<form action="deleteFile.action" method="post">--%>
        <%--<s:iterator var="file" value="#session.list">--%>
            <%--<tr>--%>
                <%--<td><input type="checkbox" name="selectAll" value="${file.filePath}"></td>--%>
                <%--<td>${file.fileName}</td>--%>
            <%--</tr>--%>
        <%--</s:iterator>--%>

    <%--</form>--%>
<%--</div>--%>
<form action="login.action" method="post">
    <input type="text" name="username" >
    <input  type="text" name="password" >
    <input type="submit" value="登陆">
</form>
<form action="login1.action" method="post">
    <input type="text" name="username" >
    <input  type="text" name="password" >
    <input type="submit" value="登陆">
</form>
<form action="login2.action" method="post">
    <input type="text" name="username" >
    <input  type="text" name="password" >
    <input type="submit" value="登陆">
</form>
<script type="text/javascript">

    function deleteFile() {
        dir.forms[0].action="deleteFile";
        dir.forms[0].submit();
    }
</script>
<a href=""></a>
</body>
</html>
