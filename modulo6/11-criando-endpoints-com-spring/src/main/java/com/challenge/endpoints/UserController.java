package com.challenge.endpoints;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		return service.findById(id)
				.orElseThrow(RuntimeException::new);
	}
	
	@GetMapping(params = "accelerationName")
	public List<User> findByAccelerationName(@RequestParam String accelerationName) {
		return service.findByAccelerationName(accelerationName);
	}
	
	@GetMapping(params = "companyId")
	public List<User> findByCompanyId(@RequestParam Long companyId) {
		return service.findByCompanyId(companyId);
	}

}
