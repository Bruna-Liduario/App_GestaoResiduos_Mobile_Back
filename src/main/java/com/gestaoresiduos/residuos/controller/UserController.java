package com.gestaoresiduos.residuos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoresiduos.residuos.dto.UserDto;
import com.gestaoresiduos.residuos.entity.User;
import com.gestaoresiduos.residuos.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
    private UserService userService;


	@PostMapping("/signup")
	public ResponseEntity<User> signUp(@RequestBody User user) {
	    try {
	        User savedUser = userService.signUp(user);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody UserDto loginDto) {
	    User user = userService.signIn(loginDto.getEmail(), loginDto.getPassword());
	    if (user == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body("{\"error\": \"Usuário inexistente ou senha inválida\"}");
	    }
	    // Evitar retornar a senha
	    user.setPassword(null);
	    return ResponseEntity.ok(user);
	}

}
