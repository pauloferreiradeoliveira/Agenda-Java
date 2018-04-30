package br.com.projecao.trabalhoa2.bean;

public class Usuario {
	
	private int id;
	private String cpf;
	private int Endereco;
	private String nome;
	private int Telefone;
	private int rg;
	private String estado_civil;
	private boolean is_ativo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getEndereco() {
		return Endereco;
	}
	public void setEndereco(int endereco) {
		Endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTelefone() {
		return Telefone;
	}
	public void setTelefone(int telefone) {
		Telefone = telefone;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estadoCivil) {
		estado_civil = estadoCivil;
	}
	public boolean isIs_ativo() {
		return is_ativo;
	}
	public void setIs_ativo(boolean isAtivo) {
		is_ativo = isAtivo;
	}
	
	

}
