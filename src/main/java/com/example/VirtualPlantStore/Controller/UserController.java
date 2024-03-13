package com.example.VirtualPlantStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.VirtualPlantStore.Entity.User;
import com.example.VirtualPlantStore.Repository.UserRepo;

@RestController
@CrossOrigin("*")

public class UserController {
	@Autowired
	private UserRepo userRepo;

	@PostMapping("/AddUser")
	public String addUser(@RequestBody User obj) {
		if (userRepo.existsByEmail(obj.getEmail())) {
			return("Email id already registerd");
		} else if (userRepo.existsByMobile(obj.getMobile())) {
			return("Mobile number already registerd");
		} else {
			userRepo.save(obj);
			return("User Added successfully ");
		}
	}
	
	@GetMapping("/GetUsers")
	public ResponseEntity<?> getUser (){
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}
	
	@PutMapping("/UpdateStatus/{id}")
	public String updateStatus(@PathVariable("id") Integer Id, @RequestBody User obj) {
		User user = userRepo.findById(Id).orElseThrow(() -> new RuntimeException("User Not Found"));
		user.setStatus(obj.getStatus());
		userRepo.save(user);
		return("Status Updated Successfully");	
	}
}
