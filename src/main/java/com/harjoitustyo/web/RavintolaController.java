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

import com.harjoitustyo.domain.Ravintola;
import com.harjoitustyo.domain.RavintolaRepository;

@Controller
public class RavintolaController {
	@Autowired
	private RavintolaRepository rarepository;
	
	@RequestMapping(value = "/lisaaravintola")
    public String lisaaRuoka(Model model){
    	model.addAttribute("ravintola", new Ravintola());
        return "lisaaravintola";
    } 
	
	@RequestMapping(value = "/tallennaravintola", method = RequestMethod.POST)
    public String tallennaRuoka(Ravintola ravintola){
        rarepository.save(ravintola);
        return "redirect:ruokasuosikit";
        
    } 
	
	@RequestMapping(value = "/poistaravintola/{id}", method = RequestMethod.GET)
    public String poistaRavintola(@PathVariable("id") Long ravintolaId, Model model) {
    	rarepository.deleteById(ravintolaId);
    	//.. tarkoittaa että mennään polussa ylöspäin
        return "redirect:../ruokasuosikit";
    }
	
	@RequestMapping(value = "/muokkaaravintola/{id}", method = RequestMethod.GET)
    public String muokkaaRuoka(@PathVariable("id") Long ravintolaId, Model model) {
    	model.addAttribute("ravintola", rarepository.findById(ravintolaId));
        return "muokkaaravintola";
    } 
	
	// Kaikki RAVINTOLAT listattuna REST-rajapinnan avulla
    @RequestMapping(value="/ravintolat", method = RequestMethod.GET)
    public @ResponseBody List<Ravintola> ruoatListaREST() {	
        return (List<Ravintola>) rarepository.findAll();
    }
    // RAVINTOLA ID:n mukaan REST-rajapinnan avulla
    @RequestMapping(value="/ravintola/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Ravintola> findStudentRest(@PathVariable("id") Long id) {	
    	return rarepository.findById(id);
    }  
}
