package testeUnitario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelpessoa.DadosPessoa;
import modelpessoa.Funcionario;
import view.TelaDetalheFuncionario;

/**
 * Criacao de Testes para qualificar a qualidade de Software
 * @author Caio Vitor
 *
 */
class teste {
	/**
	 * Teste Usado para Testar Cadastro Vazio Do sistema
	 */
	@Test
	void cadastrovazio() {
		
			DadosPessoa.getListafuncionarios().clear();
			
			TelaDetalheFuncionario var=new TelaDetalheFuncionario();
			var.InserirDados(1, 0);
			var.getTextCargaHoraria().setText(Integer.toString(0));
			var.getTextCargo().setText("");
			var.getTextCpf().setText("");
			var.getTextNome().setText("");
			var.getTextSalario().setText(Integer.toString(0));
			var.getTextTelefone().setText("");
			var.getBotaoSalvar().doClick();
			
			assertTrue(DadosPessoa.getListafuncionarios().isEmpty());
	}
	
	
	
	/**
	 * Teste para Excluir os Dados
	 */
	@Test
	void testeExcluirCliente() {
		DadosPessoa.getListafuncionarios().clear();
		TelaDetalheFuncionario var=new TelaDetalheFuncionario();
		dados();
		var.InserirDados(2, 0);
		var.getBotaoExcluir().doClick();
		assertTrue(DadosPessoa.getListafuncionarios().isEmpty());
	}
	
	private void dados() {
		Funcionario c = new Funcionario("cpf","61996592058","Caio","Marketing",40,1700.00);
		DadosPessoa.getListafuncionarios().add(c);
		
	}
}