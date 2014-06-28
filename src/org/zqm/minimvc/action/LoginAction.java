package org.zqm.minimvc.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.zqm.minimvc.form.AbstractForm;
import org.zqm.minimvc.form.LoginForm;

public class LoginAction extends BaseAction implements InterfaceAction{

	@Override
	public String execute(HttpServletRequest request, AbstractForm form,Map<String, String> forwards) {
		LoginForm logiForm = (LoginForm)form;
		String returnurl = "";
		if("zqm".equals(logiForm.getUserName())){
			returnurl = "success";
		}else{
			returnurl = "failed";
		}
		return forwards.get(returnurl);
	}

	
}
