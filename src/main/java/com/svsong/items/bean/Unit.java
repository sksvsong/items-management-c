package com.svsong.items.bean;

public class Unit {
    private Integer unitId;

    private String unitName;

    public Unit(Integer unitId, String unitName) {
        super();
        this.unitId = unitId;
        this.unitName = unitName;
    }

    public Unit() {
        super();
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }
}