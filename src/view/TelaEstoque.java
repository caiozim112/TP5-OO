package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelproduto.Dados;


//front-end
public class TelaEstoque extends JFrame implements ActionListener, ListSelectionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titulo; // titulo é um objeto da classe JLabel
	private JButton refreshVenda;
	private JList<String> listaEstoque;
	private JTextField receita;
		public TelaEstoque() {
		super("Tela Estoque");
		// this refere ao objeto que a pessoa tá construind
		this.titulo = new JLabel("Tela Cadastro Vendas");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 20));
		this.titulo.setBounds(90, 10, 250, 30);
		this.listaEstoque = new JList<String>(Dados.estoque());
		this.listaEstoque.setBounds(20, 50, 350, 120);
		this.listaEstoque.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaEstoque.setVisibleRowCount(10);// 10 linhas visiveis
		this.listaEstoque.addListSelectionListener(this);
		this.setLayout(null);
		
		System.out.println(Dados.estoque().toString());
		this.add(titulo);
		this.add(listaEstoque);
		this.setSize(400, 250);
		this.setVisible(true);
	}



	// JList ouvido

	
	public JLabel getTitulo() {
		return titulo;
	}



	public JButton getRefreshVenda() {
		return refreshVenda;
	}
	public JTextField getReceita() {
		return receita;
	}

	public void setReceita(JTextField receita) {
		this.receita = receita;
	}



	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}