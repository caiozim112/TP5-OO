package modelproduto;
public abstract class Produto {
	String id;
	String marca;

	protected Produto(String id, String marca) {
		this.id = id;
		this.marca = marca;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", marca=" + marca + "]";
	}

}
