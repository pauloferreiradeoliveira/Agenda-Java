package br.com.projecao.trabalhoa2.dao;

import java.util.List;

import br.com.projecao.trabalhoa2.bean.Perfil;


public interface PerfilDAO {
	
	public abstract void salvarPerfil(Perfil p);
	public abstract void editarPerfil(Perfil p);
	public abstract List<Perfil>  pesquisarPerfil();
	public  abstract List<Perfil>  pesquisarPerfilPesquisa(String Dado);
	public abstract Perfil  pesquisarEditarPerfil(Perfil b);
	public abstract boolean deletarPerfil(Perfil b);

}
