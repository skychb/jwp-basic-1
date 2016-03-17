package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;
import core.mvc.Controller;
import next.dao.UserDao;

public class ListUserController implements Controller {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (!UserSessionUtils.isLogined(req.getSession())) {
			return "redirect:/users/loginForm";
		}
		UserDao userdao = new UserDao();
		req.setAttribute("users", userdao.findAll());
		return "/user/list.jsp";
	}
}
