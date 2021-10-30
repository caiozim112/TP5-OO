
package view;

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

import controller.TelaProdutoProdutosController;
import modelproduto.Dados;

public class TelaProdutoProdutos extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private JLabel titulo; // titulo é um objeto da classe JLabel
	private final JButton cadastro;
	private JButton refresh;
	private JList<String> listaCapinhasCadastradas;
	private JList<String> listaCarregadoresCadastrados;
	private JList<String> listaTelasCadastradas;
	private final TelaProdutoProdutosController controle;

	/**
	 * Construtor da Classe TelaCapinha que mostra o Jlist e adiciona eventos nos
	 * botoes
	 * 
	 * 
	 * 
	 */
	public TelaProdutoProdutos(String Escolha) {
		super("");
		controle = new TelaProdutoProdutosController();
		if (Escolha.equalsIgnoreCase("Capinha")) {
			this.listaCapinhasCadastradas = new JList<String>( Dados.retornanomecapinha());
			this.listaCapinhasCadastradas.setBounds(20, 50, 350, 120);
			this.listaCapinhasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			this.listaCapinhasCadastradas.setVisibleRowCount(10);// 10 linhas visiveis
			this.listaCapinhasCadastradas.addListSelectionListener(this);
			this.add(listaCapinhasCadastradas);

		}
		if (Escolha.equalsIgnoreCase("Carregador")) {
			this.listaCarregadoresCadastrados = new JList<String>();
			this.listaCarregadoresCadastrados.setBounds(20, 50, 350, 120);
			this.listaCarregadoresCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			this.listaCarregadoresCadastrados.setVisibleRowCount(10);// 10 linhas visiveis
			this.listaCarregadoresCadastrados.addListSelectionListener(this);
			this.add(listaCarregadoresCadastrados);

		}
		if (Escolha.equalsIgnoreCase("Tela")) {
			this.listaTelasCadastradas = new JList<String>();
			this.listaTelasCadastradas.setBounds(20, 50, 350, 120);
			this.listaTelasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			this.listaTelasCadastradas.setVisibleRowCount(10);// 10 linhas visiveis
			this.listaTelasCadastradas.addListSelectionListener(this);
		}

		this.cadastro= new JButton("Cadastrar");
		this.cadastro.setBounds(70, 177, 100, 30);
		this.cadastro.addActionListener(this);

		this.refresh = new JButton("Refresh");
		this.refresh.setBounds(200, 177, 100, 30);
		this.refresh.addActionListener(this);

		this.setLayout(null);

		this.add(cadastro);
		this.add(refresh);

		this.setSize(400, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		int Vetor=listaCapinhasCadastradas.getSelectedIndex();
		controle.ExecutaAcoes(e,Vetor);
		
	}

	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

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

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JButton getRefresh() {
		return refresh;
	}

	public void setRefresh(JButton refresh) {
		this.refresh = refresh;
	}

	public JList<String> getListaCapinhasCadastradas() {
		return listaCapinhasCadastradas;
	}

	public void setListaCapinhasCadastradas(JList<String> listaCapinhasCadastradas) {
		this.listaCapinhasCadastradas = listaCapinhasCadastradas;
	}

	public JList<String> getListaCarregadoresCadastrados() {
		return listaCarregadoresCadastrados;
	}

	public void setListaCarregadoresCadastrados(JList<String> listaCarregadoresCadastrados) {
		this.listaCarregadoresCadastrados = listaCarregadoresCadastrados;
	}

	public JList<String> getListaTelasCadastradas() {
		return listaTelasCadastradas;
	}

	public void setListaTelasCadastradas(JList<String> listaTelasCadastradas) {
		this.listaTelasCadastradas = listaTelasCadastradas;
	}

	public JButton getCadastro() {
		return cadastro;
	}

	
}