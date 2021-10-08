package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleFuncionario;
import modelpessoa.DadosPessoa;

public class TelaDetalheFuncionario implements ActionListener {
	private JFrame janela;
	private JLabel labelCpf = new JLabel("Cpf: ");
	private JTextField TextCpf;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField TextTelefone;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField TextNome;
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
		this.posicao = pos;// pega a posicao do ArrayList
		janela = new JFrame();

		if (esc == 1) {
			TextCpf = new JTextField();
			TextTelefone = new JTextField();
			TextNome = new JTextField();
			TextCargo = new JTextField();
			TextCargaHoraria = new JTextField();
			TextSalario = new JTextField();
			escolha = 1;
		}
		if (esc == 2) {
			TextCpf = new JTextField(DadosPessoa.getListafuncionarios().get(pos).getCpf());
			TextTelefone = new JTextField(DadosPessoa.getListafuncionarios().get(pos).getTelefone());
			TextNome = new JTextField(DadosPessoa.getListafuncionarios().get(pos).getNome());
			TextCargo = new JTextField(DadosPessoa.getListafuncionarios().get(pos).getCargo());
			TextCargaHoraria = new JTextField(Integer.toString(DadosPessoa.getListafuncionarios().get(pos).getCargaHoraria()));//Usado para passar String para Int
			TextSalario = new JTextField(Double.toString(DadosPessoa.getListafuncionarios().get(pos).getSalario()));//usado para passar Stign para Double
			escolha = 2;
		}
		labelCpf.setBounds(30, 20, 150, 25);
		TextCpf.setBounds(180, 20, 180, 25);
		labelTelefone.setBounds(30, 50, 150, 25);
		TextTelefone.setBounds(180, 50, 180, 25);
		labelNome.setBounds(30, 80, 150, 25);
		TextNome.setBounds(180, 80, 180, 25);
		labelCargo.setBounds(30, 110, 150, 25);
		TextCargo.setBounds(180, 110, 180, 25);
		labelCargaHoraria.setBounds(30, 140, 150, 25);
		TextCargaHoraria.setBounds(180, 140, 180, 25);
		labelSalario.setBounds(30, 170, 150, 25);
		TextSalario.setBounds(180, 170, 180, 25);
		if (esc == 1 || esc == 2) {
			botaoSalvar.setBounds(30, 200, 115, 30);
		}
		if (esc == 2) {
			botaoExcluir.setBounds(180, 200, 115, 30);
		}
		this.janela.add(labelNome);
		this.janela.add(labelTelefone);
		this.janela.add(labelCpf);
		this.janela.add(labelCargo);
		this.janela.add(labelCargaHoraria);
		this.janela.add(labelSalario);
		this.janela.add(TextSalario);
		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);
		this.janela.add(TextNome);
		this.janela.add(TextTelefone);
		this.janela.add(TextCpf);
		this.janela.add(TextCargo);
		this.janela.add(TextCargaHoraria);
		this.janela.setLayout(null);

		this.janela.setSize(400, 300);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);

	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
				JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos!", null, JOptionPane.INFORMATION_MESSAGE);
		this.janela.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		ControleFuncionario controleFuncionario = new ControleFuncionario();
		String cpf = null;
		String telefone = null;
		String nome = null;
		String cargo = null;
		int cargaHoraria = 0;
		double salario = 0.0;
		Object src = e.getSource();
		if (escolha == 1) {
			cpf = TextCpf.getText();

			telefone = TextTelefone.getText();

			nome = TextNome.getText();

			cargo = TextCargo.getText();

			cargaHoraria = Integer.parseInt(TextCargaHoraria.getText());//Usado para passar String para Int

			salario = Double.parseDouble(TextSalario.getText());//Usado para passar a String para Double

			controleFuncionario.adicionaFuncionario(cpf, telefone, nome, cargo, cargaHoraria, salario);
		}
		if (src == botaoSalvar) {
			mensagemSucessoCadastro();
		}
		if (src == botaoExcluir) {
					DadosPessoa.getListafuncionarios().remove(posicao);
					mensagemSucessoExclusao();

				escolha = 0;
		}
		if (escolha == 2) {
			cpf = TextCpf.getText();

			telefone = TextTelefone.getText();

			nome = TextNome.getText();

			cargo = TextCargo.getText();

			cargaHoraria = Integer.parseInt(TextCargaHoraria.getText());//Usado para passar String para Int

			salario = Double.parseDouble(TextSalario.getText());//Usado para passar a String para Double

			controleFuncionario.alteraFuncionario(cpf, telefone, nome, cargo, cargaHoraria, salario, this.posicao);
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
