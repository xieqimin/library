<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息添加</title>
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

<div style="position: relative;top: 10%;width: 80%;margin-left: 10%">
            <form action="book_add_do.html" method="post" id="addbook" >
                <div class="form-group">
                    <label for="name">图书名</label>
                    <input type="text" class="form-control" name="name" id="name" placeholder="请输入书名">
                </div>
                <div class="form-group">
                    <label for="author">作者</label>
                    <input type="text" class="form-control" name="author" id="author"  placeholder="请输入作者名">
                </div>
                <div class="form-group">
                    <label for="publish">出版社</label>
                    <input type="text" class="form-control"  name="publish" id="publish"  placeholder="请输入出版社">
                </div>
                <div class="form-group">
                    <label for="isbn">ISBN</label>
                    <input type="text" class="form-control" name="isbn" id="isbn"  placeholder="请输入ISBN">
                </div>
                <div class="form-group">
                    <label for="introduction">简介</label>
                    <textarea class="form-control" rows="3"  name="introduction" id="introduction" placeholder="请输入简介"></textarea>
                </div>
                <div class="form-group">
                    <label for="language">语言</label>
                    <input type="text" class="form-control" name="language" id="language"  placeholder="请输入语言">
                </div>
                <div class="form-group">
                    <label for="price">价格</label>
                    <input type="text" class="form-control"  name="price"  id="price" placeholder="请输入价格">
                </div>
                <div class="form-group">
                    <label for="pubdate">出版日期</label>
                    <input type="text" class="form-control"  name="pubdate" id="pubdate"   placeholder="请输入出版日期">
                </div>
                <div class="form-group">
                    <label for="classId">分类号</label>
                    <!--<input type="text" class="form-control" name="classId" id="classId"  placeholder="请输入分类号">-->
                     <select id="classId" name="classId" class="form-control" >
                         <option value="1">马克思主义</option>
                         <option value="2">哲学</option>
                         <option value="3">社会科学总论</option>
                         <option value="4">政治法律</option>
                         <option value="5">军事</option>
                         <option value="6">经济</option>
                         <option value="7">文化</option>
                         <option value="8">语言</option>
                         <option value="9">文学</option>
                         <option value="10">艺术</option>
                         <option value="11">历史地理</option>
                         <option value="12">自然科学总论</option>
                         <option value="13">数理科学和化学</option>
                         <option value="14">天文学、地球科学</option>
                         <option value="15">生物科学</option>
                         <option value="16">医药、卫生</option>
                         <option value="17">农业科学</option>
                         <option value="18">工业技术</option>
                         <option value="19">交通运输</option>
                         <option value="20">航空、航天</option>
                         <option value="21">环境科学</option>
                         <option value="22">综合</option>


                 </select>
                 </div>
                 <div class="form-group">
                     <label for="pressmark">书架号</label>
                     <input type="text" class="form-control"  name="pressmark" id="pressmark" placeholder="请输入书架号">
                 </div>
                 <div class="form-group">
                     <label for="state">状态</label>
                    <!-- <input type="text" class="form-control"  name="state"  id="state"  >-->
                  <select  id="state" name="state" class="form-control" >
                      <option value ="1">可借阅</option>
                      <option value ="0">不可借阅</option>
                  </select>
                </div>
                <div class="form-group">
                    <label for="amount">数量</label>
                    <input type="text" class="form-control"  name="amount"  id="amount"   placeholder="请输入图书数量">
                </div>

                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubdate").val()==''||$("#classId").val()==''||$("#pressmark").val()==''||$("#state").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>

</div>



</body>
</html>
