package controle;

import modelpessoa.Cliente;
import modelpessoa.DadosPessoa;

public class ControleCliente {
	Cliente c;
	public ControleCliente() {
	
	}

	/**
	 * adiciona CLiente com os parametros
	 * @param cpf
	 * @param telefone
	 * @param nome
	 */
	public void adicionaCliente(String cpf,String telefone,String nome) {
		if(cpf.isBlank() && !telefone.isBlank() && !nome.isBlank()) { // Usado para evitar que entre Dados Em Branco
		this.c = new Cliente(cpf,telefone,nome);
		DadosPessoa.getListaclientes().add(c);
		}
	}
	/**
	 * altera Cliente a partir da Posicao
	 * @param cpf
	 * @param telefone
	 * @param nome
	 * @param pos
	 */
	public void alteraCliente(String cpf,String telefone,String nome,int pos) {
	for(Cliente c:DadosPessoa.getListaclientes()) {
		if(DadosPessoa.getListaclientes().get(pos).getCpf().equals(c.getCpf())) {
		c.setCpf(cpf);
		c.setTelefone(telefone);
		c.setNome(nome);
	}
	}
}
}
