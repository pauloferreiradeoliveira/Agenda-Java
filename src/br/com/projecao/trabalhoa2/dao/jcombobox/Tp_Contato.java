package br.com.projecao.trabalhoa2.dao.jcombobox;

public class Tp_Contato {
	private String id; 
	private String nome; 
	  
	   public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Tp_Contato(String id,String nome){  
	       this.id = id;  
	       this.nome = nome;  
	   }  
	  
	  
	   @Override  
	   public String toString(){  
	     return nome; //o que vai aparecer na comboBox  
	    }  

}
