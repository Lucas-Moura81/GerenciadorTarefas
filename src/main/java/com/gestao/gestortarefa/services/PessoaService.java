package com.gestao.gestortarefa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.domain.dto.ListarTotalHoraPessoaDto;
import com.gestao.gestortarefa.repositories.PessoaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

	private final PessoaRepository repository;
	
	
	 

	public Pessoa create(Pessoa pessoa) {
		
		
		return repository.save(pessoa);
	}
	
	public Pessoa update(Long id, Pessoa pessoa) {
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

	public List<Pessoa> listarPessoas() {
		List<Pessoa> pessoas = repository.findAll();
		return pessoas;
	}
	
	public List<Pessoa> listarPessoasPorNome() {
		List<Pessoa> pessoas = repository.findAll();
		return pessoas;
	}

	public List<ListarTotalHoraPessoaDto> listarPessoasComTotalHoras() {
		List<ListarTotalHoraPessoaDto> listar  = repository.listarTotalHoraPessoas();
		return listar;
	}

}
