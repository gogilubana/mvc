package org.zqm.minimvc.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.zqm.minimvc.form.AbstractForm;

public interface InterfaceAction {
	public String execute(HttpServletRequest request,AbstractForm form,Map<String,String> forwards);
}
