package com.gestao.gestortarefa.domain.dto;

import lombok.Data;

@Data
public class ListarTotalHoraPessoaDto {
	private String nome;
	private String departamento;
	private Integer totalHorasGastas;
}
