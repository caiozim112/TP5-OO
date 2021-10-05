package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controle.ControleCapinha;
import view.TelaMenu;
import view.TelaCliente;
import view.TelaFuncionario;
import view.TelaProduto;
import viewloja.TelaLoja;

public class TelaMenuController {
	private TelaMenu view;

	public TelaMenuController(TelaMenu view) {
		super();
		this.view = view;
	}

	public void executaBotaoProgramaPrincipal(ActionEvent e) {
		JButton botaoProgramaPrincipal =  (JButton) e.getSource();
		if (botaoProgramaPrincipal == view.getCliente()) {
			TelaCliente objPessoa = new TelaCliente();
		}
		if (botaoProgramaPrincipal == view.getFuncionario()) {
			TelaFuncionario objFuncionario = new TelaFuncionario();
		}
		if (botaoProgramaPrincipal == view.getProduto()) {
			TelaProduto objProduto = new TelaProduto();
		}
		if(botaoProgramaPrincipal == view.getVenda()) {
			TelaLoja objTela = new TelaLoja();
		}

	}
	
}
