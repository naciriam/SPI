package fr.univbrest.dosi.controllers;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.User;
import fr.univbrest.dosi.business.UserBusiness;

@RestController
public class UserController {

	@Autowired
	private UserBusiness business;

	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public void authentifier(final HttpServletRequest request,
			@RequestBody User user) throws AuthenticationException {
		final User userTemp = business.authentification(user.getLogin(),
				user.getPassword());
		if (userTemp != null) {
			request.getSession().setAttribute("user", userTemp);
		} else {
			request.getSession().removeAttribute("user");
			throw new AuthenticationException("Erreur d'authentification !");
		}
	}

	@RequestMapping(value = "/user")
	public User users(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void deconnexion(final HttpServletRequest request) {
		request.getSession().removeAttribute("user");
	}
}