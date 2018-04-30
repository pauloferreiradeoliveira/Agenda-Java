package br.com.projecao.trabalhoa2.facade;

import java.util.List;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.bean.Login;
import br.com.projecao.trabalhoa2.dao.LoginDAO;
import br.com.projecao.trabalhoa2.dao.impl.LoginDAOImpl;

public class LoginFacade {
	private LoginDAO LoginDAO;
	
	public LoginDAO getLoginDAO() {
		if (LoginDAO == null){
			LoginDAO = new LoginDAOImpl();
		}
		return LoginDAO;
	}
	public void setLoginDAO(LoginDAO loginDAO) {
		LoginDAO = loginDAO;
	}
	public    boolean  validar(Login l){
		return getLoginDAO().validar(l);
	}
	public   void Salvar(Login p){
		getLoginDAO().Salvar(p);
	}
	public boolean  validarperfil (Login l) {
		return getLoginDAO().validarperfil(l);
	}
	public void editarLogin(Login p){
		getLoginDAO().editarLogin(p);
	}
	public List<Login>  pesquisarLogin(){
		return getLoginDAO().pesquisarLogin();
	}
	public List<Login>  pesquisarLoginPesquisa(String Dado,String Valor){
		return getLoginDAO().pesquisarLoginPesquisa(Dado, Valor);
	}
	public Login  pesquisarEditarLogin(Login b){
		return getLoginDAO().pesquisarEditarLogin(b);
	}
	public void  ComboEditarPerfil(Login b,JComboBox combo){
		getLoginDAO().ComboEditarPerfil(b, combo);
	}
	public void  ComboEditarUsuario(Login b,JComboBox combo){
		getLoginDAO().ComboEditarUsuario(b, combo);
	}
	public boolean deletarUsuario(Login b){
		return getLoginDAO().deletarUsuario(b);
	}
	
}
