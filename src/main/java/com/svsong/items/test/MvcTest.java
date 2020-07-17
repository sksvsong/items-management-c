//package com.svsong.items.test;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import com.svsong.items.bean.Items;
//import com.github.pagehelper.PageInfo;
//
//
///**
// * 使用Spring测试模块提供的测试请求功能，测试/items请求的准确性
// * Spring4测试的时候，需要servlet3.0的支持
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = { "classpath:applicationContext.xml",
//        "file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })
//public class MvcTest {
//    //传入SpringMvc的ioc
//    @Autowired
//    WebApplicationContext context;
//    // 虚拟mvc请求，获取到处理结果。
//    MockMvc mockMvc;
//
//    @Before
//    public void initMockMcv() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Before
//    public void initMockMvc() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//    @Test
//    public void testPage() throws Exception {
//        //模拟请求拿到返回值
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/items").param("pn", "2"))
//                .andReturn();//第2页数据
//
//        //请求成功以后，请求域中会有pageInfo；我们可以取出pageInfo进行验证
//        MockHttpServletRequest request = result.getRequest();
//        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
//        System.out.println("当前页码：" + pi.getPageNum());
//        System.out.println("总页码：" + pi.getPages());
//        System.out.println("总记录数：" + pi.getTotal());
//        System.out.println("在页面需要连续显示的页码");
//        int[] nums = pi.getNavigatepageNums();
//        for (int i : nums) {
//            System.out.print(" " + i);
//        }
//        System.out.println();
//
//        //获取物品数据
//        List<Items> list = pi.getList();
//        for (Items item : list) {
//            System.out.println("ID：" + item.getItemId() + "==>Name:" + item.getItemName());
//        }
//
//    }
//
//}
