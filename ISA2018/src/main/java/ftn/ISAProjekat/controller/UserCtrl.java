package ftn.ISAProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.ISAProjekat.model.User;
import ftn.ISAProjekat.repository.services.UserService;

@RestController
public class UserCtrl {

	@Autowired 
	private UserService userService;
	
	@RequestMapping(
			value = "/users/login",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody User user){
		String email = user.getEmail();
		String password = user.getPassword();
		if(userService.getUser(email,password)!=null) {
			return new ResponseEntity<User>(userService.getUser(email,password),HttpStatus.OK);
		}else {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(
			value = "/users/registration",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registration(@RequestBody User user) throws Exception {
		User savedUser = userService.create(user);		
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
}