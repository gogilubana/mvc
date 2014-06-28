package org.zqm.minimvc.common.bean;

public class ForwardBean {
	private String name;
	private String value;
	public ForwardBean() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ForwardBean [name=" + name + ", value=" + value + "]";
	}
	
	
}
