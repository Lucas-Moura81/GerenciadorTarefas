package com.gestao.gestortarefa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao.gestortarefa.domain.Departamento;
import com.gestao.gestortarefa.domain.dto.RelatorioDepartamentoDto;
import com.gestao.gestortarefa.repositories.DepartamentoRepository;
import com.gestao.gestortarefa.repositories.PessoaRepository;
import com.gestao.gestortarefa.repositories.TarefaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DepartamentoService {
	private final DepartamentoRepository repository;
	private final PessoaRepository pessoaRepository;
	private final TarefaRepository tarefaRepository;

	public List<RelatorioDepartamentoDto> listarDepartamentoQtdPessoaEtarefas() {
		List<Departamento> departamentos = repository.findAll();
		List<RelatorioDepartamentoDto> dto = new ArrayList<>();
		departamentos.forEach(departamento -> {
			RelatorioDepartamentoDto departamentoDto = RelatorioDepartamentoDto.builder()
					.nomeDepartamento(departamento.getTitulo())
					.qtdTarefas(tarefaRepository.listarQtdTarefa(departamento.getId()))
					.qtdPessoa(pessoaRepository.listarQtdPessoasDepartamento(departamento.getId()))
					.build();
			dto.add(departamentoDto);
		});
		return dto;
	}
}
