package com.example.demo.pojo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

//나는 어떤 클래스에서 사용되나요 ??? XXXControlloer
//생성자를 통해 request 받아온다. 어디서?? 서블릿에서 받아옴 - Board2Controller
public class ModelAndView {
	//req.setAttribute("list", new ArrayList<>());
	HttpServletRequest req = null;//나는 어디서 주입을 받게 되나요?
	List<Map<String,Object>> list = new ArrayList<>();
	Logger logger = Logger.getLogger("ModelAndView.class");
	//컨트롤 클래스에서 결정된 화면의 이름을  담을 변수 선언
	String viewName = null;
	public ModelAndView(HttpServletRequest req) {
		logger.info("ModelAndView");
		logger.info(req);
		this.req = req;
	}
	//컨트롤 클래스에서  화면이름이 결정되면 그 값을 읽고 쓸 수 있는 메소드 설계
	public void setViewName(String viewName) {
		logger.info("setViewName");
		this.viewName = viewName;
		logger.info(viewName);
	}
	public String getViewName() {
		return viewName;
	}
	public void addObject(String name, Object obj) {
		logger.info("addObject");
		Map<String, Object> pMap = new HashMap<>();
		pMap.put(name, obj);
		req.setAttribute(name, obj);
		list.add(pMap);
		logger.info(pMap);
	}
	
}