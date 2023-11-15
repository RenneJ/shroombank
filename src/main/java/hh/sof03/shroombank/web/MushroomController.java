package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.shroombank.domain.Mushroom;
import hh.sof03.shroombank.domain.MushroomRepository;

import jakarta.validation.Valid;

@CrossOrigin
@Controller
public class MushroomController {
	@Autowired
	private MushroomRepository mushroomRepo;
	
	// RESTful methods, API
	@GetMapping(value="/mushrooms")
	public @ResponseBody Iterable<Mushroom> findAllMushrooms() {
		return this.mushroomRepo.findAll();
	}
	// Regular methods, html
	@GetMapping(value="/mushroomlist")
	public String showMushroomList(Model model) {
		model.addAttribute("mushrooms", mushroomRepo.findAll());
		return "mushroomlist";
	}
	@GetMapping(value="/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addMushroom (Model model) {
		model.addAttribute("mushroom", new Mushroom());
		return "addmushroom";
	}
	@PostMapping(value = "/save")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String saveMushroom(@ModelAttribute @Valid Mushroom mushroom, Errors errors, Model model) {
		// empty rows must not be saved to database; binomen is the least required datum
		if(errors.hasErrors()) {
			return "editmushroom";
		}
		mushroomRepo.save(mushroom);
		return "redirect:mushroomlist";
	}
	@GetMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editMushroom(@PathVariable("id") Long mushroomid, Model model) {
		model.addAttribute("mushroom", mushroomRepo.findById(mushroomid));
		return "editmushroom";
	}
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMushroom(@PathVariable("id") Long id, Model model) {
		mushroomRepo.deleteById(id);
		return "redirect:/mushroomlist";
	}
}
