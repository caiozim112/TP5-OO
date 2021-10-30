package view;

import javax.swing.JButton;

import modelproduto.Carregador;
import modelproduto.Dados;
import modelproduto.Produto;

public class TelaProdutoJlist {
	private TelaProdutoProdutos controle;
	
	public void MostraProduto(JButton Escolha,int id){
		
		if(Escolha==controle.getCadastro()) {
			((Carregador)Dados.getListaprodutos().get(0)).getId();
		}
		
		if(Escolha=="Carregador") {
			
		}
		
		if(Escolha=="Tela") {
			
		}
		for(Produto produtos: Dados.getListaprodutos()) {
			if(produtos instanceof Carregador )){
			Dados.getListaprodutos().get(id).getMarca()
				((Carregador) produtos).getMarca()
				;
			}
		}
		Dados.getListaprodutos().get(id).getMarca();
		
	
	
	
}
