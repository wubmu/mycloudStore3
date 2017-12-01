<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/11/17
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  <body>
  <%--<form enctype="multipart/form-data" action="upload.action">--%>
    <%--<div class="file-loading">--%>
      <%--<input id="kv-explorer" type="file" multiple>--%>
      <%--<input id="input-b1" name="upload" type="file" class="file">--%>
    <%--</div>--%>
    <%--<div class="fileinput-upload-button">--%>
    <%--<input></div>--%>
  <%--</form>--%>
  <input id="input-b1" name="upload" type="file" class="file" multiple>
  <script>
    $("#input-b1").fileinput({
        uploadUrl: "upload.action?savePath=${sessionScope.filePath}", // server upload action
        uploadAsync: true,
        maxFileCount: 5,
        showBrowse: false,
        browseOnZoneClick: true,
        initialPreviewAsData: true,
        initialPreviewFileType: 'image,docx',

    })
  </script>
  </body>
</html>
