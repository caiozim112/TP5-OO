package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.TelaLojaController;
import modelProduto.Dados;


//front-end
public class TelaLoja extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titulo; // titulo é um objeto da classe JLabel
	private final JButton cadastroVenda;
	private JButton refreshVenda;
	private JList<String> listaVendasCadastradas;
	private TelaLojaController controle;
	public TelaLoja() {
		super("Tela Capinha");
		this.controle=new TelaLojaController(this);
		// this refere ao objeto que a pessoa tá construind
		this.titulo = new JLabel("Tela Cadastro Vendas");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 20));
		this.titulo.setBounds(90, 10, 250, 30);
		this.listaVendasCadastradas = new JList<String>(Dados.retornanomevendas());
		this.listaVendasCadastradas.setBounds(20, 50, 350, 120);
		this.listaVendasCadastradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaVendasCadastradas.setVisibleRowCount(10);// 10 linhas visiveis
		this.listaVendasCadastradas.addListSelectionListener(this);

		this.cadastroVenda = new JButton("Cadastrar");
		this.cadastroVenda.setBounds(70, 177, 100, 30);
		this.cadastroVenda.addActionListener(this);

		this.refreshVenda = new JButton("Refresh");
		this.refreshVenda.setBounds(200, 177, 100, 30);
		this.refreshVenda.addActionListener(this);

		this.setLayout(null);

		this.add(titulo);
		this.add(listaVendasCadastradas);
		this.add(cadastroVenda);
		this.add(refreshVenda);

		this.setSize(400, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		this.controle.executaBotao(e);
		
	}

	// JList ouvido
	public void valueChanged(ListSelectionEvent e) {
		this.controle.executalista(e);
	}
	
	public JLabel getTitulo() {
		return titulo;
	}

	public JButton getCadastroVenda() {
		return cadastroVenda;
	}

	public JButton getRefreshVenda() {
		return refreshVenda;
	}

	public JList<String> getListaVendasCadastradas() {
		return listaVendasCadastradas;
	}



}