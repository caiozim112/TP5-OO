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

import controller.TelaClienteController;
import modelpessoa.DadosPessoa;

//front-end
public class TelaCliente extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel titulo; // titulo é um objeto da classe JLabel
	private final JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton buscarCliente;
	private JList<String> listaClientesCadastrados;
	private final TelaClienteController controller;
	private JLabel labelcliente = new JLabel("buscar");
	private JTextField buscar;

	public TelaCliente() {
		super("TelaPessoa");
		// this refere ao objeto que a pessoa tá construindo
		this.controller = new TelaClienteController(this);
		this.titulo = new JLabel("Cliente Cadastrados");
		this.titulo.setFont(new Font("Arial", Font.BOLD, 20));
		this.titulo.setBounds(90, 10, 250, 30);
		this.listaClientesCadastrados = new JList<String>(DadosPessoa.retornanome());
		this.listaClientesCadastrados.setBounds(20, 50, 350, 120);
		this.listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.listaClientesCadastrados.setVisibleRowCount(10);// 10 linhas visiveis
		this.listaClientesCadastrados.addListSelectionListener(this);
		
		this.cadastroCliente = new JButton("Cadastrar");
		this.cadastroCliente.setBounds(70, 177, 100, 30);
		this.cadastroCliente.addActionListener(this);

		this.refreshCliente = new JButton("Refresh");
		this.refreshCliente.setBounds(200, 177, 100, 30);
		this.refreshCliente.addActionListener(this);

		this.buscarCliente = new JButton("Buscar");
		this.buscarCliente.setBounds(330, 177, 100, 30);
		this.buscarCliente.addActionListener(this);

		buscar = new JTextField();
		this.add(buscar);
		this.add(labelcliente);
		this.buscar.setBounds(330, 20, 150, 25);
		this.labelcliente.setBounds(280, 20, 180, 25);
		this.setLayout(null);

		this.add(titulo);
		this.add(listaClientesCadastrados);
		this.add(cadastroCliente);
		this.add(refreshCliente);
		this.add(buscarCliente);

		this.setSize(500, 250);
		this.setVisible(true);
	}

	@Override // Botao ouvido
	public void actionPerformed(ActionEvent e) {
		this.controller.executaBotao(e);
	}

	// JList ouvido
	public void valueChanged(ListSelectionEvent e) {
		this.controller.executaLista(e);
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JButton getRefreshCliente() {
		return refreshCliente;
	}

	public JList<String> getListaClientesCadastrados() {
		return listaClientesCadastrados;
	}

	public void setListaClientesCadastrados(JList<String> listaClientesCadastrados) {
		this.listaClientesCadastrados = listaClientesCadastrados;
	}

	public JButton getCadastroCliente() {
		return cadastroCliente;
	}

	public JButton getBuscarCliente() {
		return buscarCliente;
	}

	public void setBuscarCliente(JButton buscarCliente) {
		this.buscarCliente = buscarCliente;
	}

	public TelaClienteController getController() {
		return controller;
	}

	public JLabel getLabelcliente() {
		return labelcliente;
	}

	public JTextField getBuscar() {
		return buscar;
	}

}