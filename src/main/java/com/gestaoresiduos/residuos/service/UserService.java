package com.gestaoresiduos.residuos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestaoresiduos.residuos.entity.User;
import com.gestaoresiduos.residuos.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	    @Autowired
	    private UserRepository userRepository;

	    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	    public User signUp(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }

	    public User signIn(String email, String password) {
	        User user = userRepository.findByEmail(email);
	        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
	            return user;
	        }
	        return null; // Se email ou senha forem inválidos
	    }
}
