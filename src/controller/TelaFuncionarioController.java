package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import modelpessoa.DadosPessoa;
import view.TelaDetalheFuncionario;
import view.TelaFuncionario;

public class TelaFuncionarioController {
	private TelaFuncionario view;

	
	public TelaFuncionarioController(TelaFuncionario view) {
		super();
		this.view = view;
	}
	public void executaBotao(ActionEvent e) {
		JButton botaoCadastroFuncionario = (JButton) e.getSource();
		if (botaoCadastroFuncionario == view.getCadastroFuncionario()) {
			TelaDetalheFuncionario TelaCadFuncionario= new TelaDetalheFuncionario();
			TelaCadFuncionario.InserirDados(1,0);
			view.getListaFuncionariosCadastrados().updateUI();
		}
		if (botaoCadastroFuncionario == view.getRefreshFuncionario()) {
			view.getListaFuncionariosCadastrados().setListData(DadosPessoa.retornanomeFuncionario());
			view.getListaFuncionariosCadastrados().updateUI();
		}

	}

	
}
