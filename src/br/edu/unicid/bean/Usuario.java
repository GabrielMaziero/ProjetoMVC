package br.edu.unicid.bean;

public class Usuario {

	// atributos
	private String user;
	private String password;

	// construtor vazio
	public Usuario() {

	}

	// contrutor com campos
	public Usuario(String user, String password) {
		this.user = user;
		this.password = password;

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}