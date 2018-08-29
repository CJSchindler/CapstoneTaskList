package co.grandcircus.tasklist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.tasklist.entity.Task;
import co.grandcircus.tasklist.entity.User;

@Controller
public class TaskController {

	@RequestMapping("/tasks")
	public ModelAndView listTasks(@SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
		if (user == null) {
			// if not, send them back to the login page with a message.
			redir.addFlashAttribute("message", "Wait! Please log in.");
			return new ModelAndView("redirect:/login");
		}
		
		ModelAndView mav = new ModelAndView("task-list");
		mav.addObject("tasks", taskDao.findByUser(user));
		return mav;
	}
	
		@RequestMapping("/tasks/add")
		public ModelAndView addTask(@SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
//			if (user == null) {
//				// if not, send them back to the login page with a message.
//				redir.addFlashAttribute("message", "Wait! Please log in.");
//				return new ModelAndView("redirect:/login");
//			}
			
			ModelAndView mav = new ModelAndView("task-add");
			return mav;
		}

		@PostMapping("/submit-task")
		public ModelAndView submitAddTask(Task task, @SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
			if (user == null) {
				// if not, send them back to the login page with a message.
				redir.addFlashAttribute("message", "Wait! Please log in.");
				return new ModelAndView("redirect:/login");
			}
			
			task.setUser(user);
			taskDao.save(task);
			ModelAndView mav = new ModelAndView("redirect:/tasks");
			return mav;
		}
		
		@RequestMapping("/tasks/{id}/delete")
		public ModelAndView deleteTask(@PathVariable("id") Long id, @SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
			
			taskDao.deleteById(id);
			ModelAndView mav = new ModelAndView("redirect:/tasks");
			return mav;
		}
		
		@RequestMapping("/tasks/{id}/edit")
		public ModelAndView editTask(@PathVariable("id") Task task, @SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
			
			ModelAndView mav = new ModelAndView("task-edit");
			mav.addObject("task", task);
			return mav;
		}
	
}
