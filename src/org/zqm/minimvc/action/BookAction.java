package org.zqm.minimvc.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.zqm.minimvc.form.AbstractForm;
import org.zqm.minimvc.form.BookForm;

public class BookAction extends BaseAction implements InterfaceAction{
	@Override
	public String execute(HttpServletRequest request, AbstractForm form,
			Map<String, String> forwards) {
		String result = "";
		BookForm bookForm =(BookForm)form;
		if("zqm".equals(bookForm.getBoolname())){
			result = "list";
		}else{
			result = "insert";
		}
		return forwards.get(result);
	}
}
