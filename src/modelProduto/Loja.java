package modelProduto;
public class Loja {
	private String nomeCliente;
	private String nomeFuncionario;
	private String id;
	private int qnt;
	private String tipoproduto;
	
	public Loja(String nomeCliente, String nomeFuncionario,String tipoproduto, String id, int qnt) {
		this.tipoproduto=tipoproduto;
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.id = id;
		this.qnt = qnt;
	}


	
	public String getTipoproduto() {
		return tipoproduto;
	}



	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getNomeFuncionario() {
		return nomeFuncionario;
	}



	public String getId() {
		return id;
	}



	public int getQnt() {
		return qnt;
	}

	
	
}
