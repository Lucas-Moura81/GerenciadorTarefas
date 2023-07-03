package com.gestao.gestortarefa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestao.gestortarefa.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(value = "SELECT COUNT(*) FROM public.tb_pessoa tp WHERE tp.id_departamento = ?1 ", nativeQuery = true)
	Integer listarQtdPessoasDepartamento(Long idDepartamento);

	@Query(value = "SELECT * FROM public.tb_pessoa tp WHERE tp.id_departamento = ?1 ", nativeQuery = true)
	List<Pessoa> listarPessoasDepartamento(Long idDepartamento);

}
