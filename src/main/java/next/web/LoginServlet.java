package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import core.db.DataBase;
import next.model.User;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String pw = req.getParameter("password");
        User user = DataBase.findUserById(userId);
        System.out.println(user.getPassword());
        System.out.println(pw);
        if(user.checkPw(pw)){
        	HttpSession session = req.getSession();
			System.out.println("success!");
			session.setAttribute("user", user);
			resp.sendRedirect("/");
        }else{
        	System.out.println("failed..");
        	resp.sendRedirect("/user/login_failed.html");
        }
	}
}
