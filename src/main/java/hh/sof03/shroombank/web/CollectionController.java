package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.sof03.shroombank.domain.Collection;
import hh.sof03.shroombank.domain.CollectionRepository;
import hh.sof03.shroombank.domain.MushroomRepository;
import hh.sof03.shroombank.domain.User;
import hh.sof03.shroombank.domain.UserRepository;

@CrossOrigin
@Controller
public class CollectionController {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CollectionRepository collectionRepo;
	@Autowired
	private MushroomRepository mushroomRepo;
		
	@GetMapping(value="/collection")
	public String listCollection(@CurrentSecurityContext(expression="authentication?.name") String username, Model model) {
		User currentuser = userRepo.findByUsername(username);
		model.addAttribute("collections", collectionRepo.findAllByUser(currentuser));
	    return "collectionlist";
	}
	// TODO: collection edit, error handling /collect/BAD_ID
	@GetMapping(value="/collect/{id}")
	public String collectMushroom(@PathVariable("id") Long mushroomid, Model model) {
		// Initialize a new collection.
		Collection collection = new Collection();
		// Bind mushroom to collection. Pass the model to template; .get() unwraps Optional<Mushroom> to Mushroom
		// TODO: Error handling
		collection.setMushroom(mushroomRepo.findById(mushroomid).get());
		model.addAttribute("collection", collection);
		return "collectform";
	}
	@PostMapping(value="/savecollection")
	public String saveCollection(@CurrentSecurityContext(expression="authentication?.name") String username, Collection collection) {
		// Fetch current user using security context and bind it to collection
		collection.setUser(userRepo.findByUsername(username));
		collectionRepo.save(collection);
		return "redirect:/collection";
	}
	@GetMapping(value="/editcollection/{id}")
	public String editCollection(@PathVariable("id") Long collectionid, @CurrentSecurityContext(expression="authentication?.name") String username,Model model) {
		Collection collection = collectionRepo.findById(collectionid).get();
		User currentuser = userRepo.findByUsername(username);
		// Users are only allowed to edit their own collections; collection needs to have currentuser as its "user" attribute
		if (collection != null && collection.getUser() == currentuser) {
			model.addAttribute("mushrooms", mushroomRepo.findAll());
			model.addAttribute("collection", collectionRepo.findById(collectionid));
			return "editcollection";
		} else {
			return "error";
		}
		
	}
}

