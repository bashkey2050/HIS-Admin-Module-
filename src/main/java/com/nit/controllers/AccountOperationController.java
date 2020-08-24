package com.nit.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.UnlockAccount;

import com.nit.model.AccountRequest;
import com.nit.service.AccountService;


@Controller
public class AccountOperationController {
	@Autowired
	private AccountService accService;
	
/*	@PostMapping(value="/savet",
			consumes="application/json")
	@CrossOrigin(origins = "http://localhost:4200")
	
	public ResponseEntity<String> SaveAcc(@RequestBody AccountRequest req){
		
		ResponseEntity<String> resp = null;
		
		Integer acc_Id = accService.SaveAccount(req);
		
		String body="Your SSN Enrolment Completed Successfully Your SSN :: "+acc_Id;
		
		resp = new ResponseEntity<String>(body ,HttpStatus.CREATED);
		
		return resp;
		
	}*/
	
	@GetMapping("/loadForm")
	   public String loadForm(Model model){
		AccountRequest uac= new AccountRequest();
		model.addAttribute("userAcc", uac);
		
		/*Map<Integer, String> cmap = service.getAllCountries( );	
		model.addAttribute("countriesMap", cmap);*/
		return "contactInfo";
	}
	

	@PostMapping("/AccReg")
	public String handleSubmitBtn(@ModelAttribute("userAcc") AccountRequest acc,Model model) {
		boolean isSaved = accService.saveUserAcc(acc);
		return "userAccRegSucess";
		}
		
		/*@RequestMapping("/getStates")
		@ResponseBody
		public Map<Integer, String> getStatesByCountryId(@RequestParam("cid") Integer countryId) {
			return service.getStatesByCountryId(countryId);
		}

		@RequestMapping("/getCities")
		@ResponseBody
		public Map<Integer, String> getCitiesByStateId(@RequestParam("sid") Integer stateId) {
			return service.getCitiesByStateId(stateId);
		}
		*/
		
		
		@PostMapping("/unlockUserAcc")
		public String unlockUserAcc(@ModelAttribute("unlockAcc") UnlockAccount acc,Model model) {
			AccountRequest userAccnt = accService.getUserAccByTempPwd(acc.getTempPwd());
			
			if(userAccnt != null) {
				userAccnt.setAccStatus("Un-Locked");
				userAccnt.setUserPwd(acc.getNewPwd());
				boolean isupdated = accService.updateAccount(userAccnt);
				
				if (isupdated) {
				
				return "unlockAccSuccess";
			}
			}
			
				model.addAttribute("errMsg", "Please enter correct temporary password");
				return "unlockAccForm";
			}
		
		
		@GetMapping("/unlockAcc")
		public String displayUnlocAccForm(@RequestParam("email") String email,Model model) {
			
			UnlockAccount unlockAcc = new UnlockAccount();
			unlockAcc.setEmail(email);
			model.addAttribute("unlockAcc", unlockAcc);
			return "unlockAccForm";
		}

}
