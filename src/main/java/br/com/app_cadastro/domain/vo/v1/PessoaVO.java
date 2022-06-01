package br.com.app_cadastro.domain.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;


public class PessoaVO extends RepresentationModel<PessoaVO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
			
	@Mapping("id")
	private Long key;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private String email;
			
	
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
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
		return Objects.hash(email, key, nome, nomeSocial, sobrenome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaVO other = (PessoaVO) obj;
		return Objects.equals(email, other.email) && Objects.equals(key, other.key) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeSocial, other.nomeSocial) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	
	
	
	
	
}
