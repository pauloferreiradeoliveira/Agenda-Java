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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import br.com.projecao.trabalhoa2.bean.TipoContato;
import br.com.projecao.trabalhoa2.facade.TipoContatoFacade;
import br.com.projecao.trabalhoa2.view.Cor;
import br.com.projecao.trabalhoa2.view.TelaCadastroTipoContato;
import br.com.projecao.trabalhoa2.view.TelaEditaTipoContato;

public class GerenciadorTipoContado extends JDialog{
	
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
	private List<TipoContato> listaTipoContato = new ArrayList<TipoContato>();
	private TipoContato TipoContato = new TipoContato();
	private TipoContatoFacade FacadeTipoContato;
	
	
	

	public JPanel getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(JPanel pesquisa) {
		this.pesquisa = pesquisa;
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

	
	

	

	public List<TipoContato> getListaTipoContato() {
		return listaTipoContato;
	}

	public void setListaTipoContato(List<TipoContato> listaTipoContato) {
		this.listaTipoContato = listaTipoContato;
	}

	public TipoContato getTipoContato() {
		return TipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		TipoContato = tipoContato;
	}

	public TipoContatoFacade getFacadeTipoContato() {
		if(FacadeTipoContato == null){
			FacadeTipoContato = new TipoContatoFacade();
		}
		return FacadeTipoContato;
	}

	public void setFacadeTipoContato(TipoContatoFacade facadeTipoContato) {
		FacadeTipoContato = facadeTipoContato;
	}

	public GerenciadorTipoContado() {
		
		this.setTitle("Gerencia de Tipo de Contato");//titulo da janela
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
		Novo.addActionListener(new AcaoMenuCadastrarPerfil());
		
		excluir = new JButton(new ImageIcon("Images/Excuir.png"));
		excluir.addActionListener(new deletar());

		editar = new JButton(new ImageIcon("Images/etitar.png"));
		editar.addActionListener(new Editar());
		
	
		
		pesquisa.add(txtpesquisa);
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
		listaTipoContato = getFacadeTipoContato().pesquisaTipoContato();
       }
       else{
    	   if (!(txtpesquisa.getText().equals("") || txtpesquisa.getText() == null)){
    	  	   listaTipoContato= getFacadeTipoContato().pesquisarTipoContatoPesquisa(txtpesquisa.getText()); 
    	   if (listaTipoContato.size()<1){
    		   PreencherTabela(true);
    	   }
       }
    	   else{
    		   PreencherTabela(true);
    	   }
       }
		Vector<String> titulo = new Vector<String>();
		titulo.add("ID:");
		titulo.add("Tipo de Contato");
		titulo.add("Descricao");
		
		
		Vector dados = new Vector();

		for (TipoContato a : listaTipoContato) {

			Vector colunas = new Vector();

			colunas.add(a.getId());
			colunas.add(a.getContato());
			colunas.add(a.getDescricao());
			
			dados.add(colunas);
		}
		DefaultTableModel model = new DefaultTableModel(dados, titulo);
		tabela.setModel(model);
		scroll.setViewportView(tabela);

	}
       
 
private class AcaoMenuCadastrarPerfil implements ActionListener{

		// reescrita de metodo
		public void actionPerformed(ActionEvent e) {
			new TelaCadastroTipoContato();
			PreencherTabela(true);
		  			

		}
	}
private class deletar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			 if (tabela.getSelectedRow() == -1) {
			        JOptionPane.showMessageDialog(null, "É PRECISO SELECIONAR UM REGISTRO.");
			    } else {

			        TipoContato = listaTipoContato.get(tabela.getSelectedRow());
			        String nome=TipoContato.getContato();
			        
			   int pergunta=JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir:\n"+nome);
			    if(pergunta==0){
			    	if(getFacadeTipoContato().deletarTipoContato(TipoContato)){
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

		    	TipoContato = listaTipoContato.get(tabela.getSelectedRow());
		        String nome=TipoContato.getContato();
		        
		   int pergunta=JOptionPane.showConfirmDialog(null, "Deseja Realmente Editar:\n"+nome);
		    if(pergunta==0){
		    	new TelaEditaTipoContato(TipoContato);
				PreencherTabela(true);
		    		
		    	}
		    	
		
	}
}
	}
}
	

