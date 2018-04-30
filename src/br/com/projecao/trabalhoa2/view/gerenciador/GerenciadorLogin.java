package br.com.projecao.trabalhoa2.view.gerenciador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import br.com.projecao.trabalhoa2.bean.Login;



import br.com.projecao.trabalhoa2.facade.LoginFacade;


import br.com.projecao.trabalhoa2.view.Cor;
import br.com.projecao.trabalhoa2.view.TelaCadastroEndereco;
import br.com.projecao.trabalhoa2.view.TelaCadastroLogin;

import br.com.projecao.trabalhoa2.view.TelaEditarLogin;




public class GerenciadorLogin extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JPanel painelTabela;
	private JPanel pesquisa;
	private JButton limpar;
	private JButton editar;
	private JButton excluir;
	private JButton Novo;
	private JButton Pesquisar;
	private JTextField txtpesquisa;
	private JTable tabela;
	private JScrollPane scroll;
	private List<Login> listaLogin = new ArrayList<Login>();
	private Login Login = new Login();
	private LoginFacade LoginFacade;
	private JComboBox comTipo;
		
	

	public JPanel getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(JPanel pesquisa) {
		this.pesquisa = pesquisa;
	}

	public JComboBox getComTipo() {
		return comTipo;
	}

	public void setComTipo(JComboBox comTipo) {
		this.comTipo = comTipo;
	}

	public JButton getPesquisar() {
		return Pesquisar;
	}

	public void setPesquisar(JButton pesquisar) {
		Pesquisar = pesquisar;
	}

	public JTextField getTxtpesquisa() {
		return txtpesquisa;
	}

	public void setTxtpesquisa(JTextField txtpesquisa) {
		this.txtpesquisa = txtpesquisa;
	}

	public JButton getNovo() {
		return Novo;
	}

	public void setNovo(JButton novo) {
		Novo = novo;
	}

	

	public JPanel getPainelTabela() {
		return painelTabela;
	}

	public void setPainelTabela(JPanel painelTabela) {
		this.painelTabela = painelTabela;
	}

	
	public JButton getLimpar() {
		return limpar;
	}

	public void setLimpar(JButton limpar) {
		this.limpar = limpar;
	}

	public JButton getEditar() {
		return editar;
	}

	public void setEditar(JButton editar) {
		this.editar = editar;
	}

	public JButton getExcluir() {
		return excluir;
	}

	public void setExcluir(JButton excluir) {
		this.excluir = excluir;
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	


	


	

	public List<Login> getListaLogin() {
		return listaLogin;
	}

	public void setListaLogin(List<Login> listaLogin) {
		this.listaLogin = listaLogin;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login login) {
		Login = login;
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

	public GerenciadorLogin() {
		
		this.setTitle("Gerencia de Login");//titulo da janela
		Cor b = new Cor();
		ImageIcon imagemTituloJanela = new ImageIcon("Images/Perfil.png");  
		setIconImage(imagemTituloJanela.getImage()); 
		this.setLayout(new FlowLayout());
		
		painelTabela = new JPanel();
		painelTabela.setLayout(new BorderLayout());
		tabela = new JTable();
		scroll = new JScrollPane();
		PreencherTabela(true);
		scroll.setViewportView(tabela);
		scroll.setPreferredSize(new Dimension(410, 130));// defeine tamanho da
															// tabela
		painelTabela.add(scroll);

		
		pesquisa = new JPanel(new FlowLayout());
		pesquisa.setBorder(BorderFactory.createTitledBorder("Pesquisa"));
		pesquisa.setBackground(b.getB());
		
	
		
		Pesquisar = new JButton(new ImageIcon("Images/pesquisa3.png"));
		Pesquisar.addActionListener(new Pesquisar());
		txtpesquisa = new JTextField(20);

		Novo = new JButton( new ImageIcon("Images/add (2).png"));
		Novo.addActionListener(new AcaoMenuCadastrarEndereco());
		
		excluir = new JButton(new ImageIcon("Images/Excuir.png"));
		excluir.addActionListener(new deletar());

		editar = new JButton(new ImageIcon("Images/etitar.png"));
		editar.addActionListener(new Editar());
		
		String[] lista = {"Login","Perfil","Usuario"};
		comTipo= new JComboBox(lista);
		
		pesquisa.add(txtpesquisa);
		pesquisa.add(comTipo);
		pesquisa.add(Pesquisar);
		getContentPane().add(pesquisa);
		
	
		
	
		

		
		
		getContentPane().add(painelTabela);
		getContentPane().add(Novo);
		getContentPane().add(editar);
		getContentPane().add(excluir);
		getContentPane().setBackground(b.getB());
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setSize(420, 290);// define o tamanho da tela
		this.setResizable(false);// nao permite redimencionar a tela
		this.setLocationRelativeTo(null);// faz com que a tela abra no centro
		this.setVisible(true);
	}

	
	private void PreencherTabela(boolean pesquisa) {
		//Vereficar Qual Preche tabela e...
       if(pesquisa){
		listaLogin = getLoginFacade().pesquisarLogin();
		}
       else{
    	   if (!(txtpesquisa.getText().equals("") || txtpesquisa.getText() == null)){
    		   String p1 = (String) comTipo.getSelectedItem();
    		   if(p1.equalsIgnoreCase("Usuario")){
    			   p1 = "nome";
    		   }
    	  	   listaLogin = getLoginFacade().pesquisarLoginPesquisa(txtpesquisa.getText(),p1); 
    	   if (listaLogin.size()<1){
    		   PreencherTabela(true);
    	   }
       }
    	   else{ //Se Ele for igual a null
    		   PreencherTabela(true);
    	   }
       }
		Vector<String> titulo = new Vector<String>();
		titulo.add("ID:");
		titulo.add("Login");
		titulo.add("Perfil");
		titulo.add("Usuario");

		
		
		Vector dados = new Vector();

		for (Login a : listaLogin) {

			Vector colunas = new Vector();

			colunas.add(a.getId());
			colunas.add(a.getLogin());
			colunas.add(a.getMostarPerfil());
			colunas.add(a.getMostarUsuario());
			dados.add(colunas);
		}
		DefaultTableModel model = new DefaultTableModel(dados, titulo);
		tabela.setModel(model);
		scroll.setViewportView(tabela);

	}
       
 
private class AcaoMenuCadastrarEndereco implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new TelaCadastroLogin();
			PreencherTabela(true);
		  			

		}
	}
