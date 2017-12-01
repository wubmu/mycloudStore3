<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/11/18
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网盘全部文件</title>
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
    <script src="js/bootstrap-table.js"></script>
    <link href="css/bootstrap-table.css" rel="stylesheet" />
    <script src="js/locale/bootstrap-table-zh-CN.js"></script>
    <link href="in.html">
    <style type="text/css">

        .file-drop-zone{
            height: 300px;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-12" style="padding-bottom: 0px">
                    <nav class="navbar navbar-default" role="navigation" style="background: #333333;padding-bottom: 0px;margin-bottom: 0px">
                        <div class="navbar-header">

                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                            </button> <a class="navbar-brand" href="#">Brand</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav" style="padding-bottom: 0px">
                                <li class="active">
                                    <a href="#">网盘</a>
                                </li>
                                <li>
                                    <a href="#">分享</a>
                                </li>
                                <li>
                                    <a href="#">更多</a>
                                </li>
                            </ul>
                            <%--<form class="navbar-form navbar-left" role="search">--%>
                                <%--<div class="form-group">--%>
                                    <%--<input type="text" class="form-control" />--%>
                                <%--</div>--%>
                                <%--<button type="submit" class="btn btn-default">--%>
                                    <%--Submit--%>
                                <%--</button>--%>
                            <%--</form>--%>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a>欢迎用户${sessionScope.user.username}</a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人资料<strong class="caret"></strong></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="logout.action">注销</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </nav>
                </div>
            </div>
            <div class="row" style="padding-left: 15px;padding-top: 0px">
                <div class="col-md-3" style="background: #f5f5f5;padding-right: 0px;
    padding-left:15px; height: 490px">
                    <ul class="nav nav-list">
                        <li class="active">
                            <a href="show.action?filePath=${sessionScope.user.rootFile}">全部文件</a>
                        </li>
                        <li>
                            <a href="typeSelect.action?contentType=image/jpeg">图片</a>
                        </li>
                        <li>
                            <a href="#">文档</a>
                        </li>
                        <li>
                            <a href="#">视频</a>
                        </li>
                        <li>
                            <a href="#">音乐</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">帮助</a>
                        </li>

                    </ul>
                </div>
                <div class="col-md-9">
                    <div class="row">
                    <div class="row">
                        <div class="col-md-6" style="padding-right: 15px;padding-left: 0px;">
                            <button class="btn btn-info btn-md" id="uploadFile"  data-toggle="modal" data-target="#upload">
                                <em><span class="glyphicon glyphicon-cloud-upload" aria-hidden="true"></span></em>
                                <span>上传</span>
                            </button>
                            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="uploadFile" id="upload">
                                <div class="modal-dialog modal-md" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" >上传文件</h4>
                                        </div>
                                        <div class="modal-body">
                                            <input id="input-b1" name="upload" type="file" class="file" multiple >
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button class="btn btn-default btn-md" type="button" onclick="deleteFile()">删除文件</button>
                            <button class="btn btn-default btn-md" type="button"  data-toggle="modal" data-target="#newFile">新建文件夹</button>
                            <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="newFile" id="newFile">
                                <div class="modal-dialog modal-sm" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="exampleModalLabel">新建文件夹</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form action="createFile.action">
                                                <div class="form-group">
                                                    <label for="recipient-name" class="control-label">文件名:</label>
                                                    <input type="text" class="form-control" id="recipient-name" name="name">
                                                </div>

                                            <div class="modal-footer">
                                                <button class="btn btn-default" type="submit">确定</button>
                                            </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <button class="btn btn-default">分享</button>
                        </div>
                        <div class="col-md-3"></div>
                        <div class="col-md-3">
                            <form action="search.action" id="formsearch">
                            <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for..." aria-describedby="search" name="search">
                            <span class="input-group-btn">
                            <button class="btn btn-default glyphicon glyphicon-search" type="button" id="search" onclick="searchFile()"></button>
                            </span>
                        </div><!-- /input-group -->
                            </form>
                        </div>
                    </div>
                    <div class="row" style="height: 36px;">
                        <div href="col-md-12">
                            <ol class="breadcrumb">
                                <s:iterator var="s" value="#session.bar">
                                <li><a href="show.action?filePath=${s.path}">${s.name}</a></li>
                                </s:iterator>
                                <%--<li><a href="#">Library</a></li>--%>
                                <%--<li class="active">Data</li>--%>
                            </ol>
                        </div>
                    </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12" style="padding-right: 15px;
    padding-left: 0px;">
                            <table class="table" id="table" style="max-height:280px ">
                                <thead>
                                    <tr>
                                        <th>选择</th>
                                        <th>文件名</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                        <form action="deleteFile.action" method="post" id="form1">
                                            <s:iterator var="file" value="#session.dirList">

                                                <td><input type="checkbox" name="selectAll" value="${file.path}"></td>
                                                        <td>
                                                            <span class="glyphicon glyphicon-folder-open"></span>
                                                            <a href="show.action?filePath=${file.path}" style="color: #424e67">${file.name}
                                                            </a>
                                                        </td>


                                                </tr>
                                            </s:iterator>
                                            <s:iterator var="file" value="#session.fileList">
                                                <tr>
                                                    <td><input type="checkbox" name="selectAll" value="${file.filePath}"></td>
                                                    <td style="color: #424e67">${file.fileName}</td>
                                                    <td><a href="down.action?fileName=${file.fileName}&path=${file.filePath}&contentType=${file.contentType}">下载</a>  </td>
                                                </tr>

                                            </s:iterator>
                                        </form>



                            </table>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>



<script type="text/javascript">
  function deleteFile() {
     var form1 =   document.getElementById("form1");
     var action1=form1.getAttribute("action");
     action1.valueOf("deleteFile");
     form1.submit();
  }
  function searchFile() {
      var form1 =   document.getElementById("formsearch");
      form1.submit();
  }
</script>
<script>
    $("#input-b1").fileinput({
        uploadUrl: "upload.action?savePath=${sessionScope.filePath}", // server upload action
        uploadAsync: true,
        maxFileCount: 5,
        showBrowse: false,
        browseOnZoneClick: true,

    })
    $(document).on('fileuploaded', function(event, data, previewId, index) {
        var result = data.response; //后台返回的json
        var json = JSON.stringify(result);
        var obj = jQuery.parseJSON(json);
        if (obj.code !== "200") {
        }

    });
</script>
</body>
</html>
