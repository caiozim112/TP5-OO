package modelpessoa;

public final class Cliente extends Pessoa {
    public Cliente(String cpf, String telefone, String nome) {
        super(cpf, telefone, nome);
       
    }

	@Override
	public String toString() {
		return "Cliente [getCpf()=" + getCpf() + ", getTelefone()=" + getTelefone() + ", getNome()=" + getNome() + "]";
	}    
    
	

}