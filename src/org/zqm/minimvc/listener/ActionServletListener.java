package org.zqm.minimvc.listener;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.zqm.minimvc.common.bean.ActionBean;
import org.zqm.minimvc.common.unit.MvcConfigXmlUtil;

/**
 * Application Lifecycle Listener implementation class ActionServletListener
 *
 */
public class ActionServletListener implements ServletContextListener {
	private final static String  PARAM_STRUTS ="struts";

    /**
     * Default constructor. 
     */
    public ActionServletListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
    	ServletContext context = event.getServletContext();
    	String strutsxmlpath = context.getInitParameter(PARAM_STRUTS);   
    	strutsxmlpath = context.getRealPath(strutsxmlpath);
    	 Map<String, ActionBean> actionMap = MvcConfigXmlUtil.init(strutsxmlpath);
    	 if(actionMap.size()>0){
    		 System.out.println("加载"+actionMap.size()+"个action成功。。。。。。。");
    	 }else{
    		 System.out.println("没有加到的action。。。。。。");
    	 }
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
