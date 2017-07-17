package club.zenyuca.common.config;

import java.util.HashMap;
import java.util.Map;

import club.zenyuca.common.util.paging.Page;

/**
 * 
 * 类描述：查询辅助类，支持链式写法，如：new CondOrderLimit().setOrderBy("id desc").setLimit(5).putCondition("username","黑猫警长").putCondition("age",33)
 * 
 * @version: 1.0
 * @author: 黑猫警长
 * @version: 2014-3-16 下午11:30:31
 */
public class CondOrderLimit {
	private Map<String, Object> conditions = new HashMap<String, Object>();// 条件
	private String orderBy;// 排序
	private Integer limit;// 限制结果数
	private Page paper;
	private String groupBy;

	public CondOrderLimit() {
	}

	public CondOrderLimit(Map<String, Object> conditions) {
		this.conditions = conditions;
	}

	public CondOrderLimit(Map<String, Object> conditions, String orderBy) {
		this.conditions = conditions;
		this.orderBy = orderBy;
	}

	public CondOrderLimit(Map<String, Object> conditions, Integer limit) {
		this.conditions = conditions;
		this.limit = limit;
	}

	public CondOrderLimit(Map<String, Object> conditions, String orderBy, Integer limit) {
		this.conditions = conditions;
		this.orderBy = orderBy;
		this.limit = limit;
	}

	public Map<String, Object> getConditions() {
		return conditions;
	}

	public CondOrderLimit setConditions(Map<String, Object> conditions) {
		this.conditions = conditions;
		return this;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public CondOrderLimit setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public CondOrderLimit setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public Page getPaper() {
		return paper;
	}

	public CondOrderLimit setPaper(Page paper) {
		this.paper = paper;
		return this;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public CondOrderLimit setGroupBy(String groupBy) {
		this.groupBy = groupBy;
		return this;
	}

	public CondOrderLimit setPageRows(Integer rows) {
		this.paper.setRows(rows);
		return this;
	}

	/**
	 * 
	 * 方法描述：清空所有查询条件
	 * 
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: 黑猫警长
	 * @version: 2014-3-16 下午11:29:20
	 */
	public CondOrderLimit clearCondtions() {
		this.conditions.clear();
		return this;
	}

	/**
	 * 
	 * 方法描述：重置
	 * 
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: 黑猫警长
	 * @version: 2014-3-16 下午11:29:06
	 */
	public CondOrderLimit reset() {
		this.conditions.clear();
		this.groupBy = null;
		this.orderBy = null;
		this.limit = null;
		return this;
	}

	/**
	 * 
	 * 方法描述：放入一个查询条件
	 * 
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: 黑猫警长
	 * @version: 2014-3-16 下午11:29:43
	 */
	public CondOrderLimit putCondition(String key, Object value) {
		this.conditions.put(key, value);
		return this;
	}

	/**
	 * 
	 * 方法描述：移除一个查询条件
	 * 
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: 黑猫警长
	 * @version: 2014-3-16 下午11:29:59
	 */
	public CondOrderLimit removeCondition(String key) {
		this.conditions.remove(key);
		return this;
	}

	/**
	 * 
	 * 方法描述：取得某个条件的值
	 * 
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: 黑猫警长
	 * @version: 2014-3-19 上午12:06:23
	 */
	public Object getCondition(String key) {
		return this.conditions.get(key);
	}
}