package controle;

import modelpessoa.DadosPessoa;
import modelpessoa.Funcionario;

public class ControleFuncionario {
	Funcionario f;

	public ControleFuncionario() {

	}

	public void adicionaFuncionario(String cpf, String telefone, String nome, String cargo, int cargaHoraria,double salario) {
		if(!cpf.isBlank() && !telefone.isBlank() && !nome.isBlank() && !cargo.isBlank() && cargaHoraria>0 && salario>0) {
		this.f = new Funcionario(cpf, telefone, nome, cargo, cargaHoraria, salario);
		
		DadosPessoa.getListafuncionarios().add(f);
		}
	}

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