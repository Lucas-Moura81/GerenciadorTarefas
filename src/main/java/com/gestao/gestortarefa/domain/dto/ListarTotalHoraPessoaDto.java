package com.gestao.gestortarefa.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListarTotalHoraPessoaDto {
	private String nome;
	private String departamento;
	private Double totalHorasGastas;
}
