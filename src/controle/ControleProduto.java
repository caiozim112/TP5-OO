package controle;


import modelpessoa.DadosPessoa;
import modelpessoa.Funcionario;
import modelproduto.Capinha;
import modelproduto.Carregador;
import modelproduto.Dados;
import modelproduto.Loja;
import modelproduto.Tela;

public class ControleProduto {
	Capinha ca;
	Carregador c;
	Tela t;
	
	public void AdicionaLista(String id, String marca,String padrao,String cor,String modelo,int qnt) {
		
		this.t=new Tela(id,marca,modelo,qnt);
		Dados.getListatelas().add(t);
		
		
		this.c=new Carregador(id,marca,padrao,qnt);
		Dados.getListacarrregadores().add(c);
		
		this.ca = new Capinha(id, marca, cor, modelo,qnt);
		Dados.getListacapinhas().add(ca);

		
	}
	
	public static Double  Receita(){
		Double valorsalario = 0.0;
		for(Funcionario f :DadosPessoa.getListafuncionarios()) {
			valorsalario=valorsalario-f.getSalario();
			}
		for(Loja l : Dados.getListavenda()) {
		valorsalario= valorsalario+(l.getQnt()*l.getValor());
	}
		return valorsalario;
	}
	public static String[] retornanomecapinhas() {// feito
		String[] s = new String[100];
		for (int i = 0; i < Dados.getListacapinhas().size(); i++) {
			s[i] = Dados.getListacapinhas().get(i).getId();
		}
		return s;
	}

	public static String[] retornanomecarrregadores() {// feito
		String[] s = new String[100];
		for (int i = 0; i < Dados.getListacapinhas().size(); i++) {
			s[i] = Dados.getListacapinhas().get(i).getId();
		}
		return s;
	}

	public static String[] retornanometelas() {// feito
		String[] s = new String[100];
		for (int i = 0; i < Dados.getListatelas().size(); i++) {
			s[i] = Dados.getListatelas().get(i).getId();
		}
		return s;
	}
	
	public static  String[] estoque() {
		String [] s= new String [50];
		int q=0;
		int u=0;
		int T1=Dados.getListacapinhas().size();//tamanho da Lista Capinha
		int T2=Dados.getListacapinhas().size()+Dados.getListacapinhas().size();
		int T3=Dados.getListacapinhas().size()+Dados.getListacapinhas().size()+Dados.getListacapinhas().size();
		for(int i=0;i<T1;i++) {
			s[i]="Capinha "+"Id:"+Dados.getListacapinhas().get(i).getId()+" Qnt: "+Dados.getListacapinhas().get(i).getQnt();
		}
		for(int i=T1;i<T2;i++) {
			s[i]="Carregador "+"Id:"+Dados.getListacarrregadores().get(u).getId()+" Qnt: "+Dados.getListacarrregadores().get(u).getQnt();
			u++;
		}
		for(int i=T2;i<T3;i++) {
			s[i]="Tela "+"Id:"+Dados.getListatelas().get(q).getId()+" Qnt: "+Dados.getListatelas().get(q).getQnt();
			q++;
		}
		return s;
	}
	
	public static String[] retornanomevendas() {//feito
		String [] s= new String[100];
		for (int i = 0; i < Dados.getListavenda().size(); i++) {
			s[i]=Dados.getListavenda().get(i).getTipoproduto();
		}
		return s;
	}
	
	
}
