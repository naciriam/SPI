package fr.univbrest.dosi.business;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.User;

@Service
public class UserBusiness {

	private final Map<String, User> listUser;

	public UserBusiness() {
		this.listUser = new HashMap<String, User>();
		this.listUser.put("root", new User("root", "root", "Admin"));
		this.listUser.put("user1", new User("user1", "user1", "Standard"));
	}

	public User authentification(final String login, final String password) {
		User userLogged = this.listUser.get(login);
		if (userLogged != null && userLogged.getPassword().equals(password))
			return userLogged;
		return null;
	}

}
