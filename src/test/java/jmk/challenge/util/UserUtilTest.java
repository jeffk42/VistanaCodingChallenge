package jmk.challenge.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import jmk.challenge.model.Login;
import jmk.challenge.model.User;

public class UserUtilTest {
	
	@Test public void testValidateUser() {
        User user = new User();
        Login login = new Login();
        
        // Create a basic User to test against
        user.setUsername("testUser");
        user.setSecurity1("question1");
        user.setSecurity2("question2");
        user.setSecurity3("question3");
        user.setAnswer1("answer1");
        user.setAnswer2("answer2");
        user.setAnswer3("answer3");
        
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
}
