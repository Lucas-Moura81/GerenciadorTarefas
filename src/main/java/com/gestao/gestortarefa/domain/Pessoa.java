package com.gestao.gestortarefa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L; 
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
    @Column(name = "nome")
    @NotNull
    @Size(min = 3, max = 150)
	private String nome; 
    
    @JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento departamento;
    
   
    
    
}
