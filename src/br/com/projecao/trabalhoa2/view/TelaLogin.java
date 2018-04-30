package br.com.projecao.trabalhoa2.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.projecao.trabalhoa2.bean.Login;
import br.com.projecao.trabalhoa2.facade.LoginFacade;




public class TelaLogin extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;  //Serialização
	//Login
	private JLabel lbLogin;
	private JTextField txtLogin;
	//Senha
	private JLabel lbSenha;
	private JPasswordField txtSenha;
	//Botoes
	private JButton btnLogar;
	private JButton btnLimpar;
	//tentativas
	int tentativas;
	private LoginFacade Login;
	private JLabel Imagem;
	private JPanel Pass;

	
    //Gets e Set
	
	
	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JPanel getPass() {
		return Pass;
	}

	public void setPass(JPanel pass) {
		Pass = pass;
	}

	public JLabel getImagem() {
		return Imagem;
	}

	public void setImagem(JLabel imagem) {
		Imagem = imagem;
	}

	public LoginFacade getLogin() {
		if(Login == null){
			Login = new LoginFacade();
		}
		return Login;
	}

	public void setLogin(LoginFacade login) {
		Login = login;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}

		public JButton getBtnLogar() {
		return btnLogar;
	}

	public void setBtnLogar(JButton btnLogar) {
		this.btnLogar = btnLogar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public JLabel getLbLogin() {
		return lbLogin;
	}

	public void setLbLogin(JLabel lbLogin) {
		this.lbLogin = lbLogin;
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(JTextField txtLogin) {
		this.txtLogin = txtLogin;
	}

	public JLabel getLbSenha() {
		return lbSenha;
	}

	public void setLbSenha(JLabel lbSenha) {
		this.lbSenha = lbSenha;
	}

	
	public TelaLogin(){
		this.setTitle("Login");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		lbLogin = new JLabel("Login");
		lbLogin.setBounds(70, 25, 80, 20);
		txtLogin =  new JTextField(10);
		txtLogin.setBounds(110, 25, 100, 20);
		
		lbSenha = new JLabel("Senha");
		lbSenha.setBounds(70, 50, 80, 20);
		txtSenha = new JPasswordField(10);
		txtSenha.setBounds(110, 50, 100, 20);
		
		Pass = new JPanel(new FlowLayout());
		Pass.setBorder(BorderFactory.createTitledBorder("Login"));
		Pass.setBackground(b.getB());
		Pass.setBounds(75, 15, 190, 100);
		
		Pass.add(lbLogin);
		Pass.add(txtLogin);
		Pass.add(lbSenha);
		Pass.add(txtSenha);
		
		Imagem = new JLabel(new ImageIcon("Images/decrypted.png"));
		Imagem.setBounds(3,32, 65, 65);
		
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new AcaoLogar());
		btnLogar.setBounds(40,125, 80, 20);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new AcaoBtnLimpar());
		btnLimpar.setBounds(150,125, 80, 20);
		
		
		
		getContentPane().add(Imagem);
		getContentPane().add(Pass);
		getContentPane().add(btnLogar);
		getContentPane().add(btnLimpar);
		
		 //Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/agenda.png");  
		setIconImage(imagemTituloJanela.getImage());  
		

		this.setVisible(true);
		this.setSize(300,200);
		this.setModal(true);
		
	
	
	}



	public void limparCampos() {
		txtLogin.setText("");
		txtSenha.setText("");
		
	}
	private class AcaoBtnLimpar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			limparCampos();
		}

	}
	
	
	private class AcaoLogar implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			//Criar um objeta da classe login
			Login l = new Login();
			boolean b = false;
			
			if (txtLogin.getText() == null || txtLogin.getText().equals("")) {
				b = true;
			} else {
				l.setLogin(txtLogin.getText());
			}
			
			if (txtSenha.getPassword() == null || txtSenha.getPassword().equals("")) {
				b = true;
			} else {
				l.setSenha(new String(txtSenha.getPassword()));
			}
			
			if(b){
				JOptionPane.showMessageDialog(null, "Usuario/Senha invalidos!\nFavor Tentar Novamente", "Mensagem de Erro!",
						JOptionPane.ERROR_MESSAGE);
			}else{
				if(getLogin().validar(l)){
					dispose();
					setVisible(false);
					new TelaPrincipal(getLogin().validarperfil(l));
				}
				else{
					tentativas++;
					if (tentativas == 4){
						JOptionPane.showMessageDialog(null, "Este login encontrar-se bloqueado, favor entrar em contato com a administração do sistema!", "Mensagem de Erro!",
								JOptionPane.ERROR_MESSAGE);
						System.exit(0);						
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Usuario/Senha invalidos!\nFavor Tentar Novamente", "Mensagem de Erro!",
								JOptionPane.ERROR_MESSAGE);
					}
					
					}
				
					
				}
			}
			
		}
	
}
