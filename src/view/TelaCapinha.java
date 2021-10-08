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

import modelproduto.Dados;

/**
 * implementacao da TelaCapinha Herda a classe Jframe e implementa a interface
 * ActionListener para criar e deixar o painel e suas usabilidades funcionais e
 * também a classe ListSelectionListener para selecionar objetos do JList
 * 
 * @author Caio Vitor
 * @version 1.0(outubro 2021)
 */
public class TelaCapinha extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JLabel titulo; // titulo é um objeto da classe JLabel
	private final JButton cadastroCapinha;
	private JButton refreshCapinha;
	private JList<String> listaCapinhasCadastradas;
	/**
	 * Construtor da Classe TelaCapinha
	 * que mostra o Jlist e adiciona eventos nos botoes
	 * 
	 * 
	 * 
	 */
	public TelaCapinha() {
		super("Tela Capinha");
		this.titulo = new JLabel("Tela Cadastrados Capinha");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 20));
		this.titulo.setBounds(90, 10, 250, 30);
		this.listaCapinhasCadastradas = new JList<String>(Dados.retornanomecapinhas());
		this.listaCapinhasCadastradas.setBounds(20, 50, 350, 120);
		this.listaCapinhasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaCapinhasCadastradas.setVisibleRowCount(10);// 10 linhas visiveis
		this.listaCapinhasCadastradas.addListSelectionListener(this);

		this.cadastroCapinha = new JButton("Cadastrar");
		this.cadastroCapinha.setBounds(70, 177, 100, 30);
		this.cadastroCapinha.addActionListener(this);

		this.refreshCapinha = new JButton("Refresh");
		this.refreshCapinha.setBounds(200, 177, 100, 30);
		this.refreshCapinha.addActionListener(this);

		this.setLayout(null);

		this.add(titulo);
		this.add(listaCapinhasCadastradas);
		this.add(cadastroCapinha);
		this.add(refreshCapinha);

		this.setSize(400, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		JButton botaoCadastroCapinha = (JButton) e.getSource();
		if (botaoCadastroCapinha == getCadastroCapinha()) {
			TelaDetalheCapinha TelaCadCapinha = new TelaDetalheCapinha();
			TelaCadCapinha.InserirDados(1, 0);
			getListaCapinhasCadastradas().updateUI();
		}
		if (botaoCadastroCapinha == getRefreshCapinha()) {
			getListaCapinhasCadastradas().setListData(Dados.retornanomecapinhas());
			getListaCapinhasCadastradas().updateUI();
		}
	}

	// JList ouvido
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		int qntnumeros = Dados.getListacapinhas().size();
		if (e.getValueIsAdjusting() && src == this.listaCapinhasCadastradas) {
			new TelaDetalheCapinha().InserirDados(2, this.listaCapinhasCadastradas.getSelectedIndex());
		}
		if (this.listaCapinhasCadastradas.getSelectedIndex() > qntnumeros) {
			mensagemlistavazia();
		}
		if (src == this.refreshCapinha) {
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

	public JButton getCadastroCapinha() {
		return cadastroCapinha;
	}

	public JButton getRefreshCapinha() {
		return refreshCapinha;
	}

	public JList<String> getListaCapinhasCadastradas() {
		return listaCapinhasCadastradas;
	}

}