package com.svsong.items.test;

import com.svsong.items.bean.Items;
import com.svsong.items.bean.Unit;
import com.svsong.items.dao.ItemsMapper;
import com.svsong.items.dao.UnitMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 *
 * @author lfy
 * 推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    UnitMapper unitMapper;

    @Autowired
    ItemsMapper itemsMapper;

    @Autowired
    SqlSession sqlSession;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD() {
	/*	//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
        System.out.println(unitMapper);

//        //1、插入几个部门
//		unitMapper.insertSelective(new Unit(null,"虎门营业区"));
//		unitMapper.insertSelective(new Unit(null,"石龙营业区"));


//        //2、生成物品数据，测试插入
//        itemsMapper.insertSelective(new Items(null, "惠普", "光影精灵", 62, "A", "省公司发配", "本部仓库", "综合部", "综合部", "综合部", 1));
//        itemsMapper.insertSelective(new Items(null, "华硕", "天选", 16, "A", "省公司发配", "本部仓库", "综合部", "综合部", "综合部", 1));
//        itemsMapper.insertSelective(new Items(null, "联想", "拯救者Y7000）", 8, "A", "省公司发配", "本部仓库", "综合部", "综合部", "综合部", 1));
//        itemsMapper.insertSelective(new Items(null, "ROG", "幻14", 3, "A", "省公司发配", "本部仓库", "综合部", "综合部", "综合部", 1));


        //3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession。

//		for(){
//			employeeMapper.insertSelective(new Employee(null, , "M", "Jerry@atguigu.com", 1));
//		}

//        ItemsMapper mapper = sqlSession.getMapper(ItemsMapper.class);
//        for (int i = 0; i < 188; i++) {
//            String uName = UUID.randomUUID().toString().substring(0, 4)+i;
//            mapper.insertSelective(new Items(null,uName , "最新", 1, "A", "购买", "本部仓库", "综合部1", "综合部2", "综合部3", 13));
//        }
//        System.out.println("批量完成");

    }

}
