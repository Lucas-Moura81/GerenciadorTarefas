package com.gestao.gestortarefa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestortarefa.domain.Tarefa;
import com.gestao.gestortarefa.services.TarefaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tarefas")
@AllArgsConstructor
public class TarefaController { 
	
	private final TarefaService tarefaService;
	
	@PostMapping
	public ResponseEntity<Tarefa> create(@RequestBody Tarefa tarefa) {
		Tarefa createTarefa = tarefaService.create(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(createTarefa);
	}
}
