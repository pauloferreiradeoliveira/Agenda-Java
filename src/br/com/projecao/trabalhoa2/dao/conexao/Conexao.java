package br.com.projecao.trabalhoa2.dao.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	private static final String url = "jdbc:mysql:fdb2.eohost.com/1077362_agenda";
	private static final String senha = "33365260";
	private static final String usuario = "1077362_agenda";

	public Connection getConection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "driver errado!");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"erro ao se conectar ao banco de dados!");
			e.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Não foi possivel se conectar ao banco");
			e.printStackTrace();
		}
		return con;
	}

}
