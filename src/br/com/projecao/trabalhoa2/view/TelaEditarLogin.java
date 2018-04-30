package br.com.projecao.trabalhoa2.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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



public class TelaEditarLogin extends JDialog  {


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
	private JLabel lblData;
	private JLabel lblreceber;
	private LoginFacade LoginFacade;
	private Login Dado;
	
	private JButton btnSalvar;

	
	
	

	
	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public JLabel getLblreceber() {
		return lblreceber;
	}

	public void setLblreceber(JLabel lblreceber) {
		this.lblreceber = lblreceber;
	}

	public Login getDado() {
		return Dado;
	}

	public void setDado(Login dado) {
		Dado = dado;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TelaEditarLogin(Login retorno) {
		Dado = getLoginFacade().pesquisarEditarLogin(retorno);
		this.setTitle("Editar Login -" +Dado.getLogin() );
		this.setLayout(null);
		Cor b = new Cor();
		
		getContentPane().setBackground(b.getB());
		
		//Nome
		txtLogin = new JTextField(15);
		lblLogin = new JLabel("*Login:");
		txtLogin.setText(Dado.getLogin());
		lblLogin.setBounds(10, 10, 60, 20);
		txtLogin.setBounds(70,10 , 120, 20);
		
		//Endereco
		txtSenha = new JTextField(15);
		lblSenha = new JLabel("*Senha:");
		lblSenha.setBounds(200, 10, 60, 20);
		txtSenha.setBounds(250,10 , 120, 20);
		txtSenha.setText(Dado.getSenha());
		
		//Perfil
		
		comPefil = new JComboBox();
		getLoginFacade().ComboEditarPerfil(Dado, comPefil);
		lblPerfil = new JLabel(" Perfil:");
		lblPerfil.setBounds(10, 35, 60, 20);
		comPefil.setBounds(70,35 , 120, 20);
		
		//Usuario
		comUsuario = new JComboBox();	
		getLoginFacade().ComboEditarUsuario(Dado, comUsuario);
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(200, 35, 60, 20);
		comUsuario.setBounds(250,35, 120, 20);
		
		 
		
		//Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/login.png");  
		setIconImage(imagemTituloJanela.getImage()); 
		
		
		lblValidacao= new JLabel("* São Campos obrigatorios");
		lblValidacao.setForeground(Color.RED);
		lblValidacao.setBounds(10, 100, 200, 25);
		
		lblreceber = new JLabel(Dado.getData());
		lblData= new JLabel("Data de Cadastro:");
		lblreceber.setBounds(300, 100, 180, 25);
		lblData.setBounds(180, 100, 150,25);
	
	
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(110,70, 100, 20);
		btnSalvar.addActionListener(new AcaoBtnSalvar());

		getContentPane().add(lblLogin);
		getContentPane().add(txtLogin);
		getContentPane().add(lblSenha);
		getContentPane().add(txtSenha);
		getContentPane().add(lblreceber);
		getContentPane().add(lblData);
		
		getContentPane().add(lblPerfil);
		getContentPane().add(comPefil);
		
		getContentPane().add(lblUsuario);
		getContentPane().add(comUsuario);
		
		getContentPane().add(btnSalvar);
			
		getContentPane().add(lblValidacao);
		
		this.setLocation(200,200);
		this.setSize(400, 180);
		this.setModal(true);
		this.setVisible(true);

	}
	

		

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
				
				p.setId(Dado.getId());
			   getLoginFacade().editarLogin(p);
			   setVisible(false);
				 
			}
		}
	}

	
	
}

