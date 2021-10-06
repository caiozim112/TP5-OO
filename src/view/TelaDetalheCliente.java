package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleCliente;
import modelpessoa.DadosPessoa;

public class TelaDetalheCliente implements ActionListener {

	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField TextNome;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField TextTelefone;
	private JLabel labelCpf = new JLabel("Cpf: ");
	private JTextField TextCpf;
	private JLabel labelCargo = new JLabel("Cargo: ");
	private JTextField TextCargo;
	private JLabel labelCargaHoraria = new JLabel("Carga Horaria: ");
	private JTextField TextCargaHoraria;
	private JLabel labelSalario = new JLabel("Salario: ");
	private JTextField TextSalario;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	int escolha = 0;
	int posicao = 0;

	public void InserirDados(int esc, int pos) {
		this.posicao = pos;
		// s = "Cadastro de Aluno";
		janela = new JFrame();
		// Cliente
		if (esc == 1) {
			TextCpf = new JTextField();
			TextTelefone = new JTextField();
			TextNome = new JTextField();
			escolha = 1;
		}
		if (esc == 3) {
			TextCpf = new JTextField(DadosPessoa.getListaclientes().get(pos).getCpf());
			TextTelefone = new JTextField(DadosPessoa.getListaclientes().get(pos).getTelefone());
			TextNome = new JTextField(DadosPessoa.getListaclientes().get(pos).getNome());
			escolha = 3;
		}

		labelNome.setBounds(30, 20, 150, 25);
		TextNome.setBounds(180, 20, 180, 25);
		labelTelefone.setBounds(30, 50, 150, 25);
		TextTelefone.setBounds(180, 50, 180, 25);
		labelCpf.setBounds(30, 80, 180, 25);
		TextCpf.setBounds(180, 80, 180, 25);
		if (esc == 1 || esc == 3) {
			botaoSalvar.setBounds(30, 200, 115, 30);
		}
		if (esc == 3) {
			botaoExcluir.setBounds(180, 200, 115, 30);
		}
		this.janela.add(labelNome);
		this.janela.add(labelTelefone);
		this.janela.add(labelCpf);
		this.janela.add(labelCargo);
		this.janela.add(labelCargaHoraria);
		this.janela.add(labelSalario);
		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);
		this.janela.add(TextNome);
		this.janela.add(TextTelefone);
		this.janela.add(TextCpf);
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
		ControleCliente controlecliente = new ControleCliente();
		String cpf;
		String telefone;
		String nome;
		Object src = e.getSource();
		if (escolha == 1) {
			cpf = TextCpf.getText();

			telefone = TextTelefone.getText();

			nome = TextNome.getText();

			controlecliente.adicionaCliente(cpf, telefone, nome);
		}
		if (src == botaoSalvar) {
			mensagemSucessoCadastro();

		}
		if (src == botaoExcluir) {
			DadosPessoa.getListaclientes().remove(this.posicao);
			mensagemSucessoExclusao();
			escolha = 0;
		}
		if (escolha == 3) {
			cpf = TextCpf.getText();
			telefone = TextTelefone.getText();
			nome = TextNome.getText();
			controlecliente.alteraCliente(cpf, telefone, nome, this.posicao);
		}

	}

	public JFrame getJanela() {
		return janela;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public JTextField getTextNome() {
		return TextNome;
	}

	public JLabel getLabelTelefone() {
		return labelTelefone;
	}

	public JTextField getTextTelefone() {
		return TextTelefone;
	}

	public JLabel getLabelCpf() {
		return labelCpf;
	}

	public JTextField getTextCpf() {
		return TextCpf;
	}

	public JLabel getLabelCargo() {
		return labelCargo;
	}

	public JTextField getTextCargo() {
		return TextCargo;
	}

	public JLabel getLabelCargaHoraria() {
		return labelCargaHoraria;
	}

	public JTextField getTextCargaHoraria() {
		return TextCargaHoraria;
	}

	public JLabel getLabelSalario() {
		return labelSalario;
	}

	public JTextField getTextSalario() {
		return TextSalario;
	}

	public JButton getBotaoExcluir() {
		return botaoExcluir;
	}

	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

}
