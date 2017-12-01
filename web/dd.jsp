<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/11/19
  Time: 21:15
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
<div class="container">
    <div class="bs-example" data-example-id="hoverable-table">
        <table class="table table-hover editable">
            <thead>
            <tr>
                <th>#</th>
                <th>Test</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Operations</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td></td>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td><a href="javascript:void(0)" class="edit"></a></td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td></td>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
                <td><!--<a href="javascript:void(0)" class="edit"></a>--></td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td></td>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
                <td><!--<a href="javascript:void(0)" class="edit"></a>--></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="editTable.js"></script>
<script>
    $(function() {
        $('.edit').handleTable({"cancel" : "<span class='glyphicon glyphicon-remove'></span>"});
        $('.editable').handleTable({
            "handleFirst" : true,
            "cancel" : " <span class='glyphicon glyphicon-remove'></span> ",
            "edit" : " <span class='glyphicon glyphicon-edit'></span> ",
            "add" : " <span class='glyphicon glyphicon-plus'></span> ",
            "save" : " <span class='glyphicon glyphicon-saved'></span> ",
            "confirm" : " <span class='glyphicon glyphicon-ok'></span> ",
            "operatePos" : -1,
            "editableCols" : [2,3,4],
            "order": ["add","edit"],
            "saveCallback" : function(data, isSuccess) { //这里可以写ajax内容，用于保存编辑后的内容
                //data: 返回的数据
                //isSucess: 方法，用于保存数据成功后，将可编辑状态变为不可编辑状态
                var flag = true; //ajax请求成功（保存数据成功），才回调isSuccess函数（修改保存状态为编辑状态）
                if(flag) {
                    isSuccess();
                    alert(data + " 保存成功");
                } else {
                    alert(data + " 保存失败");
                }

                return true;
            },
            "addCallback" : function(data,isSuccess) {
                var flag = true;
                if(flag) {
                    isSuccess();
                    alert(data + " 增加成功");
                } else {
                    alert(data + " 增加失败");
                }
            },
            "delCallback" : function(isSuccess) {
                var flag = true;
                if(flag) {
                    isSuccess();
                    alert("删除成功");
                } else {
                    alert("删除失败");
                }
            }
        });
    });
</script>
</body>
</html>
