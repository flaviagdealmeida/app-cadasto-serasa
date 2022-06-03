package br.com.app_cadastro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app_cadastro.domain.entity.Pessoa;

@Repository
public interface  PessoaRepository  extends JpaRepository<Pessoa, Long>{

//	@Query("SELECT p FROM Pessoa p WHERE p.nome LIKE LOWER(CONCAT ('%', :nome
//			'%'))")
//			Page<Pessoa> buscarPessoaPorNome(@Param("nome") String firstName, Pageable
//			pageable);
//			}

	Page<Pessoa> findByNome(String nome, Pageable pageable);

}
