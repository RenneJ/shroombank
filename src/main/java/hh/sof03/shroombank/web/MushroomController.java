package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.shroombank.domain.Mushroom;
import hh.sof03.shroombank.domain.MushroomRepository;
@CrossOrigin
@Controller
public class MushroomController {
	@Autowired
	private MushroomRepository mushroomRepo;
	
	// RESTful methods
	@GetMapping(value="/mushrooms")
	public @ResponseBody Iterable<Mushroom> findAllMushrooms() {
		return this.mushroomRepo.findAll();
	}
	// ONLY FOR TESTING. Remove this from production version. 
	@PostMapping(value="/mushrooms")
	public @ResponseBody Mushroom addOneMushroom(@RequestBody Mushroom mushroom) {
		return this.mushroomRepo.save(mushroom);
	}
	//TODO: "regular" controller methods
	@GetMapping(value="/mushroomlist")
	public String mushroomList(Model model) {
		model.addAttribute("mushrooms", mushroomRepo.findAll());
		return "mushroomlist";
	}
}
