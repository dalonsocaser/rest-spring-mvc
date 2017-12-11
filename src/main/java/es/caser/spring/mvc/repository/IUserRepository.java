package es.caser.spring.mvc.repository;

import java.util.List;

import es.caser.spring.mvc.model.User;

public interface IUserRepository {
	User save (User user);

	User findByUsername(String username);

	List<User> findAll();
}
