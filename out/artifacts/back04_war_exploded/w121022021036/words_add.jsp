<%--
  Created by IntelliJ IDEA.
  User: Liwen
  Date: 2024/1/5
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加单词</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
</head>
<body>
<h2>增加单词</h2>
<form class="form-horizontal" action="${pageContext.request.contextPath}/s121022021036/words_add" method="post">
    <input type="hidden" name="id" value="${w.id }">
    <input type="hidden" name="pageNo" value="${param.pageNo }">
    <div class="form-group">
        <label for="word" class="col-sm-1 control-label">单词</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="word" name="word">
        </div>
    </div>
    <div class="form-group">
        <label for="mark" class="col-sm-1 control-label">音标</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="mark" name="mark">
        </div>
    </div>
    <div class="form-group">
        <label for="intro" class="col-sm-1 control-label">解释</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="intro" name="intro">
        </div>
    </div>
    <div class="form-group">
        <label for="derivative" class="col-sm-1 control-label">派生词</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="derivative" name="derivative">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="submit" class="btn btn-success">提交</button>
            <button onclick="history.back()" class="btn btn-success">返回</button>
        </div>
    </div>
</form>
</body>
</html>