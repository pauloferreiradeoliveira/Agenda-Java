package br.com.projecao.trabalhoa2.dao;

import java.util.List;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.bean.Login;

public interface LoginDAO {
	public   abstract  boolean  validar(Login l);
	public   abstract void Salvar(Login p);
	public  abstract boolean  validarperfil (Login l);
	public void editarLogin(Login p);
	public List<Login>  pesquisarLogin();
	public List<Login>  pesquisarLoginPesquisa(String Dado,String Valor);
	public Login  pesquisarEditarLogin(Login b);
	public void  ComboEditarPerfil(Login b,JComboBox combo);
	public void  ComboEditarUsuario(Login b,JComboBox combo);
	public boolean deletarUsuario(Login b);
	

}
