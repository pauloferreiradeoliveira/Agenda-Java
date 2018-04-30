package br.com.projecao.trabalhoa2.view;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


import br.com.projecao.trabalhoa2.bean.Usuario;
import br.com.projecao.trabalhoa2.dao.jcombobox.Endereco;
import br.com.projecao.trabalhoa2.facade.RecuperarFacade;
import br.com.projecao.trabalhoa2.facade.UsuarioFacade;






public class TelaCadastroUsuario extends JDialog {
	private static final long serialVersionUID = 1L;
	private JFormattedTextField  txtcpf;
	private JLabel lblcpf;
	private JTextField txtNome;
	private JLabel lblNome;
	private JFormattedTextField  txtTelefone;
	private JLabel lblTelefone;
	private JFormattedTextField  txtrg;
	private JLabel lblrg;
	private JComboBox comativo;
	private JLabel lblativo1;
	private JComboBox txtestadocivil;
	private JLabel lblestadocivil;
	private JComboBox comEndereco;
	private JLabel lblEndereco;
	private UsuarioFacade Usuario;
	private RecuperarFacade Recupera;
	
	private JLabel lblValidacao;
	
	//Facade do Recupera Combo
	public RecuperarFacade getRecupera() {
		if (Recupera == null) {
			 Recupera = new RecuperarFacade();
		}
		return Recupera;
	}

	public void setRecupera(RecuperarFacade recupera) {
		Recupera = recupera;
	}

	//Facade do Usuario
	public UsuarioFacade getUsuario() {
		if (Usuario == null){
			  Usuario = new UsuarioFacade();	
			}
				return Usuario;
	}

	public void setUsuario(UsuarioFacade usuario) {
		Usuario = usuario;
	}

	private JButton btnSalvar;
	private JButton btnSair;
	
	
	
	public JComboBox getComativo() {
		return comativo;
	}

	public void setComativo(JComboBox comativo) {
		this.comativo = comativo;
	}

	public JLabel getLblativo1() {
		return lblativo1;
	}

	public void setLblativo1(JLabel lblativo1) {
		this.lblativo1 = lblativo1;
	}



	public JComboBox getTxtestadocivil() {
		return txtestadocivil;
	}

	public void setTxtestadocivil(JComboBox txtestadocivil) {
		this.txtestadocivil = txtestadocivil;
	}

	public JLabel getLblestadocivil() {
		return lblestadocivil;
	}

	public void setLblestadocivil(JLabel lblestadocivil) {
		this.lblestadocivil = lblestadocivil;
	}

	

	public JFormattedTextField getTxtcpf() {
		return txtcpf;
	}

	public void setTxtcpf(JFormattedTextField txtcpf) {
		this.txtcpf = txtcpf;
	}

	public JLabel getLblcpf() {
		return lblcpf;
	}

