<%@ page import="com.book.domain.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>借阅排行</title>
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


<c:if test="${!empty admin.admin_id}">
    <nav  style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default" role="navigation" >
        <div class="container-fluid">
            <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
                <a class="navbar-brand" href="admin_main.html">图书管理系统</a>
            </div>
            <div class="collapse navbar-collapse" >
                <ul class="nav navbar-nav navbar-left">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            图书管理
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="allbooks.html">全部图书</a></li>
                            <li class="divider"></li>
                            <li><a href="book_add.html">增加图书</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            读者管理
                            <b class="caret"></b>
                        </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="allreaders.html">全部读者</a></li>
                                        <li class="divider"></li>
                                        <li><a href="reader_add.html">增加读者</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        借还管理
                                        <b class="caret"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="lendlist.html">借还日志</a></li>
                                    </ul>
                                </li>
                                <li ><a href="bookRank.html" >借阅排行</a></li>
                                <li >
                                    <a href="admin_repasswd.html" >
                                        密码修改
                                    </a>
                                </li>
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="login.html"><span class="glyphicon glyphicon-user"></span>&nbsp;${admin.admin_id}，已登录</a></li>
                                <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
</c:if>
<c:if test="${!empty readercard.name}">
    <nav class="navbar navbar-default" role="navigation" style="background-color:#fff" style="background-color:#fff">
        <div class="container-fluid">
            <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
                <a class="navbar-brand active" href="reader_main.html"><p class="text-primary">我的图书馆</p></a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="readerbooks.html">全部图书</a></li>
                    <li><a href="reader_querybook.html" >图书查询</a></li>
                    <li><a href="reader_info.html" >个人信息</a></li>
                    <li><a href="mylend.html" >我的借还</a></li>
                    <li><a href="bookRank.html" >借阅排行</a></li>
                    <li><a href="reader_repasswd.html" >密码修改</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="reader_info.html"><span class="glyphicon glyphicon-user"></span>&nbsp;${readercard.name}，已登录</a></li>
                    <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
                </ul>
            </div>
        </div>
    </nav>
</c:if>





<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            借阅排行榜
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>借阅次数</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><c:out value="${book.name}"></c:out></td>
                    <td><c:out value="${book.author}"></c:out></td>
                    <td><c:out value="${book.publish}"></c:out></td>
                    <td><c:out value="${book.num}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
