package co.grandcircus.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.dao.TaskDao;

@Controller
public class TaskListController {

	@Autowired
	private TaskDao taskDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
	ModelAndView mav = new ModelAndView("taskIndex");
	return mav;
	}
}
