package next.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.Controller;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;

public class QuestionController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		QuestionDao qd = new QuestionDao();
		AnswerDao ad = new AnswerDao();
		
		
		int questionId = Integer.parseInt(req.getParameter("questionId"));
		Question qs = qd.findByQuestionId(questionId);
		if (qs == null) {
            throw new NullPointerException("사용자를 찾을 수 없습니다.");
        }
		req.setAttribute("question", qs);
		req.setAttribute("answers", ad.findByQuestionId(questionId));
		return "/qna/show.jsp";
	}
	
}
