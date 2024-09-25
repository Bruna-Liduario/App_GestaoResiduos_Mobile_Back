package com.gestaoresiduos.residuos.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		User savedUser = userService.signUp(user);
		if (savedUser != null) {
			return ResponseEntity.ok(savedUser);
		}
		return ResponseEntity.badRequest().build(); // Se erro ao salvar
	}

	@PostMapping("/signin")
	public ResponseEntity<UserDto> signIn(@RequestBody User user) {
	    UserDto existingUser = userService.signIn(user.getEmail(), user.getPassword());
	    if (existingUser != null) {
	        return ResponseEntity.ok(existingUser);
	    }
	    return ResponseEntity.badRequest().build(); // Se email ou senha forem inválidos
	}

}
