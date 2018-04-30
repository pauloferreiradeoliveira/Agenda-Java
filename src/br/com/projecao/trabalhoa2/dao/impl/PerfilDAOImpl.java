package br.com.projecao.trabalhoa2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.swing.JOptionPane;
import br.com.projecao.trabalhoa2.bean.Perfil;
import br.com.projecao.trabalhoa2.dao.PerfilDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;




public class PerfilDAOImpl implements PerfilDAO {

	@Override
	public void salvarPerfil(Perfil p) {

		String sql = "insert into Tb_Perfil(perfil,descricao) values(?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getPerfil());
			pstm.setString(2, p.getDescricao());
			
			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar Dados", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void editarPerfil(Perfil p) {
		String sql = "UPDATE  Tb_Perfil set perfil = ? ,descricao = ?  where id_perfil = " + p.getId();
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getPerfil());
			pstm.setString(2, p.getDescricao());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Dados  Editados com sucesso!", "Salvar Dados", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}	
	public List<Perfil>  pesquisarPerfil(){
		List<Perfil> listaPerfil = new ArrayList<Perfil>();
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select id_perfil,perfil,descricao from tb_perfil";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Perfil perfil = new Perfil();
				perfil.setPerfil(rs.getString("perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				perfil.setId(rs.getInt("id_perfil"));
	        	   	        	 
	        	   listaPerfil.add(perfil);
	        		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaPerfil;

		
}
	public List<Perfil>  pesquisarPerfilPesquisa(String Dado){
		List<Perfil> listaPerfil = new ArrayList<Perfil>();
		boolean a = true;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select id_perfil,perfil,descricao from tb_perfil where perfil = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Dado);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				a=false;
				Perfil perfil = new Perfil();
				
				perfil.setPerfil(rs.getString("perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				perfil.setId(rs.getInt("id_perfil"));
        	   	        	 
        	   listaPerfil.add(perfil);
				}	    
			if(a){
				JOptionPane.showMessageDialog(null, "Não encontrado !!!");
			}
			
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaPerfil;

		
}
	
	public Perfil  pesquisarEditarPerfil(Perfil b){
		Perfil perfil= new Perfil();		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from tb_perfil where id_perfil =" + b.getId();
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				perfil.setPerfil(rs.getString("perfil"));
				perfil.setDescricao(rs.getString("descricao"));
				perfil.setId(b.getId());
					        	  
			}
			
			 rs.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		 return perfil;
		
}
	public boolean deletarPerfil(Perfil b){
		String sql = "DELETE FROM tb_perfil WHERE id_perfil = ?";
		boolean retorno = false;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, b.getId());
			pstm.execute();
			pstm.close();
			retorno = true;
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		return retorno;
	}

	
		
		

		
	
}


