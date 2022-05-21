package br.com.app_cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app_cadastro.domain.entity.Pessoa;

@Repository
public interface  PessoaRepository  extends JpaRepository<Pessoa, Long>{

	List<Pessoa> findByNome(String nome);

}
