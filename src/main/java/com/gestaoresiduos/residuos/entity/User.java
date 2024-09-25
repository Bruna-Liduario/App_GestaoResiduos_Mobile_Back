package com.gestaoresiduos.residuos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "nome")
    private String nome;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "password")
    private String password;
	
	@Column(name = "address")
    private String address;

}
