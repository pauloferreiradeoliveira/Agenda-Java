package br.com.projecao.trabalhoa2.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;


import br.com.projecao.trabalhoa2.view.gerenciador.GerenciadorContatos;
import br.com.projecao.trabalhoa2.view.gerenciador.GerenciadorEndereco;
import br.com.projecao.trabalhoa2.view.gerenciador.GerenciadorLogin;
import br.com.projecao.trabalhoa2.view.gerenciador.GerenciadorPerfil;
import br.com.projecao.trabalhoa2.view.gerenciador.GerenciadorTipoContado;
import br.com.projecao.trabalhoa2.view.gerenciador.GerenciadorUsuario;


public class TelaPrincipal extends JFrame implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar barraMenu;
	private JToolBar barraCadastar;
	private JMenu menuCadastro;
	private JMenuItem cadastrarUsuario;
	private JMenuItem cadastrarEndereco;
	private JMenuItem cadastrarPerfil;
	private JMenuItem cadastrarLogin;
	private JMenuItem cadastrarContado;
	private JMenuItem cadastrarTipoContado;
	private JMenuItem sair;
	private JButton CadUsuario;
	private JButton CadCont;
	
	








	public JButton getCadCont() {
		return CadCont;
	}

	public void setCadCont(JButton cadCont) {
		CadCont = cadCont;
	}

	public JButton getCadUsuario() {
		return CadUsuario;
	}

	public void setCadUsuario(JButton cadUsuario) {
		CadUsuario = cadUsuario;
	}

	public JToolBar getBarraCadastar() {
		return barraCadastar;
	}

	public void setBarraCadastar(JToolBar barraCadastar) {
		this.barraCadastar = barraCadastar;
	}

	public JMenuItem getCadastrarPerfil() {
		return cadastrarPerfil;
	}

	public void setCadastrarPerfil(JMenuItem cadastrarPerfil) {
		this.cadastrarPerfil = cadastrarPerfil;
	}

	public JMenuItem getCadastrarLogin() {
		return cadastrarLogin;
	}

	public void setCadastrarLogin(JMenuItem cadastrarLogin) {
		this.cadastrarLogin = cadastrarLogin;
	}

	public JMenuItem getCadastrarContado() {
		return cadastrarContado;
	}

	public void setCadastrarContado(JMenuItem cadastrarContado) {
		this.cadastrarContado = cadastrarContado;
	}

	public JMenuItem getCadastrarTipoContado() {
		return cadastrarTipoContado;
	}

	public void setCadastrarTipoContado(JMenuItem cadastrarTipoContado) {
		this.cadastrarTipoContado = cadastrarTipoContado;
	}

	public JMenuItem getCadastrarEndereco() {
		return cadastrarEndereco;
	}

	public void setCadastrarEndereco(JMenuItem cadastrarEndereco) {
		this.cadastrarEndereco = cadastrarEndereco;
	}

	public JMenuBar getBarraMenu() {
		return barraMenu;
	}

	public void setBarraMenu(JMenuBar barraMenu) {
		this.barraMenu = barraMenu;
	}

	public JMenu getMenuCadastro() {
		return menuCadastro;
	}

	public void setMenuCadastro(JMenu menuCadastro) {
		this.menuCadastro = menuCadastro;
	}

	
	public JMenuItem getCadastrarUsuario() {
		return cadastrarUsuario;
	}

	public void setCadastrarUsuario(JMenuItem cadastrarUsuario) {
		this.cadastrarUsuario = cadastrarUsuario;
	}

	public JMenuItem getSair() {
		return sair;
	}

	public void setSair(JMenuItem sair) {
		this.sair = sair;
	}

	
	

	

	// construtor
	public TelaPrincipal(boolean perfil){
		this.setTitle("Agenda Eletronica - Elos");//titulo da janela
		this.setLayout(null);// layout flutuante - adapta bem com JFrame
		Cor b = new Cor();
		this.setVisible(true);// torna visivel
		this.setResizable(false);// não pode ser redimencionado
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);// estado da tela
		
		
		
		getContentPane().setBackground(b.getB());
		//Icone  da janela
		ImageIcon imagemTituloJanela = new ImageIcon("Images/agenda.png");  
		setIconImage(imagemTituloJanela.getImage());  
		
		
		// menu cadastro
		menuCadastro = new JMenu("Gerenciamento");// construtor com sobrecarga - JMenu("Cadastro")
		menuCadastro.setMnemonic('C');//tecla sublinhada para atalho pelo 'ALT'
		
		//Usuario
		cadastrarUsuario = new JMenuItem("Gerência de Usuario");
		cadastrarUsuario.setMnemonic('U');
		cadastrarUsuario.addActionListener(new AcaoMenuCadastrarUsuario());
		ImageIcon Usuario = new ImageIcon("Images/Usuario.png");  
		cadastrarUsuario.setIcon(Usuario);
		
		//Endereco
		cadastrarEndereco = new JMenuItem("Gerência de Endereco");
		cadastrarEndereco.setMnemonic('E');
		cadastrarEndereco.addActionListener(new AcaoMenuCadastrarEndereco());
		ImageIcon Endereco = new ImageIcon("Images/casa.png");  
		cadastrarEndereco.setIcon(Endereco);
		
		//Contato
		cadastrarContado = new JMenuItem("Gerência de Contato");
		cadastrarContado.setMnemonic('n');
		cadastrarContado.addActionListener(new AcaoMenuCadastrarContato());
		ImageIcon Contato = new ImageIcon("Images/add_con.png");  
		cadastrarContado.setIcon(Contato);
		
		//Login
		cadastrarLogin = new JMenuItem("Gerência de Login");
		cadastrarLogin.setMnemonic('L');
		cadastrarLogin.addActionListener(new AcaoMenuCadastrarLogin());
		ImageIcon login = new ImageIcon("Images/login.png");  
		cadastrarLogin.setIcon(login);
		
		//Perfil
		cadastrarPerfil = new JMenuItem("Cadastro Perfil");
		cadastrarPerfil.setMnemonic('i');
		cadastrarPerfil.addActionListener(new AcaoMenuCadastrarPerfil());
		ImageIcon Perfil = new ImageIcon("Images/add.png");  
		cadastrarPerfil.setIcon(Perfil);
	
		//Tipo
		cadastrarTipoContado = new JMenuItem("Gerência de Tipo de Contado");
		cadastrarTipoContado.setMnemonic('p');
		cadastrarTipoContado.addActionListener(new AcaoMenuCadastrarTipo());
		ImageIcon Tipo = new ImageIcon("Images/Tipo.png");  
		cadastrarTipoContado.setIcon(Tipo);
		
		CadUsuario = new JButton(new ImageIcon("Images/list_add_user.png"));
		CadUsuario.setMnemonic('U');
		CadUsuario.addActionListener(new AcaoMenuCadUsuario());
		
		
		CadCont = new JButton(new ImageIcon("Images/contacts.png"));
		CadCont.addActionListener(new AcaoMenuCadCont());
		
		
		
		// adicionando opcoes
		
		menuCadastro.add(cadastrarEndereco);
		menuCadastro.add(cadastrarContado);
		menuCadastro.add(cadastrarTipoContado);
		
		if(perfil){
		menuCadastro.add(cadastrarUsuario);
		menuCadastro.add(cadastrarLogin);
		menuCadastro.add(cadastrarPerfil);
		
		}

				
		//opcao sair
		sair = new JMenuItem("Sair");
		sair.setMnemonic('r');
		sair.addActionListener(new AcaoBotaoSair());
		menuCadastro.addSeparator();
		menuCadastro.add(sair);
		
	
	
		
		// barra menu
		barraMenu = new JMenuBar();
		barraMenu.add(menuCadastro);
		barraMenu.setBackground(b.getB());
		sair.setBackground(b.getB());
		cadastrarUsuario.setBackground(b.getB());
		cadastrarEndereco.setBackground(b.getB());
		cadastrarContado.setBackground(b.getB());
		cadastrarLogin.setBackground(b.getB());
		cadastrarPerfil.setBackground(b.getB());
		cadastrarTipoContado.setBackground(b.getB());
	
		
		barraCadastar = new JToolBar("Ferramentas");
		if(perfil){
		barraCadastar.add(CadUsuario);
		}
		
		barraCadastar.add(CadCont);
		barraCadastar.setBounds(0, 0,this.getSize().width,40);
		
		
			

		// adicionando componentes ao JFrame
		this.setJMenuBar(barraMenu);// adicionando barra de menu ao JFrame
		add(barraCadastar);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("Images/agenda2.jpg"); 
		img.setImage(img.getImage().getScaledInstance(this.getSize().width,this.getSize().height, 100)); 
		JLabel label = new JLabel(img);
		label.setBounds(0, 0,this.getSize().width,this.getSize().height);
		getContentPane().add(label);

	}
	
	
	
	// Criacao de classes internas  --- Ações
	
	



	// Inicio da classe interna 
	private class AcaoBotaoSair implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?") == 0){
				JOptionPane.showMessageDialog(null,
										"A Aplicação esta sendo encerrada...",
										"::Agenda Eletronica",
										JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			}
		}
		
	}// Termino da classe interna 

		// Inicio da classe interna 
	private class AcaoMenuCadastrarUsuario implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new GerenciadorUsuario();
		  			

		}
		
		
	}
	private class AcaoMenuCadastrarEndereco implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new GerenciadorEndereco();
		  			

		}
		
		
	}// Termino da classe interna 
	
	private class AcaoMenuCadastrarContato implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new GerenciadorContatos();
		  			

		}
		
		
	}// Termino da classe interna 
	
	private class AcaoMenuCadastrarLogin implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new GerenciadorLogin();
			
		  			

		}
		
		
	}// Termino da classe interna 
	
	private class AcaoMenuCadastrarPerfil implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			 	new GerenciadorPerfil();		

		}
		
		
	}// Termino da classe interna 
	
	private class AcaoMenuCadastrarTipo implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new GerenciadorTipoContado();
			
		  			

		}
		
		
	}// Termino da classe interna 
	
	private class AcaoMenuCadUsuario implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new TelaCadastroUsuario();
			
		}
		
	}
	
	private class AcaoMenuCadCont implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			new TelaCadastroContato();
			
		}
		
	}
	
	
}

