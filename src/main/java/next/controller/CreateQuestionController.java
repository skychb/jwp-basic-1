package next.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.Controller;
import next.dao.QuestionDao;
import next.model.Question;

public class CreateQuestionController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		final AtomicInteger count = new AtomicInteger(10);
		if (!UserSessionUtils.isLogined(req.getSession())) {
			return "redirect:/users/loginForm";
		}
		
		Question question = new Question(count.getAndIncrement(), 
				req.getParameter("writer"), 
				req.getParameter("title"), 
				req.getParameter("contents"),
				new Timestamp(Calendar.getInstance().getTime().getTime()),
				0);
		QuestionDao questionDao = new QuestionDao();
		questionDao.insert(question);
		return "redirect:/";
	}

}

