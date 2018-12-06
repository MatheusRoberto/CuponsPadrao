package dao;

import java.util.ArrayList;

import com.google.gson.Gson;

import entities.Juridica;


public interface JuridicaDAO {

	public void setGson(Gson gson);

	public void save(Juridica j);

	public void remove(Juridica j);

	public Juridica busca(Juridica j);

	public void editar(Juridica j);
	
	public ArrayList<Juridica> buscaNome(String n);

	public ArrayList<Juridica> buscaCNPJ(String s);
}
