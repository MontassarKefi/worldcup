package world.cup.repositories;

import org.springframework.data.repository.CrudRepository;

import world.cup.models.Partie;

public interface PartieRepository extends CrudRepository<Partie, Long> {

}
