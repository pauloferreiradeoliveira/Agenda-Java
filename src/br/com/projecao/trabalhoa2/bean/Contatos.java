package br.com.projecao.trabalhoa2.bean;


public class Contatos {
	private int id;
	private int tp_contato;
	private int endereco;
	private int Usuario;
	private boolean is_ativo;
	private String data;
	private String Nome;
	private String Email;
	private String Fixo;
	private String Celular;
	private String MotrarUsuario;
	private String MostrarTipo;
	

	

	public String getMotrarUsuario() {
		return MotrarUsuario;
	}

	public void setMotrarUsuario(String motrarUsuario) {
		MotrarUsuario = motrarUsuario;
	}

	public String getMostrarTipo() {
		return MostrarTipo;
	}

	public void setMostrarTipo(String mostrarTipo) {
		MostrarTipo = mostrarTipo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTp_contato() {
		return tp_contato;
	}

	public void setTp_contato(int tpContato) {
		tp_contato = tpContato;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}

	public int getUsuario() {
		return Usuario;
	}

	public void setUsuario(int usuario) {
		Usuario = usuario;
	}

	public boolean isIs_ativo() {
		return is_ativo;
	}

	public void setIs_ativo(boolean isAtivo) {
		is_ativo = isAtivo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFixo() {
		return Fixo;
	}

	public void setFixo(String fixo) {
		Fixo = fixo;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}




}
