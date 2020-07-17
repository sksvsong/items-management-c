package com.svsong.items.service;

import com.svsong.items.bean.Items;
import com.svsong.items.bean.ItemsExample;
import com.svsong.items.dao.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService {
    /**
     * service层要返回数据，需调用dao层
     *
     * @return
     */

    @Autowired
    ItemsMapper itemsMapper;

    /**
     * 查询所有物品
     *
     * @return
     */
    public List<Items> getAll() {
        //查询所有物品，故不带条件，为null
        return itemsMapper.selectByExampleWithUnit(null);
    }

    /**
     * 物品保存方法
     *
     * @param items
     */
    public void saveItem(Items items) {
        itemsMapper.insertSelective(items);
    }

    /**
     * 修改物品信息时，查询物品的信息
     * 按照物品id查询
     *
     * @param id
     * @return
     */
    public Items getItem(Integer id) {
        Items item = itemsMapper.selectByPrimaryKey(id);
        return item;

    }

    /**
     * 物品更新
     *
     * @param item
     */
    public void updateItem(Items item) {
//        页面来的数据中，没有物品名称、型号，带了什么就更新什么
        itemsMapper.updateByPrimaryKeySelective(item);
    }

    /**
     * 员工删除
     *批量删除
     * @param del_ids
     */
    public void deleteBatch(List<Integer> del_ids) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();

        //delete from xxx where emp_id in(1,2,3)
        criteria.andItemIdIn(del_ids);

        itemsMapper.deleteByExample(itemsExample);
    }

    /**
     * 员工删除
     *单个删除
     * @param id
     */
    public void deleteItem(Integer id) {
        itemsMapper.deleteByPrimaryKey(id);
    }


}
