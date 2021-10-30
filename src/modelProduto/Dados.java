package modelproduto;

import java.util.ArrayList;
import java.util.List;

public abstract class Dados {
	private static final List<Produto> listaProdutos= new ArrayList<Produto>();
	
	private static final List<Loja> listaVenda = new ArrayList<Loja>();
	

	private Dados() {
	}
	public static String[] retornanomecapinha() {// feito
		String [] s = new String[50];
		int i =0;
		int q =0;
		for(Produto produtos:Dados.listaProdutos) {
			if(produtos instanceof Capinha) {
				s[i]=((Capinha)produtos).getModelo();
				((Capinha)produtos).getModelo();
				i++;
			}
			q++;
		}
		return s;
	}
	public static List<Produto> getListaprodutos() {
		return listaProdutos;
	}


	public static List<Loja> getListavenda() {
		return listaVenda;
	}
	
}
