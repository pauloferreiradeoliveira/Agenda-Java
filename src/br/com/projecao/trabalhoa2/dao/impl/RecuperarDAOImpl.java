package br.com.projecao.trabalhoa2.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;


import br.com.projecao.trabalhoa2.dao.RecuperarDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;
//import br.com.projecao.trabalhoa2.dao.items.Usuario;
import br.com.projecao.trabalhoa2.dao.jcombobox.Endereco;
import br.com.projecao.trabalhoa2.dao.jcombobox.Perfil;
import br.com.projecao.trabalhoa2.dao.jcombobox.Tp_Contato;
import br.com.projecao.trabalhoa2.dao.jcombobox.Usuario;

public class RecuperarDAOImpl implements RecuperarDAO {
	public void retornaPerfil(JComboBox combo)  {
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select id_perfil,perfil from Tb_Perfil";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2);  
		         combo.addItem(new Perfil(id, nome)); 		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void retornaUsuario(JComboBox combo)  {
			
			Connection con = null;
			ResultSet rs = null;
			String sql = "select id_usuario,nome from Tb_Usuario";
			try{
				con = new Conexao().getConection();
				Statement stmt= con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					 String id = rs.getString(1);  
			         String nome = rs.getString(2);  
			         combo.addItem(new Usuario(id, nome)); 		    
				}
				 rs.close();
			}catch(SQLException e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
			}catch(Exception e){
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
			}
	
			
	}
	public void retornaUsuarioLogin(JComboBox combo)  {
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select id_usuario,nome from Tb_Usuario u where u.id_usuario not in (select l.Tb_Usuario_Id_Usuario from tb_login l)";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2);  
		         combo.addItem(new Usuario(id, nome)); 		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}

		
}
	public void retornaTp_Contato(JComboBox combo)  {
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select id_tp_contato,tp_contato from Tp_Contato";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2);  
		         combo.addItem(new Tp_Contato(id, nome)); 		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}

		
}
	
	public void retornaEndereco(JComboBox combo)  {
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select id_endereco,endereco from Tb_Endereco";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2);  
		        combo.addItem(new Endereco(id, nome));		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}

		
}
}