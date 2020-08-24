package com.nit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.model.AccountRequest;
import com.nit.service.AccountService;


@Controller
public class ViewAccountController {
	
	@Autowired
	private AccountService accService;
	
	
	@GetMapping("/viewContact")
	public String handleViewAccount(Model model,AccountRequest c) {
		
		List<AccountRequest> cont= accService.getAllAccountDetails();
		
		model.addAttribute("msg",cont);
		
	    return "viewContacts";
	
	}
	
	
	@RequestMapping(value="/editContact")
	public String editAccount(@RequestParam("aid") Integer acc_Id,Model model) {
		AccountRequest c= accService.getAccountByAcc_Id(acc_Id );
		model.addAttribute("contact", c);
		
		return "contactInfo";
		
	}
	
	
	@RequestMapping(value="/deleteContact")
	public String deleteAccount(@RequestParam("aid") Integer acc_Id ) {
		
		boolean isDeleted=accService.deleteContactById(acc_Id );
		if (isDeleted) {
			return "redirect:/viewContact";
		}
		return null;

}
}
