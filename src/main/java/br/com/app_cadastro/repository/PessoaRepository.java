package br.com.app_cadastro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app_cadastro.domain.entity.Pessoa;

@Repository
public interface  PessoaRepository  extends JpaRepository<Pessoa, Long>{

//faz a paginação dos dados retornados que satisfaçam a busca
	Page<Pessoa> findByNome(String nome, Pageable pageable);

}
