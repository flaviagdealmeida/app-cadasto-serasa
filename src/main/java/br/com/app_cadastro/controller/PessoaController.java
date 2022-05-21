package br.com.app_cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app_cadastro.domain.vo.v1.PessoaVO;
import br.com.app_cadastro.service.PessoaService;

@RestController
@RequestMapping("/pessoa/v1")
public class PessoaController {
	
	@Autowired
	PessoaService service;

	@RequestMapping(method=RequestMethod.GET,
			produces={"application/json","application/xml"})
	@ResponseStatus(value=HttpStatus.OK)
	public List<PessoaVO>findAll(){
		return service.buscarTodos();
	}
	
	@GetMapping(value="/{id}",
			produces={"application/json","application/xml"})
	@ResponseStatus(value=HttpStatus.OK)
	public PessoaVO findById(@PathVariable("id") Long id) {
		return service.buscarPorId(id);
	}

	@PostMapping(consumes = {"application/json","application/xml"},
			produces={"application/json","application/xml"})
	@ResponseStatus(value=HttpStatus.CREATED)
	public PessoaVO create(@Valid @RequestBody PessoaVO pessoa) {
		return service.inserir(pessoa);
	}
	
	@PutMapping(consumes = {"application/json","application/xml"},
			produces={"application/json","application/xml"})
	@ResponseStatus(value=HttpStatus.OK)
	public PessoaVO update(@Valid @RequestBody PessoaVO pessoa) {
		return service.atualizar(pessoa);
	}
		
	@DeleteMapping(value="/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
