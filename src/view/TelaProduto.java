package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.TelaProdutoController;

public class TelaProduto extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JFrame janela = new JFrame("Controle de Vendas");
	private final JLabel titulo = new JLabel("Menu Principal");
	private final JButton Capinha = new JButton("Capinha");
	private final JButton Carregador = new JButton("Carregador");
	private final JButton Tela = new JButton("Tela");
	private final TelaProdutoController controller;
	
	public TelaProduto() {
		super("Menu Produto");
		this.controller = new TelaProdutoController(this);
		
		this.setLayout(new GridLayout(4, 2));
		
		this.add(Capinha);
		this.Capinha.addActionListener(this);
		
		this.add(Carregador);
		this.Carregador.addActionListener(this);
		
		this.add(Tela);
		this.Tela.addActionListener(this);
		
		this.setSize(300, 200);
		this.setVisible(true);	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controller.executaBotao(e);
		
	}


	public JFrame getJanela() {
		return janela;
	}


	public JLabel getTitulo() {
		return titulo;
	}


	public JButton getCapinha() {
		return Capinha;
	}


	public JButton getCarregador() {
		return Carregador;
	}


	public JButton getTela() {
		return Tela;
	}
	
	
	
}
