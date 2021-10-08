package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField; 

import controle.ControleTela;
import modelproduto.Dados;

	public class TelaDetalheTela implements ActionListener {
		private JFrame janela;
		private JLabel labelId = new JLabel("Id: ");
		private JTextField TextId;
		private JLabel labelMarca= new JLabel("Marca: ");
		private JTextField TextMarca;
		private JLabel labelModelo = new JLabel("Modelo: ");
		private JTextField TextModelo;
		private JLabel labelQnt = new JLabel("Qnt: ");
		private JTextField TextQnt;
		private JButton botaoExcluir = new JButton("Excluir");
		private JButton botaoSalvar = new JButton("Salvar");
		int escolha=0;
		int posicao=0;
		public void InserirDados(int esc ,int pos) {
			this.posicao=pos;
			// s = "Cadastro de Aluno";
			janela = new JFrame();
			//Cliente
			if(esc==1) {
				TextId = new JTextField();
				TextMarca = new JTextField();
				TextModelo = new JTextField();
				TextQnt= new JTextField();
				escolha=1;
			}
			if (esc == 2) {
				TextId = new JTextField(Dados.getListatelas().get(pos).getId());
				TextMarca = new JTextField(Dados.getListatelas().get(pos).getMarca());
				TextModelo = new JTextField(Dados.getListatelas().get(pos).getModelo());
				TextQnt= new JTextField(Integer.toString(Dados.getListatelas().get(pos).getQnt()));
				escolha=2;
			}
			
			labelId.setBounds(30, 20, 150, 25);
			TextId.setBounds(180, 20, 180, 25);
			labelMarca.setBounds(30, 50, 150, 25);
			TextMarca.setBounds(180, 50, 180, 25);
			labelModelo.setBounds(30, 80, 150, 25);
			TextModelo.setBounds(180, 80, 180, 25);
			labelQnt.setBounds(30,110,150,25);
			TextQnt.setBounds(180,110,180,25);
			if (esc == 1||esc==2) {
				botaoSalvar.setBounds(30, 200, 115, 30);
			}
			if (esc==2) {
				botaoExcluir.setBounds(180,200,115,30);
			}
			this.janela.add(labelId);
			this.janela.add(TextId);
			this.janela.add(labelMarca);
			this.janela.add(TextMarca);
			this.janela.add(labelModelo);
			this.janela.add(TextModelo);
			this.janela.add(labelQnt);
			this.janela.add(TextQnt);
			
			this.janela.add(botaoExcluir);
			this.janela.add(botaoSalvar);
			this.janela.setLayout(null);

			this.janela.setSize(400, 300);
			this.janela.setVisible(true);

			botaoSalvar.addActionListener(this);
			botaoExcluir.addActionListener(this);
			

		}

		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}

		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}

		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,
					"ERRO AO SALVAR OS DADOS!\n " + "Pode ter ocorrido um dos dois erros a seguir:  \n"
							+ "1. Nem todos os campos foram preenchidos \n"
							+ "2. CPF, identidade, DDD e telefone n�o cont�m apenas n�meros",
					null, JOptionPane.ERROR_MESSAGE);
		}

		public void mensagemErroExclusaoAluno() {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao excluir o dado.\n " + "Verifique se o aluno est� matriculado\n"
							+ "em alguma disciplina. Se sim, cancele\n " + "a matricula e tente novamente.",
					null, JOptionPane.ERROR_MESSAGE);
		}

		public void mensagemErroExclusaoProf() {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro ao excluir o dado.\n " + "Verifique se o professor est� respons�vel\n"
							+ "por alguma disciplina. Se sim, substitua\n " + "o professor e tente novamente.",
					null, JOptionPane.ERROR_MESSAGE);
		}
		public void actionPerformed(ActionEvent e) {
			ControleTela controletela = new ControleTela();
			String id;
			String marca;
			String modelo;
			int qnt;
			Object src = e.getSource();
			if(escolha ==1) {
				id = TextId.getText();

				marca = TextMarca.getText();

				modelo = TextModelo.getText();
				
				qnt= Integer.parseInt(TextQnt.getText());
				
				controletela.adicionaTela(id, marca, modelo,qnt);
			}
			if(src == botaoSalvar) {
			mensagemSucessoCadastro();
			
			}
			if(src==botaoExcluir) {
						Dados.getListatelas().remove(this.posicao);
						mensagemSucessoExclusao();
						escolha = 0;
					}
			if(escolha==2) {
				id = TextId.getText();

				marca = TextMarca.getText();

				modelo = TextModelo.getText();
				
				qnt= Integer.parseInt(TextQnt.getText());
				
				controletela.alteraTela(id, marca, modelo,qnt, this.posicao);
			}

		}

		
		
		
		}
