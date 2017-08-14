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

import jmk.challenge.model.User;
import jmk.challenge.util.UserUtil;

/**
 * Controller for user registration
 * @author jkraus
 *
 */
@Controller
public class UserRegistrationController {
	
	private static final Logger LOG = Logger.getLogger(UserRegistrationController.class.getName());

/**
 * Handle the initial registration page.
 * @param request
 * @param response
 * @return
 */
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	
    ModelAndView modelView = new ModelAndView("register");
    modelView.addObject("user", new User());
    LOG.log(Level.INFO, "New User object created");
    return modelView;

  }

  /**
   * Handle the security questions page.
   * @param request
   * @param response
   * @param user
   * @return
   */
  @RequestMapping(value = "/register-security", method = RequestMethod.POST)
  public ModelAndView updateSecurityQuestions(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
	  
	  request.getSession().setAttribute("user", user);
	  ModelAndView modelView = null;
	  
	  // Make sure the values have been filled out, otherwise return to the previous page.
	  if (user != null) {
		  if (user.getUsername() != null && !user.getUsername().isEmpty() &&
			  user.getBirthMonth() > 0  &&
			  user.getBirthDay() > 0  &&
			  user.getBirthYear() > 0 ) {
			  
			  modelView = new ModelAndView("register-security");
			  modelView.addObject("secQuestions", UserUtil.SECURITY_QUESTIONS);
			  LOG.log(Level.INFO, "Registration started for: "+user.getUsername()+", DOB "+
					  user.getBirthMonth()+"/"+user.getBirthDay()+"/"+user.getBirthYear());
			  return modelView;
		  }
		  else {
			  modelView = new ModelAndView("register");
			  modelView.addObject("errorMessage", "Your username and birthday are mandatory fields. Please try again.");
			  LOG.log(Level.WARNING, "Invalid registration fields found.");
			  return modelView;
		  }
			  

	  } else {
		  modelView = new ModelAndView("register");
		  modelView.addObject("errorMessage", "There was a problem getting the user. Please try again.");
		  LOG.log(Level.WARNING, "Session does not include a user object.");
		  return modelView;
	  }
	  

  }
  
  /**
   * Handle the welcome page that loads when the user completes registration.
   * @param request
   * @param response
   * @param user
   * @return
   */
  @RequestMapping(value = "/register-complete", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) {

	  request.getSession().setAttribute("user", user);
	  
	  ModelAndView modelView = null;
	  
	  // Make sure the security questions have been selected and have answers.
	  if (user != null) {

		  if (UserUtil.validateSecurityQuestions(user)) {  
			  LOG.log(Level.INFO, "Registration security questions are valid.");
			  modelView = new ModelAndView("welcome");
			  
			  return modelView;
		  }
		  else {
			  modelView = new ModelAndView("register-security");
			  modelView.addObject("secQuestions", UserUtil.SECURITY_QUESTIONS);
			  modelView.addObject("errorMessage", "You must select three different security questions and answer them. Please try again.");
			  LOG.log(Level.WARNING, "Invalid security question fields found.");
			  return modelView;
		  }
			  

	  } else {
		  modelView = new ModelAndView("register");
		  modelView.addObject("errorMessage", "There was a problem getting the user. Please try again.");
		  LOG.log(Level.WARNING, "Session does not include a user object.");
		  return modelView;
	  }

  }

}
