package br.com.app_cadastro.security;

import java.io.Serializable;

import lombok.Data;

@Data
public class CredenciaisContaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	
	
	
}
