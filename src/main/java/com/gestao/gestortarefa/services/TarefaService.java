package com.gestao.gestortarefa.services;

import java.util.List;
import java.util.Random;

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
		return repository.save(tarefa);
	}

	public Tarefa alocarPessoa(Long id) {
		Tarefa tarefa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

		List<Pessoa> pessoas = pessoaRepository.listarPessoasDepartamento(tarefa.getDepartamento().getId());
		Random rand = new Random();
		Pessoa pessoa = pessoas.get(rand.nextInt(pessoas.size()));
		tarefa.setPessoaAlocada(pessoa);
		return repository.save(tarefa);
	}

	public Tarefa finalizarTarefa(Long id) {
		Tarefa tarefa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada"));

		tarefa.setFinalizada(true);
		return repository.save(tarefa);
	}

	public List<Tarefa> listar3TarefasSemPessoasAlocadas() {
		return repository.listar3TarefasSemPessoasAlocadas();
	}

}
