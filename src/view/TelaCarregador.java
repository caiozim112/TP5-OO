package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelProduto.Dados;



//front-end
public class TelaCarregador extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private JLabel titulo; // titulo é um objeto da classe JLabel
	private final JButton cadastroCarregador;
	private JButton refreshCarregador;
	private JList<String> listaCarregadoresCadastradas;

	public TelaCarregador() {
		super("Tela Carregador");
		// this refere ao objeto que a pessoa tá construind
		this.titulo = new JLabel("Cadastrados Carregadores");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.titulo.setBounds(0, 10, 250, 30);
		this.listaCarregadoresCadastradas = new JList<String>(Dados.retornanomecarrregadores());
		this.listaCarregadoresCadastradas.setBounds(20, 50, 350, 120);
		this.listaCarregadoresCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaCarregadoresCadastradas.setVisibleRowCount(10);// 10 linhas visiveis
		this.listaCarregadoresCadastradas.addListSelectionListener(this);

		this.cadastroCarregador = new JButton("Cadastrar");
		this.cadastroCarregador.setBounds(70, 177, 100, 30);
		this.cadastroCarregador.addActionListener(this);

		this.refreshCarregador = new JButton("Refresh");
		this.refreshCarregador.setBounds(200, 177, 100, 30);
		this.refreshCarregador.addActionListener(this);

		this.setLayout(null);

		this.add(titulo);
		this.add(listaCarregadoresCadastradas);
		this.add(cadastroCarregador);
		this.add(refreshCarregador);

		this.setSize(400, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		JButton botaoCadastroCarregador = (JButton) e.getSource();
		if (botaoCadastroCarregador == getCadastroCarregador()) {
			TelaDetalheCarregador TelaCadCarregador = new TelaDetalheCarregador();
			TelaCadCarregador.InserirDados(1,0);
			getListaCarregadoresCadastradas().updateUI();
		}
		if (botaoCadastroCarregador == getRefreshCarregador()) {
			getListaCarregadoresCadastradas().setListData(Dados.retornanomecarrregadores());
			getListaCarregadoresCadastradas().updateUI();
		}
	}

	// JList ouvido
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		int qntnumeros = Dados.getListacarrregadores().size();
		if (e.getValueIsAdjusting() && src == this.listaCarregadoresCadastradas) {
			new TelaDetalheCarregador().InserirDados(2, this.listaCarregadoresCadastradas.getSelectedIndex());
		}
		if (this.listaCarregadoresCadastradas.getSelectedIndex() > qntnumeros) {
			mensagemlistavazia();
		}
		if (src == this.refreshCarregador) {
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

	public JButton getCadastroCarregador() {
		return cadastroCarregador;
	}

	public JButton getRefreshCarregador() {
		return refreshCarregador;
	}

	public JList<String> getListaCarregadoresCadastradas() {
		return listaCarregadoresCadastradas;
	}



}