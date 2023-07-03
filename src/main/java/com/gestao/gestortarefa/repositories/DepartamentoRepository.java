package com.gestao.gestortarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestao.gestortarefa.domain.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
  
 
}
