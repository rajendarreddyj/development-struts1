package com.rajendarreddyj.displaytag;

import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.ObjectUtils;
import org.displaytag.decorator.CheckboxTableDecorator;
import org.displaytag.model.TableModel;

public class RadioButtonDecorator extends CheckboxTableDecorator {

	@Override
	public void init(PageContext pageContext, Object decorated, TableModel tableModel) {
		super.init(pageContext, decorated, tableModel);
	}

	public String getRadioButton() {
		String rowid = ObjectUtils.toString(evaluate("id"));
		String sunpassPlusParkingVal = ObjectUtils.toString(evaluate("option"));

		StringBuffer buffer = new StringBuffer();
		if ("optIn".equalsIgnoreCase(sunpassPlusParkingVal)) {

			buffer.append("<input type=\"radio\"  name= \"" + rowid
					+ "_chk\"  id=\"_chk\" aria-label=\"Sunpass Plus Opt in selection\"  value=\"");
			buffer.append(rowid);
			buffer.append("\"");
			buffer.append("");
			buffer.append(" checked=\"checked\"");
			buffer.append("/>");
			buffer.append("Opt-in");
			buffer.append("&nbsp;&nbsp;");
			buffer.append("<input type=\"radio\"  name= \"" + rowid
					+ "_chk\"  id=\"_chk\" aria-label=\"Sunpass Plus Opt out selection\"  value=\"");
			buffer.append("\"");
			buffer.append("");
			buffer.append("'/>");
			buffer.append("Opt-out");
		} else {
			buffer.append("<input type=\"radio\"  name= \"" + rowid
					+ "_chk\"  id=\"_chk\" aria-label=\"Sunpass Plus Opt in selection\"  value=\"");
			buffer.append(rowid);
			buffer.append("\"");
			buffer.append("");
			buffer.append("/>");
			buffer.append("Opt-in");
			buffer.append("&nbsp;&nbsp;");
			buffer.append("<input type=\"radio\"  name= \"" + rowid
					+ "_chk\"  id=\"_chk\" aria-label=\"Sunpass Plus Opt out selection\"  value=\"");
			buffer.append("\"");
			buffer.append("");
			buffer.append(" checked=\"checked\"");
			buffer.append("'/>");
			buffer.append("Opt-out");
		}
		return buffer.toString();
	}
}
