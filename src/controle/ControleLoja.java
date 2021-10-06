package controle;

import modelProduto.Dados;
import modelProduto.Loja;
import modelpessoa.DadosPessoa;
public class ControleLoja {
	Loja l;

	public ControleLoja() {

	}

	public void adicionaVenda(String nomedoCliente, String nomedoFuncionario, String tipodeProduto, String id,int qnt,Double valor) {
		ValidaProduto(tipodeProduto,id,qnt);
		String nomecliente=validadornomedocliente(nomedoCliente);
		String nomeFuncionario = validadornomedoFuncionario(nomedoFuncionario);
		this.l = new Loja(nomecliente,nomeFuncionario, tipodeProduto, id, qnt,valor);
		Dados.getListavenda().add(l);
	}

	public void removeVenda(int pos) {
		Dados.getListavenda().remove(pos);

	}

	private String validadornomedocliente(String nomedoCliente) {
		for (int i = 0; i <= DadosPessoa.getListaclientes().size();i++) {
			if (nomedoCliente.equals(DadosPessoa.getListaclientes().get(i).getNome())) {
				return nomedoCliente;
			}
		}
		return null;
	}

	private String validadornomedoFuncionario(String nomedoFuncionario) {
		for (int i = 0; i <= DadosPessoa.getListafuncionarios().size(); i++)
			if (nomedoFuncionario.equals(DadosPessoa.getListafuncionarios().get(i).getNome())) {
				return nomedoFuncionario;
			}
		return null;
	}

	private void ValidaProduto(String tipodeProduto,String id,int qnt) {
		if("Capinha".equalsIgnoreCase(tipodeProduto)) {
			Dados.getListacapinhas().get(validaIdCapinha(id)).setQnt(Dados.getListacapinhas().get(validaIdCapinha(id)).getQnt()-qnt);
		}
		if("Carregador".equalsIgnoreCase(tipodeProduto)) {
			Dados.getListacarrregadores().get(validaIdCarregador(id)).setQnt(Dados.getListacarrregadores().get(validaIdCapinha(id)).getQnt()-qnt);
		}
		if("Tela".equalsIgnoreCase(tipodeProduto)) {
			Dados.getListatelas().get(validaIdTela(id)).setQnt(Dados.getListatelas().get(validaIdTela(id)).getQnt()-qnt);
		}
	}
		
	private int validaIdCapinha(String id) {  //Funcao valida Capinha caso a capinha esteja na Lista ela retorna a posicao na lista
		for(int i =0;i<Dados.getListacapinhas().size();i++) {
			if(Dados.getListacapinhas().get(i).getId().equals(id)) {
				return i;
			}
	}
		return 0;
	}
	
	private int validaIdTela(String id) { ////Funcao valida Capinha caso a capinha esteja na Lista ela retorna a posicao na lista
		for(int i =0;i<Dados.getListatelas().size();i++) {
			if(Dados.getListatelas().get(i).getId().equals(id)) {
				return i;
			}
	}
		return 0;
	}
	
	private int validaIdCarregador(String id) {
		for(int i =0;i<Dados.getListacarrregadores().size();i++) {
			if(Dados.getListacarrregadores().get(i).getId().equals(id)) {
				return i;
			}
	}
		return 0;
	}

}
