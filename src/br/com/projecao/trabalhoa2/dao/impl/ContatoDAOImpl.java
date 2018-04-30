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

import br.com.projecao.trabalhoa2.bean.Contatos;

import br.com.projecao.trabalhoa2.dao.ContatosDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;
import br.com.projecao.trabalhoa2.dao.jcombobox.Endereco;
import br.com.projecao.trabalhoa2.dao.jcombobox.Tp_Contato;
import br.com.projecao.trabalhoa2.dao.jcombobox.Usuario;

public  class ContatoDAOImpl implements ContatosDAO{

	@Override
	public void Salvar(Contatos p) {

		String sql = "insert into tb_contatos (Tb_Usuario_Id_Usuario, Tp_Contato_id_tp_contato,Tb_Endereco_id_endereco,is_ativo, dt_cadastro, Nome, Email, Telefone_Fixo, Telefone_Celular) values(?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, p.getUsuario());
			pstm.setInt(2, p.getTp_contato());
			pstm.setInt(3, p.getEndereco());
			pstm.setBoolean(4, p.isIs_ativo());
			pstm.setString(5, p.getData());
			pstm.setString(6, p.getNome());
			pstm.setString(7, p.getEmail());
			pstm.setString(8, p.getFixo());
			pstm.setString(9, p.getCelular());
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
	public List<Contatos>  pesquisarContatos(){
		List<Contatos> listaLogin = new ArrayList<Contatos>();
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "SELECT Tb_Usuario.nome as 'Usuario' ,id_contato,  tp_contato.tp_contato, tb_contatos.Nome ,Telefone_Fixo,id_contato FROM tb_contatos INNER JOIN Tb_Usuario ON Tb_Usuario.Id_Usuario = tb_contatos.Tb_Usuario_Id_Usuario INNER JOIN tp_contato ON tp_contato.id_tp_contato = tb_contatos.Tp_Contato_id_tp_contato";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Contatos Login = new Contatos();
				Login.setMotrarUsuario(rs.getString("Usuario"));
				Login.setNome(rs.getString("nome"));
				Login.setMostrarTipo(rs.getString("tp_contato"));
				Login.setId(Integer.parseInt(rs.getString("id_contato")));
				
				listaLogin.add(Login);
	        		    
			}
			 rs.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		return listaLogin;

		
}
	public List<Contatos>  pesquisarContatosPesquisa(String Dado,String Valor){
		List<Contatos> listaContato = new ArrayList<Contatos>();
		boolean a = true;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT Tb_Usuario.nome as 'Usuario' ,id_contato,  tp_contato.tp_contato as 'tipo', tb_contatos.Nome ,Telefone_Fixo,id_contato FROM tb_contatos INNER JOIN Tb_Usuario ON Tb_Usuario.Id_Usuario = tb_contatos.Tb_Usuario_Id_Usuario INNER JOIN tp_contato ON tp_contato.id_tp_contato = tb_contatos.Tp_Contato_id_tp_contato where " + Valor + " = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Dado);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				a=false;
				Contatos Login = new Contatos();
				Login.setMotrarUsuario(rs.getString("Usuario"));
				Login.setNome(rs.getString("nome"));
				Login.setMostrarTipo(rs.getString("tipo"));
				Login.setId(Integer.parseInt(rs.getString("id_contato")));
				listaContato.add(Login);
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
		return listaContato;

		
}
	
	public Contatos  pesquisarEditarContatos(Contatos b){
		Contatos retorno = new Contatos();		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from  tb_contatos where id_contato =" + b.getId();
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				retorno.setId(b.getId());
				retorno.setCelular(rs.getString("Telefone_Celular"));
				retorno.setFixo(rs.getString("Telefone_Fixo"));
				retorno.setUsuario(rs.getInt("Tb_Usuario_Id_Usuario"));
				retorno.setTp_contato(rs.getInt("Tp_Contato_id_tp_contato"));
				retorno.setEndereco(rs.getInt("Tb_Endereco_id_endereco"));
				retorno.setNome(rs.getString("nome"));
				retorno.setEmail(rs.getString("Email"));
				retorno.setIs_ativo(rs.getBoolean("is_ativo"));
				retorno.setData(rs.getString("dt_cadastro"));
   	  
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
	public void  ComboEditarTipoPerfil(Contatos b,JComboBox combo){
		Connection con = null;
		ResultSet rs = null;
	
		int tipo = 0;
		int cont = 0;
		String sql = "select id_tp_contato,tp_contato from  tp_contato";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2); 
		         if(id.equals(String.valueOf(b.getTp_contato()))){
		        	tipo = cont;
		        	}
		         
		         cont ++;
		        combo.addItem(new Tp_Contato(id, nome));		    
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
	public void  ComboEditarUsuario(Contatos b,JComboBox combo){
		Connection con = null;
		ResultSet rs = null;
	
		int tipo = 0;
		int cont = 0;
		String sql = "select id_usuario,nome from Tb_Usuario";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2); 
		         if(id.equals(String.valueOf(b.getUsuario()))){
		        	tipo = cont;
		        	}
		         
		         cont ++;
		        combo.addItem(new Usuario(id, nome));		    
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

	public void  ComboEditarEndereco(Contatos b,JComboBox combo){
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
	public void editarContatos(Contatos p) {
		String sql = "UPDATE tb_contatos set Tb_Usuario_Id_Usuario = ?, Tp_Contato_id_tp_contato = ?,Tb_Endereco_id_endereco = ?,is_ativo = ?,  Nome = ?, Email = ?, Telefone_Fixo  = ?, Telefone_Celular = ? where id_contato = " + p.getId();
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, p.getUsuario());
			pstm.setInt(2, p.getTp_contato());
			pstm.setInt(3, p.getEndereco());
			pstm.setBoolean(4, p.isIs_ativo());
			pstm.setString(5, p.getNome());
			pstm.setString(6, p.getEmail());
			pstm.setString(7, p.getFixo());
			pstm.setString(8, p.getCelular());
			pstm.execute();
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
	public boolean deletarContato(Contatos b){
		String sql = "DELETE FROM   tb_contatos WHERE  id_contato = ?";
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