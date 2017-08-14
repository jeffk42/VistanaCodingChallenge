package jmk.challenge.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import jmk.challenge.model.Login;
import jmk.challenge.model.User;

public class UserUtilTest {
	
	@Test public void testValidateUser() {
        User user = new User();
        Login login = new Login();
        
        // Create a basic User to test against
        user.setUsername("testUser");
        String [] questions = {"question1", "question2", "question3"};
        String [] answers = {"answer1", "answer2", "answer3"};
        
        user.setSecurityQuestions(questions);
        user.setSecurityAnswers(answers);
        
        //Create a "correct" login where the user answered security question 1
        login.setUsername("testUser");
        login.setSecurityQuestion("question1");
        login.setSecurityAnswer("answer1");
        
        assertTrue("validateUser should pass and return the user when security question #1 is answered correctly.", UserUtil.validateUser(login,user).equals(user));
        
        //Create a "correct" login where the user answered security question 2
        login.setSecurityQuestion("question2");
        login.setSecurityAnswer("answer2");
        
        assertTrue("validateUser should pass and return the user when security question #2 is answered correctly.", UserUtil.validateUser(login,user).equals(user));
        
        //Create a "correct" login where the user answered security question 3
        login.setSecurityQuestion("question3");
        login.setSecurityAnswer("answer3");
        
        assertTrue("validateUser should pass and return the user when security question #3 is answered correctly.", UserUtil.validateUser(login,user).equals(user));
        
        //Create a failed login where the user answered security question 1 incorrectly
        login.setSecurityQuestion("question1");
        login.setSecurityAnswer("wrong answer");
        
        assertTrue("validateUser should fail and return null when security question #1 is answered incorrectly.", UserUtil.validateUser(login,user) == null);

        //Create a failed login where the user answered security question 2 incorrectly
        login.setSecurityQuestion("question2");
        login.setSecurityAnswer("wrong answer");
        
        assertTrue("validateUser should fail and return null when security question #2 is answered incorrectly.", UserUtil.validateUser(login,user) == null);
        
        //Create a failed login where the user answered security question 3 incorrectly
        login.setSecurityQuestion("question3");
        login.setSecurityAnswer("wrong answer");
        
        assertTrue("validateUser should fail and return null when security question #3 is answered incorrectly.", UserUtil.validateUser(login,user) == null);
        
        //Create a failed login where the user answered the security question correctly but used the wrong username
        login.setUsername("wrongUser");
        login.setSecurityQuestion("question3");
        login.setSecurityAnswer("answer3");
        
        assertTrue("validateUser should fail and return null when the username is wrong.", UserUtil.validateUser(login,user) == null);
    }
	
	@Test public void testValidateSecurityQuestions() {
		User user = new User();
        
        // Create a basic User to test against
        user.setUsername("testUser");
        String [] questions = {UserUtil.SECURITY_QUESTIONS.get(0), 
        						UserUtil.SECURITY_QUESTIONS.get(1), 
        						UserUtil.SECURITY_QUESTIONS.get(2)};
        String [] answers = {"answer1", "answer2", "answer3"};
        
        user.setSecurityQuestions(questions);
        user.setSecurityAnswers(answers);
        
        // User contains three distinct and known security questions, and all questions are answered.
        assertTrue("validateSecurityQuestions should pass with three distinct known questions and valid answers.", 
        		UserUtil.validateSecurityQuestions(user));
        
        user.getSecurityQuestions()[2] = UserUtil.SECURITY_QUESTIONS.get(1);
        
        // User contains three known security questions, but one of them is a duplicate.
        assertFalse("validateSecurityQuestions should fail with a duplicate question.", 
        		UserUtil.validateSecurityQuestions(user));
        
        user.getSecurityQuestions()[2] = "unknown question";
        
        // User contains an unknown question.
        assertFalse("validateSecurityQuestions should fail with an unknown question.", 
        		UserUtil.validateSecurityQuestions(user));
        
        user.getSecurityQuestions()[2] = UserUtil.SECURITY_QUESTIONS.get(1);
        user.getSecurityAnswers()[0] = "";
        
        // User contains an empty answer.
        assertFalse("validateSecurityQuestions should fail with an empty answer.", 
        		UserUtil.validateSecurityQuestions(user));
	}
}
