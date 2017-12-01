<%--
  Created by IntelliJ IDEA.
  User: 吴亚斌
  Date: 2017/11/19
  Time: 20:35
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
<table id="table"></table>
<script type="text/javascript">
    $(dir).ready(function () {
        $('#table').bootstrapTable({
            url:"json/json",//请求数据url
            data:"json/show",
//            queryParams: function (params) {
//                return {
//                    offset: params.offset,  //页码
//                    limit: params.limit,   //页面大小
//                    search : params.search, //搜索
//                    order : params.order, //排序
//                    ordername : params.sort, //排序
//                };
//            },
            showHeader : true,
            showColumns : true,
            showRefresh : true,
            pagination: true,//分页
            sidePagination : 'server',//服务器端分页
            pageNumber : 1,
            pageList: [5, 10, 20, 50],//分页步进值
            search: true,//显示搜索框
            //表格的列
            columns: [
                {
                    field: 'id',//域值
                    title: '规则ID',//标题
                    visible: true,//false表示不显示
                    sortable: true,//启用排序
                    width : '5%',
                },
                {
                    field: 'fileName',//域值
                    title: '唯一英文标识',//标题
                    visible: true,//false表示不显示
                    sortable: true,//启用排序
                    width : '30%',
                    editable:true,
                },
                {
                    field: 'cotentType',//域值
                    title: '中文描述',//内容
                    visible: true,//false表示不显示
                    sortable: true,//启用排序
                    width : '35%',
                    editable:true,
                },
                {
                    field: 'uuidName',//域值
                    title: '状态',//内容
                    visible: true,//false表示不显示
                    sortable: true,//启用排序
                    width : '20%',
                    formatter : function (value, row, index) {
                        if (row['status'] === 1) {
                            return '正常';
                        }
                        if (row['status'] === 0) {
                            return '禁用';
                        }
                        return value;
                    }
                }
            ]
        });
    })

</script>
</body>
</html>
