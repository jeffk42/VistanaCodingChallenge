package jmk.challenge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jmk.challenge.collection.UserUtil;
import jmk.challenge.model.User;

/**
 * Controller for user registration
 * @author jkraus
 *
 */
@Controller
public class UserRegistrationController {

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
			  
			  return modelView;
		  }
		  else {
			  modelView = new ModelAndView("register");
			  modelView.addObject("errorMessage", "Your username and birthday are mandatory fields. Please try again.");
			  return modelView;
		  }
			  

	  } else {
		  modelView = new ModelAndView("register");
		  modelView.addObject("errorMessage", "There was a problem getting the user. Please try again.");
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
		  if (user.getSecurity1() != null && !user.getSecurity1().isEmpty() &&
			  user.getAnswer1() != null && !user.getAnswer1().isEmpty() &&
			  user.getSecurity2() != null && !user.getSecurity2().isEmpty() &&
			  user.getAnswer2() != null && !user.getAnswer2().isEmpty() &&
			  user.getSecurity3() != null && !user.getSecurity3().isEmpty() &&
			  user.getAnswer3() != null && !user.getAnswer3().isEmpty() ) {
			  
			  modelView = new ModelAndView("welcome");
			  
			  return modelView;
		  }
		  else {
			  modelView = new ModelAndView("register-security");
			  modelView.addObject("secQuestions", UserUtil.SECURITY_QUESTIONS);
			  modelView.addObject("errorMessage", "You must select three different security questions and answer them. Please try again.");
			  return modelView;
		  }
			  

	  } else {
		  modelView = new ModelAndView("register");
		  modelView.addObject("errorMessage", "There was a problem getting the user. Please try again.");
		  return modelView;
	  }

  }

}
