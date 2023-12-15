package com.example.demo.pojo3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//1-1과 1-2와는 다르게 컨트롤클래스 부터 메소드를 쪼갠다
//메소드마다 req와 res를 주입 받을 수 있어야 한다.
public interface Controller3 {
	public Object execute(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;
	
	//게시판 구현메소드 추가
	public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardList(HttpServletRequest req, HttpServletResponse res);
	public Object boardDetail(HttpServletRequest req, HttpServletResponse res);
	public Object boardInsert(HttpServletRequest req, HttpServletResponse res);
	public Object boardUpdate(HttpServletRequest req, HttpServletResponse res);
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res);
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res);
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res);
	public Object imageGet(HttpServletRequest req, HttpServletResponse res);
	
}
// -> 스타트업 취업:최신기술, 공공부분, 금융(제1금융,제2금융.), 물류, 회계 - 레거시 보유(spring3.0, 4.0초기버전) - 서블릿 중심 프레임워크아직 벗어나지 못함
//-> spring2.5이전 -> spring3.0, 4.0 -> spring5.0, 6.0잠깐-> spring boot starter
//-> 공통된 생각 - IoC{Inversion of Control}, DI{dependency injection}, 객체관리(Context-> ApplicationContext -> 스프링컨테이너의 종류중 한가지)
//ActionForward - path:String변수, isRedirect:boolean  - true이면 sendRedirect, false: forward
//-> String -> "redirect:/board/boardList.gd3", "forward:/board/boardList.gd3", "/board/boardList.gd3"
//-> Object : String에서 Object로 변경한 이유가 뭐지? - ModelAndView, 또는 상위버전 Model(스프링에서 UI지원하기 위한 제공되는 클래스)
// -> ModelAndView - >  select -> 유지 -> forward -> 유효범위:request