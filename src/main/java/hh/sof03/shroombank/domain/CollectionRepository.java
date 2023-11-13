package hh.sof03.shroombank.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Long>{
	List<Collection> findAllByUser(User user);

}
