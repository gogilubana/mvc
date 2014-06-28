package org.zqm.minimvc.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zqm.minimvc.action.InterfaceAction;
import org.zqm.minimvc.common.bean.ActionBean;
import org.zqm.minimvc.common.unit.FillFormUnit;
import org.zqm.minimvc.common.unit.MvcConfigXmlUtil;
import org.zqm.minimvc.form.AbstractForm;

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 262788867781975293L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String reqpath = req.getServletPath();
		String actionPath = this.getActionPathByServletPath(reqpath);
		ActionBean actionBean = MvcConfigXmlUtil.actionMappingMap.get(actionPath);
		if(actionBean!=null){
			AbstractForm form = FillFormUnit.fillForm(req,actionBean.getFormclass());
			InterfaceAction action = null;
			String actionClassName = actionBean.getType();
			String url = "";
			try {
				Class obj = Class.forName(actionClassName);
				action = (InterfaceAction) obj.newInstance();
				url = action.execute(req,form,actionBean.getForwards());
				RequestDispatcher dis = req.getRequestDispatcher(url);
				dis.forward(req, resp);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}else{
			PrintWriter out = resp.getWriter();
			out.print("not found action-mapping for "+actionPath);
		}
	}

	private String getActionPathByServletPath(String reqpath) {
		String path = reqpath.substring(reqpath.lastIndexOf("/")+1);
		String[] strArr =  path.split("\\.");
		return strArr[0];
	}

	public static void main(String[] args) {
		String path = "/login.do";
		String basepath = path.substring(path.lastIndexOf("/")+1);
		System.out.println(basepath.split("\\.")[0]);
	}

}
