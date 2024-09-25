package com.gestaoresiduos.residuos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestaoresiduos.residuos.dto.UserDto;
import com.gestaoresiduos.residuos.entity.User;
import com.gestaoresiduos.residuos.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	    @Autowired
	    private UserRepository userRepository;

	    public User signUp(User user) {
	        return userRepository.save(user);
	    }

	    public UserDto signIn(String email, String password) {
	        User user = userRepository.findByEmail(email);
	        if (user != null && user.getPassword().equals(password)) {
	            UserDto userDto = new UserDto();
	            userDto.setEmail(user.getEmail());
	            return userDto;
	        }
	        return null; // Se email ou senha forem inválidos
	    }
	    
}
