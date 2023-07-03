package com.gestao.gestortarefa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatorioDepartamentoDto {
  
	private String nomeDepartamento; 
    private Integer qtdPessoa;
    private Integer qtdTarefas; 
    
}
