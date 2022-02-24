package com.codingdojo.dojosyninjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.dojosyninjas.entity.Dojo;
import com.codingdojo.dojosyninjas.service.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	/* JSP */
	
	@RequestMapping()
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "dojos/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Dojo result = dojoService.findDojo(id);
		model.addAttribute("dojo", result);
		return "dojos/show";
	}
	
	/* HTTP */
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			model.addAttribute("dojos", dojos);
			return "dojos/index";
		}
		
		dojoService.createDojo(dojo);
		return "redirect:/dojos";
	}
}
