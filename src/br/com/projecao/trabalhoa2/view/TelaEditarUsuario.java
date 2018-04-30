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
import br.com.projecao.trabalhoa2.facade.UsuarioFacade;




public class TelaEditarUsuario extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField txtcpf;
	private JLabel lblcpf;
	private JTextField txtNome;
	private JLabel lblNome;
	private JFormattedTextField txtTelefone;
	private JLabel lblTelefone;
	private JFormattedTextField  txtrg;
	private JLabel lblrg;
	private JComboBox comativo;
	private JLabel lblativo1;
	private JComboBox txtestadocivil;
	private JLabel lblestadocivil;
	private JComboBox comEndereco;
	private JLabel lblEndereco;
	private Usuario Dados;
	private UsuarioFacade Usuario;
	
	private JLabel lblValidacao;
	
	
	public Usuario getDados() {
		return Dados;
	}

	public void setDados(Usuario dados) {
		Dados = dados;
	}

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

	public JTextField getTxtcpf() {
		return txtcpf;
	}

	public void setTxtcpf(JTextField txtcpf) {
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



	public JFormattedTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(JFormattedTextField txtTelefone) {
		this.txtTelefone = txtTelefone;
	}

	public JLabel getLblTelefone() {
		return lblTelefone;
	}

	public void setLblTelefone(JLabel lblTelefone) {
		this.lblTelefone = lblTelefone;
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



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public  TelaEditarUsuario(Usuario retorno) {
		Dados = getUsuario().pesquisaUsuarioEditar(retorno);
	   this.setTitle("Editar Usuario - " + Dados.getNome());
		this.setLayout(null);
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		
		//Cpf
		txtcpf = new JTextField(14);
		txtcpf.setText(Dados.getCpf());
		txtcpf.setEnabled(false);
		txtcpf.setBounds(new Rectangle(60, 10, 100, 20));
		lblcpf = new JLabel("* CPF:");
		lblcpf.setBounds(new Rectangle(10, 10, 40, 20));
		
		//Nome
		txtNome = new JTextField(25);
		txtNome.setText(Dados.getNome());
		lblNome = new JLabel("*Nome:");
		txtNome.setBounds(new Rectangle(60, 40, 266, 20));
		lblNome.setBounds(new Rectangle(10, 40, 50, 20));
		
		//telefone
		try {
			MaskFormatter masktel = new MaskFormatter("########");
			masktel.setValidCharacters("0123456789");
			txtTelefone = new JFormattedTextField(masktel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtTelefone.setText(String.valueOf(Dados.getTelefone()));
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
		txtrg.setText(String.valueOf(Dados.getRg()));
		txtrg.setBounds(new Rectangle(220, 10, 106, 20));
		lblrg = new JLabel("*  RG:");
		lblrg.setBounds(new Rectangle(170, 10, 40, 20));
		
		//Estado Civil
		String[] estado = {"Solteiro(a)","Casado(a)","Separado(a)","Divorciado(a)","Viúvo(a)"};
		txtestadocivil = new JComboBox(estado);
		txtestadocivil.setBounds(new Rectangle(95, 130, 100, 20));	
		txtestadocivil.setSelectedItem(Dados.getEstado_civil());
		lblestadocivil = new JLabel("*Estado Civil:");
		lblestadocivil.setBounds(new Rectangle(10, 130, 150, 20));
		
		//Perfil
		comEndereco = new JComboBox();
		getUsuario().ComboEditarEndereco(Dados, comEndereco);
		comEndereco.setBounds(new Rectangle(82, 70, 245, 20));
		lblEndereco = new JLabel(" Endereco:");
		lblEndereco.setBounds(new Rectangle(10, 70, 80, 20));
		
		//Ativo
		String[] lista = {"Ativo","Inativo"}; 
		comativo = new JComboBox(lista);
		
		if(Dados.isIs_ativo()){
			comativo.setSelectedIndex(0);
		}
		else{
			comativo.setSelectedIndex(1);
		}
		
		lblativo1 = new JLabel("Tipo:");
		comativo.setBounds(new Rectangle(60, 100, 81, 20));
		lblativo1.setBounds(new Rectangle(10, 100, 80, 20));
				
		
		lblValidacao= new JLabel("* São Campos obrigatorios  ");
		lblValidacao.setForeground(Color.RED);
		lblValidacao.setBounds(new Rectangle(10, 190, 300, 25));
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoBtnSalvar());
		btnSalvar.setBounds(new Rectangle(125, 160, 81, 25));
		
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
		getContentPane().add(lblValidacao);
		
		this.setLocation(200,200);
		this.setSize(360, 250);
		this.setModal(true);
		this.setVisible(true);
		this.setResizable(false);

	}


	
		

	

	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JFormattedTextField RG = new JFormattedTextField();
			JFormattedTextField telefone = new JFormattedTextField();
			

			try {
				MaskFormatter maskRG = new MaskFormatter("#######");
				MaskFormatter maskTEL = new MaskFormatter("########");

				RG = new JFormattedTextField(maskRG);
				telefone = new JFormattedTextField(maskTEL);

			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			Usuario p = new Usuario();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			boolean b = false;
			
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
			if(p1 == "Ativo"){
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
				
				p.setId(Dados.getId());//passa o Id para a beab Usuario
				
				p.setCpf(txtcpf.getText());
				
				//Para Selecionar O estado Civil 
				String Estado = (String) txtestadocivil.getSelectedItem();
				p.setEstado_civil(Estado);
				
				getUsuario().editarUsuario(p);//Para Salavar o Usuario no Banco
				setVisible(false);//Para fechar a tela
				

			}
		}
	}


	
}
