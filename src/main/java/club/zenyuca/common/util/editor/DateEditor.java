package club.zenyuca.common.util.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

import club.zenyuca.common.util.DateUtil;


public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			setValue(DateUtil.string2Date(text, "yyyy-MM-dd"));
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
