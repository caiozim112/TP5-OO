package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import controle.ControleCapinha;
import modelproduto.Dados;
import view.TelaDetalheCapinha;

public class TelaDetalheCapinhaController {
	private TelaDetalheCapinha view;
	
	
	public TelaDetalheCapinhaController(TelaDetalheCapinha view) {
		this.view = view;
	}
	public void executaBotao(ActionEvent e) {
		ControleCapinha controlecapinha = new ControleCapinha();
		String id;
		String marca;
		String cor;
		String modelo;
		int qnt;
		Object src = e.getSource();
		if (view.getEscolha() == 1) { 
			id = view.getTextId().getText();

			marca = view.getTextMarca().getText();

			cor = view.getTextCor().getText();

			modelo = view.getTextModelo().getText();
			
			qnt = Integer.parseInt(view.getTextQnt().getText());

			controlecapinha.adicionaCapinha(id, marca, cor, modelo,qnt);
		}
		if (view.getEscolha() == 2) {
			id = view.getTextId().getText();
			
			marca = view.getTextMarca().getText();

			cor = view.getTextCor().getText();

			modelo = view.getTextModelo().getText();
			
			qnt = Integer.parseInt(view.getTextQnt().getText());
			controlecapinha.alteraCapinha(id, marca, cor, modelo,qnt, view.getPosicao());
		}
		if (src == view.getBotaoSalvar()) {
			mensagemSucessoCadastro();

		}
		if (src == view.getBotaoExcluir()) {
					Dados.getListacapinhas().remove(view.getPosicao());
					mensagemSucessoExclusao();
				}
		
		
		
		
	}
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		view.getJanela().dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		view.getJanela().dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,
				"ERRO AO SALVAR OS DADOS!\n " + "Pode ter ocorrido um dos dois erros a seguir:  \n"
						+ "1. Nem todos os campos foram preenchidos \n"
						+ "2. CPF, identidade, DDD e telefone n�o cont�m apenas n�meros",
				null, JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoAluno() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n " + "Verifique se o aluno est� matriculado\n"
						+ "em alguma disciplina. Se sim, cancele\n " + "a matricula e tente novamente.",
				null, JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoProf() {
		JOptionPane.showMessageDialog(null,
				"Ocorreu um erro ao excluir o dado.\n " + "Verifique se o professor est� respons�vel\n"
						+ "por alguma disciplina. Se sim, substitua\n " + "o professor e tente novamente.",
				null, JOptionPane.ERROR_MESSAGE);
	}

}
