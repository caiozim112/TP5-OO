package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import view.TelaProduto;
import view.TelaProdutoProdutos;

public class TelaProdutoController {
	private TelaProduto view;

	public TelaProdutoController(TelaProduto view) {
		super();
		this.view = view;
	}

	public void executaBotao(ActionEvent e) {
		JButton botaoTelaProduto = (JButton) e.getSource();

	if (botaoTelaProduto == view.getCapinha()) {
		TelaProdutoProdutos objCapinha = new TelaProdutoProdutos("Capinha");
		}
		if (botaoTelaProduto == view.getCarregador()) {
			TelaProdutoProdutos objCarregador = new TelaProdutoProdutos("Carregador");
		}
		if (botaoTelaProduto == view.getTela()) {
			TelaProdutoProdutos objTela = new TelaProdutoProdutos("Tela");
		}

	}
}
