package com.gestao.gestortarefa.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.services.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

	private final PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
		Pessoa createPessoa = pessoaService.create(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(createPessoa);

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> upDate(@PathVariable Long id, @RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.upDate(id, pessoa);
		return ResponseEntity.ok(newPessoa);
	}
	
	  @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        pessoaService.delete(id);
	        return ResponseEntity.noContent().build();
	    }

}
