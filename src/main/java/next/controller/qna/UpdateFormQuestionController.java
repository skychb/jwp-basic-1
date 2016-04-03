package next.controller.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.controller.UserSessionUtils;
import next.dao.QuestionDao;
import next.dao.UserDao;
import next.model.Question;
import next.model.User;
import core.mvc.AbstractController;
import core.mvc.ModelAndView;

public class UpdateFormQuestionController extends AbstractController {
	private QuestionDao questionDao = new QuestionDao();
	private UserDao userDao = new UserDao();
	
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	Question question = questionDao.findById(Long.parseLong(request.getParameter("questionId")));
    	
    	ModelAndView mav = jspView("/qna/updateForm.jsp");
    	mav.addObject("questions", question);
    	return mav;
	}
}
