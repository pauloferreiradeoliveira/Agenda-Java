package br.com.projecao.trabalhoa2.view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.projecao.trabalhoa2.bean.TipoContato;
import br.com.projecao.trabalhoa2.facade.TipoContatoFacade;


public class TelaEditaTipoContato extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTipoContato;
	private JLabel lblTipoContato;
	private JTextField txtDescricao;
	private JLabel lblDescricao;
	private JLabel lblValidacao;
	
	private JButton btnSalvar;
	private TipoContatoFacade Facade;
	private TipoContato Tipo;
	
	
	


	public TipoContato getTipo() {
		return Tipo;
	}

	public void setTipo(TipoContato tipo) {
		Tipo = tipo;
	}

	public TipoContatoFacade getFacade() {
		if(Facade == null){
			Facade = new TipoContatoFacade();
		}
		return Facade;
	}

	public void setFacade(TipoContatoFacade facade) {
		Facade = facade;
	}

	public JLabel getLblValidacao() {
		return lblValidacao;
	}

	public void setLblValidacao(JLabel lblValidacao) {
		this.lblValidacao = lblValidacao;
	}



	public JTextField getTxtTipoContato() {
		return txtTipoContato;
	}

	public void setTxtTipoContato(JTextField txtTipoContato) {
		this.txtTipoContato = txtTipoContato;
	}

	public JLabel getLblTipoContato() {
		return lblTipoContato;
	}

	public void setLblTipoContato(JLabel lblTipoContato) {
		this.lblTipoContato = lblTipoContato;
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


	public TelaEditaTipoContato(TipoContato d) {
		Tipo = getFacade().pesquisarEditarTipo(d);
		this.setTitle("Cadastrar Tipo de Contato");
		this.setLayout(null);
		Cor b = new Cor();
		getContentPane().setBackground(b.getB());
		
		//Tipo
		txtTipoContato = new JTextField(20);
		txtTipoContato.setBounds(125, 10, 300, 20);
		txtTipoContato.setText(Tipo.getContato());
		lblTipoContato = new JLabel("*Tipo de Contado:");
		lblTipoContato.setBounds(10, 10, 120,20);
		
		//Endereco
		txtDescricao = new JTextField(30);
		txtDescricao.setBounds(100, 35, 325, 20);
		txtDescricao.setText(Tipo.getDescricao());
		lblDescricao = new JLabel("  Descricao:");
		lblDescricao.setBounds(10,35,80,20);
		
		 //Icone  
		ImageIcon imagemTituloJanela = new ImageIcon("Images/Tipo.png");  
		setIconImage(imagemTituloJanela.getImage());  
		
		
		lblValidacao= new JLabel("* São Campos obrigatorios");
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AcaoBtnSalvar());
		btnSalvar.setBounds(220, 70, 100, 25);
		lblValidacao.setForeground(Color.RED);
		lblValidacao.setBounds(10, 100, 400,25);

		getContentPane().add(lblTipoContato);
		getContentPane().add(txtTipoContato);
		getContentPane().add(lblDescricao);
		getContentPane().add(txtDescricao);
		
		getContentPane().add(btnSalvar);
	
		
		getContentPane().add(lblValidacao);
		this.setLocation(200,200);
		this.setSize(460, 180);
		this.setModal(true);
		this.setVisible(true);

	}	 

	private class AcaoBtnSalvar implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			TipoContato p = new TipoContato();
			String msg = "O(s) campo(s) abaixo é/são de preechimento obrigatório";
			boolean b = false;
			
			//Contato
			if (txtTipoContato.getText() == null || txtTipoContato.getText().equals("")) {
				msg += "\nContato";
				b = true;
			} else {
				p.setContato(txtTipoContato.getText());
			}
			
					
			if (b) {
				JOptionPane.showMessageDialog(null, msg, "Mensagem de Erro!",JOptionPane.ERROR_MESSAGE);
			} else {
				p.setDescricao(txtDescricao.getText());
				p.setId(Tipo.getId());
				getFacade().EditarTipoCOntato(p);
			    setVisible(false);
			}
		}
	}

	
}
