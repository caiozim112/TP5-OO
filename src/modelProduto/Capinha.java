package modelProduto;

public final class Capinha extends Produto {
	private String cor;
	private String modelo;
	private int qnt;
	public Capinha(String id, String marca, String cor, String modelo,int qnt) {
		super(id, marca);
		this.cor = cor;
		this.modelo = modelo;
		this.qnt = qnt;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	

}