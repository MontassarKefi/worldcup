package world.cup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;

import world.cup.models.User;
import world.cup.payload.response.MessageResponseMetier;
 
import world.cup.service.ImpUserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;



@RestController
@CrossOrigin(origins = "*") // api sera consommée par Angular
@RequestMapping("/api")
public class UserController {
	@Autowired
	ImpUserService userv;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@PostMapping("/addusert")
	public MessageResponseMetier createUser(@Validated @RequestBody User user) {
		return userv.saveUser(user);
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@PathVariable(value = "id") Long Id) {
		return userv.findById(Id);
		// .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<User> getAllUsers() {
		List<User> pro = userv.findAllUsers();
		return pro;

	}
	
	@DeleteMapping("/user/{id}")
	public MessageResponseMetier deleteUser(@PathVariable(value = "id") Long userId) {

		return userv.delete(userId);

	}
	
	@PutMapping("/user/{id}")
	public MessageResponseMetier updateUser(@PathVariable(value = "id") Long Id, @Validated @RequestBody User userDetails) {

		User user = userv.findById(Id).orElseThrow(null);
		
		user.setEmail(userDetails.getEmail());
		user.setPassword(encoder.encode(userDetails.getPassword())); 
		user.setUsername(userDetails.getUsername());
		
		
		MessageResponseMetier updatedUser = userv.saveUser(user);
		return updatedUser;
	}
}
