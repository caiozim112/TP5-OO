package modelproduto;

public final class Tela extends Produto {
	private String modelo;
	private int qnt;
	public Tela(String id, String marca, String modelo,int qnt) {
		super(id, marca);
		this.modelo = modelo;
		this.qnt= qnt;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Tela [modelo=" + modelo + ", qnt=" + qnt + ", id=" + id + ", marca=" + marca + "]";
	}
	
}
