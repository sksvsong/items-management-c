<%--
  Created by IntelliJ IDEA.
  User: chinalife
  Date: 2020/7/8
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--c:foreach 标签库--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>物品管理系统</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- web路径：
      不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
      以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
              http://localhost:3306/crud
       -->
    <script type="text/javascript"
            src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<%--搭建显示页面--%>
<div class="container">
    <%--    标题--%>
    <div class="row">
        <div class="col-md-12">
            <h2>物品管理系统</h2>
        </div>
    </div>
    <%--    按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary">新增卡片</button>
            <button class="btn btn-danger">批量删除</button>
        </div>
    </div>

    <%--    显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover table-striped table-bordered table-condensed">
                <tr class="info">
                    <td>#</td>
                    <td>名称</td>
                    <td>型号</td>
                    <td>数量</td>
                    <td>使用状态</td>
                    <td>来源</td>
                    <td>存放地点</td>
                    <td>保管人姓名</td>
                    <td>使用人姓名</td>
                    <td>使用单位</td>
                    <td>使用部门</td>
                    <td>操作</td>
                </tr>

                <%--                pageInfo.list是查询到的数据--%>
                <c:forEach items="${pageInfo.list}" var="item">
                    <tr>
                        <td>${item.itemId}</td>
                        <td>${item.itemName}</td>
                        <td>${item.itemModel }</td>
                        <td>${item.itemNum}</td>
                        <td>${item.itemUsageStatus}</td>
                        <td>${item.itemSource}</td>
                        <td>${item.itemStorageLocation}</td>
                        <td>${item.itemCustodian}</td>
                        <td>${item.itemUser}</td>
                        <td>${item.unit.unitName}</td>
                        <td>${item.itemUseDept}</td>
                        <td>
                            <button class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-pencil"
                                                                         aria-hidden="true"></span>编辑
                            </button>
                            <button class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-remove"
                                                                        aria-hidden="true"></span>删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <%--    显示分页信息--%>
    <div class="row">
        <%--        分页文字信息--%>
        <div class="col-md-6">
            当前第${pageInfo.pageNum}页，共${pageInfo.pages}页,共${pageInfo.total}条数据
        </div>

        <%--        分页条信息--%>
        <div class="col-md-6">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li><a href="${APP_PATH}/items?pn=1">首页</a></li>

                    <c:if test="${pageInfo.hasPreviousPage}">
                        <li>
                            <a href="${APP_PATH}/items?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                        <%--                       page_Num是取出来要遍历的，pageInfo.pageNum是当前页码 --%>
                        <c:if test="${page_Num == pageInfo.pageNum}">
                            <li class="active"><a href="#">${page_Num}</a></li>
                        </c:if>
                        <c:if test="${page_Num != pageInfo.pageNum}">
                            <li><a href="${APP_PATH}/items?pn=${page_Num}">${page_Num}</a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage}">
                        <li>
                            <a href="${APP_PATH}/items?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <li><a href="${APP_PATH}/items?pn=${pageInfo.pages}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>

</body>
</html>
