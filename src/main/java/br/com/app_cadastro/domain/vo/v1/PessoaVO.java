package br.com.app_cadastro.domain.vo.v1;

import java.io.Serializable;

import lombok.Data;

@Data
public class PessoaVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private Long id;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private String email;
}
