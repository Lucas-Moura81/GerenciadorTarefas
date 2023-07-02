package com.gestao.gestortarefa.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Table(name = "tb_tarefa")
@Entity
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	@NotNull
	private String titulo;
	
	@Column(name = "descricao")
	@NotNull
	private String descricao;
	
	@NotNull
	@Column(name = "prazo")
	private LocalDate prazo;
	
	
	@NotNull
	@Column(name = "duracao")
	private Double duracao;
	
	@NotNull
	@Column(name = "finalizada")
	private Boolean finalizada;
	
	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "id")
	private Pessoa pessoaAlocada;
	
	@JoinColumn(name = "idDepartamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento departamento;

}
