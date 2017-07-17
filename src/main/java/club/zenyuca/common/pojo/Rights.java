package club.zenyuca.common.pojo;

import java.io.Serializable;
import club.zenyuca.common.util.paging.Page;
import club.zenyuca.common.pojo.BasePojo;

public class Rights extends BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Page paper;
	private Integer rightsSeq;
	private String rights;
	private String rightsUrl;
	private Integer rightsRole;

	public Page getPaper() {
		return paper;
	}

	public void setPaper(Page paper) {
		this.paper = paper;
	}

	public Integer getRightsSeq() {
		return rightsSeq;
	}

	public void setRightsSeq(Integer rightsSeq) {
		this.rightsSeq = rightsSeq;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getRightsUrl() {
		return rightsUrl;
	}

	public void setRightsUrl(String rightsUrl) {
		this.rightsUrl = rightsUrl;
	}

	public Integer getRightsRole() {
		return rightsRole;
	}

	public void setRightsRole(Integer rightsRole) {
		this.rightsRole = rightsRole;
	}

}