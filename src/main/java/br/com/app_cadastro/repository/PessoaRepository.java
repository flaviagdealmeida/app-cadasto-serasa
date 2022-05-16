package br.com.app_cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app_cadastro.domain.Pessoa;

@Repository
public interface  PessoaRepository  extends JpaRepository<Pessoa, Long>{

}
