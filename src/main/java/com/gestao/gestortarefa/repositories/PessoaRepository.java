package com.gestao.gestortarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.gestortarefa.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
