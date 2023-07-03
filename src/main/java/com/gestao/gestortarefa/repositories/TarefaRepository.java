package com.gestao.gestortarefa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestao.gestortarefa.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    @Query(value = " select "
    		+ " tt.* "
    		+ " FROM "
    		+ " public.tb_tarefa tt "
    		+ " WHERE "
    		+ " tt.finalizada IS false "
    		+ " and tt.id_pessoa is null "
    		+ " AND tt.prazo <= current_date "
    		+ " ORDER BY prazo "
    		+ " LIMIT 3", nativeQuery = true)
   List<Tarefa> listar3TarefasSemPessoasAlocadas();
    
    @Query(value = "SELECT COUNT(*) FROM public.tb_tarefa tp WHERE tp.id_departamento = ?1 ", nativeQuery = true)
    Integer listarQtdTarefa(Long idDepartamento); 
    
    @Query(value = "select avg(tt.duracao) from public.tb_tarefa tt where tt.id_pessoa = ?1 ", nativeQuery = true)
    Double calcularMediaTarefa(Long idPessoa); 
    
    @Query(value = "select sum(tt.duracao) from public.tb_tarefa tt where tt.id_pessoa = ?1 ", nativeQuery = true)
    Double calcularTotalTarefa(Long idPessoa);
    
    @Query(value = "select * from public.tb_tarefa tt where tt.id_pessoa = ?1 ", nativeQuery = true)
    List<Tarefa> listarTarefasPessoa(Long idPessoa);
}


    
