package controle;

import modelProduto.Carregador;
import modelProduto.Dados;

public class ControleCarregador {
	Carregador c;

	public ControleCarregador() {

	}

	public void adicionaCarregador(String id, String marca, String padrao,int qnt) {
		this.c = new Carregador(id, marca, padrao,qnt);
		Dados.getListacarrregadores().add(c);
	}

	public void alteraCarregador(String id, String marca, String padrao,int qnt, int pos) {
		for (Carregador c : Dados.getListacarrregadores()) {
			if (Dados.getListacarrregadores().get(pos).getId().equals(c.getId())) {
				c.setId(id);
				c.setMarca(marca);
				c.setPadrao(padrao);
				c.setQnt(qnt);
			}

		}
	}

	public void removeCarregador(int pos) {
		for (Carregador c : Dados.getListacarrregadores()) {
			if (Dados.getListacarrregadores().get(pos).getId().equals(c.getId())) {
				Dados.getListacarrregadores().remove(c);
			}

		}
	}
}
