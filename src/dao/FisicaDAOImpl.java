package dao;

import java.util.ArrayList;
import org.json.JSONObject;

import com.google.gson.Gson;

import connection.FabricaConexao;
import entities.Fisica;

public class FisicaDAOImpl implements FisicaDAO {

	private static JSONObject jsonObject = FabricaConexao.getJSONObject();
	private Gson gson;

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void save(Fisica f) {
		JSONObject fisica = new JSONObject(gson.toJson(f));
		FisicaDAOImpl.jsonObject.append("clientes", fisica);
	}

	public void remove(Fisica f) {
		for (int i = 0; i < jsonObject.getJSONArray("clientes").length(); i++) {
			JSONObject jsob = jsonObject.getJSONArray("clientes").getJSONObject(i);
			if (jsob.getString("CPF").equals(f.getCpf())) {
				jsonObject.getJSONArray("clientes").remove(i);
				break;
			}
		}
	}

	public Fisica busca(Fisica f) {
		JSONObject jsob = new JSONObject(gson.toJson(f));
		for (int i = 0; i < jsonObject.getJSONArray("clientes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("clientes").getJSONObject(i);
			if(job.equals(jsob)) {
				return gson.fromJson(job.toString(), Fisica.class);
			}
		}
		return null;
	}
	
	public void editar(Fisica f) {
		int index = buscaCPFEditar(f.getCpf()) ; 
		FisicaDAOImpl.jsonObject.getJSONArray("clientes").put(index, gson.toJson(f));
	}
	
	private int buscaCPFEditar(String s) {
		for (int i = 0; i < jsonObject.getJSONArray("clientes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("clientes").getJSONObject(i);
			if(job.getString("CPF").equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Fisica> buscaNome(String n) {
		ArrayList<Fisica> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("clientes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("clientes").getJSONObject(i);
			if(job.getString("nome").equalsIgnoreCase(n)) {
				Fisica f = gson.fromJson(job.toString(), Fisica.class);
				finds.add(f);
			}
		}
		return finds;
	}
	
	
	public ArrayList<Fisica> buscaCPF(String s) {
		ArrayList<Fisica> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("clientes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("clientes").getJSONObject(i);
			if(job.getString("CPF").equals(s)) {
				Fisica f = gson.fromJson(job.toString(), Fisica.class);
				finds.add(f);
			}
		}
		return finds;
	}
	
}
