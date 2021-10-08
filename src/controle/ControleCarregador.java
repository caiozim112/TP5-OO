package controle;

import modelproduto.Carregador;
import modelproduto.Dados;

/**
 * Controle DO Carregador
 * @author Caio Vitor
 *
 */
public class ControleCarregador {
	Carregador c;

	public ControleCarregador() {

	}

	/**
	 * Adiciona Carregador
	 * @param id
	 * @param marca
	 * @param padrao
	 * @param qnt
	 */
	public void adicionaCarregador(String id, String marca, String padrao,int qnt) {
		this.c = new Carregador(id, marca, padrao,qnt);
		Dados.getListacarrregadores().add(c);
	}

	/**
	 * 
	 * Alterar Carregador a partir da posicao em que se encontra na Lista
	 * 
	 * @param id
	 * @param marca
	 * @param padrao
	 * @param qnt
	 * @param pos
	 */
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

	/**
	 * Remove carregador a partir da posicao
	 * 
	 * @param pos
	 */
	public void removeCarregador(int pos) {
		for (Carregador c : Dados.getListacarrregadores()) {
			if (Dados.getListacarrregadores().get(pos).getId().equals(c.getId())) {
				Dados.getListacarrregadores().remove(c);
			}

		}
	}
}
