package com.example.brinquedos.controller;
 
import com.example.brinquedos.model.Brinquedo;
import com.example.brinquedos.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brinquedos")

public class BrinquedoController {
	 
	@Autowired
	    private BrinquedoService service;

	    @GetMapping
	    public String getAllBrinquedos(Model model) {
	        model.addAttribute("brinquedos", service.getAllBrinquedos());
	        return "brinquedos";
	    }

	    @GetMapping("/{id}")
	    public String getBrinquedoById(@PathVariable Long id, Model model) {
	        model.addAttribute("brinquedo", service.getBrinquedoById(id));
	        return "brinquedo";
	    }

	    @GetMapping("/new")
	    public String createBrinquedoForm(Model model) {
	        model.addAttribute("brinquedo", new Brinquedo());
	        return "create_brinquedo";
	    }

	    @PostMapping
	    public String saveBrinquedo(@ModelAttribute Brinquedo brinquedo) {
	        service.saveBrinquedo(brinquedo);
	        return "redirect:/brinquedos";
	    }

	    @GetMapping("/edit/{id}")
	    public String editBrinquedoForm(@PathVariable Long id, Model model) {
	        model.addAttribute("brinquedo", service.getBrinquedoById(id));
	        return "edit_brinquedo";
	    }

	    @PostMapping("/{id}")
	    public String updateBrinquedo(@PathVariable Long id, @ModelAttribute Brinquedo brinquedo) {
	        brinquedo.setId(id);
	        service.updateBrinquedo(brinquedo);
	        return "redirect:/brinquedos";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteBrinquedo(@PathVariable Long id) {
	        service.deleteBrinquedo(id);
	        return "redirect:/brinquedos";
	    }
}
