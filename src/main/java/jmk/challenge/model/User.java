package jmk.challenge.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jmk.challenge.util.UserUtil;

@Component
@Scope("session")
public class User {
	
	private String username;
	private int birthMonth;
	private int birthYear;
	private int birthDay;
	private String [] securityQuestions = new String[UserUtil.SECURITY_QUESTION_COUNT];
	private String [] securityAnswers = new String[UserUtil.SECURITY_QUESTION_COUNT];
	
	
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the birthMonth
	 */
	public int getBirthMonth() {
		return birthMonth;
	}
	/**
	 * @param birthMonth the birthMonth to set
	 */
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	/**
	 * @return the birthYear
	 */
	public int getBirthYear() {
		return birthYear;
	}
	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	/**
	 * @return the birthDay
	 */
	public int getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * @return the securityQuestions
	 */
	public String[] getSecurityQuestions() {
		return securityQuestions;
	}
	/**
	 * @param securityQuestions the securityQuestions to set
	 */
	public void setSecurityQuestions(String[] securityQuestions) {
		this.securityQuestions = securityQuestions;
	}
	/**
	 * @return the securityAnswers
	 */
	public String[] getSecurityAnswers() {
		return securityAnswers;
	}
	/**
	 * @param securityAnswers the securityAnswers to set
	 */
	public void setSecurityAnswers(String[] securityAnswers) {
		this.securityAnswers = securityAnswers;
	}
	


}
