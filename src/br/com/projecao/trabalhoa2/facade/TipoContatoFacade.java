package br.com.projecao.trabalhoa2.facade;

import java.util.List;

import br.com.projecao.trabalhoa2.bean.TipoContato;
import br.com.projecao.trabalhoa2.dao.TipoContatoDAO;
import br.com.projecao.trabalhoa2.dao.impl.TipoContatoDAOImpl;

public class TipoContatoFacade {
	private TipoContatoDAO tipoContatoDAO;
	
	public TipoContatoDAO getTipoContatoDAO() {
		if(tipoContatoDAO == null){
			tipoContatoDAO = new TipoContatoDAOImpl();
		}
		
		return tipoContatoDAO;
	}

	public void setTipoContatoDAO(TipoContatoDAO tipoContatoDAO) {
		this.tipoContatoDAO = tipoContatoDAO;
	}

	public  void salvarTipoContado(TipoContato p){
		getTipoContatoDAO().salvarTipoContado(p);
	}
	public void EditarTipoCOntato(TipoContato p){
		getTipoContatoDAO().EditarTipoCOntato(p);
	}
	public List<TipoContato>  pesquisaTipoContato(){
		return getTipoContatoDAO().pesquisaTipoContato();
	}
	public List<TipoContato>  pesquisarTipoContatoPesquisa(String Dado){
		return getTipoContatoDAO().pesquisarTipoContatoPesquisa(Dado);
	}
	public TipoContato  pesquisarEditarTipo(TipoContato b){
		return getTipoContatoDAO().pesquisarEditarTipo(b);
	}
	public boolean deletarTipoContato(TipoContato b){
		return getTipoContatoDAO().deletarTipoContato(b);
	}

}
