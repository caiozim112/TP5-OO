package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.TelaDetalheCapinhaController;
import modelproduto.Dados;

public class TelaDetalheCapinha implements ActionListener {

	private JFrame janela;
	private JLabel labelId = new JLabel("Id: ");
	private JTextField TextId;
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField TextMarca;
	private JLabel labelCor = new JLabel("Cor: ");
	private JTextField TextCor;
	private JLabel labelModelo = new JLabel("Modelo: ");
	private JTextField TextModelo;
	private JLabel labelQnt = new JLabel("Qnt: ");
	private JTextField TextQnt;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	int escolha = 0;
	int posicao = 0;
	TelaDetalheCapinhaController controle;

	public void InserirDados(int esc, int pos) {
		this.posicao = pos;
		janela = new JFrame();
		this.controle = new TelaDetalheCapinhaController(this);
		if (esc == 1) {
			TextId = new JTextField();
			TextMarca = new JTextField();
			TextCor = new JTextField();
			TextModelo = new JTextField();
			TextQnt = new JTextField();
			escolha = 1;
		}
		if (esc == 2) {
			TextId = new JTextField(Dados.getListacapinhas().get(pos).getId());
			TextMarca = new JTextField(Dados.getListacapinhas().get(pos).getMarca());
			TextCor = new JTextField(Dados.getListacapinhas().get(pos).getCor());
			TextModelo = new JTextField(Dados.getListacapinhas().get(pos).getModelo());
			TextQnt = new JTextField(Integer.toString((Dados.getListacapinhas().get(pos).getQnt())));
			escolha = 2;
		}

		labelId.setBounds(30, 20, 150, 25);
		TextId.setBounds(180, 20, 180, 25);
		labelMarca.setBounds(30, 50, 150, 25);
		TextMarca.setBounds(180, 50, 180, 25);
		labelCor.setBounds(30, 80, 180, 25);
		TextCor.setBounds(180, 80, 180, 25);
		labelModelo.setBounds(30, 110, 180, 25);
		TextModelo.setBounds(180, 110, 180, 25);
		labelQnt.setBounds(30, 140, 180, 25);
		TextQnt.setBounds(180, 140, 180, 25);
		if (esc == 1 || esc == 2) {
			botaoSalvar.setBounds(30, 200, 115, 30);
		}
		if (esc == 2) {
			botaoExcluir.setBounds(180, 200, 115, 30);
		}
		this.janela.add(labelId);
		this.janela.add(TextId);
		this.janela.add(labelMarca);
		this.janela.add(TextMarca);
		this.janela.add(labelCor);
		this.janela.add(TextCor);
		this.janela.add(labelModelo);
		this.janela.add(TextModelo);
		this.janela.add(labelQnt);
		this.janela.add(TextQnt);
		
		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);
		this.janela.setLayout(null);

		this.janela.setSize(400, 300);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e) {
		this.controle.executaBotao(e);

	}

	
	
	public JLabel getLabelQnt() {
		return labelQnt;
	}


	public void setLabelQnt(JLabel labelQnt) {
		this.labelQnt = labelQnt;
	}


	public JTextField getTextQnt() {
		return TextQnt;
	}


	public void setTextQnt(JTextField textQnt) {
		TextQnt = textQnt;
	}


	public JFrame getJanela() {
		return janela;
	}

	public JLabel getLabelId() {
		return labelId;
	}

	public JTextField getTextId() {
		return TextId;
	}

	public JLabel getLabelMarca() {
		return labelMarca;
	}

	public JTextField getTextMarca() {
		return TextMarca;
	}

	public JLabel getLabelCor() {
		return labelCor;
	}

	public JTextField getTextCor() {
		return TextCor;
	}

	public JLabel getLabelModelo() {
		return labelModelo;
	}

	public JTextField getTextModelo() {
		return TextModelo;
	}

	public JButton getBotaoExcluir() {
		return botaoExcluir;
	}

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public int getEscolha() {
		return escolha;
	}

	public int getPosicao() {
		return posicao;
	}
	
	
	

}
