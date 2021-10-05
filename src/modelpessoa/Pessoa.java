package modelpessoa;
public abstract class Pessoa {
    private String cpf;
    private String telefone;
    private String nome;

    protected Pessoa(String cpf, String telefone, String nome) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void alt() {
   
    }
    
    public void del() {
    	
    }
    
    public void listar() {
    	
    }
    
}
