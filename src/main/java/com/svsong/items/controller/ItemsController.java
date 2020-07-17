package com.svsong.items.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.svsong.items.bean.Items;
import com.svsong.items.bean.Msg;
import com.svsong.items.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器：处理物品增删改查请求
 */
@Controller
public class ItemsController {
    /**
     * @Autowired 自动装配service层的业务组件，
     * 而service层的业务组件，查出所有的物品数据
     * 故创建getAll()方法
     */
    @Autowired
    ItemsService itemsService;

    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/item/{ids}",method=RequestMethod.DELETE)
    @SuppressWarnings("unchecked")
    public Msg deleteItem(@PathVariable("ids")String ids){

        if(ids.contains("-")){
            //批量删除
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            itemsService.deleteBatch(del_ids);
        }else{
            //单个删除
            Integer id = Integer.parseInt(ids);
            itemsService.deleteItem(id);
        }
        return Msg.success();
    }

    /**
     * 如果直接发送ajax=PUT形式的请求
     * 封装的数据
     * Employee
     * [empId=1014, empName=null, gender=null, email=null, dId=null]
     *
     * 问题：
     * 请求体中有数据；
     * 但是Employee对象封装不上；
     * update tbl_emp  where emp_id = 1014;
     *
     * 原因：
     * Tomcat：
     * 		1、将请求体中的数据，封装一个map。
     * 		2、request.getParameter("empName")就会从这个map中取值。
     * 		3、SpringMVC封装POJO对象的时候。
     * 				会把POJO中每个属性的值，request.getParamter("email");
     * AJAX发送PUT请求引发的血案：
     * 		PUT请求，请求体中的数据，request.getParameter("empName")拿不到
     * 		Tomcat一看是PUT不会封装请求体中的数据为map，只有POST形式的请求才封装请求体为map
     * org.apache.catalina.connector.Request--parseParameters() (3111);
     *
     * protected String parseBodyMethods = "POST";
     * if( !getConnector().isParseBodyMethod(getMethod()) ) {
     success = true;
     return;
     }
     *
     *
     * 解决方案；
     * 我们要能支持直接发送PUT之类的请求还要封装请求体中的数据
     * 1、配置上HttpPutFormContentFilter；
     * 2、他的作用；将请求体中的数据解析包装成一个map。
     * 3、request被重新包装，request.getParameter()被重写，就会从自己封装的map中取数据
     * 物品更新方法
     * 编辑页面，点击更新按钮
     * @param item
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/item/{itemId}",method=RequestMethod.PUT)
    public Msg saveItem(Items item,HttpServletRequest request){
        itemsService.updateItem(item);
        return Msg.success()	;
    }


    /**
     * 修改物品时，查询物品的信息
     * 按照物品id查询
     * {id}来自请求地址的变量
     * @return
     */
    @RequestMapping(value="/item/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Msg getItem(@PathVariable("id")Integer id) {
        Items item = itemsService.getItem(id);
        return Msg.success().add("item", item);
    }




    /**
     * 物品保存
     * 1、支持JSR303校验
     * 2、导入Hibernate-Validator
     *
     * @return
     */
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Msg saveItem(@Valid Items items, BindingResult result) {
        if (result.hasErrors()) {
            //校验失败，应该返回失败，在模态框中显示后端校验失败的错误信息
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            itemsService.saveItem(items);
            return Msg.success();
        }

    }


    /**
     * 导入Jackson 包
     *
     * @param pn
     * @return
     */
    @RequestMapping("/items")
    //@ResponseBody 自动把返回地对象转为字符串
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Msg getItemsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        //startPage后面紧跟着的查询是就是一个分页查询
        List<Items> items = itemsService.getAll();
        //使用PageInfo包装查询后的结果，只需将PageInfo page交给页面即可
        //封装了详细的信息：包括查询出来的数据
        //5是导航栏下方，连续显示的页数
        PageInfo page = new PageInfo(items, 6);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 查询物品列表 ，获取所有物品
     * RequestMapping注解，处理/items请求（分页查询）
     * 需调用service层，故创建ItemsService itemsService
     *
     * @return
     */
    //@RequestMapping("/items")
    //自定义pagenumber->pn,传入第几页,若没传，默认值为1
    @SuppressWarnings("unchecked")
    public String getItems(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        /**
         * 故创建getAll()，方法这不是分页查询，
         * 故引入PageHelper分页插件
         * 在查询之前，只需调用PageHelper.startPage，并传入页码和每页的大小（每页8行数据）
         */
        PageHelper.startPage(pn, 8);
        //startPage后面紧跟着的查询是就是一个分页查询
        List<Items> items = itemsService.getAll();
        //使用PageInfo包装查询后的结果，只需将PageInfo page交给页面即可
        //封装了详细的信息：包括查询出来的数据
        //5是导航栏下方，连续显示的页数
        PageInfo page = new PageInfo(items, 5);
        model.addAttribute("pageInfo", page);

        return "list";//来到list.jsp进行展示
        //因为配置了视图解析器dispatcherServlet-servlet.xml，
        //会来到"/WEB-INF/views/"故在views下创建list.jsp
    }
}
