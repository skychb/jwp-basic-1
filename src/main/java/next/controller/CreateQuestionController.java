package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.Controller;
import next.dao.QuestionDao;
import next.model.Question;

public class CreateQuestionController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (!UserSessionUtils.isLogined(req.getSession())) {
			return "redirect:/users/loginForm";
		}
		Question question = new Question(
				req.getParameter("writer"),
				req.getParameter("title"),
				req.getParameter("contents"));
		
		QuestionDao qd = new QuestionDao();
		qd.insert(question);
		return "redirect:/";
	}

}

