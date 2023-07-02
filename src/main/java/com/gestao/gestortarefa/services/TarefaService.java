package com.gestao.gestortarefa.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.domain.Tarefa;
import com.gestao.gestortarefa.repositories.PessoaRepository;
import com.gestao.gestortarefa.repositories.TarefaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TarefaService {
	private final TarefaRepository repository;
	private final PessoaRepository pessoaRepository; 
	
	public Tarefa create(Tarefa tarefa) {
		tarefa.setId(null);
		return repository.save(tarefa);
	}
	   public Tarefa alocarPessoa(Long id, Long pessoaId) {
	        Tarefa tarefa = repository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

	        Pessoa pessoa = pessoaRepository.findById(pessoaId)
	                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

	        if (!tarefa.getDepartamento().equals(pessoa.getDepartamento())) {
	            throw new IllegalArgumentException("A pessoa não pertence ao mesmo departamento da tarefa");
	        }

	        tarefa.setPessoaAlocada(pessoa);
	        return repository.save(tarefa);
	    }
	    public Tarefa finalizarTarefa(Long id) {
	        Tarefa tarefa = repository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

	        tarefa.setFinalizada(true);
	        return repository.save(tarefa);
	}
	    
	  
}
