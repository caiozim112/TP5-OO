package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.TelaFuncionarioController;
import controller.TelaClienteController;
import modelpessoa.DadosPessoa;

//front-end
public class TelaFuncionario extends JFrame implements ActionListener, ListSelectionListener {

	private JLabel titulo; // titulo é um objeto da classe JLabel
	private final JButton cadastroFuncionario;
	private JButton refreshFuncionario;
	private JButton buscarFuncionario;
	private JList<String> listaFuncionariosCadastrados;
	private final TelaFuncionarioController controller;
	private JLabel labelFuncionario = new JLabel("buscar");
	private JTextField buscar;

	public TelaFuncionario() {
		super("TelaPessoa");
		// this refere ao objeto que a pessoa tá construindo
		this.controller = new TelaFuncionarioController(this);
		this.titulo = new JLabel("Funcionarios Cad");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 20));
		this.titulo.setBounds(90, 10, 250, 30);
		this.listaFuncionariosCadastrados = new JList<String>(DadosPessoa.retornanomeFuncionario());
		this.listaFuncionariosCadastrados.setBounds(20, 50, 350, 120);
		this.listaFuncionariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaFuncionariosCadastrados.setVisibleRowCount(10);
		this.listaFuncionariosCadastrados.addListSelectionListener(this);

		this.cadastroFuncionario = new JButton("Cadastrar");
		this.cadastroFuncionario.setBounds(70, 177, 100, 30);
		this.cadastroFuncionario.addActionListener(this);

		this.refreshFuncionario = new JButton("Refresh");
		this.refreshFuncionario.setBounds(200, 177, 100, 30);
		this.refreshFuncionario.addActionListener(this);

		this.buscarFuncionario = new JButton("Buscar");
		this.buscarFuncionario.setBounds(330, 177, 100, 30);
		this.buscarFuncionario.addActionListener(this);

		buscar = new JTextField();
		this.add(buscar);
		this.add(labelFuncionario);
		this.buscar.setBounds(330, 20, 150, 25);
		this.labelFuncionario.setBounds(280, 20, 180, 25);
		this.setLayout(null);

		this.setLayout(null);

		this.add(titulo);
		this.add(listaFuncionariosCadastrados);
		this.add(cadastroFuncionario);
		this.add(refreshFuncionario);
		this.add(buscarFuncionario);
		this.setSize(500, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		JButton botaoCadastroFuncionario = (JButton) e.getSource();
		if (botaoCadastroFuncionario == getCadastroFuncionario()) {
			TelaDetalheFuncionario TelaCadFuncionario = new TelaDetalheFuncionario();
			TelaCadFuncionario.InserirDados(1, 0);
			getListaFuncionariosCadastrados().updateUI();
		}
		if (botaoCadastroFuncionario == getRefreshFuncionario()) {
			getListaFuncionariosCadastrados().setListData(DadosPessoa.retornanomeFuncionario());
			getListaFuncionariosCadastrados().updateUI();
		}

		if (botaoCadastroFuncionario == getBuscarFuncionario() && buscar.getText() != null) {
			String nomeFuncionariobuscar = buscar.getText();
			getListaFuncionariosCadastrados().setListData(DadosPessoa.procuraFuncionario(nomeFuncionariobuscar));
			getListaFuncionariosCadastrados().updateUI();
		}
	}

	// JList ouvido
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		int qntnumeros = DadosPessoa.getListafuncionarios().size();
		if (e.getValueIsAdjusting() && src == this.listaFuncionariosCadastrados) {
			System.out.println("oila" + this.listaFuncionariosCadastrados.getSelectedIndex());
			new TelaDetalheFuncionario().InserirDados(2, this.listaFuncionariosCadastrados.getSelectedIndex());
		}
		if (this.listaFuncionariosCadastrados.getSelectedIndex() > qntnumeros) {
			mensagemlistavazia();
		}
		if (src == this.refreshFuncionario) {
			mensagematualiza();
		}
	}

	public void mensagemlistavazia() {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro.\n " + "Cadastre um Cliente\n", null,
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagematualiza() {
		JOptionPane.showMessageDialog(null, "Atualizou os dados\n ", null, JOptionPane.ERROR_MESSAGE);
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JButton getRefreshFuncionario() {
		return refreshFuncionario;
	}

	public JList<String> getListaFuncionariosCadastrados() {
		return listaFuncionariosCadastrados;
	}

	public JButton getCadastroFuncionario() {
		return cadastroFuncionario;
	}

	public TelaFuncionarioController getController() {
		return controller;
	}

	public JButton getBuscarFuncionario() {
		return buscarFuncionario;
	}

}