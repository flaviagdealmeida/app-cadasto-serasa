package br.com.app_cadastro.domain.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaVO extends RepresentationModel<PessoaVO> implements Serializable{
	
	private static final long serialVersionUID = 1L;
			
	@Mapping("id")
	private Long key;
	private String nome;
	private String sobrenome;
	private String nomeSocial;
	private String email;
	
		
	
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
