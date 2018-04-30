package br.com.projecao.trabalhoa2.dao;


import java.util.List;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.bean.Usuario;


public interface UsuarioDAO {
	public abstract void salvarUsuario(Usuario p);
	public abstract List<Usuario>  pesquisarUsuario();
	public  abstract boolean deletarUsuario(Usuario b);
	public abstract Usuario  pesquisarEditarUsuario(Usuario b);
	public void  ComboEditarEndereco(Usuario b,JComboBox combo);
	public void editarUsuario(Usuario p);
	public List<Usuario>  pesquisarUsuarioPesquisa(String Dado,String Valor);
}
