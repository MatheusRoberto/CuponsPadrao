package dao;

import java.util.ArrayList;

import com.google.gson.Gson;

import entities.Cupom;
import entities.Juridica;


public interface CupomDAO {

	public void setGson(Gson gson);

	public void save(Cupom cc);

	public void remove(Cupom cc);

	public Cupom busca(Cupom cc);

	public void editar(Cupom cc);
	
	public ArrayList<Cupom> buscaNome(String n);

	public ArrayList<Cupom> buscaJuridica(Juridica j);
}
