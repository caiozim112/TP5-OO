package modelProduto;

public final class Carregador extends Produto {
	private String padrao;
	private int qnt;

	public Carregador(String id, String marca, String padrao, int qnt) {
		super(id, marca);
		this.padrao = padrao;
		this.qnt = qnt;
	}

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	@Override
	public String toString() {
		return " padrao=" + padrao + ", id=" + id + ", marca=" + marca + "]";
	}

}