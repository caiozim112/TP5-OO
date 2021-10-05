package modelpessoa;

public final class Funcionario extends Pessoa {
    private String cargo;
    private int cargaHoraria;
    private double salario;

    public Funcionario(String cpf, String telefone, String nome, String cargo, int cargaHoraria, double salario) {
        super(cpf, telefone, nome);
        this.cargo = cargo;
        this.cargaHoraria = cargaHoraria;
        this.salario = salario;
    }

    

	public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
