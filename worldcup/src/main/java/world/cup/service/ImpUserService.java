package world.cup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import world.cup.models.User;
import world.cup.payload.response.MessageResponseMetier;
import world.cup.repositories.UserRepository;
 


@Service
public class ImpUserService implements IUserService {
	@Autowired
	UserRepository urepos;

	@Transactional
	@Override
	public MessageResponseMetier saveUser(User user) {
		boolean existe = urepos.existsByEmail(user.getEmail());
		if (existe) {
			return new MessageResponseMetier(false, "Echec !", "Cet email existe déja !");
		}
		urepos.save(user);
		return new MessageResponseMetier(true, "Succès", "Opération réalisée avec succès.");
	}

	/*
	 * @Override public User saveUser(User user) { // TODO Auto-generated method
	 * stub return urepos.save(user); }
	 */

	@Transactional
	@Override
	public MessageResponseMetier delete(Long id) {
		try {
		User user = findById(id).get();
		System.out.println(user.getPassword());
		
		
			urepos.deleteById(id);
			return new MessageResponseMetier(true, "Succès", "L'enregistrement à été supprimé avec succès.");
		}
		catch(Exception e ) {
			return new MessageResponseMetier(false, "Echec", "Cet enregistrement n'existe pas !");

		}
		
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return urepos.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) urepos.findAll();
	}







}
