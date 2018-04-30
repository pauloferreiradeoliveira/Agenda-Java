package br.com.projecao.trabalhoa2.dao;

import javax.swing.JComboBox;



public interface RecuperarDAO {
	
	public abstract void retornaUsuario(JComboBox combo);
	public abstract void retornaPerfil(JComboBox combo);
	public abstract void retornaTp_Contato(JComboBox combo);
	public  abstract void retornaEndereco(JComboBox combo);
	public void retornaUsuarioLogin(JComboBox combo);

}
