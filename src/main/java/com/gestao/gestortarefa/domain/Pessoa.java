package com.gestao.gestortarefa.domain;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L; 
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
    
	private String nome; 
	
	private String departamento; 

}
