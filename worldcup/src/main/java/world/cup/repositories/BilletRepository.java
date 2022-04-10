package world.cup.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Billet;
@Repository 
public interface BilletRepository extends CrudRepository<Billet, Long>{

	
}
