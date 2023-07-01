package com.gestao.gestortarefa.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_tarefa")
@Entity
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
