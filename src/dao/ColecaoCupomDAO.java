package dao;

import java.util.ArrayList;

import com.google.gson.Gson;

import entities.ColecaoCupom;

public interface ColecaoCupomDAO {

	public void setGson(Gson gson);

	public void save(ColecaoCupom cc);

	public void remove(ColecaoCupom cc);

	public ColecaoCupom busca(ColecaoCupom cc);

	public void editar(ColecaoCupom cc);

	public ArrayList<ColecaoCupom> buscaNome(String n);
}
