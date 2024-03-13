package com.example.VirtualPlantStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VirtualPlantStore.Entity.Admin;
import com.example.VirtualPlantStore.Repository.AdminRepo;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminRepo adminRepo;

	@PostMapping("/AddAdmin")
	public String addAdmin(@RequestBody Admin obj) {

		if (adminRepo.existsByEmail(obj.getEmail())) {
			return("Email id already registerd");
		} else if (adminRepo.existsByMobile(obj.getMobile())) {
			return ("Mobile number already registerd");
		} else {
			adminRepo.save(obj);
			return ("Admin Added successfully ");
		}
	}
}
