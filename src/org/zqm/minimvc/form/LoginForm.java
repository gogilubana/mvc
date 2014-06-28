package org.zqm.minimvc.form;

public class LoginForm extends AbstractForm{
	private String userName;
	private String pwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		
		return "userName="+this.userName+",pwd="+this.pwd;
	}
	public LoginForm() {
		super();
	}
	public LoginForm(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}
	
	
}
