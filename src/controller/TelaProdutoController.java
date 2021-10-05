package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import view.TelaCapinha;
import view.TelaCarregador;
import view.TelaProduto;
import view.TelaTela;

public class TelaProdutoController {
	private TelaProduto view;

	public TelaProdutoController(TelaProduto view) {
		super();
		this.view = view;
	}

	public void executaBotao(ActionEvent e) {
		JButton botaoTelaProduto = (JButton) e.getSource();

		if (botaoTelaProduto == view.getCapinha()) {
			TelaCapinha objCapinha = new TelaCapinha();
		}
		if (botaoTelaProduto == view.getCarregador()) {
			TelaCarregador objCarregador = new TelaCarregador();
		}
		if (botaoTelaProduto == view.getTela()) {
			TelaTela objTela = new TelaTela();
		}

	}
}
