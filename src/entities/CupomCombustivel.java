package entities;

public class CupomCombustivel extends Cupom {

	@Override
	public void listarCupom() {
		// TODO Auto-generated method stub
		System.out.println("Cupom: " + getNome() + " - Fornecedor: " + getFornecedor());
		System.out.println("Tipo: Combustivel");
		System.out.println("Promo��o: " + getPromocao());
		System.out.println("Tipo: " + getTipo());
		System.out.println("Descri��o: " + getDescricao());
		System.out.println();

	}

	@Override
	protected CupomCombustivel clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (CupomCombustivel) super.clone();
	}
}
