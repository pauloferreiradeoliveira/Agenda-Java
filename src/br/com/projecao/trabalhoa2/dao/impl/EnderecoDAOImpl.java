package br.com.projecao.trabalhoa2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projecao.trabalhoa2.bean.Endereco;
import br.com.projecao.trabalhoa2.dao.EnderecoDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;

public class EnderecoDAOImpl implements EnderecoDAO {

	@Override
	public void salvarEndereco(Endereco p) {
		
		String sql = "insert into Tb_Endereco(cep,endereco,cidade,estado,pais) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getCep());
			pstm.setString(2, p.getEndereco());
			pstm.setString(3, p.getCidade());
			pstm.setString(4, p.getEstado());
			pstm.setString(5, p.getPais());
			
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
	
	public void editarEndereco(Endereco p) {
		String sql = "UPDATE  Tb_Endereco set cep = ?,endereco = ?,cidade = ?,estado = ?,pais= ?  where id_endereco = " + p.getId();
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getCep());
			pstm.setString(2, p.getEndereco());
			pstm.setString(3, p.getCidade());
			pstm.setString(4, p.getEstado());
			pstm.setString(5, p.getPais());
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
	public List<Endereco>  pesquisarEndereco(){
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select id_endereco,endereco,cidade,estado from Tb_Endereco";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Endereco Endereco = new Endereco();
				Endereco.setCidade(rs.getString("cidade"));
				Endereco.setEndereco(rs.getString("endereco"));
				Endereco.setId(rs.getInt("id_endereco"));
				Endereco.setEstado(rs.getString("estado"));
	        	   	        	 
	        	   listaEndereco.add(Endereco);
	        		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaEndereco;

		
}
	public List<Endereco>  pesquisarEnderecoPesquisa(String Dado,String Tipo){
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		boolean a = true;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select id_endereco,endereco,cidade,estado from Tb_Endereco where " + Tipo + " = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Dado);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				a=false;
				Endereco Endereco = new Endereco();
				Endereco.setCidade(rs.getString("cidade"));
				Endereco.setEndereco(rs.getString("endereco"));
				Endereco.setId(rs.getInt("id_endereco"));
				Endereco.setEstado(rs.getString("estado"));
	        	   	        	 
	        	   listaEndereco.add(Endereco);
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
		return listaEndereco;

		
}
	
	public Endereco  pesquisarEditarEndereco(Endereco Endereco){
			
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from Tb_Endereco where id_endereco =" + Endereco.getId();
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				
				Endereco.setCidade(rs.getString("cidade"));
				Endereco.setEndereco(rs.getString("endereco"));
				Endereco.setId(rs.getInt("id_endereco"));
				Endereco.setEstado(rs.getString("estado"));
				Endereco.setCep(rs.getString("cep"));
				Endereco.setPais(rs.getString("pais"));
				
				
					        	  
			}
			
			 rs.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		 return Endereco;
		
}
	public boolean deletarEndereco(Endereco b){
		String sql = "DELETE FROM Tb_Endereco where id_endereco = ?";
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
