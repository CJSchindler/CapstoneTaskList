package co.grandcircus.tasklist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.tasklist.entity.User;

@Controller
public class MembersController {
	
	@RequestMapping("/member-task-view")
	public ModelAndView memberTaskView(@SessionAttribute(name="user", required=false) User user, RedirectAttributes redir) {
		// For this URL, make sure there is a user on the session.
		if (user == null) {
			// if not, send them back to the login page with a message.
			redir.addFlashAttribute("message", "Wait! Please log in.");
			return new ModelAndView("redirect:/login");
		}
		
		// if the user is logged in, proceed as normal.
		return new ModelAndView("member-task-view");
	}

}
