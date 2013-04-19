package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapeamentos {
	
	Map<String, Long> mapeamentoProdutoPosicao;
	Map<String, List<String>> mapeamentoTipo; 
	Map<String, List<String>> mapeamentoMarca; 
	Map<String, List<String>> mapeamentoTitulo;
	
	Long posicaoProdutoNoMapeamento;
	
	public Mapeamentos()
	{
		mapeamentoProdutoPosicao = new HashMap<String, Long>();
		mapeamentoTipo = new HashMap<String, List<String>>();
		mapeamentoMarca = new HashMap<String, List<String>>();
		mapeamentoTitulo = new HashMap<String, List<String>>(); 
		this.posicaoProdutoNoMapeamento = 0L;
		
	}
	
	public Map<String, List<String>> retornarMapeamentoDeTipo()
	{
		return mapeamentoTipo;
	}
	
	public Map<String, List<String>> retornarMapeamentoDeMarca()
	{
		return mapeamentoMarca;
	}
	
	public Map<String, List<String>> retornarMapeamentoDeTitulo()
	{
		return mapeamentoTitulo;
	}
}
