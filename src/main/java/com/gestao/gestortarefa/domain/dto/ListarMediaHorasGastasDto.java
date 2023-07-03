package com.gestao.gestortarefa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ListarMediaHorasGastasDto {
	private String nome;
	private Double mediaHorasGastas;

}
