package dao;

import java.util.ArrayList;

import com.google.gson.Gson;

import entities.Compra;
import entities.Fisica;

public interface CompraDAO {

	public void setGson(Gson gson);

	public void save(Compra cc);

	public void remove(Compra cc);

	public Compra busca(Compra cc);

	public void editar(Compra cc);

	public ArrayList<Compra> buscaFisica(Fisica f);
}
