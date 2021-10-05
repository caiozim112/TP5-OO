package modelpessoa;

import java.util.ArrayList;
import java.util.List;

public abstract class DadosPessoa {
	private static final List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	private static final List<Cliente> listaClientes = new ArrayList<Cliente>();

	private DadosPessoa() {
	}

	public static List<Funcionario> getListafuncionarios() {
		return listaFuncionarios;
	}

	public static List<Cliente> getListaclientes() {
		return listaClientes;
	}
	
	public static String[] retornanome() {//feito
		String [] s= new String[100];
		for (int i = 0; i < listaClientes.size(); i++) {
			s[i]=listaClientes.get(i).getNome();
		}
		return s;
	}
	public static String[] retornanomeFuncionario() {//feito
		String [] s= new String[100];
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			s[i]=listaFuncionarios.get(i).getNome();
		}
		return s;
	}
	
	public static String[] procuracliente(String nome) {
		
		String [] u= new String[100];
		for (int i = 0; i < listaClientes.size(); i++) {
			if(nome.equals(listaClientes.get(i).getNome())) {
			u[i]=listaClientes.get(i).getNome();
		}
	}
		return u;
	}
	public static String[] procuraFuncionario(String nome) {
		
		String [] u= new String[100];
		for (int i = 0; i < listaFuncionarios.size(); i++) {
			if(nome.equals(listaFuncionarios.get(i).getNome())) {
			u[i]=listaFuncionarios.get(i).getNome();
		}
	}
		return u;
	}
	

}
