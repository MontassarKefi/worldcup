package world.cup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import world.cup.models.Billet;
import world.cup.repositories.BilletRepository;


@Service
public class ImpBilletService implements IBilletService {
	@Autowired
	BilletRepository brepos;

	@Override
	public Billet saveBillet(Billet billet) {
		// TODO Auto-generated method stub
		return brepos.save(billet);
	}

	@Override
	public Optional<Billet> findById(Long id) {
		// TODO Auto-generated method stub
		return brepos.findById(id);
	}

	@Override
	public List<Billet> findAllBillets() {
		// TODO Auto-generated method stub
		return (List<Billet>) brepos.findAll();
	}

	@Override
	public void delete(Billet billet) {
		// TODO Auto-generated method stub
		brepos.delete(billet);
	}
}
