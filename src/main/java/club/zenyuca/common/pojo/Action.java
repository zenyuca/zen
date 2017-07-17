package club.zenyuca.common.pojo;

import java.io.Serializable;
import club.zenyuca.common.util.paging.Page;
import club.zenyuca.common.pojo.BasePojo;

public class Action extends BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Page paper;
	private Integer actionSeq;
	private String actionUrl;
	private String actionFunc;
	private String actionTitle;
	private String actionClass;
	private String actionIcon;
	private Integer actionLevel;
	public Page getPaper() {
		return paper;
	}
	public void setPaper(Page paper) {
		this.paper = paper;
	}
	public Integer getActionSeq() {
		return actionSeq;
	}
	public void setActionSeq(Integer actionSeq) {
		this.actionSeq = actionSeq;
	}
	public String getActionUrl() {
		return actionUrl;
	}
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	public String getActionFunc() {
		return actionFunc;
	}
	public void setActionFunc(String actionFunc) {
		this.actionFunc = actionFunc;
	}
	public String getActionTitle() {
		return actionTitle;
	}
	public void setActionTitle(String actionTitle) {
		this.actionTitle = actionTitle;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public String getActionIcon() {
		return actionIcon;
	}
	public void setActionIcon(String actionIcon) {
		this.actionIcon = actionIcon;
	}
	public Integer getActionLevel() {
		return actionLevel;
	}
	public void setActionLevel(Integer actionLevel) {
		this.actionLevel = actionLevel;
	}

}