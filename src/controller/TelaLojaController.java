package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import modelproduto.Dados;
import view.TelaDetalheLoja;
import view.TelaLoja;

public class TelaLojaController {
	private TelaLoja view;

	public TelaLojaController(TelaLoja view) {
		super();
		this.view = view;
	}

	public void executaBotao(ActionEvent e) {
		JButton botaoCadastroVenda = (JButton) e.getSource();
		if (botaoCadastroVenda == view.getCadastroVenda()) {
			TelaDetalheLoja cadvenda = new TelaDetalheLoja();
			cadvenda.InserirDados(1, 0);
			view.getListaVendasCadastradas().updateUI();
		}
		if (botaoCadastroVenda == view.getRefreshVenda()) {
			view.getListaVendasCadastradas().setListData(Dados.retornanomevendas());
			view.getListaVendasCadastradas().updateUI();
			view.getReceita().setText(Double.toString(Dados.Receita()));
			view.getReceita().updateUI();
		}

	}
	public void executalista(ListSelectionEvent e) {
		Object src = e.getSource();
		int qntnumeros = Dados.getListavenda().size();
		if (e.getValueIsAdjusting() && src == view.getListaVendasCadastradas()) {
			new TelaDetalheLoja().InserirDados(3, view.getListaVendasCadastradas().getSelectedIndex());
		}
		if (view.getListaVendasCadastradas().getSelectedIndex() > qntnumeros) {
			mensagemlistavazia();
		}
	}
	public void mensagemlistavazia() {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro.\n " + "Cadastre um Cliente\n", null,
				JOptionPane.ERROR_MESSAGE);
	}
}
