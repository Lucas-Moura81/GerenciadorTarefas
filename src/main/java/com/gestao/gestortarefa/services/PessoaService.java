package com.gestao.gestortarefa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.domain.Tarefa;
import com.gestao.gestortarefa.domain.dto.ListarMediaHorasGastasDto;
import com.gestao.gestortarefa.domain.dto.ListarTotalHoraPessoaDto;
import com.gestao.gestortarefa.repositories.PessoaRepository;
import com.gestao.gestortarefa.repositories.TarefaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

	private final PessoaRepository repository;
	private final TarefaRepository tarefaRepository;

	public Pessoa create(Pessoa pessoa) {

		return repository.save(pessoa);
	}

	public Pessoa update(Long id, Pessoa pessoa) {
		Pessoa existingPessoa = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pessoa com esse id não foi encontrado:" + id));
		existingPessoa.setNome(pessoa.getNome());
		existingPessoa.setDepartamento(pessoa.getDepartamento());
		return repository.save(existingPessoa);
	}

	public String delete(Long id) {
		Pessoa pessoa = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Pessoa com esse id não foi encontrado: " + id));
		List<Tarefa> tarefas = tarefaRepository.listarTarefasPessoa(pessoa.getId());
		tarefas.forEach(tarefa -> {
			tarefa.setPessoaAlocada(null);
			tarefaRepository.save(tarefa);
		});

		repository.delete(pessoa);
		return "Pessoa excluida com sucesso !" + id;
	}

	public List<ListarTotalHoraPessoaDto> listarPessoasComTotalHoras() {
		List<ListarTotalHoraPessoaDto> listar = new ArrayList<>();
		List<Pessoa> pessoas = repository.findAll();
		pessoas.forEach(pessoa -> {
			ListarTotalHoraPessoaDto dto = ListarTotalHoraPessoaDto.builder()
					.nome(pessoa.getNome())
					.totalHorasGastas(tarefaRepository.calcularTotalTarefa(pessoa.getId()))
					.departamento(pessoa.getDepartamento().getTitulo())
					.build();
			listar.add(dto);
		});

		return listar;
	}

	public List<ListarMediaHorasGastasDto> listarMediaHorasGastas() {
		List<ListarMediaHorasGastasDto> listar = new ArrayList<>();
		List<Pessoa> pessoas = repository.findAll();
		pessoas.forEach( pessoa -> {
			ListarMediaHorasGastasDto dto = ListarMediaHorasGastasDto.builder()
					.nome(pessoa.getNome())
					.mediaHorasGastas(tarefaRepository.calcularMediaTarefa(pessoa.getId()))
					.build();
			listar.add(dto);
		});
		return listar;
	}

}
