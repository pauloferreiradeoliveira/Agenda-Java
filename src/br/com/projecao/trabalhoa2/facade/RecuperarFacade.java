package br.com.projecao.trabalhoa2.facade;

import javax.swing.JComboBox;

import br.com.projecao.trabalhoa2.dao.RecuperarDAO;
import br.com.projecao.trabalhoa2.dao.impl.RecuperarDAOImpl;

public class RecuperarFacade {
	private RecuperarDAO RecuperarDAO;

	public RecuperarDAO getRecuperarDAO() {
		if (RecuperarDAO == null){
			RecuperarDAO = new RecuperarDAOImpl();
		}
		return RecuperarDAO;
	}

	public void setRecuperarDAO(RecuperarDAO recuperarDAO) {
		RecuperarDAO = recuperarDAO;
	}

	
	public void retornaUsuario(JComboBox combo){
		getRecuperarDAO().retornaUsuario(combo);
	}
	public void retornaPerfil(JComboBox combo){
		getRecuperarDAO().retornaPerfil(combo);
	}
	public void retornaTp_Contato(JComboBox combo){
		getRecuperarDAO().retornaTp_Contato(combo);
	}
	public void retornaEndereco(JComboBox combo){
		getRecuperarDAO().retornaEndereco(combo);
	}
	public void retornaUsuarioLogin(JComboBox combo){
		getRecuperarDAO().retornaUsuarioLogin(combo);
	}
}
