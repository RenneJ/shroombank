package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof03.shroombank.domain.UserRepository;

@CrossOrigin
@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(value="/listusers")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String listAllUsers(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "userlist";
	}
	@GetMapping(value = "/deleteuser/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		// Don't delete urself admin!
		if (id == 1 && userRepo.findById(id).get().getRole().equals("ADMIN")) {
			return "redirect:/listusers";
		} else {
		userRepo.deleteById(id);
		return "redirect:/listusers";
		}
	}

}
