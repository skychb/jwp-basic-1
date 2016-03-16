package next.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/list")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session.getAttribute("user") != null){
			//requestDispatcher는 요청을 보내주는 클래스이다. 디스패치 메서드에 req, resp를 넘겨주는거.
			//dispatcher는 두가지 호출 방식을 사용하는데, 인클루드, 포워드이다. 포워드는 호출을 하는 순간 서블릿이 멈추고 jsp로 넘어가서 거기서 실행후 종료 
			//인클루드는 프로그램이 끝나지 않고 다시 나머지 서블릿이 실행된다. 
	        req.setAttribute("users", DataBase.findAll());
	        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
	        rd.forward(req, resp);
		}else{
			resp.sendRedirect("/");
		}
		
	}
}
