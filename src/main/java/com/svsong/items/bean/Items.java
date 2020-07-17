package com.svsong.items.bean;

import javax.validation.constraints.Pattern;

public class Items {
    private Integer itemId;

    private String itemName;

    private String itemModel;

// 此验证有问题
//Request processing failed; nested exception is javax.validation.UnexpectedTypeException: HV000030: No validator could be found for constraint 'javax.validation.constraints.Pattern' validating type 'java.lang.Integer'. Check configuration for 'itemNum'
//    @Pattern(regexp = "^[0-9]*[1-9][0-9]*$", message = "数量必须是数字")
    private Integer itemNum;

    private String itemUsageStatus;

    private String itemSource;

    private String itemStorageLocation;

    private String itemCustodian;

    private String itemUser;

    private String itemUseDept;

    private Integer itemUnitId;

    //查询物品信息的同时，部门信息也查询出来
    private Unit unit;

    public Items() {
        super();
    }

    public Items(Integer itemId, String itemName, String itemModel, Integer itemNum, String itemUsageStatus, String itemSource, String itemStorageLocation, String itemCustodian, String itemUser, String itemUseDept, Integer itemUnitId) {
        super();
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemModel = itemModel;

        this.itemNum = itemNum;
        this.itemUsageStatus = itemUsageStatus;
        this.itemSource = itemSource;
        this.itemStorageLocation = itemStorageLocation;
        this.itemCustodian = itemCustodian;
        this.itemUser = itemUser;
        this.itemUseDept = itemUseDept;
        this.itemUnitId = itemUnitId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemModel() {
        return itemModel;
    }

    public void setItemModel(String itemModel) {
        this.itemModel = itemModel == null ? null : itemModel.trim();
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public String getItemUsageStatus() {
        return itemUsageStatus;
    }

    public void setItemUsageStatus(String itemUsageStatus) {
        this.itemUsageStatus = itemUsageStatus == null ? null : itemUsageStatus.trim();
    }

    public String getItemSource() {
        return itemSource;
    }

    public void setItemSource(String itemSource) {
        this.itemSource = itemSource == null ? null : itemSource.trim();
    }

    public String getItemStorageLocation() {
        return itemStorageLocation;
    }

    public void setItemStorageLocation(String itemStorageLocation) {
        this.itemStorageLocation = itemStorageLocation == null ? null : itemStorageLocation.trim();
    }

    public String getItemCustodian() {
        return itemCustodian;
    }

    public void setItemCustodian(String itemCustodian) {
        this.itemCustodian = itemCustodian == null ? null : itemCustodian.trim();
    }

    public String getItemUser() {
        return itemUser;
    }

    public void setItemUser(String itemUser) {
        this.itemUser = itemUser == null ? null : itemUser.trim();
    }

    public String getItemUseDept() {
        return itemUseDept;
    }

    public void setItemUseDept(String itemUseDept) {
        this.itemUseDept = itemUseDept == null ? null : itemUseDept.trim();
    }

    public Integer getItemUnitId() {
        return itemUnitId;
    }

    public void setItemUnitId(Integer itemUnitId) {
        this.itemUnitId = itemUnitId;
    }
}