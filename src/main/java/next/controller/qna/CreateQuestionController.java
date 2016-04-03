package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.mvc.AbstractController;
import core.mvc.ModelAndView;
import next.controller.UserSessionUtils;
import next.dao.QuestionDao;
import next.model.Question;

public class CreateQuestionController extends AbstractController{
	private QuestionDao qd = new QuestionDao();

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(UserSessionUtils.isLogined(request.getSession())){
			Question question = new Question(request.getParameter("writer"),
					request.getParameter("title"),
					request.getParameter("contents"));
			Question savedQuestion = qd.insert(question);
			jsonView().addObject("question", savedQuestion);
		}
		return jspView("redirect:/");
	}
}
