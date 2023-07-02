package com.gestao.gestortarefa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.domain.dto.ListarTotalHoraPessoaDto;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value =  "select "
			+ "	p.nome, "
			+ "	td.titulo, "
			+ "	sum(tt.duracao) as total_horas "
			+ " from "
			+ "	public.tb_pessoa p, "
			+ "	public.tb_tarefa tt, "
			+ "	public.tb_departamento td "
			+ " where "
			+ "	p.id = tt.id_pessoa "
			+ " and td.id = p.id_departamento "
			+ " group by p.nome, td.titulo ", nativeQuery = true )
	List<ListarTotalHoraPessoaDto> listarTotalHoraPessoas();
}
