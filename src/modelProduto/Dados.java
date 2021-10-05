package modelProduto;

import java.util.ArrayList;
import java.util.List;

public abstract class Dados {
	private static final List<Capinha> listaCapinhas = new ArrayList<Capinha>();

	private static final List<Carregador> listaCarrregadores = new ArrayList<Carregador>();

	private static final List<Tela> listaTelas = new ArrayList<Tela>();
	
	private static final List<Loja> listaVenda = new ArrayList<Loja>();

	private Dados() {
	}

	public static List<Capinha> getListacapinhas() {
		return listaCapinhas;
	}

	public static List<Carregador> getListacarrregadores() {
		return listaCarrregadores;
	}

	public static List<Tela> getListatelas() {
		return listaTelas;
	}

	public static String[] retornanomecapinhas() {// feito
		String[] s = new String[100];
		for (int i = 0; i < listaCapinhas.size(); i++) {
			s[i] = listaCapinhas.get(i).getId();
		}
		return s;
	}

	public static String[] retornanomecarrregadores() {// feito
		String[] s = new String[100];
		for (int i = 0; i < listaCarrregadores.size(); i++) {
			s[i] = listaCarrregadores.get(i).getId();
		}
		return s;
	}

	public static String[] retornanometelas() {// feito
		String[] s = new String[100];
		for (int i = 0; i < listaTelas.size(); i++) {
			s[i] = listaTelas.get(i).getId();
		}
		return s;
	}
	
	public static List<Loja> getListavenda() {
		return listaVenda;
	}
	
	public static String[] retornanomevendas() {//feito
		String [] s= new String[100];
		for (int i = 0; i < listaVenda.size(); i++) {
			s[i]=listaVenda.get(i).getTipoproduto();
		}
		return s;
	}
}