private class deletar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			 if (tabela.getSelectedRow() == -1) {
			        JOptionPane.showMessageDialog(null, "É PRECISO SELECIONAR UM REGISTRO.");
			    } else {

			    	Login = listaLogin.get(tabela.getSelectedRow());
			        String nome=Login.getLogin();
			        
			   int pergunta=JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir:\n"+nome);
			    if(pergunta==0){
			    	if(getLoginFacade().deletarUsuario(Login)){
			    		JOptionPane.showMessageDialog(null, "USUARIO EXCUIDO");
			    		PreencherTabela(true);
			    	}
			    	
			
		}
	}
		}
}

private class Pesquisar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		PreencherTabela(false);
	}
	
	
}



private class Editar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		 if (tabela.getSelectedRow() == -1) {
		        JOptionPane.showMessageDialog(null, "É PRECISO SELECIONAR UM REGISTRO.");
		    } else {

		    	Login = listaLogin.get(tabela.getSelectedRow());
		        String nome=Login.getLogin();
		        
		   int pergunta=JOptionPane.showConfirmDialog(null, "Deseja Realmente Editar:\n"+nome);
		    if(pergunta==0){
		    	new TelaEditarLogin(Login);
				PreencherTabela(true);
		    		
		    	}
		    	
		
	}
}
	}
}
	

