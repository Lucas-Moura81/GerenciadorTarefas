package com.gestao.gestortarefa.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Tarefa implements Serializable {

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String titulo; 
	
	private String descricao; 
	
	private LocalDate prazo; 
	
	private String departamento; 
	
	private Integer duracao; 
	
	private Boolean finalizada; 
	
	private Pessoa pessoaAlocada; 
	
	
}
