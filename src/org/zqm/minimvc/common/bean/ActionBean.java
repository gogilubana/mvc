package org.zqm.minimvc.common.bean;

import java.util.List;
import java.util.Map;

public class ActionBean {
	private String path;
	private String name;
	private String type;
	private String formclass;
	private Map<String,String> forwards;
	public ActionBean() {
		super();
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormclass() {
		return formclass;
	}
	public void setFormclass(String formclass) {
		this.formclass = formclass;
	}
	
	public Map<String, String> getForwards() {
		return forwards;
	}
	public void setForwards(Map<String, String> forwards) {
		this.forwards = forwards;
	}
	@Override
	public String toString() {
		return "ActionBean [path=" + path + ", name=" + name + ", type=" + type
				+ ", formclass=" + formclass + ", forwards=" + forwards + "]";
	}
	
}
