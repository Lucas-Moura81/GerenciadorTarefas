package com.gestao.gestortarefa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestortarefa.domain.dto.RelatorioDepartamentoDto;
import com.gestao.gestortarefa.services.DepartamentoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/departamento")
@AllArgsConstructor
public class DepartamentoController {
 private final DepartamentoService departamentoService;
 
         @GetMapping
          public ResponseEntity<List<RelatorioDepartamentoDto>> listarDepartamentoQtdPessoaEtarefas(){
        	 List<RelatorioDepartamentoDto> departamento = departamentoService.listarDepartamentoQtdPessoaEtarefas();
        	 return ResponseEntity.ok(departamento); 
         }
 
}
