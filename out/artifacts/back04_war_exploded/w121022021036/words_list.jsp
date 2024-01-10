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
    <title>单词本</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <style>
        body {
            background-color: #f2f2f2; /*护眼的浅灰色*/
        }
    </style>
</head>
<body>
<table class="table table-bordered table-hover">
    <tr>
        <th width="100px">编号</th>
        <th width="200px">单词</th>
        <th width="200px">音标</th>
        <th width="850px">解释</th>
        <th width="600px">派生</th>
        <th width="450px">操作</th>
    </tr>
    <c:forEach var="w" items="${p.getList() }" varStatus="s">
        <tr>
            <td><p>${s.count + p.pageSize * (p.pageNo-1) }</p></td>
            <td><p>${w.word }</p></td>
            <td><p>${w.mark }</p></td>
            <td><p>${w.intro }</p></td>
            <td><p>${w.derivative }</p></td>
            <td>
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath}/w121022021036/words_add.jsp?id=${w.id }&pageNo=${p.pageNo}">新增单词</a>
                <a class="btn btn-danger"
                   href="${pageContext.request.contextPath}/s121022021036/words_del?id=${w.id }&pageNo=${p.pageNo}">删除单词</a>
                <a class="btn btn-info"
                   href="${pageContext.request.contextPath}/s121022021036/words_editShow?id=${w.id }&pageNo=${p.pageNo}">修改单词</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div style='text-align:center;'>
    <a class='btn btn-info' <c:if test="${p.pageNo==1}"> disabled </c:if>
            <c:if test="${p.pageNo!=1}"> href="${param.url}?pageNo=1${param.param}" </c:if>>首页</a>
    <a class='btn btn-info' <c:if test="${p.pageNo==1}"> disabled </c:if>
            <c:if test="${p.pageNo!=1}"> href="${param.url}?pageNo=${p.pageNo-1}${param.param}" </c:if>>上一页</a>
    <h3 style='display:inline;'> [${p.pageNo }/${p.totalPage}] </h3>
    <h3 style='display:inline;'> [${p.totalCount}] </h3>
    <a class='btn btn-info'
            <c:if test="${p.totalPage==0 || p.pageNo==p.totalPage}"> disabled </c:if>
            <c:if test="${p.pageNo!=p.totalPage}"> href="${param.url}?pageNo=${p.pageNo+1}${param.param}" </c:if>>下一页</a>
    <a class='btn btn-info' <c:if test="${p.totalPage==0 || p.pageNo==p.totalPage}"> disabled </c:if>
            <c:if test="${p.pageNo!=p.totalPage}"> href="${param.url}?pageNo=${p.totalPage}${param.param}" </c:if>>尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' onclick='location.href="${param.url}?pageNo="+(this.previousSibling.value) + "${param.param}"'>GO</a>
</div>
</body>
</html>