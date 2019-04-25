<%--
  Created by IntelliJ IDEA.
  User: 君行天下
  Date: 2017/7/31
  Time: 8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅《 ${book.name}》</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<body>
<nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand " href="reader_main.html"><p class="text-primary">我的图书馆</p></a>
        </div>
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/readerbooks.html">全部图书</a></li>
                <li class="active">
                    <a href="reader_querybook.html" >
                        图书查询
                    </a>
                </li>
                <li>
                    <a href="reader_info.html" >
                        个人信息
                    </a>
                </li>
                <li >
                    <a href="mylend.html" >
                        我的借还
                    </a>
                </li>
                <li >
                    <a href="reader_repasswd.html" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="reader_info.html"><span class="glyphicon glyphicon-user"></span>&nbsp;${readercard.name}，已登录</a></li>
                <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 25%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">借阅《 ${book.name}》</h3>
        </div>
        <div class="panel-body">
            <form action="readerlendbookdo.html?id=${book.book_id}" method="post" id="lendbook" >
                <div class="input-group">
                    <span  class="input-group-addon">书名</span>
                    <input type="text" readonly="readonly" class="form-control" name="name" id="name" value="${book.name}">
                </div>
                <br/>
                <div class="input-group">
                    <span class="input-group-addon">读者证号</span>
                    <input type="text" readonly="readonly"  class="form-control" name="readerId" id="readerId" placeholder="借阅人读者证号" value="${readerId}" >
                </div>
                <br/>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#lendbook").submit(function () {
                        if($("#name").val()==''||$("#readerId").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
