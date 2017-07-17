package club.zenyuca.common.pojo;

  import java.io.Serializable;
  import club.zenyuca.common.util.paging.Page;
  import club.zenyuca.common.pojo.BasePojo;
  public class Menu extends BasePojo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Page paper;
    private Integer menuSeq;
    private String menuName;
    private Integer menuLevel;
    private Integer menuParent;
    private String menuUrl;
    private String menuIcon;
    private String menuDescribe;
	public Page getPaper() {
		return paper;
	}
	public void setPaper(Page paper) {
		this.paper = paper;
	}
	public Integer getMenuSeq() {
		return menuSeq;
	}
	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	public Integer getMenuParent() {
		return menuParent;
	}
	public void setMenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public String getMenuDescribe() {
		return menuDescribe;
	}
	public void setMenuDescribe(String menuDescribe) {
		this.menuDescribe = menuDescribe;
	}

  }