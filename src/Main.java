import modelProduto.Capinha;
import modelProduto.Dados;
import modelProduto.Tela;
import modelpessoa.Cliente;
import modelpessoa.DadosPessoa;
import modelpessoa.Funcionario;
import view.TelaMenu;
public class Main {

	public static void main(String[] args) {
		Dadosaleatorios();
		TelaMenu telaInicial = new TelaMenu();;
	}
	private static void Dadosaleatorios() {
		Cliente c=new Cliente("1223323442","33081267","Caio");
		DadosPessoa.getListaclientes().add(c);
		Funcionario f = new Funcionario("111111111","33081268","Felipe","Marketing",40,1500.00);
		DadosPessoa.getListafuncionarios().add(f);
		Capinha ca = new Capinha("3434","IPHONE","azul","IPHONE X",10);
		Dados.getListacapinhas().add(ca);
		Tela t = new Tela("5555","Samsung","S9",10);
		Dados.getListatelas().add(t);
	}
	
}
