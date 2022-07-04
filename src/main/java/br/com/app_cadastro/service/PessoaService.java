package br.com.app_cadastro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public Page<PessoaVO> buscarTodos(Pageable pageable) {
		var page = repository.findAll(pageable);
		return page.map(this::convertToPessoaVO);
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
	
	public Page<PessoaVO> findByName(String nome, Pageable pageable){
		var page = repository.findByNome(nome, pageable);
		return page.map(this::convertToPessoaVO);		
	}
		

	private PessoaVO convertToPessoaVO(Pessoa entity) {
		return DozerConverter.parseObject(entity, PessoaVO.class);
	}

}
