package controle;
import modelProduto.Dados;
import modelProduto.Tela;
public class ControleTela {
		Tela t;
		public ControleTela() {

		}

		public void adicionaTela(String id, String marca, String modelo,int qnt) {
			this.t = new Tela(id,marca,modelo, qnt);
			Dados.getListatelas().add(t);
		}

		public void alteraTela(String id, String marca, String modelo,int qnt, int pos) {
			for (Tela t : Dados.getListatelas()) {
				if (Dados.getListatelas().get(pos).getId().equals(t.getId())) {
					t.setId(id);
					t.setMarca(marca);
					t.setModelo(modelo);
				}

			}
		}
	}