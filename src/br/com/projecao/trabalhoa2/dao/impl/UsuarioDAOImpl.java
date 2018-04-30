package br.com.projecao.trabalhoa2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import br.com.projecao.trabalhoa2.bean.Usuario;
import br.com.projecao.trabalhoa2.dao.UsuarioDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;
import br.com.projecao.trabalhoa2.dao.jcombobox.Endereco;

public class UsuarioDAOImpl implements UsuarioDAO{

	@Override
	public void salvarUsuario(Usuario p) {
		String sql = "INSERT INTO tb_usuario (cpf,Tb_Endereco_id_endereco,nome,telefone,rg,estado_civil,is_ativo) VALUES (?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getCpf());
			pstm.setInt(2, p.getEndereco());
			pstm.setString(3, p.getNome());
			pstm.setInt(4, p.getTelefone());
			pstm.setInt(5, p.getRg());
			pstm.setString(6, p.getEstado_civil());
			pstm.setBoolean(7, p.isIs_ativo());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar Dados", JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void editarUsuario(Usuario p) {
		String sql = "UPDATE  tb_usuario set Tb_Endereco_id_endereco = ?,nome = ?,telefone = ?,rg = ?,estado_civil = ?,is_ativo = ? where id_Usuario = " + p.getId();
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, p.getEndereco());
			pstm.setString(2, p.getNome());
			pstm.setInt(3, p.getTelefone());
			pstm.setInt(4, p.getRg());
			pstm.setString(5, p.getEstado_civil());
			pstm.setBoolean(6, p.isIs_ativo());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Dados Editados com sucesso!", "Salvar Dados", JOptionPane.INFORMATION_MESSAGE);
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}	
	public List<Usuario>  pesquisarUsuario(){
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select rg,cpf,nome,Id_Usuario from Tb_Usuario";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Usuario usuario = new Usuario();
	            usuario.setRg(rs.getInt("rg"));
	        	   usuario.setCpf(rs.getString("cpf"));
	        	   usuario.setNome(rs.getString("nome"));
	        	   usuario.setId(Integer.parseInt(rs.getString("Id_Usuario")));
	        	 
	        	   listaUsuario.add(usuario);
	        		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaUsuario;

		
}
	public List<Usuario>  pesquisarUsuarioPesquisa(String Dado,String Valor){
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		boolean a = true;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select rg,cpf,nome,Id_Usuario from Tb_Usuario where " + Valor + " = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Dado);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				a=false;
				Usuario usuario = new Usuario();
				
	            usuario.setRg(rs.getInt("rg"));
	        	   usuario.setCpf(rs.getString("cpf"));
	        	   usuario.setNome(rs.getString("nome"));
	        	   usuario.setId(Integer.parseInt(rs.getString("Id_Usuario")));
	        	 
	        	   listaUsuario.add(usuario);
				}	    
			if(a){
				JOptionPane.showMessageDialog(null, "Usuario não encontrado !!!");
			}
			
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaUsuario;

		
}
	
	public Usuario  pesquisarEditarUsuario(Usuario b){
		Usuario retorno = new Usuario();		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from Tb_Usuario where Id_Usuario =" + b.getId();
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				retorno.setRg(rs.getInt("rg"));
				retorno.setCpf(rs.getString("cpf"));
				retorno.setNome(rs.getString("nome"));
				retorno.setId(Integer.parseInt(rs.getString("Id_Usuario")));
				retorno.setEndereco(Integer.parseInt(rs.getString("Tb_Endereco_id_endereco")));
				retorno.setEstado_civil(rs.getString("estado_civil"));
				retorno.setId(b.getId());
				retorno.setIs_ativo(rs.getBoolean("is_ativo"));
				retorno.setTelefone(rs.getInt("telefone"));
				
	        	  
			}
			
			 rs.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		 return retorno;
		
}
	public void  ComboEditarEndereco(Usuario b,JComboBox combo){
		Connection con = null;
		ResultSet rs = null;
	
		int tipo = 0;
		int cont = 0;
		String sql = "select id_endereco,endereco from Tb_Endereco ";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2); 
		         if(id.equals(String.valueOf(b.getEndereco()))){
		        	tipo = cont;
		        	}
		         
		         cont ++;
		        combo.addItem(new Endereco(id, nome));		    
			}
			rs.close();
			combo.setSelectedIndex(tipo);		 
			 
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		
}
		
	public boolean deletarUsuario(Usuario b){
		String sql = "DELETE FROM tb_usuario WHERE Id_Usuario = ?";
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


