package dao;

import java.util.ArrayList;

import com.google.gson.Gson;

import entities.Fisica;


public interface FisicaDAO {

	public void setGson(Gson gson);

	public void save(Fisica f);

	public void remove(Fisica f);

	public Fisica busca(Fisica f);

	public void editar(Fisica f);
	
	public ArrayList<Fisica> buscaNome(String n);

	public ArrayList<Fisica> buscaCPF(String s);
}
