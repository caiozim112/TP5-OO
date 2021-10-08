package modelproduto;

import java.util.ArrayList;
import java.util.List;
import modelpessoa.DadosPessoa;
import modelpessoa.Funcionario;

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
	
	public static Double  Receita(){
		Double valorsalario = 0.0;
		for(Funcionario f :DadosPessoa.getListafuncionarios()) {
			valorsalario=valorsalario-f.getSalario();
			}
		for(Loja l : getListavenda()) {
		valorsalario= valorsalario+(l.getQnt()*l.getValor());
	}
		return valorsalario;
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
	
	public static  String[] estoque() {
		String [] s= new String [50];
		int q=0;
		int u=0;
		int T1=listaCapinhas.size();//tamanho da Lista Capinha
		int T2=listaCapinhas.size()+listaCarrregadores.size();
		int T3=listaCapinhas.size()+listaCarrregadores.size()+listaTelas.size();
		for(int i=0;i<T1;i++) {
			s[i]="Capinha "+"Id:"+listaCapinhas.get(i).getId()+" Qnt: "+listaCapinhas.get(i).getQnt();
		}
		for(int i=T1;i<T2;i++) {
			s[i]="Carregador "+"Id:"+listaCarrregadores.get(u).getId()+" Qnt: "+listaCarrregadores.get(u).getQnt();
			u++;
		}
		for(int i=T2;i<T3;i++) {
			s[i]="Tela "+"Id:"+listaTelas.get(q).getId()+" Qnt: "+listaTelas.get(q).getQnt();
			q++;
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
