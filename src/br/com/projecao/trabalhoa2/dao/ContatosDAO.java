package br.com.projecao.trabalhoa2.dao;

import java.util.List;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.bean.Contatos;

public interface ContatosDAO {
	public abstract void Salvar(Contatos p);
	public List<Contatos>  pesquisarContatos();
	public List<Contatos>  pesquisarContatosPesquisa(String Dado,String Valor);
	public Contatos  pesquisarEditarContatos(Contatos b);
	public void  ComboEditarTipoPerfil(Contatos b,JComboBox combo);
	public void  ComboEditarUsuario(Contatos b,JComboBox combo);
	public void  ComboEditarEndereco(Contatos b,JComboBox combo);
	public abstract void editarContatos(Contatos p) ;
	public abstract boolean deletarContato(Contatos b);
}
