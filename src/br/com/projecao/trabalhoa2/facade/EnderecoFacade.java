package br.com.projecao.trabalhoa2.facade;
import java.util.List;

import br.com.projecao.trabalhoa2.bean.Endereco;
import br.com.projecao.trabalhoa2.dao.EnderecoDAO;
import br.com.projecao.trabalhoa2.dao.impl.EnderecoDAOImpl;


public class EnderecoFacade implements EnderecoDAO {
	private EnderecoDAO EnderecoDAO;

	public EnderecoDAO getEnderecoDAO() {
		if (EnderecoDAO == null){
			EnderecoDAO = new EnderecoDAOImpl();
		}
	
		return EnderecoDAO;
	}

	public void setContatosDAO(EnderecoDAO EnderecoDAO) {
		this.EnderecoDAO = EnderecoDAO;
	}
	public  void salvarEndereco(Endereco p){
		getEnderecoDAO().salvarEndereco(p);
	}

	@Override
	public boolean deletarEndereco(Endereco b) {
		return getEnderecoDAO().deletarEndereco(b);
	}

	@Override
	public void editarEndereco(Endereco p) {
		getEnderecoDAO().editarEndereco(p);
		
	}

	@Override
	public Endereco pesquisarEditarEndereco(Endereco Endereco) {
		return getEnderecoDAO().pesquisarEditarEndereco(Endereco);
	}

	@Override
	public List<Endereco> pesquisarEndereco() {
		return getEnderecoDAO().pesquisarEndereco();
	}

	@Override
	public List<Endereco> pesquisarEnderecoPesquisa(String Dado,String Tipo) {
		return getEnderecoDAO().pesquisarEnderecoPesquisa(Dado,Tipo);
	}
	
}
