package com.onpassive.otracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onpassive.otracker.entity.User;
import com.onpassive.otracker.repository.UserRepository;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/auth")
@Log4j
public class UserController {
	
static final String classNmae=UserController.class.getName();
	
//	@Autowired
//	JwtUtil jwtUtil;
	
	@Autowired
	UserRepository userRepo;
	
//	@Autowired
//	AuthenticationManager authenticationManager;
	
//	  @PostMapping("/signin")
//	  public String signIn(@RequestBody AuthRequest authRequest) throws Exception {
//		 String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
//		 log.info(classNmae+""+methodName+"started");
//		  try {
//		  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
//		  }
//		  catch (Exception e) {
//			  e.getMessage();
//			throw new Exception("invalid username/password");
//		}
//		  return jwtUtil.generateToken(authRequest.getEmail());
//	  
//	  }
//	  
	  
	  @PostMapping("/signup")
	  public ResponseEntity<User> signUp(@RequestBody User user) throws Exception {
		 String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 log.info(classNmae+""+methodName+"started");
		User u= userRepo.save(user);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);	  
	  }
	  
	  @PutMapping("/updateEmp")
	  public ResponseEntity<User> update(@RequestBody User user) throws Exception {
		 String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 log.info(classNmae+""+methodName+"started");
		User user1= userRepo.findById(user.getUserId()).get();
		user1.setEmail(user.getEmail());
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		User u= userRepo.save(user1);
		return new ResponseEntity<User>(u, HttpStatus.CREATED);	  
	  }
	  
	  
	  @GetMapping("/getAllEmp")
	  public ResponseEntity<List<User>> getAllEmployee() throws Exception {
		 String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 log.info(classNmae+""+methodName+"started");
		List<User> u= userRepo.findAll();
		return new ResponseEntity<List<User>>(u, HttpStatus.OK);	  
	  }
	  
	  @GetMapping("/findByEmpId/{id}")
	  public ResponseEntity<User> findByEmpId(@PathVariable Integer id) throws Exception {
		 String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 log.info(classNmae+""+methodName+"started");
		User u= userRepo.findById(id).get();
		return new ResponseEntity<User>(u, HttpStatus.OK);	  
	  }
	  
	  @DeleteMapping("/deleteByEmpId/{id}")
	  public ResponseEntity<String> deleteByEmpId(@PathVariable Integer id) throws Exception {
		 String methodName= Thread.currentThread().getStackTrace()[1].getMethodName();
		 log.info(classNmae+""+methodName+"started");
		 userRepo.deleteById(id);
		return new ResponseEntity<String>("deleted successfull",HttpStatus.OK)  ;
	  }
	  
	  
	 
	
}
