package controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import modelpessoa.DadosPessoa;
import view.TelaCliente;
import view.TelaDetalheCliente;

//back-end
public class TelaClienteController {
	private TelaCliente view;

	public TelaClienteController(TelaCliente view) {
		super();
		this.view = view;
	}

	public void executaBotao(ActionEvent e) {
		JButton botaoCadastroCliente = (JButton) e.getSource();
		if (botaoCadastroCliente == view.getCadastroCliente()) {
			TelaDetalheCliente TelaCadPessoa = new TelaDetalheCliente();
			TelaCadPessoa.InserirDados(1,0);
			view.getListaClientesCadastrados().updateUI();
		}
		if (botaoCadastroCliente == view.getRefreshCliente()) {
			view.getListaClientesCadastrados().setListData(DadosPessoa.retornanome());
			view.getListaClientesCadastrados().updateUI();
		}
		if (botaoCadastroCliente == view.getBuscarCliente() && view.getBuscar().getText() != null) {
			String nomeclientebuscar=view.getBuscar().getText();
			view.getListaClientesCadastrados().setListData(DadosPessoa.procuracliente(nomeclientebuscar));
			view.getListaClientesCadastrados().updateUI();
		}
	}
	
	public void executaLista(ListSelectionEvent e) {
		Object src = e.getSource();
		int qntnumeros = DadosPessoa.getListaclientes().size();
		if (e.getValueIsAdjusting() && src == view.getListaClientesCadastrados()) {
			new TelaDetalheCliente().InserirDados(3, view.getListaClientesCadastrados().getSelectedIndex());
		}
		if (view.getListaClientesCadastrados().getSelectedIndex() > qntnumeros) {
			mensagemlistavazia();
		}
	}
	

	public void mensagemlistavazia() {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro.\n " + "Cadastre um Cliente\n", null,
				JOptionPane.ERROR_MESSAGE);
	}

}
