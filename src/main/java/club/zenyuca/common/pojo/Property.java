package club.zenyuca.common.pojo;

import java.io.Serializable;
import club.zenyuca.common.util.paging.Page;
import club.zenyuca.common.pojo.BasePojo;

public class Property extends BasePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Page paper;
	private Integer ptySeq;
	private String ptyKey;
	private String ptyValue;
	private String ptyNote;

	public Page getPaper() {
		return paper;
	}

	public void setPaper(Page paper) {
		this.paper = paper;
	}

	public Integer getPtySeq() {
		return ptySeq;
	}

	public void setPtySeq(Integer ptySeq) {
		this.ptySeq = ptySeq;
	}

	public String getPtyKey() {
		return ptyKey;
	}

	public void setPtyKey(String ptyKey) {
		this.ptyKey = ptyKey;
	}

	public String getPtyValue() {
		return ptyValue;
	}

	public void setPtyValue(String ptyValue) {
		this.ptyValue = ptyValue;
	}

	public String getPtyNote() {
		return ptyNote;
	}

	public void setPtyNote(String ptyNote) {
		this.ptyNote = ptyNote;
	}

}