package br.com.projecao.trabalhoa2.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;


import br.com.projecao.trabalhoa2.bean.Contatos;
import br.com.projecao.trabalhoa2.dao.jcombobox.Endereco;
import br.com.projecao.trabalhoa2.dao.jcombobox.Tp_Contato;
import br.com.projecao.trabalhoa2.dao.jcombobox.Usuario;
import br.com.projecao.trabalhoa2.facade.ContatosFacade;
import br.com.projecao.trabalhoa2.facade.RecuperarFacade;



public class TelaCadastroContato extends JDialog  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JLabel lblNome;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JFormattedTextField txtFixo;
	private JLabel lblFixo;
	private JFormattedTextField txtCelular;
	private JLabel lblCelular;
	private JComboBox comUsuario;
	private JLabel lblUsuario;
	private JComboBox comEndereco;
	private JLabel lblEndereco;
	private JComboBox comativo;
	private JLabel lblativo1;
	private JComboBox comTipo;
	private JLabel lblTipo;
	private JLabel lblValidacao;
	private RecuperarFacade Facede;
	private ContatosFacade Contato;

	
	private JButton btnSalvar;
	private JButton btnSair;
	 
	
	
	

	


	public ContatosFacade getContato() {
		if(Contato == null){
			Contato = new ContatosFacade();
		}
		return Contato;
	}

	public void setContato(ContatosFacade contato) {
		Contato = contato;
	}

	public RecuperarFacade getFacede() {
		if(Facede == null){
			Facede = new RecuperarFacade();
		}
		return Facede;
	}

	public void setFacede(RecuperarFacade facede) {
		Facede = facede;
	}

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

	public JComboBox getComTipo() {
		return comTipo;
	}

	public void setComTipo(JComboBox comTipo) {
		this.comTipo = comTipo;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
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

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	

	public JLabel getLblFixo() {
		return lblFixo;
	}

	public void setLblFixo(JLabel lblFixo) {
		this.lblFixo = lblFixo;
	}

	

	public JFormattedTextField getTxtFixo() {
		return txtFixo;
	}

	public void setTxtFixo(JFormattedTextField txtFixo) {
		this.txtFixo = txtFixo;
	}

	public JFormattedTextField getTxtCelular() {
		return txtCelular;
	}

	public void setTxtCelular(JFormattedTextField txtCelular) {
		this.txtCelular = txtCelular;
	}

	public JLabel getLblCelular() {
		return lblCelular;
	}

	public void setLblCelular(JLabel lblCelular) {
		this.lblCelular = lblCelular;
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

	public TelaCadastroContato() {
		this.setTitle("Cadastrar Contatos");
		this.setLayout(null);
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		//Nome
		txtNome = new JTextField(34);
		lblNome = new JLabel("*Nome:");
		
		
		//Email
		txtEmail = new JTextField(20);
		lblEmail = new JLabel("*Email:");
		
		//Celular
		try {
			MaskFormatter masktel = new MaskFormatter("(##)####-####");
			masktel.setValidCharacters("0123456789");
			txtCelular = new JFormattedTextField(masktel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lblCelular = new JLabel("*Telefone Celular:");
	
		//Fixo
		try {
			MaskFormatter masktel = new MaskFormatter("(##)####-####");
			masktel.setValidCharacters("0123456789");
			txtFixo = new JFormattedTextField(masktel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lblFixo = new JLabel("*Telefone Fixo:");
		
		//Endereco
		
		comEndereco = new JComboBox();
		getFacede().retornaEndereco(comEndereco);
		lblEndereco = new JLabel(" Endereco:");
		
		//Usuario
		comUsuario = new JComboBox();	
		getFacede().retornaUsuario(comUsuario);
		lblUsuario = new JLabel("Usuario:");
		
		//Tipo
		comTipo = new JComboBox();	
		getFacede().retornaTp_Contato(comTipo);
		lblTipo = new JLabel("Tipo:");
		
		//Ativo
		String[] lista = {"Ativo","Inativo"};
		comativo = new JComboBox(lista);
		lblativo1 = new JLabel("Estado:");
		
		//Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/add_con.png");  
		setIconImage(imagemTituloJanela.getImage()); 
		
		lblValidacao= new JLabel("* São Campos obrigatorios");
		lblValidacao.setForeground(Color.RED);  
		 
		
		btnSair = new JButton("Limpar");
		btnSair.addActionListener(new AcaoBtnLimpar());
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoBtnSalvar());

		
		//Onde ficarar cada componete na tela
		lblNome.setBounds(10, 10, 70, 20);
		txtNome.setBounds(60, 10, 180, 20);
		lblTipo.setBounds(260, 10, 50, 20);
		comTipo.setBounds(300, 10, 100, 20);
		lblEmail.setBounds(10,35,50,20);
		txtEmail.setBounds(60,35 ,180, 20);
		
		lblativo1.setBounds(250, 35, 50, 20);
		comativo.setBounds(300,35, 100,20);
		lblFixo.setBounds(10,60,90,20);
		txtFixo.setBounds(100, 60, 90, 20);
		lblCelular.setBounds(200,60,100,20);
		txtCelular.setBounds(310, 60, 90, 20);
		lblEndereco.setBounds(10, 85, 70, 20);
		comEndereco.setBounds(80, 85, 320, 20);
		lblUsuario.setBounds(10,110,50,20);
		comUsuario.setBounds(60,110 ,180, 20);
		btnSair.setBounds(100, 135, 80, 25);
		btnSalvar.setBounds(230, 135, 80, 25);
		lblValidacao.setBounds(10,165,300,25);
		
		
		
		
		
		getContentPane().add(lblNome);
		getContentPane().add(txtNome);
		getContentPane().add(lblEmail);
		getContentPane().add(txtEmail);
		getContentPane().add(lblCelular);
		getContentPane().add(txtCelular);
		getContentPane().add(lblFixo);
		getContentPane().add(txtFixo);
		
		getContentPane().add(lblEndereco);
		getContentPane().add(comEndereco);
		
		getContentPane().add(lblUsuario);
		getContentPane().add(comUsuario);
		
		getContentPane().add(lblTipo);
		getContentPane().add(comTipo);
		
		getContentPane().add(lblativo1);
		getContentPane().add(comativo);
		
		getContentPane().add(btnSalvar);
		getContentPane().add(btnSair);
		
		getContentPane().add(lblValidacao);
		
		this.setLocation(200,200);
		this.setSize(460, 210);
		this.setModal(true);
		this.setVisible(true);

	}
	


	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Contatos p = new Contatos();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			boolean b = false;
			JFormattedTextField telefone = new JFormattedTextField();
		
			try {
				MaskFormatter maskTEL = new MaskFormatter("(##)####-####");
				telefone = new JFormattedTextField(maskTEL);

			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			//Nome
			if (txtNome.getText() == null || txtNome.getText().equals("")) {
				msg += "\nNome";
				b = true;
				 
			} else {
				p.setNome(txtNome.getText());
				
			}
			//Email
			if (txtEmail.getText() == null || txtEmail.getText().equals("")) {
				msg += "\nEmail";
				b = true;
				 
			} else {
				p.setEmail(txtEmail.getText());	
				 
			}
			
			//Celular
			if (txtCelular.getText().equals(telefone.getText())) {
				msg += "\nCelular";
				b = true;
				lblCelular.setForeground(Color.RED);  
			} else {
				p.setCelular(txtCelular.getText());	
				 
			}
			
			//Fixo
			if (txtFixo.getText().equals(telefone.getText())) {
				msg += "\nFixo";
				b = true;
				  
			} else {
				p.setFixo(txtFixo.getText());
				
			}
			
			String p1 = (String) comativo.getSelectedItem();
			if(p1 == "ativo"){
				p.setIs_ativo(true);
			}
			else
			{
				p.setIs_ativo(false);
			}
			
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String Data = dateFormat.format(date);
		     p.setData(Data);
										
			if (b) {
				JOptionPane.showMessageDialog(null, msg, "Mensagem de Erro!",JOptionPane.ERROR_MESSAGE);
			} else {	
				
				Tp_Contato i = (Tp_Contato) comTipo.getSelectedItem();  
				int id = Integer.parseInt(i.getId());
				p.setTp_contato(id);
				
				Usuario o = (Usuario) comUsuario.getSelectedItem();  
				int id1 = Integer.parseInt(o.getId());
				p.setUsuario(id1);
				
				Endereco s = (Endereco) comEndereco.getSelectedItem();  
				int id2 = Integer.parseInt(s.getId());
				p.setEndereco(id2);
				
				
				 getContato().Salvar(p);
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
		txtCelular.setText("");
		txtEmail.setText("");
		txtFixo.setText("");
		txtNome.setText("");
		
	}
}

