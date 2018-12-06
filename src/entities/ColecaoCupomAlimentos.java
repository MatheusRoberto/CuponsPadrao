package entities;

import java.util.ArrayList;

public class ColecaoCupomAlimentos extends ColecaoCupom {

	private ArrayList<CupomAlimento> cupons;
	
	public ColecaoCupomAlimentos() {
		// TODO Auto-generated constructor stub
		this.cupons = new ArrayList<>();
	}
	
	public ArrayList<CupomAlimento> getCupons(){
		return new ArrayList<>(cupons);
	}
	
	public void listarColecao() {
		// TODO implement here
		System.out.println("Cole��o: "+getNome());
		System.out.println("Categoria: Alimentos - Vers�o: "+ getVersao());
		System.out.println("Valor: R$"+getPreco());
		System.out.println("Data de Inicio: "+getDataInicio()+"/ Data Termino: " + getDataValidade());
		System.out.println("Descri��o: "+getDescricao());
		for(int i = 0; i < this.cupons.size(); i++) {
			this.cupons.get(i).listarCupom();
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println();
	}

}
