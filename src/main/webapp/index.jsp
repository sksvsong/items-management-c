<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>卡片信息</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!-- web路径：
    不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
    以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
            http://localhost:3306/crud。
    http://localhost:8080/ssm-curd/src/main/webapp/index.jsp
            request.getContextPath()得到的是/webapp
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

<!-- 修改卡片的模态框 id="itemUpdateModal"-->
<div class="modal fade" id="itemUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">卡片修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <%--                    这些 name 值，要和bean里的值一样--%>
                    <%--物品名称--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">物品名称</label>
                        <div class="col-sm-8">
                            <p class="form-control-static" id="itemName_update_static"></p>
                        </div>
                    </div>
                    <%--型号--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">型号</label>
                        <div class="col-sm-8">
                            <p class="form-control-static" id="model_update_static"></p>
                        </div>
                    </div>
                    <%--数量--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-8">
                            <input type="number" name="itemNum" class="form-control" id="num_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--使用状态--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用状态</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="itemUsageStatus" id="usageStatus1_update_input" value="A"
                                       checked="checked"> 正常
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="itemUsageStatus" id="usageStatus2_update_input" value="B"> 待发放
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="itemUsageStatus" id="usageStatus3_update_input" value="C"> 待报废
                            </label>
                        </div>
                    </div>
                    <%--来源--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">来源</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemSource" class="form-control" id="source_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--存放地点--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">存放地点</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemStorageLocation" class="form-control"
                                   id="storageLocation_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--保管人姓名--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">保管人姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemCustodian" class="form-control" id="custodian_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--使用人姓名--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用人姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemUser" class="form-control" id="user_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--使用单位-用id--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用单位</label>
                        <div class="col-sm-6">
                            <!-- 部门的话，提交部门id即可  还是“itemUnitId”-->
                            <select class="form-control" name="itemUnitId">
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用部门</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemUseDept" class="form-control" id="useDept_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="item_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>


<!-- 新建卡片的模态框 id="itemAddModal"-->
<div class="modal fade" id="itemAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">卡片建立</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <%--                    这些 name 值，要和bean里的值一样--%>
                    <%--物品名称--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">物品名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemName" class="form-control" id="itemName_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--型号--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">型号</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemModel" class="form-control" id="model_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--数量--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">数量</label>
                        <div class="col-sm-8">
                            <input type="number" name="itemNum" class="form-control" id="num_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--使用状态--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用状态</label>
                        <div class="col-sm-8">
                            <label class="radio-inline">
                                <input type="radio" name="itemUsageStatus" id="usageStatus1_add_input" value="A"
                                       checked="checked"> 正常
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="itemUsageStatus" id="usageStatus2_add_input" value="B"> 待发放
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="itemUsageStatus" id="usageStatus3_add_input" value="C"> 待报废
                            </label>
                        </div>
                    </div>
                    <%--来源--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">来源</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemSource" class="form-control" id="source_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--存放地点--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">存放地点</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemStorageLocation" class="form-control"
                                   id="storageLocation_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--保管人姓名--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">保管人姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemCustodian" class="form-control" id="custodian_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--使用人姓名--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用人姓名</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemUser" class="form-control" id="user_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <%--使用单位-用id--%>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用单位</label>
                        <div class="col-sm-6">
                            <!-- 部门的话，提交部门id即可  还是“itemUnitId”-->
                            <select class="form-control" name="itemUnitId">
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">使用部门</label>
                        <div class="col-sm-8">
                            <input type="text" name="itemUseDept" class="form-control">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="item_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>


<!-- 搭建显示页面 -->
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-12">
            <h3>物品管理系统</h3>
        </div>
    </div>
    <!-- 按钮 -->
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary btn-sm" id="item_add_modal_btn">新建卡片</button>
            <button class="btn btn-danger btn-sm" id="item_delete_all_btn">批量删除</button>
        </div>
    </div>
    <!-- 显示表格数据 -->
    <div class="row">
        <div class="col-md-12">
            <table class="table rtable-hover table-striped table-bordered table-condensed" id="items_table">
                <thead>
                <tr>
                    <td>
                        <input type="checkbox" id="check_all"/>
                    </td>
                    <td>#</td>
                    <td>物品名称</td>
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
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    <!-- 显示分页信息 -->
    <div class="row">
        <!--分页文字信息  -->
        <div class="col-md-6" id="page_info_area"></div>
        <!-- 分页条信息 -->
        <div class="col-md-6" id="page_nav_area"></div>
    </div>
