package jmk.challenge.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jmk.challenge.model.Login;
import jmk.challenge.model.User;
import jmk.challenge.util.UserUtil;

@Controller
public class UserLoginController {
  
	private static final Logger LOG = Logger.getLogger(UserLoginController.class.getName());
	
	/**
	 * Called when the user enters a username in the pop-up menu.
	 * @param request
	 * @param response
	 * @return
	 */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView modelView = null;
    Login newLogin = new Login();
    User user = (User)request.getSession().getAttribute("user");
    
    if (user == null) {
    	// There's no user in session, so start over.
    	modelView = new ModelAndView("index");
    	modelView.addObject("errorMessage", "There is no user in session. Please register before attempting to login.");
    	LOG.log(Level.WARNING, "Login attempted with no user in session.");
    }
    else {
    	
	    modelView = new ModelAndView("login");
	    // Get the login username from the popup.
	    newLogin.setUsername(request.getParameter("username"));
	    
	    // Randomly choose a security question for that user to answer.
	    
		int rand = 1 + (int)(3 * Math.random());
		
		if (rand == 1) {
			newLogin.setSecurityQuestion(user.getSecurity1());
		}
		else if (rand == 2) {
			newLogin.setSecurityQuestion(user.getSecurity2());
		}
		else {
			newLogin.setSecurityQuestion(user.getSecurity3());
		}
		
	    modelView.addObject("login", newLogin);
    }
    
    return modelView;

  }

  /**
   * Called when the user enters the answer to a randomly chosen security question.
   * @param request
   * @param response
   * @param login
   * @return
   */
  @RequestMapping(value = "/login-security", method = RequestMethod.POST)
  public ModelAndView loginSecurity(HttpServletRequest request, HttpServletResponse response,
		  @ModelAttribute("login") Login login) {

	  // Get the user in session.
	User inSessionUser = (User) request.getSession().getAttribute("user");
	
	if (inSessionUser != null)
		LOG.log(Level.INFO, "Session user found: "+inSessionUser.getUsername());
	else 
		LOG.log(Level.WARNING, "Session User is null.");
	
    ModelAndView modelView = null;

    // Make sure the username and security question/answer matches what the user registered.
    User user = UserUtil.validateUser(login, inSessionUser);

    if (null != user) {
    	modelView = new ModelAndView("loginsuccess");
    } else {
    	modelView = new ModelAndView("login");
    	modelView.addObject("errorMessage", "Your username or security question is incorrect. Please try again.");
    	LOG.log(Level.INFO, "User failed authentication.");
    }

    return modelView;

  }
  

}
