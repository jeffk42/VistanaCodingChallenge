/**
 * 
 */
package jmk.challenge.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import jmk.challenge.model.Login;
import jmk.challenge.model.User;

/**
 * A utility class for validating the login from the user in session.
 * @author jkraus
 *
 */
public class UserUtil {
	
	private static final Logger LOG = Logger.getLogger(UserUtil.class.getName());
	
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
	 * The number of security questions that the user must answer when registering.
	 */
	public static final int SECURITY_QUESTION_COUNT = 3;
	
	/**
	 * Determines if the login information matches the user in session.
	 * @param login the Login object containing the login information
	 * @param user the user in session
	 * @return a User object if validation succeeds, otherwise null.
	 */
	public static User validateUser(Login login, User user) {
		User thisUser = user;

		if (thisUser != null && login != null) {
			String loginQ = login.getSecurityQuestion();
			String loginA = "";
			int qNum = 0;
			
			// Go through the user's chosen security questions to find the one that was answered during login.
			while (qNum < UserUtil.SECURITY_QUESTION_COUNT && loginA.isEmpty())
			{
				if (loginQ.equals(thisUser.getSecurityQuestions()[qNum]))
					loginA = thisUser.getSecurityAnswers()[qNum];
				
				qNum++;
			}
			
			// If username and security question are correct, return the user object.
			if (login.getUsername().equals(thisUser.getUsername()) && 
					login.getSecurityAnswer().equalsIgnoreCase(loginA)) {
				LOG.log(Level.INFO, "User "+thisUser.getUsername()+" has been validated.");
				return thisUser;
			}
			else return null;
		}
		else {
			LOG.log(Level.WARNING, "While validating user: Login or User object is null.");
			return null;
		}
			
		
	}
	
	/**
	 * Ensure that the security questions are unique and answered.
	 * @param user
	 * @return true if the security questions and answers are valid.
	 */
	public static boolean validateSecurityQuestions(User user) {
		return !(containsUnknownQuestions(user.getSecurityQuestions()) ||
				containsDuplicate(user.getSecurityQuestions()) ||
				containsEmpty(user.getSecurityQuestions()) || 
				containsEmpty(user.getSecurityAnswers()));
	}
	
	/**
	 * Checks for duplicate values in an array.
	 * @param values
	 * @return true if the array contains a duplicate value
	 */
	private static boolean containsDuplicate(String [] values) {
		Set<String> tempSet = new HashSet<String>();
		
		for (String val : values)
		{
		    if (tempSet.contains(val)) return true;
		    tempSet.add(val);
		}
		return false;
		
	}
	
	/**
	 * Checks for empty values in an array.
	 * @param values
	 * @return true if an empty value is found.
	 */
	private static boolean containsEmpty(String [] values) {
		for (String val : values)
			if (val == null || val.isEmpty())
				return true;
		
		return false;
	}
	
	/**
	 * Checks to make sure the question is valid.
	 * @param question
	 * @return true if the question exists in the list of security questions.
	 */
	private static boolean isValidQuestion(String question) {
		return SECURITY_QUESTIONS.contains(question);
	}
	
	/**
	 * Checks for unknown questions in the list of security questions.
	 * @param questions
	 * @return true if the array contains a question that isn't in the defined list.
	 */
	private static boolean containsUnknownQuestions(String [] questions) {
		for (String q : questions)
			if (!isValidQuestion(q))
				return true;
		
		return false;
	}

}
