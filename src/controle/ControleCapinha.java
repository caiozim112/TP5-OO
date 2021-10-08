package controle;

import modelproduto.Capinha;
import modelproduto.Dados;


/**
 * @author Caio Vitor
 *
 */
public class ControleCapinha {
	Capinha c;

	/**
	 * Contrutor vazio da classe ControleCapinha
	 */
	public ControleCapinha() {

	}

	public void adicionaCapinha(String id, String marca, String cor, String modelo,int qnt) {
		this.c = new Capinha(id, marca, cor, modelo,qnt);
		Dados.getListacapinhas().add(c);
	}

	/**
	 * alteração Da Capinha com o setter
	 * @param id
	 * id para identificação do produto
	 * @param marca
	 *	marca da Capinha
	 * @param cor
	 * cor do produto
	 * @param modelo
	 * modelo que cabe no celular
	 * @param qnt
	 * qnt de produtos no estoque
	 * @param pos
	 * posicao na List
	 * 
	 */
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
	
	/**
	 * remocao da capinha com  a posicao dela
	 * @param pos
	 * posicao no list
	 * 
	 * 
	 */
	public void removeCapinha(int pos) {
		for (Capinha c : Dados.getListacapinhas()) {
			if (Dados.getListacapinhas().get(pos).getId().equals(c.getId())) {
			Dados.getListacapinhas().remove(c);

			}
		}
	}
}