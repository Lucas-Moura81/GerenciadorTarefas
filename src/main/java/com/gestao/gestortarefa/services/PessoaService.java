package com.gestao.gestortarefa.services;

import org.springframework.stereotype.Service;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.repositories.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

	private final PessoaRepository repository;

	public Pessoa create(Pessoa pessoa) {
		pessoa.setId(null);
		return repository.save(pessoa);
	}

	public Pessoa upDate(Long id, Pessoa pessoa) {
		Pessoa existingPessoa = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pessoa not found with id: " + id));
		existingPessoa.setNome(pessoa.getNome());
		existingPessoa.setDepartamento(pessoa.getDepartamento());
		return repository.save(existingPessoa);
	}

	public void delete(Long id) {
		   Pessoa pessoa = repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Pessoa not found with id: " + id));
	        repository.delete(pessoa);		
	}

}
