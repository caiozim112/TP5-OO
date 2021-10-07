package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import controller.TelaMenuController;

public class  TelaMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JFrame janela = new JFrame("Controle de Vendas");
	private final JLabel titulo = new JLabel("Menu Principal");
	private final JButton cliente = new JButton("Cliente");
	private final JButton funcionario = new JButton("Funcionario");
	private final JButton produto = new JButton("Produto");
	private final JButton venda = new JButton("Loja/Venda");
	private final JButton estoque = new JButton("Estoque");
	private final TelaMenuController controller;

	public TelaMenu() {
		super("Menu");
		this.controller= new TelaMenuController(this);
		this.setLayout(new GridLayout(4, 2));
		
		this.add(cliente);//adiciona o botao cliente
		this.cliente.addActionListener(this);//coloca o ouvido
		
		this.add(funcionario);
		this.funcionario.addActionListener(this);
		
		this.add(produto);
		this.produto.addActionListener(this);
		
		this.add(venda);
		this.venda.addActionListener(this);
		
		this.add(estoque);
		this.estoque.addActionListener(this);
		
		this.setSize(300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executaBotaoProgramaPrincipal(e);
	}

	public JFrame getJanela() {
		return janela;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JButton getEstoque() {
		return estoque;
	}

	public JButton getCliente() {
		return cliente;
	}

	public JButton getFuncionario() {
		return funcionario;
	}

	public JButton getProduto() {
		return produto;
	}

	public JButton getVenda() {
		return venda;
	}

	public TelaMenuController getController() {
		return controller;
	}

}