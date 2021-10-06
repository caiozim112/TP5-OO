package modelProduto;
public class Loja {
	private String nomeCliente;
	private String nomeFuncionario;
	private String id;
	private int qnt;
	private String tipoproduto;
	private Double valor;
	public Loja(String nomeCliente, String nomeFuncionario,String tipoproduto, String id, int qnt,Double valor) {
		this.tipoproduto=tipoproduto;
		this.nomeCliente = nomeCliente;
		this.nomeFuncionario = nomeFuncionario;
		this.id = id;
		this.qnt = qnt;
		this.valor = valor;
	}


	
	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
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
