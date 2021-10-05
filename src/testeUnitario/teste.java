package testeUnitario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelpessoa.DadosPessoa;
import view.TelaDetalheFuncionario;

class teste {
	@Test
	void cadastrovazio() {
		
			DadosPessoa.getListafuncionarios().clear();
			
			
		   var interfaceTeste = new TelaDetalheFuncionario();
			interfaceTeste.getTextCpf().setText(" ");
			interfaceTeste.getTextTelefone().setText(" ");
			interfaceTeste.getTextNome().setText(" ");
			interfaceTeste.getTextCargo().setText(" ");
			interfaceTeste.getTextCargaHoraria().setText(" ");
			interfaceTeste.getTextSalario().setText(" ");
			
			interfaceTeste.getBotaoSalvar().doClick();
			
			assertTrue(DadosPessoa.getListafuncionarios().isEmpty());
			System.out.println("oi");
	}

}