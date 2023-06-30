package com.gestao.gestortarefa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.repositories.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	@Autowired
	private PessoaRepository pessoaRepository; 
	
    @PostMapping
    public Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
    	return pessoaRepository.save(pessoa);
    }
	

}
