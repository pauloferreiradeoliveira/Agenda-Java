package br.com.projecao.trabalhoa2.view;


import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.projecao.trabalhoa2.bean.Perfil;
import br.com.projecao.trabalhoa2.facade.PerfilFacade;

public class TelaCadastroPerfil extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPerfil;
	private JLabel lblPerfil;
	private JTextField txtDescricao;
	private JLabel lblDescricao;
	private JLabel lblValidacao;
	
	private JButton btnSalvar;
	private JButton btnSair;
	private PerfilFacade PerfilDAO;
	
	


	public PerfilFacade getPerfilDAO() {
		if(PerfilDAO == null){
			PerfilDAO = new PerfilFacade();
		}
		return PerfilDAO;
	}

	public void setPerfilDAO(PerfilFacade perfilDAO) {
		PerfilDAO = perfilDAO;
	}

	public JLabel getLblValidacao() {
		return lblValidacao;
	}

	public void setLblValidacao(JLabel lblValidacao) {
		this.lblValidacao = lblValidacao;
	}

	public JTextField getTxtPerfil() {
		return txtPerfil;
	}

	public void setTxtPerfil(JTextField txtPerfil) {
		this.txtPerfil = txtPerfil;
	}

	public JLabel getLblPerfil() {
		return lblPerfil;
	}

	public void setLblPerfil(JLabel lblPerfil) {
		this.lblPerfil = lblPerfil;
	}

	public JTextField getTxtDescricao() {
		return txtDescricao;
	}

	public void setTxtDescricao(JTextField txtDescricao) {
		this.txtDescricao = txtDescricao;
	}

	public JLabel getLblDescricao() {
		return lblDescricao;
	}

	public void setLblDescricao(JLabel lblDescricao) {
		this.lblDescricao = lblDescricao;
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

	public TelaCadastroPerfil() {
		this.setTitle("Cadastrar Perfil");
		this.setLayout(null);
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		//Nome
		txtPerfil = new JTextField(30);
		txtPerfil.setBounds(new Rectangle(70,10,126, 20));
		lblPerfil = new JLabel("* Perfil: ");
		lblPerfil.setBounds(new Rectangle(10, 10, 70, 20));
		
		//Endereco
		txtDescricao = new JTextField(30);
		txtDescricao.setBounds(new Rectangle(70,35,250, 20));
		lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(new Rectangle(6, 35, 70, 20));
		
		
		//Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/add.png");  
		setIconImage(imagemTituloJanela.getImage()); 
		
		lblValidacao= new JLabel("* São Campos obrigatorios");
		lblValidacao.setForeground(Color.RED);
		lblValidacao.setBounds(new Rectangle(10,85,250, 20));
		
		btnSair = new JButton("Limpar");
		btnSair.addActionListener(new AcaoBtnLimpar());
		btnSair.setBounds(new Rectangle(70,60,81, 20));
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoBtnSalvar());
		btnSalvar.setBounds(new Rectangle(180,60,81, 20));

		getContentPane().add(lblPerfil);
		getContentPane().add(txtPerfil);
		getContentPane().add(lblDescricao);
		getContentPane().add(txtDescricao);
		
		getContentPane().add(btnSalvar);
		getContentPane().add(btnSair);
		
		getContentPane().add(lblValidacao);
		
		this.setLocation(200,200);
		this.setSize(350, 180);
		this.setModal(true);
		this.setVisible(true);

	}


	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Perfil p = new Perfil();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			boolean b = false;
			
			//Perfil
			if (txtPerfil.getText() == null || txtPerfil.getText().equals("")) {
				msg += "\nPerfil";
				b = true;
			} else {
				p.setPerfil(txtPerfil.getText());
			}
			
			
						
			if (b) {
				JOptionPane.showMessageDialog(null, msg, "Mensagem de Erro!",JOptionPane.ERROR_MESSAGE);
			} else {	
				p.setDescricao(txtDescricao.getText());
				getPerfilDAO().salvarPerfil(p);
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
		txtPerfil.setText("");
		txtDescricao.setText("");
		
	}
	
}
