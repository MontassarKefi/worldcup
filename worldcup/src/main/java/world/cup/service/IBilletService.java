package world.cup.service;

import java.util.List;
import java.util.Optional;

import world.cup.models.Billet;


public interface IBilletService {

	Optional<Billet> findById(Long id);

	Billet saveBillet(Billet billet);

	List<Billet> findAllBillets();

	void delete(Billet billet);
	
	


	





}
