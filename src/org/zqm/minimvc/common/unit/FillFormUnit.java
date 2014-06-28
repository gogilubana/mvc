package org.zqm.minimvc.common.unit;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import org.zqm.minimvc.form.AbstractForm;
import org.zqm.minimvc.form.LoginForm;

public class FillFormUnit {
	public static AbstractForm fillForm(HttpServletRequest req, String formClass){
		AbstractForm form = null;
		try {
			Class obj = Class.forName(formClass);
			form = (AbstractForm)obj.newInstance();
			Field[] fieldArr = obj.getDeclaredFields();
			for (Field field : fieldArr) {
				field.setAccessible(true);
				String value = req.getParameter(field.getName());
				if(!"".equals(value)&&null!=value){
					field.set(form, value);
				}
				field.setAccessible(false);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return form;
	}
}
