package hh.sof03.shroombank.domain;

import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Long>{
	Collection findCollectionByUser(User user);

}
