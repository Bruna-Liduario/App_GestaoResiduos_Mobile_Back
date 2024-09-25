package com.gestaoresiduos.residuos.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "agendamentos")
@Data
public class Agendamentos {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "data_coleta", nullable = false)
	    @Temporal(TemporalType.DATE)
	    private LocalDate dataColeta;

	    @Column(name = "material", nullable = false)
	    private String material;
	      

}
