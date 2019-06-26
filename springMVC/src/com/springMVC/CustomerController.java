package com.springMVC;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	// add an initbinder to convert trim inpuit strings
	
	//remove leading and trailing whitespace
	
	//resolve issue for our validation
	@InitBinder 
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditer=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditer);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer")
	Customer customer, BindingResult bindingResult) {
		System.out.println("Binding result:"+ bindingResult);
		System.out.println("\n\n\n\n");
		System.out.println("lastName:|"+customer.getLastName()+"|");
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		return "customer-confirmation";
	}
}
