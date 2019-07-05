package binbinlau.plane.xo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("`uid` is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("`uid` is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("`uid` =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("`uid` <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("`uid` >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("`uid` >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("`uid` <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("`uid` <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("`uid` like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("`uid` not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("`uid` in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("`uid` not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("`uid` between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("`uid` not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidIsNull() {
            addCriterion("`fromuseruid` is null");
            return (Criteria) this;
        }

        public Criteria andFromuseruidIsNotNull() {
            addCriterion("`fromuseruid` is not null");
            return (Criteria) this;
        }

        public Criteria andFromuseruidEqualTo(String value) {
            addCriterion("`fromuseruid` =", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidNotEqualTo(String value) {
            addCriterion("`fromuseruid` <>", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidGreaterThan(String value) {
            addCriterion("`fromuseruid` >", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidGreaterThanOrEqualTo(String value) {
            addCriterion("`fromuseruid` >=", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidLessThan(String value) {
            addCriterion("`fromuseruid` <", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidLessThanOrEqualTo(String value) {
            addCriterion("`fromuseruid` <=", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidLike(String value) {
            addCriterion("`fromuseruid` like", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidNotLike(String value) {
            addCriterion("`fromuseruid` not like", value, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidIn(List<String> values) {
            addCriterion("`fromuseruid` in", values, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidNotIn(List<String> values) {
            addCriterion("`fromuseruid` not in", values, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidBetween(String value1, String value2) {
            addCriterion("`fromuseruid` between", value1, value2, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseruidNotBetween(String value1, String value2) {
            addCriterion("`fromuseruid` not between", value1, value2, "fromuseruid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidIsNull() {
            addCriterion("`fromuseroid` is null");
            return (Criteria) this;
        }

        public Criteria andFromuseroidIsNotNull() {
            addCriterion("`fromuseroid` is not null");
            return (Criteria) this;
        }

        public Criteria andFromuseroidEqualTo(Integer value) {
            addCriterion("`fromuseroid` =", value, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidNotEqualTo(Integer value) {
            addCriterion("`fromuseroid` <>", value, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidGreaterThan(Integer value) {
            addCriterion("`fromuseroid` >", value, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidGreaterThanOrEqualTo(Integer value) {
            addCriterion("`fromuseroid` >=", value, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidLessThan(Integer value) {
            addCriterion("`fromuseroid` <", value, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidLessThanOrEqualTo(Integer value) {
            addCriterion("`fromuseroid` <=", value, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidIn(List<Integer> values) {
            addCriterion("`fromuseroid` in", values, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidNotIn(List<Integer> values) {
            addCriterion("`fromuseroid` not in", values, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidBetween(Integer value1, Integer value2) {
            addCriterion("`fromuseroid` between", value1, value2, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromuseroidNotBetween(Integer value1, Integer value2) {
            addCriterion("`fromuseroid` not between", value1, value2, "fromuseroid");
            return (Criteria) this;
        }

        public Criteria andFromusernameIsNull() {
            addCriterion("`fromusername` is null");
            return (Criteria) this;
        }

        public Criteria andFromusernameIsNotNull() {
            addCriterion("`fromusername` is not null");
            return (Criteria) this;
        }

        public Criteria andFromusernameEqualTo(String value) {
            addCriterion("`fromusername` =", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotEqualTo(String value) {
            addCriterion("`fromusername` <>", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameGreaterThan(String value) {
            addCriterion("`fromusername` >", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameGreaterThanOrEqualTo(String value) {
            addCriterion("`fromusername` >=", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameLessThan(String value) {
            addCriterion("`fromusername` <", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameLessThanOrEqualTo(String value) {
            addCriterion("`fromusername` <=", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameLike(String value) {
            addCriterion("`fromusername` like", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotLike(String value) {
            addCriterion("`fromusername` not like", value, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameIn(List<String> values) {
            addCriterion("`fromusername` in", values, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotIn(List<String> values) {
            addCriterion("`fromusername` not in", values, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameBetween(String value1, String value2) {
            addCriterion("`fromusername` between", value1, value2, "fromusername");
            return (Criteria) this;
        }

        public Criteria andFromusernameNotBetween(String value1, String value2) {
            addCriterion("`fromusername` not between", value1, value2, "fromusername");
            return (Criteria) this;
        }

        public Criteria andTouseruidIsNull() {
            addCriterion("`touseruid` is null");
            return (Criteria) this;
        }

        public Criteria andTouseruidIsNotNull() {
            addCriterion("`touseruid` is not null");
            return (Criteria) this;
        }

        public Criteria andTouseruidEqualTo(String value) {
            addCriterion("`touseruid` =", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidNotEqualTo(String value) {
            addCriterion("`touseruid` <>", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidGreaterThan(String value) {
            addCriterion("`touseruid` >", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidGreaterThanOrEqualTo(String value) {
            addCriterion("`touseruid` >=", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidLessThan(String value) {
            addCriterion("`touseruid` <", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidLessThanOrEqualTo(String value) {
            addCriterion("`touseruid` <=", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidLike(String value) {
            addCriterion("`touseruid` like", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidNotLike(String value) {
            addCriterion("`touseruid` not like", value, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidIn(List<String> values) {
            addCriterion("`touseruid` in", values, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidNotIn(List<String> values) {
            addCriterion("`touseruid` not in", values, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidBetween(String value1, String value2) {
            addCriterion("`touseruid` between", value1, value2, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseruidNotBetween(String value1, String value2) {
            addCriterion("`touseruid` not between", value1, value2, "touseruid");
            return (Criteria) this;
        }

        public Criteria andTouseroidIsNull() {
            addCriterion("`touseroid` is null");
            return (Criteria) this;
        }

        public Criteria andTouseroidIsNotNull() {
            addCriterion("`touseroid` is not null");
            return (Criteria) this;
        }

        public Criteria andTouseroidEqualTo(Integer value) {
            addCriterion("`touseroid` =", value, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidNotEqualTo(Integer value) {
            addCriterion("`touseroid` <>", value, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidGreaterThan(Integer value) {
            addCriterion("`touseroid` >", value, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidGreaterThanOrEqualTo(Integer value) {
            addCriterion("`touseroid` >=", value, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidLessThan(Integer value) {
            addCriterion("`touseroid` <", value, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidLessThanOrEqualTo(Integer value) {
            addCriterion("`touseroid` <=", value, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidIn(List<Integer> values) {
            addCriterion("`touseroid` in", values, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidNotIn(List<Integer> values) {
            addCriterion("`touseroid` not in", values, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidBetween(Integer value1, Integer value2) {
            addCriterion("`touseroid` between", value1, value2, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTouseroidNotBetween(Integer value1, Integer value2) {
            addCriterion("`touseroid` not between", value1, value2, "touseroid");
            return (Criteria) this;
        }

        public Criteria andTousernameIsNull() {
            addCriterion("`tousername` is null");
            return (Criteria) this;
        }

        public Criteria andTousernameIsNotNull() {
            addCriterion("`tousername` is not null");
            return (Criteria) this;
        }

        public Criteria andTousernameEqualTo(String value) {
            addCriterion("`tousername` =", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotEqualTo(String value) {
            addCriterion("`tousername` <>", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameGreaterThan(String value) {
            addCriterion("`tousername` >", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameGreaterThanOrEqualTo(String value) {
            addCriterion("`tousername` >=", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameLessThan(String value) {
            addCriterion("`tousername` <", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameLessThanOrEqualTo(String value) {
            addCriterion("`tousername` <=", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameLike(String value) {
            addCriterion("`tousername` like", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotLike(String value) {
            addCriterion("`tousername` not like", value, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameIn(List<String> values) {
            addCriterion("`tousername` in", values, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotIn(List<String> values) {
            addCriterion("`tousername` not in", values, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameBetween(String value1, String value2) {
            addCriterion("`tousername` between", value1, value2, "tousername");
            return (Criteria) this;
        }

        public Criteria andTousernameNotBetween(String value1, String value2) {
            addCriterion("`tousername` not between", value1, value2, "tousername");
            return (Criteria) this;
        }

        public Criteria andUseravatarIsNull() {
            addCriterion("`useravatar` is null");
            return (Criteria) this;
        }

        public Criteria andUseravatarIsNotNull() {
            addCriterion("`useravatar` is not null");
            return (Criteria) this;
        }

        public Criteria andUseravatarEqualTo(String value) {
            addCriterion("`useravatar` =", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotEqualTo(String value) {
            addCriterion("`useravatar` <>", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarGreaterThan(String value) {
            addCriterion("`useravatar` >", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarGreaterThanOrEqualTo(String value) {
            addCriterion("`useravatar` >=", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarLessThan(String value) {
            addCriterion("`useravatar` <", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarLessThanOrEqualTo(String value) {
            addCriterion("`useravatar` <=", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarLike(String value) {
            addCriterion("`useravatar` like", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotLike(String value) {
            addCriterion("`useravatar` not like", value, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarIn(List<String> values) {
            addCriterion("`useravatar` in", values, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotIn(List<String> values) {
            addCriterion("`useravatar` not in", values, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarBetween(String value1, String value2) {
            addCriterion("`useravatar` between", value1, value2, "useravatar");
            return (Criteria) this;
        }

        public Criteria andUseravatarNotBetween(String value1, String value2) {
            addCriterion("`useravatar` not between", value1, value2, "useravatar");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("`title` is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("`title` is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("`title` =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("`title` <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("`title` >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("`title` >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("`title` <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("`title` <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("`title` like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("`title` not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("`title` in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("`title` not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("`title` between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("`title` not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("`content` is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("`content` is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("`content` =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("`content` <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("`content` >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("`content` >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("`content` <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("`content` <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("`content` like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("`content` not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("`content` in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("`content` not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("`content` between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("`content` not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andHrefIsNull() {
            addCriterion("`href` is null");
            return (Criteria) this;
        }

        public Criteria andHrefIsNotNull() {
            addCriterion("`href` is not null");
            return (Criteria) this;
        }

        public Criteria andHrefEqualTo(String value) {
            addCriterion("`href` =", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotEqualTo(String value) {
            addCriterion("`href` <>", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThan(String value) {
            addCriterion("`href` >", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefGreaterThanOrEqualTo(String value) {
            addCriterion("`href` >=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThan(String value) {
            addCriterion("`href` <", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLessThanOrEqualTo(String value) {
            addCriterion("`href` <=", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefLike(String value) {
            addCriterion("`href` like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotLike(String value) {
            addCriterion("`href` not like", value, "href");
            return (Criteria) this;
        }

        public Criteria andHrefIn(List<String> values) {
            addCriterion("`href` in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotIn(List<String> values) {
            addCriterion("`href` not in", values, "href");
            return (Criteria) this;
        }

        public Criteria andHrefBetween(String value1, String value2) {
            addCriterion("`href` between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andHrefNotBetween(String value1, String value2) {
            addCriterion("`href` not between", value1, value2, "href");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Boolean value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Boolean value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Boolean value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Boolean value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Boolean value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Boolean> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Boolean> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Boolean value1, Boolean value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Boolean value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Boolean value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Boolean value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Boolean value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Boolean> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Boolean> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("`site` is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("`site` is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(Boolean value) {
            addCriterion("`site` =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(Boolean value) {
            addCriterion("`site` <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(Boolean value) {
            addCriterion("`site` >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`site` >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(Boolean value) {
            addCriterion("`site` <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(Boolean value) {
            addCriterion("`site` <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<Boolean> values) {
            addCriterion("`site` in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<Boolean> values) {
            addCriterion("`site` not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(Boolean value1, Boolean value2) {
            addCriterion("`site` between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`site` not between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("`sn` is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("`sn` is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("`sn` =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("`sn` <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("`sn` >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("`sn` >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("`sn` <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("`sn` <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("`sn` like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("`sn` not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("`sn` in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("`sn` not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("`sn` between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("`sn` not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andDataIsNull() {
            addCriterion("`data` is null");
            return (Criteria) this;
        }

        public Criteria andDataIsNotNull() {
            addCriterion("`data` is not null");
            return (Criteria) this;
        }

        public Criteria andDataEqualTo(String value) {
            addCriterion("`data` =", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotEqualTo(String value) {
            addCriterion("`data` <>", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThan(String value) {
            addCriterion("`data` >", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataGreaterThanOrEqualTo(String value) {
            addCriterion("`data` >=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThan(String value) {
            addCriterion("`data` <", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLessThanOrEqualTo(String value) {
            addCriterion("`data` <=", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataLike(String value) {
            addCriterion("`data` like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotLike(String value) {
            addCriterion("`data` not like", value, "data");
            return (Criteria) this;
        }

        public Criteria andDataIn(List<String> values) {
            addCriterion("`data` in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotIn(List<String> values) {
            addCriterion("`data` not in", values, "data");
            return (Criteria) this;
        }

        public Criteria andDataBetween(String value1, String value2) {
            addCriterion("`data` between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andDataNotBetween(String value1, String value2) {
            addCriterion("`data` not between", value1, value2, "data");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("`createtime` is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("`createtime` is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("`createtime` =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("`createtime` <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("`createtime` >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`createtime` >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("`createtime` <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("`createtime` <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("`createtime` in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("`createtime` not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("`createtime` between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("`createtime` not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("`updatetime` is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("`updatetime` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("`updatetime` =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("`updatetime` <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("`updatetime` >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("`updatetime` >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("`updatetime` <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("`updatetime` <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("`updatetime` in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("`updatetime` not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("`updatetime` between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("`updatetime` not between", value1, value2, "updatetime");
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