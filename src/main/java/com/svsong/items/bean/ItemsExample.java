package com.svsong.items.bean;

import java.util.ArrayList;
import java.util.List;

public class ItemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemModelIsNull() {
            addCriterion("item_model is null");
            return (Criteria) this;
        }

        public Criteria andItemModelIsNotNull() {
            addCriterion("item_model is not null");
            return (Criteria) this;
        }

        public Criteria andItemModelEqualTo(String value) {
            addCriterion("item_model =", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelNotEqualTo(String value) {
            addCriterion("item_model <>", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelGreaterThan(String value) {
            addCriterion("item_model >", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelGreaterThanOrEqualTo(String value) {
            addCriterion("item_model >=", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelLessThan(String value) {
            addCriterion("item_model <", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelLessThanOrEqualTo(String value) {
            addCriterion("item_model <=", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelLike(String value) {
            addCriterion("item_model like", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelNotLike(String value) {
            addCriterion("item_model not like", value, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelIn(List<String> values) {
            addCriterion("item_model in", values, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelNotIn(List<String> values) {
            addCriterion("item_model not in", values, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelBetween(String value1, String value2) {
            addCriterion("item_model between", value1, value2, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemModelNotBetween(String value1, String value2) {
            addCriterion("item_model not between", value1, value2, "itemModel");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNull() {
            addCriterion("item_num is null");
            return (Criteria) this;
        }

        public Criteria andItemNumIsNotNull() {
            addCriterion("item_num is not null");
            return (Criteria) this;
        }

        public Criteria andItemNumEqualTo(Integer value) {
            addCriterion("item_num =", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotEqualTo(Integer value) {
            addCriterion("item_num <>", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThan(Integer value) {
            addCriterion("item_num >", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_num >=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThan(Integer value) {
            addCriterion("item_num <", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumLessThanOrEqualTo(Integer value) {
            addCriterion("item_num <=", value, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumIn(List<Integer> values) {
            addCriterion("item_num in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotIn(List<Integer> values) {
            addCriterion("item_num not in", values, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumBetween(Integer value1, Integer value2) {
            addCriterion("item_num between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemNumNotBetween(Integer value1, Integer value2) {
            addCriterion("item_num not between", value1, value2, "itemNum");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusIsNull() {
            addCriterion("item_usage_status is null");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusIsNotNull() {
            addCriterion("item_usage_status is not null");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusEqualTo(String value) {
            addCriterion("item_usage_status =", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusNotEqualTo(String value) {
            addCriterion("item_usage_status <>", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusGreaterThan(String value) {
            addCriterion("item_usage_status >", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusGreaterThanOrEqualTo(String value) {
            addCriterion("item_usage_status >=", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusLessThan(String value) {
            addCriterion("item_usage_status <", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusLessThanOrEqualTo(String value) {
            addCriterion("item_usage_status <=", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusLike(String value) {
            addCriterion("item_usage_status like", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusNotLike(String value) {
            addCriterion("item_usage_status not like", value, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusIn(List<String> values) {
            addCriterion("item_usage_status in", values, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusNotIn(List<String> values) {
            addCriterion("item_usage_status not in", values, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusBetween(String value1, String value2) {
            addCriterion("item_usage_status between", value1, value2, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemUsageStatusNotBetween(String value1, String value2) {
            addCriterion("item_usage_status not between", value1, value2, "itemUsageStatus");
            return (Criteria) this;
        }

        public Criteria andItemSourceIsNull() {
            addCriterion("item_source is null");
            return (Criteria) this;
        }

        public Criteria andItemSourceIsNotNull() {
            addCriterion("item_source is not null");
            return (Criteria) this;
        }

        public Criteria andItemSourceEqualTo(String value) {
            addCriterion("item_source =", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceNotEqualTo(String value) {
            addCriterion("item_source <>", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceGreaterThan(String value) {
            addCriterion("item_source >", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceGreaterThanOrEqualTo(String value) {
            addCriterion("item_source >=", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceLessThan(String value) {
            addCriterion("item_source <", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceLessThanOrEqualTo(String value) {
            addCriterion("item_source <=", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceLike(String value) {
            addCriterion("item_source like", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceNotLike(String value) {
            addCriterion("item_source not like", value, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceIn(List<String> values) {
            addCriterion("item_source in", values, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceNotIn(List<String> values) {
            addCriterion("item_source not in", values, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceBetween(String value1, String value2) {
            addCriterion("item_source between", value1, value2, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemSourceNotBetween(String value1, String value2) {
            addCriterion("item_source not between", value1, value2, "itemSource");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationIsNull() {
            addCriterion("item_storage_location is null");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationIsNotNull() {
            addCriterion("item_storage_location is not null");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationEqualTo(String value) {
            addCriterion("item_storage_location =", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationNotEqualTo(String value) {
            addCriterion("item_storage_location <>", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationGreaterThan(String value) {
            addCriterion("item_storage_location >", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationGreaterThanOrEqualTo(String value) {
            addCriterion("item_storage_location >=", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationLessThan(String value) {
            addCriterion("item_storage_location <", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationLessThanOrEqualTo(String value) {
            addCriterion("item_storage_location <=", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationLike(String value) {
            addCriterion("item_storage_location like", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationNotLike(String value) {
            addCriterion("item_storage_location not like", value, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationIn(List<String> values) {
            addCriterion("item_storage_location in", values, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationNotIn(List<String> values) {
            addCriterion("item_storage_location not in", values, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationBetween(String value1, String value2) {
            addCriterion("item_storage_location between", value1, value2, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemStorageLocationNotBetween(String value1, String value2) {
            addCriterion("item_storage_location not between", value1, value2, "itemStorageLocation");
            return (Criteria) this;
        }

        public Criteria andItemCustodianIsNull() {
            addCriterion("item_custodian is null");
            return (Criteria) this;
        }

        public Criteria andItemCustodianIsNotNull() {
            addCriterion("item_custodian is not null");
            return (Criteria) this;
        }

        public Criteria andItemCustodianEqualTo(String value) {
            addCriterion("item_custodian =", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianNotEqualTo(String value) {
            addCriterion("item_custodian <>", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianGreaterThan(String value) {
            addCriterion("item_custodian >", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianGreaterThanOrEqualTo(String value) {
            addCriterion("item_custodian >=", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianLessThan(String value) {
            addCriterion("item_custodian <", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianLessThanOrEqualTo(String value) {
            addCriterion("item_custodian <=", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianLike(String value) {
            addCriterion("item_custodian like", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianNotLike(String value) {
            addCriterion("item_custodian not like", value, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianIn(List<String> values) {
            addCriterion("item_custodian in", values, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianNotIn(List<String> values) {
            addCriterion("item_custodian not in", values, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianBetween(String value1, String value2) {
            addCriterion("item_custodian between", value1, value2, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemCustodianNotBetween(String value1, String value2) {
            addCriterion("item_custodian not between", value1, value2, "itemCustodian");
            return (Criteria) this;
        }

        public Criteria andItemUserIsNull() {
            addCriterion("item_user is null");
            return (Criteria) this;
        }

        public Criteria andItemUserIsNotNull() {
            addCriterion("item_user is not null");
            return (Criteria) this;
        }

        public Criteria andItemUserEqualTo(String value) {
            addCriterion("item_user =", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserNotEqualTo(String value) {
            addCriterion("item_user <>", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserGreaterThan(String value) {
            addCriterion("item_user >", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserGreaterThanOrEqualTo(String value) {
            addCriterion("item_user >=", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserLessThan(String value) {
            addCriterion("item_user <", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserLessThanOrEqualTo(String value) {
            addCriterion("item_user <=", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserLike(String value) {
            addCriterion("item_user like", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserNotLike(String value) {
            addCriterion("item_user not like", value, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserIn(List<String> values) {
            addCriterion("item_user in", values, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserNotIn(List<String> values) {
            addCriterion("item_user not in", values, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserBetween(String value1, String value2) {
            addCriterion("item_user between", value1, value2, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUserNotBetween(String value1, String value2) {
            addCriterion("item_user not between", value1, value2, "itemUser");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptIsNull() {
            addCriterion("item_use_dept is null");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptIsNotNull() {
            addCriterion("item_use_dept is not null");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptEqualTo(String value) {
            addCriterion("item_use_dept =", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptNotEqualTo(String value) {
            addCriterion("item_use_dept <>", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptGreaterThan(String value) {
            addCriterion("item_use_dept >", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptGreaterThanOrEqualTo(String value) {
            addCriterion("item_use_dept >=", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptLessThan(String value) {
            addCriterion("item_use_dept <", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptLessThanOrEqualTo(String value) {
            addCriterion("item_use_dept <=", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptLike(String value) {
            addCriterion("item_use_dept like", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptNotLike(String value) {
            addCriterion("item_use_dept not like", value, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptIn(List<String> values) {
            addCriterion("item_use_dept in", values, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptNotIn(List<String> values) {
            addCriterion("item_use_dept not in", values, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptBetween(String value1, String value2) {
            addCriterion("item_use_dept between", value1, value2, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUseDeptNotBetween(String value1, String value2) {
            addCriterion("item_use_dept not between", value1, value2, "itemUseDept");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdIsNull() {
            addCriterion("item_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdIsNotNull() {
            addCriterion("item_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdEqualTo(Integer value) {
            addCriterion("item_unit_id =", value, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdNotEqualTo(Integer value) {
            addCriterion("item_unit_id <>", value, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdGreaterThan(Integer value) {
            addCriterion("item_unit_id >", value, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_unit_id >=", value, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdLessThan(Integer value) {
            addCriterion("item_unit_id <", value, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_unit_id <=", value, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdIn(List<Integer> values) {
            addCriterion("item_unit_id in", values, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdNotIn(List<Integer> values) {
            addCriterion("item_unit_id not in", values, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdBetween(Integer value1, Integer value2) {
            addCriterion("item_unit_id between", value1, value2, "itemUnitId");
            return (Criteria) this;
        }

        public Criteria andItemUnitIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_unit_id not between", value1, value2, "itemUnitId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}