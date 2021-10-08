package controle;

import modelpessoa.DadosPessoa;
import modelpessoa.Funcionario;

public class ControleFuncionario {
	Funcionario f;

	public ControleFuncionario() {

	}

	/**
	 * adiciona no list instanciando a classe Funcionario
	 * @param cpf
	 * @param telefone
	 * @param nome
	 * @param cargo
	 * @param cargaHoraria
	 * @param salario
	 */
	public void adicionaFuncionario(String cpf, String telefone, String nome, String cargo, int cargaHoraria,double salario) {
		if(!cpf.isBlank() && !telefone.isBlank() && !nome.isBlank() && !cargo.isBlank() && cargaHoraria>0 && salario>0) {//usado como referencia pra evitar Cadatro de Dados em Branco
		this.f = new Funcionario(cpf, telefone, nome, cargo, cargaHoraria, salario);
		DadosPessoa.getListafuncionarios().add(f);
		
		}
	}

	/**
	 * recebe a posicao e usa os parametros para settar os atributos do Funcionario
	 * @param cpf
	 * @param telefone
	 * @param nome
	 * @param cargo
	 * @param cargaHoraria
	 * @param salario
	 * @param pos
	 * @return void
	 */
	public void alteraFuncionario(String cpf, String telefone, String nome, String cargo, int cargaHoraria,double salario, int pos) {
		for (Funcionario f : DadosPessoa.getListafuncionarios()) {
			if (DadosPessoa.getListafuncionarios().get(pos).getCpf().equals(f.getCpf())) {
				f.setCpf(cpf);
				f.setTelefone(telefone);
				f.setNome(nome);
				f.setCargo(cargo);
				f.setCargaHoraria(cargaHoraria);
				f.setSalario(salario);
			}
		}
	}
}