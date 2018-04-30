package br.com.projecao.trabalhoa2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.projecao.trabalhoa2.bean.TipoContato;
import br.com.projecao.trabalhoa2.dao.TipoContatoDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;



public class TipoContatoDAOImpl implements TipoContatoDAO {

	@Override
	public void salvarTipoContado(TipoContato p) {
		String sql = "insert into Tp_Contato(tp_contato,descricao) values(?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getContato());
			pstm.setString(2, p.getDescricao());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar Dados", JOptionPane.INFORMATION_MESSAGE);
			pstm.close();

		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}
		
	public void EditarTipoCOntato(TipoContato p) {
		String sql = "UPDATE  tp_contato  set tp_contato = ? ,descricao = ?  where id_tp_contato = " + p.getId();
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getContato());
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
	public List<TipoContato>  pesquisaTipoContato(){
		List<TipoContato> listaTipoContato = new ArrayList<TipoContato>();
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from tp_contato";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				TipoContato Contato = new TipoContato();
				Contato.setContato(rs.getString("tp_contato"));
				Contato.setDescricao(rs.getString("descricao"));
				Contato.setId(rs.getInt("id_tp_contato"));
	        	   	        	 
	        	   listaTipoContato.add(Contato);
	        		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaTipoContato;

		
}
	public List<TipoContato>  pesquisarTipoContatoPesquisa(String Dado){
		List<TipoContato> listaTipoContato = new ArrayList<TipoContato>();
		boolean a = true;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from tp_contato where tp_contato = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Dado);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				a=false;
				TipoContato Contato = new TipoContato();
				Contato.setContato(rs.getString("tp_contato"));
				Contato.setDescricao(rs.getString("descricao"));
				Contato.setId(rs.getInt("id_tp_contato"));
	        	   	        	 
	        	   listaTipoContato.add(Contato);
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
		return listaTipoContato;

		
}
	
	public TipoContato  pesquisarEditarTipo(TipoContato b){
		TipoContato Contato= new TipoContato();		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from tp_contato where id_tp_contato =" + b.getId();
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				Contato.setContato(rs.getString("tp_contato"));
				Contato.setDescricao(rs.getString("descricao"));
				Contato.setId(rs.getInt("id_tp_contato"));
					        	  
			}
			
			 rs.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		 return Contato;
		
}
	public boolean deletarTipoContato(TipoContato b){
		String sql = "DELETE FROM tp_contato WHERE id_tp_contato = ?";
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
	
	


	


