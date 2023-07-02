package com.gestao.gestortarefa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PutMapping("/alocar/{id}")
	public ResponseEntity<Tarefa> alocarPessoa(@PathVariable Long id, @RequestParam Long pessoaId){
		Tarefa tarefa = tarefaService.alocarPessoa(id, pessoaId);
		return ResponseEntity.ok(tarefa);
	}
	
    @PutMapping("/finalizar/{id}")
    public ResponseEntity<Tarefa> finalizarTarefa(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.finalizarTarefa(id);
        return ResponseEntity.ok(tarefa);
    }
    
}
