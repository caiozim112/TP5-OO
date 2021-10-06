package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.TelaDetalheLojaController;
import modelProduto.Dados;

public class TelaDetalheLoja implements ActionListener  {
	private JFrame janela;
	private JLabel labelnomeCliente = new JLabel("Nome do Cliente: ");
	private JTextField TextnomeCliente;
	private JLabel labelnomeFuncionario = new JLabel("Nome Do Funcionario: ");
	private JTextField TextnomeFuncionario;
	private JLabel labeltipoProduto=new JLabel("Tipo de Produto: ");
	private JTextField TexttipoProduto;
	private JLabel labelidProduto=new JLabel("Id: ");
	private JTextField TextidProduto;
	private JLabel labelqnt = new JLabel("Quantidade: ");
	private JTextField TextqntProduto;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	int escolha=0;
	int posicao=0;
	private TelaDetalheLojaController controle;
	public void InserirDados(int esc ,int pos) {
		this.posicao=pos;
		this.controle= new TelaDetalheLojaController(this);
		// s = "Cadastro de Aluno";
		janela = new JFrame();
		//Cliente
		if(esc == 1) {
			TextnomeCliente = new JTextField();
			TextnomeFuncionario = new JTextField();
			TexttipoProduto = new JTextField();
			TextidProduto = new JTextField();
			TextqntProduto= new JTextField();
			escolha =1;
		}
		if (esc == 3) {
		TextnomeCliente = new JTextField(Dados.getListavenda().get(pos).getNomeCliente());
		TextnomeFuncionario = new JTextField(Dados.getListavenda().get(pos).getNomeFuncionario());
		TexttipoProduto = new JTextField(Dados.getListavenda().get(pos).getTipoproduto());
		TextidProduto = new JTextField(Dados.getListavenda().get(pos).getId());
		TextqntProduto= new JTextField(String.valueOf(Dados.getListavenda().get(pos).getQnt()));
		
		}
		
		labelnomeCliente.setBounds(30, 20, 150, 25);
		TextnomeCliente.setBounds(180, 20, 180, 25);
		labelnomeFuncionario.setBounds(30, 50, 150, 25);
		TextnomeFuncionario.setBounds(180, 50, 180, 25);
		labeltipoProduto.setBounds(30, 80, 180, 25);
		TexttipoProduto.setBounds(180, 80, 180, 25);
		labelidProduto.setBounds(30, 110, 150, 25);
		TextidProduto.setBounds(180, 110, 180, 25);
		labelqnt.setBounds(30, 140, 150, 25);
		TextqntProduto.setBounds(180, 140, 180, 25);
		
		if (esc == 1) {
			botaoSalvar.setBounds(30, 200, 115, 30);
		}
		if (esc==3) {
			botaoExcluir.setBounds(180,200,115,30);
		}
		this.janela.add(labelnomeCliente);
		this.janela.add(labelnomeFuncionario);
		this.janela.add(labeltipoProduto);
		this.janela.add(labelidProduto);
		this.janela.add(TextidProduto);
		this.janela.add(labelqnt);
		this.janela.add(botaoExcluir);
		this.janela.add(botaoSalvar);
		this.janela.add(TextnomeCliente);
		this.janela.add(TextnomeFuncionario);
		this.janela.add(TexttipoProduto);
		this.janela.add(TextqntProduto);
		this.janela.setLayout(null);

		this.janela.setSize(400, 300);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controle.executaBotao(e);
	}
	public JFrame getJanela() {
		return janela;
	}
	public JLabel getLabelnomeCliente() {
		return labelnomeCliente;
	}
	public JTextField getTextnomeCliente() {
		return TextnomeCliente;
	}
	public JLabel getLabelnomeFuncionario() {
		return labelnomeFuncionario;
	}
	public JTextField getTextnomeFuncionario() {
		return TextnomeFuncionario;
	}
	public JLabel getLabeltipoProduto() {
		return labeltipoProduto;
	}
	public JTextField getTexttipoProduto() {
		return TexttipoProduto;
	}
	public JLabel getLabelqnt() {
		return labelqnt;
	}
	public JTextField getTextqntProduto() {
		return TextqntProduto;
	}
	public JButton getBotaoExcluir() {
		return botaoExcluir;
	}
	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}
	public int getEscolha() {
		return escolha;
	}
	public int getPosicao() {
		return posicao;
	}
	public JLabel getLabelidProduto() {
		return labelidProduto;
	}
	public JTextField getTextidProduto() {
		return TextidProduto;
	}
	public TelaDetalheLojaController getControle() {
		return controle;
	}
	

}
