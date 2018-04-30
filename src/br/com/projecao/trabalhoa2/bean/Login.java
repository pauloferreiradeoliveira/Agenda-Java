package br.com.projecao.trabalhoa2.bean;




public class Login {
	
	private int id;
	private String login;
	private String senha;
	private int usuario;
	private int perfil;
	private String MostarUsuario;
	private String MostarPerfil;
	private String Data;	
	   
	
	public String getMostarUsuario() {
		return MostarUsuario;
	}

	public void setMostarUsuario(String mostarUsuario) {
		MostarUsuario = mostarUsuario;
	}

	public String getMostarPerfil() {
		return MostarPerfil;
	}

	public void setMostarPerfil(String mostarPerfil) {
		MostarPerfil = mostarPerfil;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	


}
