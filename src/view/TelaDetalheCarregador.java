package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleCarregador;
import modelProduto.Dados;

public class TelaDetalheCarregador implements ActionListener {
	private JFrame janela;
	private JLabel labelId = new JLabel("Id: ");
	private JTextField TextId;
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField TextMarca;
	private JLabel labelPadrao = new JLabel("Padrao: ");
	private JTextField TextPadrao;
	private JLabel labelQnt = new JLabel("Qnt: ");
	private JTextField TextQnt;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	int escolha = 0;
	int posicao = 0;

	public void InserirDados(int esc, int pos) {
		this.posicao = pos;
		janela = new JFrame();
		if (esc == 1) {
			TextId = new JTextField();
			TextMarca = new JTextField();
			TextPadrao = new JTextField();
			TextQnt = new JTextField();
			escolha = 1;
		}
		if (esc == 2) {
			TextId = new JTextField(Dados.getListacarrregadores().get(pos).getId());
			TextMarca = new JTextField(Dados.getListacarrregadores().get(pos).getMarca());
			TextPadrao = new JTextField(Dados.getListacarrregadores().get(pos).getPadrao());
			TextQnt = new JTextField(Integer.toString(Dados.getListacarrregadores().get(pos).getQnt()));
			escolha = 2;
		}

		labelId.setBounds(30, 20, 150, 25);
		TextId.setBounds(180, 20, 180, 25);
		labelMarca.setBounds(30, 50, 150, 25);
		TextMarca.setBounds(180, 50, 180, 25);
		labelPadrao.setBounds(30, 80, 180, 25);
		TextPadrao.setBounds(180, 80, 180, 25);
		labelQnt.setBounds(30, 110, 180, 25);
		TextQnt.setBounds(180, 110, 180, 25);
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
		this.janela.add(labelPadrao);
		this.janela.add(TextPadrao);
		this.janela.add(TextQnt);
		this.janela.add(labelQnt);

		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);
		this.janela.setLayout(null);

		this.janela.setSize(400, 300);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);

	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
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

	public void actionPerformed(ActionEvent e) {
		ControleCarregador controlecarregador = new ControleCarregador();
		String id;
		String marca;
		String padrao;
		int qnt;
		Object src = e.getSource();
		if (escolha == 1) {
			id = TextId.getText();

			marca = TextMarca.getText();

			padrao = TextPadrao.getText();
			
			qnt = Integer.parseInt(TextQnt.getText());

			controlecarregador.adicionaCarregador(id, marca, padrao,qnt);
		}
		if (src == botaoSalvar) {
			mensagemSucessoCadastro();

		}
		if (src == botaoExcluir) {
					Dados.getListacarrregadores().remove(this.posicao);
					mensagemSucessoExclusao();
				escolha = 0;
			}

			if (escolha == 2) {
				id = TextId.getText();

				marca = TextMarca.getText();

				padrao = TextPadrao.getText();
				
				qnt = Integer.parseInt(TextQnt.getText());
				controlecarregador.alteraCarregador(id, marca, padrao,qnt, this.posicao);

			}

		}
	}
