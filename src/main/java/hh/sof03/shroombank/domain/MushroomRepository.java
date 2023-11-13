package hh.sof03.shroombank.domain;

import org.springframework.data.repository.CrudRepository;

public interface MushroomRepository extends CrudRepository<Mushroom, Long>{
	String findByName(String name);
}
