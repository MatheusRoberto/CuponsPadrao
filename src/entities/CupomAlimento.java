package entities;

public class CupomAlimento extends Cupom {

	@Override
	public void listarCupom() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("Cupom: " + getNome() + " - Fornecedor: " + getFornecedor());
		System.out.println("Tipo: Alimento");
		System.out.println("Promo��o: " + getPromocao());
		System.out.println("Tipo: " + getTipo());
		System.out.println("Descri��o: " + getDescricao());
		System.out.println();

	}
	
	@Override
	protected CupomAlimento clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (CupomAlimento) super.clone();
	}

}
