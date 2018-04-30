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




import br.com.projecao.trabalhoa2.bean.Login;
import br.com.projecao.trabalhoa2.dao.LoginDAO;
import br.com.projecao.trabalhoa2.dao.conexao.Conexao;
import br.com.projecao.trabalhoa2.dao.jcombobox.Perfil;
import br.com.projecao.trabalhoa2.dao.jcombobox.Usuario;




public class LoginDAOImpl implements LoginDAO {

	@Override
	public boolean  validar (Login l) {
		
		boolean retorno = false;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from TB_Login where login = ? and senha = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, l.getLogin());
			pstm.setString(2, l.getSenha());
			rs = pstm.executeQuery();
			if(rs.next()){
				retorno = true;
			}
			pstm.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		return retorno;
	}
    public boolean  validarperfil (Login l) {
		
		boolean retorno = false;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT tb_perfil.perfil FROM `tb_login` inner join tb_perfil on Tb_Perfil_id_perfil = id_perfil  WHERE login = ? and senha = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, l.getLogin());
			pstm.setString(2, l.getSenha());
			rs = pstm.executeQuery();
			
			while(rs.next()){
				if(rs.getString("perfil").equalsIgnoreCase("Administrador")){
					retorno = true;
				}
			}
			pstm.close();
		}catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro, não foi possivel efetuar a transação", "Erro Inserir Dados", JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ocorreu um erro", "Falha de Sistema", JOptionPane.ERROR_MESSAGE);
		}
		
		return retorno;
	}
	@Override
	public void Salvar(Login p) {

		String sql = "insert into Tb_Login(Login,Tb_Usuario_id_usuario,Tb_Perfil_id_perfil,senha,dt_cadastro) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getLogin());
			pstm.setInt(2, p.getUsuario());
			pstm.setInt(3, p.getPerfil());
			pstm.setString(4, p.getSenha());
			pstm.setString(5, p.getData());
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

	public void editarLogin(Login p) {
		String sql = "UPDATE  Tb_Login set Login = ?,Tb_Usuario_id_usuario= ?,Tb_Perfil_id_perfil= ?,senha= ? where Id_login= " + p.getId();
		Connection con = null;
		PreparedStatement pstm = null;
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getLogin());
			pstm.setInt(2, p.getUsuario());
			pstm.setInt(3, p.getPerfil());
			pstm.setString(4, p.getSenha());
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
	public List<Login>  pesquisarLogin(){
		List<Login> listaLogin = new ArrayList<Login>();
		
		Connection con = null;
		ResultSet rs = null;
		String sql = "SELECT Tb_Usuario.nome, Tb_Perfil.perfil, login,id_login FROM TB_Login INNER JOIN Tb_Usuario ON Tb_Usuario.Id_Usuario = TB_Login.Tb_Usuario_Id_Usuario INNER JOIN Tb_Perfil ON Tb_Perfil.id_perfil = TB_Login.Tb_Perfil_id_perfil";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Login Login = new Login();
				Login.setMostarPerfil(rs.getString("perfil"));
				Login.setMostarUsuario(rs.getString("nome"));
				Login.setLogin(rs.getString("login"));
				Login.setId(Integer.parseInt(rs.getString("id_login")));
	        	 
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
	public List<Login>  pesquisarLoginPesquisa(String Dado,String Valor){
		List<Login> listaLogin = new ArrayList<Login>();
		boolean a = true;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT Tb_Usuario.nome, Tb_Perfil.perfil, login,id_login FROM TB_Login INNER JOIN Tb_Usuario ON Tb_Usuario.Id_Usuario = TB_Login.Tb_Usuario_Id_Usuario INNER JOIN Tb_Perfil ON Tb_Perfil.id_perfil = TB_Login.Tb_Perfil_id_perfil where " + Valor + " = ?";
		try{
			con = new Conexao().getConection();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, Dado);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				a=false;
				Login Login = new Login();
				Login.setMostarPerfil(rs.getString("perfil"));
				Login.setMostarUsuario(rs.getString("nome"));
				Login.setLogin(rs.getString("login"));
				Login.setId(Integer.parseInt(rs.getString("id_login")));
				
	        	 
	        	   listaLogin.add(Login);
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
		return listaLogin;

		
}
	
	public Login  pesquisarEditarLogin(Login b){
		Login retorno = new Login();		
		Connection con = null;
		ResultSet rs = null;
		String sql = "select * from TB_Login where id_login =" + b.getId();
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				
				retorno.setId(b.getId());
				retorno.setLogin(rs.getString("login"));
				retorno.setPerfil(rs.getInt("Tb_Usuario_Id_Usuario"));
				retorno.setSenha(rs.getString("senha"));
				retorno.setPerfil(rs.getInt("Tb_Perfil_id_perfil"));
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
	public void  ComboEditarPerfil(Login b,JComboBox combo){
		Connection con = null;
		ResultSet rs = null;
	
		int tipo = 0;
		int cont = 0;
		String sql = "select id_perfil,perfil from Tb_Perfil";
		try{
			con = new Conexao().getConection();
			Statement stmt= con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				 String id = rs.getString(1);  
		         String nome = rs.getString(2); 
		         if(id.equals(String.valueOf(b.getPerfil()))){
		        	tipo = cont;
		        	}
		         
		         cont ++;
		        combo.addItem(new Perfil(id, nome));		    
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
	public void  ComboEditarUsuario(Login b,JComboBox combo){
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
	public boolean deletarUsuario(Login b){
		String sql = "DELETE FROM TB_Login WHERE Id_login = ?";
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



