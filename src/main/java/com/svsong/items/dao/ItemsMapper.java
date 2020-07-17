package com.svsong.items.dao;

import com.svsong.items.bean.Items;
import com.svsong.items.bean.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
    long countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(Integer itemId);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(Integer itemId);

    List<Items> selectByExampleWithUnit(ItemsExample example);

    Items selectByPrimaryKeyWithUnit(Integer itemId);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);
}