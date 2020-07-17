package com.svsong.items.controller;

import com.svsong.items.bean.Msg;
import com.svsong.items.bean.Unit;
import com.svsong.items.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和单位有关的信息
 * 即在新增时，查询单位信息来选择单位进行输入，而不是文字输入
 */
@Controller
public class UnitController {

    @Autowired
    private UnitService unitService;

    /**
     * 返回所有的部门信息
     * //所有Jason的数据返回都包装为Msg对象
     */
    @RequestMapping("/units")
    @ResponseBody
    public Msg getUnits() {
        //查出的所有部门信息
        List<Unit> list = unitService.getUnits();
        return Msg.success().add("units", list);
    }
}
