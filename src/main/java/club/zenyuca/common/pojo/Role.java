package club.zenyuca.common.pojo;

import java.io.Serializable;
import club.zenyuca.common.util.paging.Page;
import club.zenyuca.common.pojo.BasePojo;

public class Role extends BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Page paper;
	private Integer roleSeq;
	private String roleName;
	private String roleNote;
	private String roleRights;
	private Integer roleType;

	public Page getPaper() {
		return paper;
	}

	public void setPaper(Page paper) {
		this.paper = paper;
	}

	public Integer getRoleSeq() {
		return roleSeq;
	}

	public void setRoleSeq(Integer roleSeq) {
		this.roleSeq = roleSeq;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNote() {
		return roleNote;
	}

	public void setRoleNote(String roleNote) {
		this.roleNote = roleNote;
	}

	public String getRoleRights() {
		return roleRights;
	}

	public void setRoleRights(String roleRights) {
		this.roleRights = roleRights;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

}