package com.gestao.gestortarefa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.gestortarefa.domain.Pessoa;
import com.gestao.gestortarefa.domain.dto.ListarTotalHoraPessoaDto;
import com.gestao.gestortarefa.services.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pessoa")
@AllArgsConstructor
public class PessoaController {

	private final PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa) {
		Pessoa createPessoa = pessoaService.create(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(createPessoa);

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.update(id, pessoa);
		return ResponseEntity.ok(newPessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	  
    @GetMapping("/pessoas")
    public ResponseEntity<List<ListarTotalHoraPessoaDto>> listarPessoasComTotalHoras(){
    	 List<ListarTotalHoraPessoaDto> pessoasDto = pessoaService.listarPessoasComTotalHoras();
    	    return ResponseEntity.ok(pessoasDto);
    }
}
