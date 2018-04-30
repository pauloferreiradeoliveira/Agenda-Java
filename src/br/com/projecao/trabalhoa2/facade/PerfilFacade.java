package br.com.projecao.trabalhoa2.facade;

import java.util.List;

import br.com.projecao.trabalhoa2.bean.Perfil;
import br.com.projecao.trabalhoa2.dao.PerfilDAO;
import br.com.projecao.trabalhoa2.dao.impl.PerfilDAOImpl;

public class PerfilFacade {
	
	private PerfilDAO perfilDAO;
	
	
	
	
	public PerfilDAO getPerfilDAO() {
		if(perfilDAO == null){
			perfilDAO = new PerfilDAOImpl();
		}
		
		return perfilDAO;
	}




	public void setPerfilDAO(PerfilDAO perfilDAO) {
		this.perfilDAO = perfilDAO;
	}




	public  void salvarPerfil(Perfil p){
		getPerfilDAO().salvarPerfil(p);
		
	}
	public  void editarPerfil(Perfil p){
		getPerfilDAO().editarPerfil(p);
	}
	public  List<Perfil>  pesquisarPerfil(){
		return getPerfilDAO().pesquisarPerfil();
	}
	public   List<Perfil>  pesquisarPerfilPesquisa(String Dado){
		return getPerfilDAO().pesquisarPerfilPesquisa(Dado);
	}
	public  Perfil  pesquisarEditarPerfil(Perfil b){
		return getPerfilDAO().pesquisarEditarPerfil(b);
	}
	public  boolean deletarPerfil(Perfil b){
		return getPerfilDAO().deletarPerfil(b);
	}
}
