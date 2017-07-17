package club.zenyuca.common.pojo;

import java.io.Serializable;
import club.zenyuca.common.util.paging.Page;

public class User extends BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Page paper;
	private Integer userSeq;
	private String userLoginname;
	private String userLoginpass;
	private String userName;
	private Integer userRoleSeq;
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Page getPaper() {
		return paper;
	}

	public void setPaper(Page paper) {
		this.paper = paper;
	}

	public Integer getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserLoginname() {
		return userLoginname;
	}

	public void setUserLoginname(String userLoginname) {
		this.userLoginname = userLoginname;
	}

	public String getUserLoginpass() {
		return userLoginpass;
	}

	public void setUserLoginpass(String userLoginpass) {
		this.userLoginpass = userLoginpass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserRoleSeq() {
		return userRoleSeq;
	}

	public void setUserRoleSeq(Integer userRoleSeq) {
		this.userRoleSeq = userRoleSeq;
	}

}