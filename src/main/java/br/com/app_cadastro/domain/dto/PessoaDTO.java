package br.com.app_cadastro.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.app_cadastro.domain.entity.Pessoa;
import lombok.Data;

@Data
public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private String email;
	
	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.nomeSocial = pessoa.getNomeSocial();
		this.email = pessoa.getEmail();
	}
	
	public static List<PessoaDTO> converterLista(List<Pessoa> pessoas){
		return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
	}
	

	
	
}
