package jmk.challenge.model;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class User {
	
	private String username;
	private int birthMonth;
	private int birthYear;
	private int birthDay;
	private HashMap<String,String> qaMap = null;
	private String security1;
	private String answer1;
	private String security2;
	private String answer2;
	private String security3;
	private String answer3;
	
	
	
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
	 * @return the qaMap
	 */
	public HashMap<String,String> getQaMap() {
		return qaMap;
	}
	/**
	 * @param qaMap the qaMap to set
	 */
	public void setQaMap(HashMap<String,String> qaMap) {
		this.qaMap = qaMap;
	}
	
	public void addQuestionAnswer(String question, String answer) {
		getQaMap().put(question, answer);
	}
	
	public String getQuestionAnswer(String question) {
		return getQaMap().get(question);
	}
	
	public String getPassword() {
		return getQaMap().get("password");
	}
	
	public void setPassword(String newPassword) {
		getQaMap().put("password", newPassword);
	}
	/**
	 * @return the security1
	 */
	public String getSecurity1() {
		return security1;
	}
	/**
	 * @param security1 the security1 to set
	 */
	public void setSecurity1(String security1) {
		this.security1 = security1;
	}
	/**
	 * @return the answer1
	 */
	public String getAnswer1() {
		return answer1;
	}
	/**
	 * @param answer1 the answer1 to set
	 */
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	/**
	 * @return the security2
	 */
	public String getSecurity2() {
		return security2;
	}
	/**
	 * @param security2 the security2 to set
	 */
	public void setSecurity2(String security2) {
		this.security2 = security2;
	}
	/**
	 * @return the answer2
	 */
	public String getAnswer2() {
		return answer2;
	}
	/**
	 * @param answer2 the answer2 to set
	 */
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	/**
	 * @return the security3
	 */
	public String getSecurity3() {
		return security3;
	}
	/**
	 * @param security3 the security3 to set
	 */
	public void setSecurity3(String security3) {
		this.security3 = security3;
	}
	/**
	 * @return the answer3
	 */
	public String getAnswer3() {
		return answer3;
	}
	/**
	 * @param answer3 the answer3 to set
	 */
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

}
