package org.zqm.minimvc.form;

public class BookForm extends AbstractForm {
	private String boolname;
	private float price = (float) 0.0;
	private String auth;
	
	public BookForm() {
		super();
	}
	public String getBoolname() {
		return boolname;
	}
	public void setBoolname(String boolname) {
		this.boolname = boolname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
