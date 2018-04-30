package br.com.projecao.trabalhoa2.dao;

import java.util.List;

import br.com.projecao.trabalhoa2.bean.TipoContato;

public interface TipoContatoDAO {
	public abstract void salvarTipoContado(TipoContato p);
	public void EditarTipoCOntato(TipoContato p);
	public List<TipoContato>  pesquisaTipoContato();
	public List<TipoContato>  pesquisarTipoContatoPesquisa(String Dado);
	public TipoContato  pesquisarEditarTipo(TipoContato b);
	public boolean deletarTipoContato(TipoContato b);
}
