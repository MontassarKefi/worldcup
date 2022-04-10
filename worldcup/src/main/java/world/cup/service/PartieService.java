package world.cup.service;

import java.util.List;
import java.util.Optional;

import world.cup.models.Partie;


public interface PartieService {

	Partie savePartie(Partie partie);
	
	Optional<Partie> findById(Long id);


	List<Partie> findAllParties();

	void delete(Partie partie);

}
