package controle;

import modelpessoa.Cliente;
import modelpessoa.DadosPessoa;

public class ControleCliente {
	Cliente c;
	public ControleCliente() {

	}

	public void adicionaCliente(String cpf,String telefone,String nome) {
		this.c = new Cliente(cpf,telefone,nome);
		DadosPessoa.getListaclientes().add(c);
	}
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
