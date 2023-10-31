package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.shroombank.domain.Mushroom;
import hh.sof03.shroombank.domain.MushroomRepository;

@RestController
public class MushroomController {
	@Autowired
	private MushroomRepository mushroomRepo;
	
//	public MushroomController(MushroomRepository mushroomRepo) {
//		this.mushroomRepo = mushroomRepo;
//	}
	@GetMapping("/mushrooms")
	public Iterable<Mushroom> findAllMushrooms() {
		return this.mushroomRepo.findAll();
	}
	@PostMapping("/mushrooms")
	public Mushroom addOneMushroom(@RequestBody Mushroom mushroom) {
		return this.mushroomRepo.save(mushroom);
	}
}
