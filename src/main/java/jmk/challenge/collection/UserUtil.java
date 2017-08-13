/**
 * 
 */
package jmk.challenge.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jmk.challenge.model.Login;
import jmk.challenge.model.User;

/**
 * A utility class for validating the login from the user in session.
 * @author jkraus
 *
 */
public class UserUtil {
	
	/**
	 * The list of available security questions for user registration.
	 */
	public static final List<String> SECURITY_QUESTIONS = Arrays.asList(
									"What is the name of your first pet?",
									"What is the name of your high school mascot?",
									"What was the make of your first car?",
									"What is your father's middle name?",
									"What is your favorite color?",
									"What is the air speed velocity of an unladen swallow?",
									"How do you feel?");
	
	/**
	 * Determines if the login information matches the user in session.
	 * @param login the Login object containing the login information
	 * @param user the user in session
	 * @return a User object if validation succeeds, otherwise null.
	 */
	public static User validateUser(Login login, User user) {
		User thisUser = user;
		System.out.println("Login: username = "+login.getUsername());
		System.out.println("Login: question = "+login.getSecurityQuestion());
		System.out.println("Login: answer = "+login.getSecurityAnswer());
		System.out.println("user: username = "+user.getUsername());
		System.out.println("user: q1 = "+user.getSecurity1());
		System.out.println("user: a1 = "+user.getAnswer1());
		if (thisUser != null && login != null) {
			String loginQ = login.getSecurityQuestion();
			String loginA = "";
			
			if (loginQ.equals(thisUser.getSecurity1()))
				loginA = thisUser.getAnswer1();
			else if (loginQ.equals(thisUser.getSecurity2()))
				loginA = thisUser.getAnswer2();
			else if (loginQ.equals(thisUser.getSecurity3()))
				loginA = thisUser.getAnswer3();
			
			if (login.getUsername().equals(thisUser.getUsername()) && 
					login.getSecurityAnswer().equalsIgnoreCase(loginA))
				return thisUser;
			else return null;
		}
		else return null;
		
	}

}
