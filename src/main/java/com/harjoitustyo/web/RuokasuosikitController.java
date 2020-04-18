package com.harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.harjoitustyo.domain.RavintolaRepository;
import com.harjoitustyo.domain.Ruoka;
import com.harjoitustyo.domain.RuokaRepository;

@Controller
public class RuokasuosikitController {
	@Autowired
	private RuokaRepository rrepository;
	@Autowired
	private RavintolaRepository rarepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }  
	
	@RequestMapping(value= {"/", "/ruokasuosikit"})
    public String ruokaSuosikit(Model model) {	
        model.addAttribute("ruoat", rrepository.findAll());
        model.addAttribute("ravintolat", rarepository.findAll());
        return "ruokasuosikit";
    }
	// Kaikki ruoat listattuna REST-rajapinnan avulla
    @RequestMapping(value="/ruoat", method = RequestMethod.GET)
    public @ResponseBody List<Ruoka> ruoatListaREST() {	
        return (List<Ruoka>) rrepository.findAll();
    }
    // ruoka ID:n mukaan REST-rajapinnan avulla
    @RequestMapping(value="/ruoka/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Ruoka> findStudentRest(@PathVariable("id") Long id) {	
    	return rrepository.findById(id);
    }  
	
	@RequestMapping(value = "/lisaa")
    public String lisaaRuoka(Model model){
    	model.addAttribute("ruoka", new Ruoka());
    	model.addAttribute("ravintolat", rarepository.findAll());
        return "lisaa";
    } 
	
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST)
    public String tallennaRuoka(Ruoka ruoka){
        rrepository.save(ruoka);
        return "redirect:ruokasuosikit";
        // Ohjaa tallennuksen jälkeen bookstore pääsivu endpointtiin
    }    

    @RequestMapping(value = "/poista/{id}", method = RequestMethod.GET)
    public String poistaRuoka(@PathVariable("id") Long ruokaId, Model model) {
    	rrepository.deleteById(ruokaId);
    	//.. tarkoittaa että mennään polussa ylöspäin
        return "redirect:../ruokasuosikit";
    }
    
    @RequestMapping(value = "/muokkaa/{id}", method = RequestMethod.GET)
    public String muokkaaRuoka(@PathVariable("id") Long ruokaId, Model model) {
    	model.addAttribute("ruoka", rrepository.findById(ruokaId));
    	model.addAttribute("ravintolat", rarepository.findAll());
        return "muokkaa";
    }  
	
}
