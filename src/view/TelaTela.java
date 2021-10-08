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



//front-end
public class TelaTela extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private final JButton cadastroTela;
	private JButton refreshTela;
	private JList<String> listaTelasCadastradas;

	public TelaTela() {
		super("Tela Tela");
		// this refere ao objeto que a pessoa tá construind
		this.titulo = new JLabel("Tela Cadastrados Tela");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 20));
		this.titulo.setBounds(90, 10, 250, 30);
		this.listaTelasCadastradas = new JList<String>(Dados.retornanometelas());
		this.listaTelasCadastradas.setBounds(20, 50, 350, 120);
		this.listaTelasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaTelasCadastradas.setVisibleRowCount(10);// 10 linhas visiveis
		this.listaTelasCadastradas.addListSelectionListener(this);

		this.cadastroTela = new JButton("Cadastrar");
		this.cadastroTela.setBounds(70, 177, 100, 30);
		this.cadastroTela.addActionListener(this);

		this.refreshTela = new JButton("Refresh");
		this.refreshTela.setBounds(200, 177, 100, 30);
		this.refreshTela.addActionListener(this);

		this.setLayout(null);

		this.add(titulo);
		this.add(listaTelasCadastradas);
		this.add(cadastroTela);
		this.add(refreshTela);

		this.setSize(400, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		JButton botaoCadastroTela = (JButton) e.getSource();
		if (botaoCadastroTela == getCadastroTela()) {
			TelaDetalheTela TelaCadTela= new TelaDetalheTela();
			TelaCadTela.InserirDados(1,0);
			getListaTelasCadastradas().updateUI();
		}
		if (botaoCadastroTela == getRefreshTela()) {
			getListaTelasCadastradas().setListData(Dados.retornanometelas());
			getListaTelasCadastradas().updateUI();
		}
	}

	// JList ouvido
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		int qntnumeros = Dados.getListatelas().size();
		if (e.getValueIsAdjusting() && src == this.listaTelasCadastradas) {
			new TelaDetalheTela().InserirDados(2, this.listaTelasCadastradas.getSelectedIndex());
		}
		if (this.listaTelasCadastradas.getSelectedIndex() > qntnumeros) {
			mensagemlistavazia();
		}
		if (src == this.refreshTela) {
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

	public JButton getCadastroTela() {
		return cadastroTela;
	}

	public JButton getRefreshTela() {
		return refreshTela;
	}

	public JList<String> getListaTelasCadastradas() {
		return listaTelasCadastradas;
	}

	


}