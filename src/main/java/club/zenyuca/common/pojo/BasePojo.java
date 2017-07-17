package club.zenyuca.common.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 创建时间 */
	private Date createTime;
	/** 创建人 */
	private Integer createrId;
	/** 最后一次修改时间 */
	private Date lastModifyTime;
	/** 最后一次修改人 */
	private Integer updaterId;

	/** 作为数据库查询条件 */
	private Map<String, Object> paramsMap = new HashMap<String, Object>();

	public void setParams(Map<String, String[]> map) {
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			this.paramsMap.put(string, map.get(string)[0]);
		}
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(Integer updaterId) {
		this.updaterId = updaterId;
	}

}
