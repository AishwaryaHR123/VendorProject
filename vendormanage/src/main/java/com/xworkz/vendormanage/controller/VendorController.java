package com.xworkz.vendormanage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xworkz.vendormanage.dto.VendorDTO;
import com.xworkz.vendormanage.service.VendorService;

@Controller
@RequestMapping("/")
public class VendorController {
	@Autowired
	private VendorService service;
	public VendorController() {
		System.out.println("Created VendorController...");
	}
	
	@PostMapping("/laptop")
	public String saveVendorDetails(Model model,@Valid VendorDTO dto, BindingResult result)
	{
		System.out.println("Details of the Generator: " + dto);
		System.out.println("Generator DTO has errors: " + result.hasErrors());

		model.addAttribute("dto", dto);

		if (result.hasErrors()) {
			List<ObjectError> objectErrors = result.getAllErrors();
			objectErrors.forEach(a -> System.err.println(a.getObjectName() + " " + a.getDefaultMessage()));
			model.addAttribute("error", objectErrors);
			return "Registration.jsp";
		} else {
			model.addAttribute("noErrors", "Details saved.");
			String uniqueError = service.isExistByGstOrMailOrSiteOrNo(dto.getGstNo(),dto.getContactNo(),dto.getEmail(),dto.getWebsite());
			if (uniqueError != null) {
				model.addAttribute("uniqueError", uniqueError);
				return "Registration.jsp";
			}
			this.service.save(dto);
			this.service.sendEmail(dto.getEmail());
			return "RegistrationSuccess.jsp";
		}

	}
		
	}
	
