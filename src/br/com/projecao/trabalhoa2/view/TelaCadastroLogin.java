package br.com.projecao.trabalhoa2.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import br.com.projecao.trabalhoa2.bean.Login;
import br.com.projecao.trabalhoa2.dao.jcombobox.Perfil;
import br.com.projecao.trabalhoa2.dao.jcombobox.Usuario;
import br.com.projecao.trabalhoa2.facade.LoginFacade;
import br.com.projecao.trabalhoa2.facade.RecuperarFacade;



public class TelaCadastroLogin extends JDialog  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JLabel lblLogin;
	private JTextField txtSenha;
	private JLabel lblSenha;
	private JComboBox comUsuario;
	private JLabel lblUsuario;
	private JComboBox comPefil;
	private JLabel lblPerfil;
	private JLabel lblValidacao;
	private LoginFacade LoginFacade;
	private RecuperarFacade Recupera;
	
	private JButton btnSalvar;
	private JButton btnSair;
	
	
	

	
	public RecuperarFacade getRecupera() {
		if(Recupera == null){
			Recupera = new RecuperarFacade();
		}
		return Recupera;
	}

	public void setRecupera(RecuperarFacade recupera) {
		Recupera = recupera;
	}

	public LoginFacade getLoginFacade() {
		if(LoginFacade == null){
			LoginFacade = new LoginFacade();
		}
		return LoginFacade;
	}

	public void setLoginFacade(LoginFacade loginFacade) {
		LoginFacade = loginFacade;
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	public JLabel getLblLogin() {
		return lblLogin;
	}

	public void setLblLogin(JLabel lblLogin) {
		this.lblLogin = lblLogin;
	}

	public JTextField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JTextField txtSenha) {
		this.txtSenha = txtSenha;
	}

	public JLabel getLblSenha() {
		return lblSenha;
	}

	public void setLblSenha(JLabel lblSenha) {
		this.lblSenha = lblSenha;
	}

	

	public JComboBox getComUsuario() {
		return comUsuario;
	}

	public void setComUsuario(JComboBox comUsuario) {
		this.comUsuario = comUsuario;
	}

	public JLabel getLblUsuario() {
		return lblUsuario;
	}

	public void setLblUsuario(JLabel lblUsuario) {
		this.lblUsuario = lblUsuario;
	}



	public JComboBox getComPefil() {
		return comPefil;
	}

	public void setComPefil(JComboBox comPefil) {
		this.comPefil = comPefil;
	}

	public JLabel getLblPerfil() {
		return lblPerfil;
	}

	public void setLblPerfil(JLabel lblPerfil) {
		this.lblPerfil = lblPerfil;
	}

	public JLabel getLblValidacao() {
		return lblValidacao;
	}

	public void setLblValidacao(JLabel lblValidacao) {
		this.lblValidacao = lblValidacao;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public void setBtnSalvar(JButton btnSalvar) {
		this.btnSalvar = btnSalvar;
	}

	public JButton getBtnSair() {
		return btnSair;
	}

	public void setBtnSair(JButton btnSair) {
		this.btnSair = btnSair;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TelaCadastroLogin() {
		this.setTitle("Cadastrar Login");
		this.setLayout(null);
		Cor b = new Cor();
		
		getContentPane().setBackground(b.getB());
		
		//Nome
		txtLogin = new JTextField(15);
		lblLogin = new JLabel("*Login:");
		lblLogin.setBounds(10, 10, 60, 20);
		txtLogin.setBounds(70,10 , 120, 20);
		
		//Endereco
		txtSenha = new JTextField(15);
		lblSenha = new JLabel("*Senha:");
		lblSenha.setBounds(200, 10, 60, 20);
		txtSenha.setBounds(250,10 , 120, 20);
		
		//Perfil
		
		comPefil = new JComboBox();
		getRecupera().retornaPerfil(comPefil);
		lblPerfil = new JLabel(" Perfil:");
		lblPerfil.setBounds(10, 35, 60, 20);
		comPefil.setBounds(70,35 , 120, 20);
		
		//Usuario
		comUsuario = new JComboBox();	
		getRecupera().retornaUsuarioLogin(comUsuario);
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(200, 35, 60, 20);
		comUsuario.setBounds(250,35, 120, 20);
		 
		
		//Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/login.png");  
		setIconImage(imagemTituloJanela.getImage()); 
		
		
		lblValidacao= new JLabel("* São Campos obrigatorios  ");
		lblValidacao.setForeground(Color.RED);
		lblValidacao.setBounds(10, 100, 200, 25);
		btnSair = new JButton("Limpar");
		btnSair.setBounds(90,70, 100, 20);
		btnSair.addActionListener(new AcaoBtnLimpar());
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(210,70, 100, 20);
		btnSalvar.addActionListener(new AcaoBtnSalvar());

		getContentPane().add(lblLogin);
		getContentPane().add(txtLogin);
		getContentPane().add(lblSenha);
		getContentPane().add(txtSenha);
		
		getContentPane().add(lblPerfil);
		getContentPane().add(comPefil);
		
		getContentPane().add(lblUsuario);
		getContentPane().add(comUsuario);
		
		getContentPane().add(btnSalvar);
		getContentPane().add(btnSair);
		
		getContentPane().add(lblValidacao);
		
		this.setLocation(200,200);
		this.setSize(400, 180);
		this.setModal(true);
		this.setVisible(true);

	}
	

		

	/*
	 * public static void main(String[] args) { new TelaCadastroPessoa(); }
	 */

	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Login p = new Login();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			boolean b = false;
			
			//Nome
			if (txtLogin.getText() == null || txtLogin.getText().equals("")) {
				msg += "\nLogin";
				b = true;
			} else {
				p.setLogin(txtLogin.getText());
			}
			//Senha
			if (txtSenha.getText() == null || txtSenha.getText().equals("")) {
				msg += "\nSenha";
				b = true;
			} else {
				p.setSenha(txtSenha.getText());	
			}
			//Usuario
			int p4 =comUsuario.getSelectedIndex();
			if (p4 == -1){
				msg += "\nUsuario";
				b = true;
			}
			else
			{
				Usuario o = (Usuario) comUsuario.getSelectedItem();  
				int id1 = Integer.parseInt(o.getId());
				p.setUsuario(id1);
			}
			//Usuario
			int p5 =comPefil.getSelectedIndex();
			if (p5 == -1){
				msg += "\nPerfil";
				b = true;
			}
			else
			{
				Perfil i = (Perfil) comPefil.getSelectedItem();  
				int id = Integer.parseInt(i.getId());
				p.setPerfil(id);
			}
			
			
										
			if (b) {
				JOptionPane.showMessageDialog(null, msg, "Mensagem de Erro!",JOptionPane.ERROR_MESSAGE);
			} else {	
				
				Date date = new Date();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String Data = dateFormat.format(date);
			     p.setData(Data);
			   getLoginFacade().Salvar(p);
			   limparCampos();
				 
			}
		}
	}

	private class AcaoBtnLimpar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}

	}

	public void limparCampos() {
		txtLogin.setText("");
		txtSenha.setText("");
		
	}
	
}

