package br.com.projecao.trabalhoa2.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.projecao.trabalhoa2.bean.Endereco;
import br.com.projecao.trabalhoa2.facade.EnderecoFacade;




public class TelaCadastroEndereco extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFormattedTextField txtCEP;
	private JLabel lblCEP;
	private JTextField txtEndereco;
	private JLabel lblEndereco;
	private JTextField txtCidade;
	private JLabel lblCidade;
	private JTextField txtEstado;
	private JLabel lblEstado;
	private JTextField txtPais;
	private JLabel lblPais;
	private JLabel lblValidacao;
	private EnderecoFacade Endereco;
	

	private JButton btnSalvar;
	private JButton btnSair;



	
	public EnderecoFacade getEndereco() {
		if(Endereco == null){
			Endereco = new EnderecoFacade();
		}
		return Endereco;
	}

	public void setEndereco(EnderecoFacade endereco) {
		Endereco = endereco;
	}

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(JTextField txtEstado) {
		this.txtEstado = txtEstado;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public JTextField getTxtPais() {
		return txtPais;
	}

	public void setTxtPais(JTextField txtPais) {
		this.txtPais = txtPais;
	}

	public JLabel getLblPais() {
		return lblPais;
	}

	public void setLblPais(JLabel lblPais) {
		this.lblPais = lblPais;
	}

	public JTextField getTxtCEP() {
		return txtCEP;
	}

	public void setTxtCEP(JFormattedTextField txtCEP) {
		this.txtCEP = txtCEP;
	}

	public JLabel getLblCEP() {
		return lblCEP;
	}

	public void setLblCEP(JLabel lblCEP) {
		this.lblCEP = lblCEP;
	}

	public JTextField getTxtEndereco() {
		return txtEndereco;
	}

	public void setTxtEndereco(JTextField txtEndereco) {
		this.txtEndereco = txtEndereco;
	}

	public JLabel getLblEndereco() {
		return lblEndereco;
	}

	public void setLblEndereco(JLabel lblEndereco) {
		this.lblEndereco = lblEndereco;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public void setTxtCidade(JTextField txtCidade) {
		this.txtCidade = txtCidade;
	}

	public JLabel getLblCidade() {
		return lblCidade;
	}

	public void setLblCidade(JLabel lblCidade) {
		this.lblCidade = lblCidade;
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

	public TelaCadastroEndereco() {
		this.setTitle("Cadastrar Endereco");
		this.setLayout(null);
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		//Cep
		try {
			MaskFormatter masktel = new MaskFormatter("#####-###");
			masktel.setValidCharacters("0123456789");
			txtCEP = new JFormattedTextField(masktel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCEP.setBounds(60, 10, 75, 20);
		lblCEP = new JLabel("* CEP: ");
		lblCEP.setBounds(10, 10, 40, 20);
		
		
		
		//Cidade
		lblCidade = new JLabel("*Cidade:");
		lblCidade.setBounds(145, 10, 60, 20);
		txtCidade = new JTextField(15);
		txtCidade.setBounds(210, 10, 150, 20);
		
		//Estado
		lblEstado = new JLabel("* Estado:");
		lblEstado.setBounds(10, 35,  60, 20);
		txtEstado = new JTextField(10);
		txtEstado.setBounds(75, 35,  150, 20);
		
		
		//Endereco
		txtEndereco = new JTextField(27);
		txtEndereco.setBounds(90, 60,  270, 20);
		lblEndereco = new JLabel("* Endereco:");
		lblEndereco.setBounds(10, 60,  90, 20);
		
		//Pais
		lblPais = new JLabel("* Pais:");
		lblPais.setBounds(230, 35,  55, 20);
		txtPais = new JTextField(9);
		txtPais.setBounds(280, 35,  80, 20);
		
		//Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/casa.png");  
		setIconImage(imagemTituloJanela.getImage()); 
		
		lblValidacao= new JLabel("* São Campos obrigatorios");
		lblValidacao.setForeground(Color.RED); 
		lblValidacao.setBounds(10, 110, 200, 20);
		
		btnSair = new JButton("Limpar");
		btnSair.addActionListener(new AcaoBtnLimpar());
		btnSair.setBounds(100, 85,  90, 20);
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoBtnSalvar());
		btnSalvar.setBounds(200, 85,  90, 20);

		getContentPane().add(lblCEP);
		getContentPane().add(txtCEP);
		
		getContentPane().add(lblCidade);
		getContentPane().add(txtCidade);
		getContentPane().add(lblEstado);
		getContentPane().add(txtEstado);
		
		getContentPane().add(lblPais);
		getContentPane().add(txtPais);
		getContentPane().add(lblEndereco);
		getContentPane().add(txtEndereco);
     	
		getContentPane().add(btnSalvar);
		getContentPane().add(btnSair);
		getContentPane().add(lblValidacao);
		this.setLocation(200,200);
		this.setSize(390, 180);
		this.setModal(true);
		this.setVisible(true);

	}

	

	 

	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Endereco p = new Endereco();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			
			boolean b = false;
			
			//CEP
			if (txtCEP.getText() == null || txtCEP.getText().equals("")) {
				msg += "\nCEP";
				b = true;
			} else {
				p.setCep(txtCEP.getText());
			}
			
			// Endereco
			if (txtEndereco.getText() == null || txtEndereco.getText().equals("")) {
				msg += "\nEndereço";
				b = true;
			} else {
				p.setEndereco(txtEndereco.getText());
			}
			
			//Cidade
			if (txtCidade.getText() == null || txtCidade.getText().equals("")) {
				msg += "\nCidade";
				b = true;
			} else {
				p.setCidade(txtCidade.getText());
			}
			
			
		
			//Pais
			if (txtPais.getText() == null || txtPais.getText().equals("")) {
				msg += "\nPais";
				b = true;
			} else {
				p.setPais(txtPais.getText());
			}
			//Estado
			if (txtEstado.getText() == null || txtEstado.getText().equals("")) {
				msg += "\nEstado";
				b = true;
			} else {
				
				p.setEstado(txtEstado.getText());
				
			}

			
			if (b) {
				JOptionPane.showMessageDialog(null, msg, "Mensagem de Erro!",JOptionPane.ERROR_MESSAGE);
			} else {
				getEndereco().salvarEndereco(p);
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
		txtCEP.setText("");
		txtEndereco.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtPais.setText("");
	}
}
