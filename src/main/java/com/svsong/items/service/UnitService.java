package com.svsong.items.service;

import com.svsong.items.bean.Unit;
import com.svsong.items.dao.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitMapper unitMapper;

    public List<Unit> getUnits() {
        //null:查询所有，没条件
        List<Unit> units = unitMapper.selectByExample(null);
        return units;
    }
}
