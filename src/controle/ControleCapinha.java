package controle;

import modelproduto.Capinha;
import modelproduto.Dados;

public class ControleCapinha {
	Capinha c;

	public ControleCapinha() {

	}

	public void adicionaCapinha(String id, String marca, String cor, String modelo,int qnt) {
		this.c = new Capinha(id, marca, cor, modelo,qnt);
		Dados.getListacapinhas().add(c);
	}

	public void alteraCapinha(String id, String marca, String cor, String modelo,int qnt, int pos) {
		for (Capinha c : Dados.getListacapinhas()) {
			if (Dados.getListacapinhas().get(pos).getId().equals(c.getId())) {
				c.setId(id);
				c.setMarca(marca);
				c.setCor(cor);
				c.setModelo(modelo);
				c.setQnt(qnt);
			}

		}
	}
	public void removeCapinha(int pos) {
		for (Capinha c : Dados.getListacapinhas()) {
			if (Dados.getListacapinhas().get(pos).getId().equals(c.getId())) {
			Dados.getListacapinhas().remove(c);

			}
		}
	}
}