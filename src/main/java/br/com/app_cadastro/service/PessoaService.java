package br.com.app_cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app_cadastro.adapter.DozerConverter;
import br.com.app_cadastro.domain.entity.Pessoa;
import br.com.app_cadastro.domain.vo.v1.PessoaVO;
import br.com.app_cadastro.exception.ResourceNotFoundException;
import br.com.app_cadastro.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;

	public PessoaVO inserir(PessoaVO pessoa) {
		var entity = DozerConverter.parseObject(pessoa, Pessoa.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
		return vo;
	}

	public List<PessoaVO> buscarTodos() {
		return DozerConverter.parseListObject(repository.findAll(), PessoaVO.class);
	}

	public PessoaVO buscarPorId(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		return DozerConverter.parseObject(entity, PessoaVO.class);

	}

	public PessoaVO atualizar(PessoaVO pessoa) {
		var entity = repository.findById(pessoa.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));

		entity.setNome(pessoa.getNome());
		entity.setSobrenome(pessoa.getSobrenome());
		entity.setNomeSocial(pessoa.getNomeSocial());
		entity.setEmail(pessoa.getEmail());

		var vo = DozerConverter.parseObject(repository.save(entity), PessoaVO.class);
		return vo;
	}

	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));
		repository.delete(entity);
	}

	public List<Pessoa> buscarPorNome(String nome) {
		return repository.findByNome(nome);
	}

}
