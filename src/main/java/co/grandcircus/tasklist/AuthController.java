package co.grandcircus.tasklist;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.tasklist.dao.UserDao;
import co.grandcircus.tasklist.entity.User;


@Controller
public class AuthController {

	@Autowired
	UserDao userDao;
	
//	@Autowired
//	GithubService githubService;

	//Show log in form
	@RequestMapping("/login-form")
	public ModelAndView showLoginForm() {
	ModelAndView mav = new ModelAndView("login-form"); //offers choice of login or register
	return mav;
	}
	
	// to create a new user (register)
	@PostMapping("/submit-registration")
	public ModelAndView submitReg(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpSession session,
			RedirectAttributes redir) {
		User user = new User(email, password);
		userDao.save(user);
		session.setAttribute("user", user);
		redir.addFlashAttribute("message", "Registered! Please log in: ");
		ModelAndView mav = new ModelAndView("redirect:/login-form");
		return mav;
	}
	
	//existing user login
	@PostMapping("/submit-login")
	public ModelAndView submitLoginForm(
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			HttpSession session, RedirectAttributes redir) {
		// Find the matching user.
		User user = userDao.findByEmail(email);
		if (user == null || !password.equals(user.getPassword())) {
			// If the user or password don't match, display an error message.
			ModelAndView mav = new ModelAndView("/taskIndex"); //go back to the first page
			mav.addObject("message", "Incorrect username or password. Please try again.");
			return mav;
		}
		// if they do match, add user to session
		session.setAttribute("user", user);
		//tell user they are logged in
		redir.addFlashAttribute("message", "You are now logged in.");
		return new ModelAndView("redirect:tasks/");
	}
	
}
//		// A flash message will only show on the very next page. Then it will go away.
//		// It is useful with redirects since you can't add attributes to the mav.
//		redir.addFlashAttribute("message", "Logged in.");
//		return new ModelAndView("redirect:/");
//	}
//
//	@RequestMapping("/logout")
//	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
//		// invalidate clears the current user session and starts a new one.
//		session.invalidate();
//		
//		// A flash message will only show on the very next page. Then it will go away.
//		// It is useful with redirects since you can't add attributes to the mav.
//		redir.addFlashAttribute("message", "Logged out.");
//		return new ModelAndView("redirect:/");
//	}
//
//	// This is the second step in OAuth. After the user approves the login on the github site, it redirects back
//	// to our site with a temporary code.
//	@RequestMapping("/oauth-github-callback")
//	public ModelAndView handleGithubCallback(@RequestParam("code") String code, HttpSession session) {
//		// First we must exchange that code for an access token.
//		String accessToken = githubService.getGithubAccessToken(code);
//		// Then we can use that access token to get information about the user and other things.
//		User githubUser = githubService.getUserFromGithubApi(accessToken);
//
//		// Check to see if the user is already in our database.
//		User user = userDao.findByGithubId(githubUser.getGithubId());
//		if (user == null) {
//			// if not, add them.
//			user = githubUser;
//			userDao.save(user);
//		}
//
//		// Set the user on the session, just like the other type of login.
//		session.setAttribute("user", user);
//		// In some apps, you need the access token later, so throw that on the session, too.
//		session.setAttribute("githubAccessToken", accessToken);
//
//		return new ModelAndView("redirect:/");

