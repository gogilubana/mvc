package org.zqm.minimvc.control;

import java.util.HashMap;
import java.util.Map;

public class ActionMapping {

	public static Map<String, String> getActionMap() {
		Map<String,String> map = new HashMap<String, String>();
		String formClassName ="org.zqm.minimvc.form.LoginForm";
		String actionClassName="org.zqm.minimvc.action.LoginAction";
		map.put(formClassName, actionClassName);
		formClassName ="org.zqm.minimvc.form.SomeForm";
		actionClassName="org.zqm.minimvc.action.SomeAction";
		map.put(formClassName, actionClassName);
		return map;
	}

}
