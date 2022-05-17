package br.com.app_cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app_cadastro.domain.Pessoa;
import br.com.app_cadastro.exception.ResourceNotFoundException;
import br.com.app_cadastro.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	
	public Pessoa inserir(Pessoa pessoa) {
		return repository.save(pessoa);
	}
	
	public List<Pessoa> buscarTodos(){
		return repository.findAll();
	}
	
	public Pessoa buscarPorId(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		
		return	entity;
		
	}
	
	public void delete(Long id) {
		Pessoa entity = repository.findById(id)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		repository.delete(entity);
	}
	
	public Pessoa atualizar(Pessoa pessoa) {
		Pessoa entity = buscarPorId(pessoa.getId());
		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setNomeSocial(pessoa.getNomeSocial());
		entity.setEmail(pessoa.getEmail());
	
		return inserir(entity);
		
	}
	
	public List<Pessoa> buscarPorNome(String nome){
		return repository.findByNome(nome);
	}
	
	
	
}
