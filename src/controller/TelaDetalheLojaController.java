package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controle.ControleLoja;
import viewloja.TelaDetalheLoja;

public class TelaDetalheLojaController {
	private TelaDetalheLoja view;

	public TelaDetalheLojaController(TelaDetalheLoja view) {
		super();
		this.view = view;
	}
	
	public void executaBotao(ActionEvent e) {
		ControleLoja objLoja = new ControleLoja();
		String nomedoCliente;
		String nomedoFuncionario;
		String tipodeProduto;
		String id;
		int qnt;
		Object src = e.getSource();
		if(view.getEscolha()==1) {
			nomedoCliente=view.getTextnomeCliente().getText();
			nomedoFuncionario=view.getTextnomeFuncionario().getText();
			tipodeProduto=view.getTexttipoProduto().getText();
			id=view.getTextidProduto().getText();
			qnt= Integer.parseInt(view.getTextqntProduto().getText());
			objLoja.adicionaVenda(nomedoCliente, nomedoFuncionario, tipodeProduto,id,qnt);
		}
		if(src==view.getBotaoSalvar()) {
			mensagemSucessoCadastro();
		}
		if(src==view.getBotaoExcluir()) {
			objLoja.removeVenda(view.getPosicao());
			 mensagemSucessoExclusao();
		}
	}
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		view.getJanela().dispose();
	}
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos!", null,
				JOptionPane.INFORMATION_MESSAGE);
		view.getJanela().dispose();
	}
}
