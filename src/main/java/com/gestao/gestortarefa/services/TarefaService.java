package com.gestao.gestortarefa.services;

import org.springframework.stereotype.Service;

import com.gestao.gestortarefa.domain.Tarefa;
import com.gestao.gestortarefa.repositories.TarefaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TarefaService {
	private final TarefaRepository repository;
	
	public Tarefa create(Tarefa tarefa) {
		tarefa.setId(null);
		return repository.save(tarefa);
	} 
}
