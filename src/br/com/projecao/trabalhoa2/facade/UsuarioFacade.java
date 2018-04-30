package br.com.projecao.trabalhoa2.facade;

import java.util.List;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.bean.Usuario;
import br.com.projecao.trabalhoa2.dao.UsuarioDAO;
import br.com.projecao.trabalhoa2.dao.impl.UsuarioDAOImpl;


public class UsuarioFacade {
  private UsuarioDAO usuario;

public UsuarioDAO getUsuario() {
	if (usuario == null){
	  usuario = new UsuarioDAOImpl();	
	}
	return usuario;
}

public void setUsuario(UsuarioDAO usuario) {
	this.usuario = usuario;
}

public void salvarUsuario(Usuario v){
	getUsuario().salvarUsuario(v);
}

public List<Usuario> pesquisarUsuario() {
	return getUsuario().pesquisarUsuario();
	
}

public boolean deletarUsuario(Usuario usuario2) {
	return getUsuario().deletarUsuario(usuario2);
}
public Usuario pesquisaUsuarioEditar(Usuario b) {
	return getUsuario().pesquisarEditarUsuario(b);
}
public void  ComboEditarEndereco(Usuario b,JComboBox combo){
	getUsuario().ComboEditarEndereco(b, combo);
}
public void editarUsuario(Usuario p) {
	getUsuario().editarUsuario(p);
}
public List<Usuario>  pesquisarUsuarioPesquisa(String Dado,String Valor){
	return getUsuario().pesquisarUsuarioPesquisa(Dado, Valor);
}
}
