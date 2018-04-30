package br.com.projecao.trabalhoa2.dao;

import java.util.List;

import br.com.projecao.trabalhoa2.bean.Endereco;



public interface EnderecoDAO {
	public abstract void salvarEndereco(Endereco p);
	public abstract void editarEndereco(Endereco p);
	public abstract List<Endereco>  pesquisarEndereco();
	public abstract List<Endereco>  pesquisarEnderecoPesquisa(String Dado,String Tipo);
	public abstract Endereco  pesquisarEditarEndereco(Endereco Endereco);
	public abstract boolean deletarEndereco(Endereco b);
	

}