	public void setLblcpf(JLabel lblcpf) {
		this.lblcpf = lblcpf;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}



	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
	}



	public JFormattedTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JFormattedTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public JFormattedTextField getTxtrg() {
		return txtrg;
	}

	public void setTxtrg(JFormattedTextField txtrg) {
		this.txtrg = txtrg;
	}

	public JLabel getLblrg() {
		return lblrg;
	}

	public void setLblrg(JLabel lblrg) {
		this.lblrg = lblrg;
	}

	public JComboBox getComEndereco() {
		return comEndereco;
	}

	public void setComEndereco(JComboBox comEndereco) {
		this.comEndereco = comEndereco;
	}

	public JLabel getLblEndereco() {
		return lblEndereco;
	}

	public void setLblEndereco(JLabel lblEndereco) {
		this.lblEndereco = lblEndereco;
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

	public  TelaCadastroUsuario() {
		
	   this.setTitle("Cadastrar Usuario");
		this.setLayout(null);
		
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		//Cpf
		
		try {
			MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
			maskCpf.setValidCharacters("0123456789");
			txtcpf = new JFormattedTextField(maskCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtcpf.setBounds(new Rectangle(60, 10, 100, 20));
		lblcpf = new JLabel("* CPF:");
		lblcpf.setBounds(new Rectangle(10, 10, 40, 20));
		
		//Nome
		txtNome = new JTextField(25);
		txtNome.setBounds(new Rectangle(60, 40, 266, 20));
		lblNome = new JLabel("*Nome:");
		lblNome.setBounds(new Rectangle(10, 40, 50, 20));
		
		//telefone
		try {
			MaskFormatter masktel = new MaskFormatter("########");
			masktel.setValidCharacters("0123456789");
			txtTelefone = new JFormattedTextField(masktel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtTelefone.setBounds(new Rectangle(220, 100, 106, 20));
		lblTelefone = new JLabel("*Telefone:");
		lblTelefone.setBounds(new Rectangle(160, 100, 80, 20));
		
		
		//rg
		try {
		MaskFormatter maskrg = new MaskFormatter("#######");
		maskrg.setValidCharacters("0123456789");
		txtrg = new JFormattedTextField(maskrg);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		txtrg.setBounds(new Rectangle(220, 10, 106, 20));
		lblrg = new JLabel("*RG:");
		lblrg.setBounds(new Rectangle(170, 10, 40, 20));
		
		//Estado Civil
		String[] estado = {"Solteiro(a)","Casado(a)","Separado(a)","Divorciado(a)","Viúvo(a)"};
		txtestadocivil = new JComboBox(estado);
		txtestadocivil.setBounds(new Rectangle(95, 130, 100, 20));
			
		lblestadocivil = new JLabel("*Estado Civil:");
		lblestadocivil.setBounds(new Rectangle(10, 130, 150, 20));
		
		
		//Endereco
		comEndereco = new JComboBox();
		getRecupera().retornaEndereco(comEndereco);
		comEndereco.setBounds(new Rectangle(82, 70, 245, 20));
		lblEndereco = new JLabel(" Endereco:");
		lblEndereco.setBounds(new Rectangle(10, 70, 80, 20));
		
		//Ativo
		String[] lista = {"Ativo","Inativo"};
		comativo = new JComboBox(lista);
		comativo.setBounds(new Rectangle(60, 100, 81, 20));
		lblativo1 = new JLabel("Tipo:");
		lblativo1.setBounds(new Rectangle(10, 100, 80, 20));
		
				
		
		lblValidacao= new JLabel("* São Campos obrigatorios  ");
		lblValidacao.setBounds(new Rectangle(10, 190, 300, 25));
		lblValidacao.setForeground(Color.RED);
		btnSair = new JButton("Limpar");
		btnSair.setBounds(new Rectangle(80, 160, 81, 25));
		btnSair.addActionListener(new AcaoBtnLimpar());
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(new Rectangle(200, 160, 81, 25));
		btnSalvar.addActionListener(new AcaoBtnSalvar());
		
		//Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/Usuario.png");  
		setIconImage(imagemTituloJanela.getImage()); 

		getContentPane().add(lblcpf);
		getContentPane().add(txtcpf);
		getContentPane().add(lblrg);
		getContentPane().add(txtrg);
		getContentPane().add(lblNome);
		getContentPane().add(txtNome);

		getContentPane().add(lblTelefone);
		getContentPane().add(txtTelefone);
		

		getContentPane().add(lblestadocivil);
		getContentPane().add(txtestadocivil);
		

		getContentPane().add(lblEndereco);
		getContentPane().add(comEndereco);
		
		getContentPane().add(lblativo1);
		getContentPane().add(comativo);
		

		
		getContentPane().add(btnSalvar);
		getContentPane().add(btnSair);
		
		getContentPane().add(lblValidacao);
		
		this.setLocation(200,200);
		this.setSize(360, 250);
		this.setModal(true);
		this.setVisible(true);
		this.setResizable(false);

	}
	
	
	public static void main(String[] args) {
		new TelaCadastroUsuario();
	}
	

	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JFormattedTextField RG = new JFormattedTextField();
			JFormattedTextField telefone = new JFormattedTextField();
			JFormattedTextField cpf = new JFormattedTextField();

			try {
				MaskFormatter maskRG = new MaskFormatter("#######");
				MaskFormatter maskTEL = new MaskFormatter("########");
				MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");

				RG = new JFormattedTextField(maskRG);
				telefone = new JFormattedTextField(maskTEL);
				cpf = new JFormattedTextField(maskCpf);

			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			Usuario p = new Usuario();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			boolean b = false;
			
			//CPF
			if (txtcpf.getText().equals(cpf.getText())) {
				msg += "\ncpf";
				b = true;
			} else {
				p.setCpf(txtcpf.getText());
			}
			//Nome
			if (txtNome.getText() == null || txtNome.getText().equals("")) {
				msg += "\nNome";
				b = true;
			} else {
				p.setNome(txtNome.getText());	
			}
			//RG
			if (txtrg.getText().equals(RG.getText()) ) {
				msg += "\nRG";
				b = true;
			} else {
				p.setRg(Integer.parseInt(txtrg.getText()));	
						}
			
			
			
			//Telefone
			if (txtTelefone.getText().equals(telefone.getText())) {
				msg += "\nTelefone";
				b = true;
			} else {
				p.setTelefone(Integer.parseInt(txtTelefone.getText()));	
			}
			
			
			
			
			String p1 = (String) comativo.getSelectedItem();
			if(p1 == "ativo"){
				p.setIs_ativo(true);
			}
			else
			{
				p.setIs_ativo(false);
			}
										
			if (b) {
				JOptionPane.showMessageDialog(null, msg, "Mensagem de Erro!",JOptionPane.ERROR_MESSAGE);
			} else {	
				
				//Para Selecionar O Endereco
				Endereco o = (Endereco) comEndereco.getSelectedItem(); //Retorna na Classe Endereco do pacote item 
				int id1 = Integer.parseInt(o.getId());//Pega o valor numerico
				p.setEndereco(id1);//Passa o Endereco para A bean Usuario
				
								
				//Para Selecionar O estado Civil 
				String Estado = (String) txtestadocivil.getSelectedItem();
				p.setEstado_civil(Estado);
				
				getUsuario().salvarUsuario(p);//Para Salavar o Usuario no Banco
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
		txtcpf.setText("");
		txtNome.setText("");
		txtrg.setText("");
		txtTelefone.setText("");
		
	}
	
}