</div>

<script type="text/javascript">
    var totalRecord, currentPage;//currentPage员工信息更新后，回到本页面
    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function () {
        //去首页
        to_page(1);
    });

    //跳转页面
    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/items",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                //console.log(result);
                //1、解析并显示员工数据
                build_items_table(result);
                //2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);
            }
        });
    }

    //显示表格里的数据
    function build_items_table(result) {
        //清空table表格
        $("#items_table tbody").empty();
        var items = result.extend.pageInfo.list;
        $.each(items, function (index, item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var itemIdTd = $("<td></td>").append(item.itemId);
            var itemNameTd = $("<td></td>").append(item.itemName);
            var modelTd = $("<td></td>").append(item.itemModel);
            var numTd = $("<td></td>").append(item.itemNum);

            var status = "";
            if(item.itemUsageStatus == "A") {
                status = "正常";
            } else if (item.itemUsageStatus == "B") {
                status = "待发放";
            } else if (item.itemUsageStatus == "C") {
                status = "待报废";
            } else {
                status = item.itemUsageStatus;
            }
            var usageStatusTd = $("<td></td>").append(status);

            var sourceTd = $("<td></td>").append(item.itemSource);
            var storageLocationTd = $("<td></td>").append(item.itemStorageLocation);
            var custodianTd = $("<td></td>").append(item.itemCustodian);
            var userTd = $("<td></td>").append(item.itemUser);

            //怎么做
            var unitNameTd = $("<td></td>").append(item.unit.unitName);

            var useDeptTd = $("<td></td>").append(item.itemUseDept);
            /**
             <button class="">
             <span class="" aria-hidden="true"></span>
             编辑
             </button>
             */
                //通过edit_btn delete_btn来绑定单击事件
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-xs edit_btn")
                    .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            //为编辑按钮添加一个自定义的属性，来表示当前物品的id（修用于修改）
            editBtn.attr("edit-id", item.itemId);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-xs delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            //为删除按钮添加一个自定义的属性来表示当前删除的员工id
            delBtn.attr("del-id", item.itemId);

            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            //var delBtn =
            //append方法执行完成以后还是返回原来的元素
            $("<tr></tr>").append(checkBoxTd)
                .append(itemIdTd)
                .append(itemNameTd)
                .append(modelTd)
                .append(numTd)
                .append(usageStatusTd)
                .append(sourceTd)
                .append(storageLocationTd)
                .append(custodianTd)
                .append(userTd)
                .append(unitNameTd)
                .append(useDeptTd)
                .append(btnTd)
                .appendTo("#items_table tbody");
        });
    }

    //解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页,总" +
            result.extend.pageInfo.pages + "页,总" +
            result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    //解析显示分页条，点击分页要能去下一页....
    function build_page_nav(result) {
        //page_nav_area
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");

        //构建元素
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页的事件
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        //添加首页和前一页 的提示
        ul.append(firstPageLi).append(prePageLi);
        //1,2，3遍历给ul中添加页码提示
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            ul.append(numLi);
        });
        //添加下一页和末页 的提示
        ul.append(nextPageLi).append(lastPageLi);

        //把ul加入到nav
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //清空表单样式及内容
    function reset_form(ele) {
        //清空表单内容
        $(ele)[0].reset();
        //清空表单样式
        //$(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮弹出模态框。
    $("#item_add_modal_btn").click(function () {
        //清除表单数据（表单完整重置（表单的数据，表单的样式））
        reset_form("#itemAddModal form");
        //s$("")[0].reset();
        //发送Ajax请求，查出单位信息，显示在下拉列表中
        getUnits("#itemAddModal select");
        //弹出模态框的代码
        $("#itemAddModal").modal({
            backdrop: "static"
        })
    })

    //在数据库中，查出所有的单位信息，并显示在下拉列表中
    function getUnits(ele) {
        //清空之前下拉列表的值
        $(ele).empty();
        //发送Ajax请求
        $.ajax({
            //向服务器要所有的部门信息/units
            //在controller创建方法UnitController
            url: "${APP_PATH}/units",
            type: "GET",
            success: function (result) {
                // extend: {depts: Array(8)-deptId: 17, deptName: "开发部"
                // console.log(result)
                //在下拉列表中显示部门信息
                // $("#unit_add_select")//法1
                // $("#itemAddModal select").append()//模态框里只有select
                $.each(result.extend.units, function () {
                    var optionEle = $("<option></option>").append(this.unitName).attr("value", this.unitId);
                    optionEle.appendTo(ele);
                })
            }
        })
    }

    //校验表单数据
    function validate_add_form() {
        //1、拿到要校验的数据，使用正则表达式
        var itemNum = $("#num_add_input").val();
        // var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        var regNum = /^[0-9]*[1-9][0-9]*$/
        if (!regNum.test(itemNum)) {
            //alert("用户名可以是2-5位中文或者6-16位英文和数字的组合");
            show_validate_msg("#num_add_input", "error", "数量应该是大于零的数字");
            return false;
        } else {
            show_validate_msg("#num_add_input", "success", "");
        }
        //2、校验邮箱信息
        // var email = $("#email_add_input").val();
        // var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        // if (!regEmail.test(email)) {
        //     //alert("邮箱格式不正确");
        //     //应该清空这个元素之前的样式
        //     show_validate_msg("#email_add_input", "error", "邮箱格式不正确");
        //     /* $("#email_add_input").parent().addClass("has-error");
        //     $("#email_add_input").next("span").text("邮箱格式不正确"); */
        //     return false;
        // } else {
        //     show_validate_msg("#email_add_input", "success", "");
        // }
        return true;
    }

    //显示校验结果的提示信息
    function show_validate_msg(ele, status, msg) {
        //清除当前元素的校验状态
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if ("success" == status) {
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        } else if ("error" == status) {
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }

    <%--//校验用户名是否可用--%>
    <%--$("#empName_add_input").change(function () {--%>
    <%--    //发送ajax请求校验用户名是否可用--%>
    <%--    var empName = this.value;--%>
    <%--    $.ajax({--%>
    <%--        url: "${APP_PATH}/checkuser",--%>
    <%--        data: "empName=" + empName,--%>
    <%--        type: "POST",--%>
    <%--        success: function (result) {--%>
    <%--            if (result.code == 100) {--%>
    <%--                show_validate_msg("#empName_add_input", "success", "用户名可用");--%>
    <%--                $("#emp_save_btn").attr("ajax-va", "success");--%>
    <%--            } else {--%>
    <%--                show_validate_msg("#empName_add_input", "error", result.extend.va_msg);--%>
    <%--                $("#emp_save_btn").attr("ajax-va", "error");--%>
    <%--            }--%>
    <%--        }--%>
    <%--    });--%>
    <%--});--%>

    //点击保存,保存卡片。
    $("#item_save_btn").click(function () {
        //1、模态框中填写的表单数据提交给服务器进行保存
        //1、先对要提交给服务器的数据进行校验
        if (!validate_add_form()) {
            return false;
        }
        //1、判断之前的ajax用户名校验是否成功。如果成功。
        // if ($(this).attr("ajax-va") == "error") {
        //     return false;
        // }

        //2、发送ajax请求保存物品
        $.ajax({
            url: "${APP_PATH}/item",
            type: "POST",
            data: $("#itemAddModal form").serialize(),
            success: function (result) {
                //alert(result.msg);
                if (result.code == 100) {
                    //卡片保存成功；
                    //1、关闭模态框
                    $("#itemAddModal").modal('hide');

                    //2、来到最后一页，显示刚才保存的数据
                    //发送ajax请求显示最后一页数据即可
                    to_page(totalRecord);
                } else {
                    //显示失败信息
                    //console.log(result);
                    //有哪个字段的错误信息就显示哪个字段的；
                    if (undefined != result.extend.errorFields.itemNum) {
                        //显示员工名字的错误信息
                        show_validate_msg("#num_add_input", "error", result.extend.errorFields.itemNum);
                    }
                }
            }
        });
    });


    //点击每条数据右侧的“编辑”按钮
    //1、我们是按钮创建之前就绑定了click，所以绑定不上。
    //页面一加载，就会执行js代码，进行事件的绑定
    //表格中的数据，是页面加载完成之后发送的Ajax请求
    //故方法1）、可以在创建按钮的时候绑定。    方法2）、绑定点击.live()，即使该元素是以后再添加进来的，也可以绑定事件
    //jquery新版没有live，使用on进行替代
    $(document).on("click", ".edit_btn", function () {
        //alert("edit");
        //1、查出单位信息，并显示单位列表
        getUnits("#itemUpdateModal select");
        //2、查出要修改的物品信息，显示物品的名称、型号，这两个选项不允许修改
        //this表示当前被点击的按钮
        getItem($(this).attr("edit-id"));

        //3、把编辑按钮上的员工的id传递给模态框到更新按钮
        $("#item_update_btn").attr("edit-id", $(this).attr("edit-id"));
        $("#itemUpdateModal").modal({
            backdrop: "static"
        });
    });

    //查出要修改的物品信息
    function getItem(id) {
        $.ajax({
            url: "${APP_PATH}/item/" + id,
            type: "GET",
            success: function (result) {
                var itemData = result.extend.item;
                $("#itemName_update_static").text(itemData.itemName);
                $("#model_update_static").text(itemData.itemModel);
                $("#num_update_input").val(itemData.itemNum);
                $("#itemUpdateModal input[name=itemUsageStatus]").val([itemData.itemUsageStatus]);

                $("#source_update_input").val(itemData.itemSource);
                $("#storageLocation_update_input").val(itemData.itemStorageLocation);
                $("#custodian_update_input").val(itemData.itemCustodian);
                $("#user_update_input").val(itemData.itemUser);

                $("#empUpdateModal select").val([itemData.itemUnitId]);
                $("#useDept_update_input").val(itemData.itemUseDept);
            }
        });
    }

    //点击更新按钮，更新物品信息
    $("#item_update_btn").click(function () {
        //验证数量是否合法
        //1、校验邮箱信息
        var num = $("#num_update_input").val();
        var regNum = /^[0-9]*[1-9][0-9]*$/;
        if (!regNum.test(num)) {
            show_validate_msg("#num_update_input", "error", "数量输入不正确");
            return false;
        } else {
            show_validate_msg("#num_update_input", "success", "");
        }

        //2、发送ajax请求，保存更新的物品数据
        //弹出编辑的模态框，把编辑按钮上的物品id，传递到更新按钮上
        $.ajax({
            url: "${APP_PATH}/item/" + $(this).attr("edit-id"),
            type: "PUT",
            data: $("#itemUpdateModal form").serialize(),
            success: function (result) {
                //alert(result.msg);
                //1、关闭对话框
                $("#itemUpdateModal").modal("hide");
                //2、回到本页面
                to_page(currentPage);
            }
        });
    });

    //单个删除
    $(document).on("click", ".delete_btn", function () {
        //1、弹出是否确认删除对话框
        //$(this):当前点击的删除按钮
        var itemName = $(this).parents("tr").find("td:eq(2)").text();
        var itemModel = $(this).parents("tr").find("td:eq(3)").text();
        var itemId = $(this).attr("del-id");
        if (confirm("确认删除【" + itemName + "-"+ itemModel + "】吗？")) {
            //确认，发送ajax请求删除即可
            $.ajax({
                url: "${APP_PATH}/item/" + itemId,
                type: "DELETE",
                success: function (result) {
                    alert(result.msg);
                    //回到本页
                    to_page(currentPage);
                }
            });
        }
    });

    //完成全选/全不选功能
    $("#check_all").click(function () {
        //attr获取checked是undefined;
        //我们这些dom原生的属性；采用attr获取自定义属性的值；
        //      采用prop修改和读取dom原生属性的值
        //$(".check_item")根据class查找表格中的选择框
        //表头中选择框框的状态：$(this).prop("checked")
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    //check_item
    //为表格中的选择框绑定事件，同理用“on”来绑定
    $(document).on("click", ".check_item", function () {
        //判断当前选择中的元素是否5个
        //表单中选择框的个数：$(".check_item").length
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });

    //点击批量删除，完成批量删除操作
    $("#item_delete_all_btn").click(function () {
        //
        var itemNames = "";
        var del_idstr = "";
        $.each($(".check_item:checked"), function () {
            //this代表当前遍历的.check_item:checked的选择框
            //.parents("tr")找为tr的祖先元素
            itemNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
            //组装员工id字符串
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        //去除itemNames多余的","
        itemNames = itemNames.substring(0, itemNames.length - 1);
        //去除删除的id多余的"-"
        del_idstr = del_idstr.substring(0, del_idstr.length - 1);
        if (confirm("确认删除【" + itemNames + "】吗？")) {
            //发送ajax请求删除
            $.ajax({
                url: "${APP_PATH}/item/" + del_idstr,
                type: "DELETE",
                success: function (result) {
                    alert(result.msg);
                    //回到当前页面
                    to_page(currentPage);
                }
            });
        }
    });
</script>
</body>
</html>
