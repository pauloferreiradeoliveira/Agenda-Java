package br.com.projecao.trabalhoa2.facade;

import java.util.List;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.bean.Contatos;

import br.com.projecao.trabalhoa2.dao.ContatosDAO;
import br.com.projecao.trabalhoa2.dao.impl.ContatoDAOImpl;

public class ContatosFacade {
     private ContatosDAO ContatosDAO;

	public ContatosDAO getContatosDAO() {
		if (ContatosDAO == null){
			ContatosDAO = new ContatoDAOImpl();
		}
	
		return ContatosDAO;
	}

	public void setContatosDAO(ContatosDAO contatosDAO) {
		ContatosDAO = contatosDAO;
	}
     
	public  void Salvar(Contatos p){
		getContatosDAO().Salvar(p);
		
	}
	public List<Contatos>  pesquisarContatos(){
		return getContatosDAO().pesquisarContatos();
	}
	public List<Contatos>  pesquisarContatosPesquisa(String Dado,String Valor){
		return getContatosDAO().pesquisarContatosPesquisa(Dado, Valor);
	}
	public Contatos  pesquisarEditarContatos(Contatos b){
		return getContatosDAO().pesquisarEditarContatos(b);
	}
	public void  ComboEditarTipoPerfil(Contatos b,JComboBox combo){
		getContatosDAO().ComboEditarTipoPerfil(b, combo);
	}
	public void  ComboEditarUsuario(Contatos b,JComboBox combo){
		getContatosDAO().ComboEditarUsuario(b, combo);
	}
	public void  ComboEditarEndereco(Contatos b,JComboBox combo){
		getContatosDAO().ComboEditarEndereco(b, combo);
	}
	public void editarContatos(Contatos p){
		getContatosDAO().editarContatos(p);
	}
	public boolean deletarContato(Contatos b){
		return getContatosDAO().deletarContato(b);
	}
}
