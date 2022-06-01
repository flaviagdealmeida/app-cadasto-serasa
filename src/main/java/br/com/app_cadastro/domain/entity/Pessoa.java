package br.com.app_cadastro.domain.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_pessoas")

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private Long id;
	
	@NotBlank
	@Size(max=20)
	@Column(name="nome_pessoa")
	private String nome;
		
	@NotBlank
	@Size(max=40)
	@Column(name="sobrenome_pessoa")
	private String sobrenome;
		
	@NotBlank
	@Size(max=35)	
	@Column(name="nomesocial_pessoa")
	private String nomeSocial;
	
	@NotBlank
	@Size(max=80)
	@Email
	@Column(name="email_pessoa")
	private String email;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(Long id, @NotBlank @Size(max = 20) String nome, @NotBlank @Size(max = 40) String sobrenome,
			@NotBlank @Size(max = 35) String nomeSocial, @NotBlank @Size(max = 80) @Email String email) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeSocial = nomeSocial;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, nomeSocial, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeSocial, other.nomeSocial) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	
	
	
	
	
	

}
