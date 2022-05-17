package br.com.app_cadastro.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_pessoas")
@Data // padrão java bean 
@NoArgsConstructor
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private Long id;
	
	@Column(name="nome_pessoa")
	private String nome;
	
	@Column(name="sobrenome_pessoa")
	private String sobrenome;
	
	@Column(name="nomesocial_pessoa")
	private String nomeSocial;
	
	@Column(name="email_pessoa")
	private String email;
	
	
	
	
	

}
