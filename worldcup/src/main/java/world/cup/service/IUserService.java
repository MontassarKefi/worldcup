package world.cup.service;

import java.util.List;
import java.util.Optional;

import world.cup.models.User;
import world.cup.payload.response.MessageResponseMetier;


public interface IUserService {
	MessageResponseMetier saveUser(User user);

	Optional<User> findById(Long id);


	List<User> findAllUsers();

//	void delete(Optional<User> user);


	MessageResponseMetier delete(Long id);



}
