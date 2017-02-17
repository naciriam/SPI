package fr.univbrest.dosi.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private String login,password,role;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", role="
				+ role + "]";
	}

	
}
