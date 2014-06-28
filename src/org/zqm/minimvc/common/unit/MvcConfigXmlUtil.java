package org.zqm.minimvc.common.unit;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.zqm.minimvc.common.bean.ActionBean;

public class MvcConfigXmlUtil {
	public static Map<String,ActionBean> actionMappingMap = new HashMap<String, ActionBean>();
	public static Map<String,ActionBean> init(String strutsxmlpath){
		Map<String,ActionBean> actionMap = new HashMap<String, ActionBean>();
		ActionBean actionBean = null;
		try {
			SAXBuilder saxb = new SAXBuilder();
			Document doucment = saxb.build(new File(strutsxmlpath));
			Element root = doucment.getRootElement();
			Element beans = root.getChild("beans");
			Element actionMapping = root.getChild("action-mapping");
			List<Element> beanList = beans.getChildren();
			List<Element> actionMappingList = actionMapping.getChildren();
			for (Element actionXml : actionMappingList) {
				actionBean = new ActionBean();
				String actionName = actionXml.getAttributeValue("name");
				String actionType = actionXml.getAttributeValue("type");
				String path = actionXml.getAttributeValue("path");
				List<Element> forwardXmls = actionXml.getChildren();
				Map<String,String> forwards = new HashMap<String, String>();
				for (Element forwardXml : forwardXmls) {
					String forwardName = forwardXml.getAttributeValue("name");
					String forwardValue = forwardXml.getAttributeValue("value");
					forwards.put(forwardName, forwardValue);
				}
				actionBean.setName(actionName);
				actionBean.setPath(path);
				actionBean.setType(actionType);
				actionBean.setForwards(forwards);
				for (Element beanXml : beanList) {
					String beanName = beanXml.getAttributeValue("name");
					if(actionName.equals(beanName)){
						String beanClass = beanXml.getAttributeValue("class");
						actionBean.setFormclass(beanClass);
						break;
					}
				}
				actionMap.put(path, actionBean);
			}
			actionMappingMap = actionMap;
			return actionMap;
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return actionMap;
	}
	public static void main(String[] args) {
		init("struts/struts-config.xml");
	}
}
