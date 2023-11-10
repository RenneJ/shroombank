package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import hh.sof03.shroombank.domain.CollectionRepository;
import hh.sof03.shroombank.domain.User;
import hh.sof03.shroombank.domain.UserRepository;

@CrossOrigin
@Controller
public class CollectionController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CollectionRepository collectionRepo;
		
	@GetMapping(value="/collection")
	public String hello(@CurrentSecurityContext(expression="authentication?.name") String username, Model model) {
		//System.out.println(username);
		//System.out.println(userRepo.findByUsername(username));
		User currentuser = userRepo.findByUsername(username);
		model.addAttribute("collections", collectionRepo.findCollectionByUser(currentuser));
	    return "collectionlist";
	}
	// TODO: Add method + edit
}

