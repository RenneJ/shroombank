package hh.sof03.shroombank.web;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.shroombank.domain.User;
import hh.sof03.shroombank.domain.UserRepository;
import jakarta.validation.Valid;


/*METHODS FOR LOGIN AND SIGNUP. CONDITIONAL REDIRECT TO EITHER USER VIEW OR ADMIN VIEW*/

@CrossOrigin
@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	@GetMapping(value={"/index"})
	public String showIndex() {
		return "index";
	}
	@GetMapping(value="/signup")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "newuser";
	}
	@PostMapping(value="/saveuser")
	public String saveUser(@ModelAttribute @Valid User user, Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "newuser";
		}
		int strength = 12; // work factor of bcrypt; "rounds"
		String plaintext = user.getHash();
		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(strength, new SecureRandom());
		
		user.setHash(bCryptPasswordEncoder.encode(plaintext));
		user.setRole("USER");	// only USER role can be made with UI
		userRepo.save(user);
		return "redirect:login";
	}

}
