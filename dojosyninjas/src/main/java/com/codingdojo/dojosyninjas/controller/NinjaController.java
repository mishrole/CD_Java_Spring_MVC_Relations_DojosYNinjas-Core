package com.codingdojo.dojosyninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosyninjas.entity.Dojo;
import com.codingdojo.dojosyninjas.entity.Ninja;
import com.codingdojo.dojosyninjas.service.DojoService;
import com.codingdojo.dojosyninjas.service.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	/* JSP */
	
	@RequestMapping()
	public String index(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos_list", dojos);
		return "ninjas/new";
	}
	
	/* HTTP */
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos_list", dojos);
			return "ninjas/new";
		}
		
		ninjaService.createNinja(ninja);
		return "redirect:/dojos";
	}
}
