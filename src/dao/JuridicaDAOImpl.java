package dao;

import java.util.ArrayList;
import org.json.JSONObject;

import com.google.gson.Gson;

import connection.FabricaConexao;
import entities.Juridica;

public class JuridicaDAOImpl implements JuridicaDAO{

	private static JSONObject jsonObject = FabricaConexao.getJSONObject();
	private Gson gson;

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void save(Juridica j) {
		JSONObject Juridica = new JSONObject(gson.toJson(j));
		JuridicaDAOImpl.jsonObject.append("fornecedores", Juridica);
	}

	public void remove(Juridica j) {
		for (int i = 0; i < jsonObject.getJSONArray("fornecedores").length(); i++) {
			JSONObject jsob = jsonObject.getJSONArray("fornecedores").getJSONObject(i);
			if (jsob.getString("CNPJ").equals(j.getCnpj())) {
				jsonObject.getJSONArray("fornecedores").remove(i);
				break;
			}
		}
	}

	public Juridica busca(Juridica j) {
		JSONObject jsob = new JSONObject(gson.toJson(j));
		for (int i = 0; i < jsonObject.getJSONArray("fornecedores").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("fornecedores").getJSONObject(i);
			if(job.equals(jsob)) {
				return gson.fromJson(job.toString(), Juridica.class);
			}
		}
		return null;
	}
	
	public void editar(Juridica j) {
		int index = buscaCNPJEditar(j.getCnpj()) ; 
		JuridicaDAOImpl.jsonObject.getJSONArray("fornecedores").put(index, gson.toJson(j));
	}
	
	private int buscaCNPJEditar(String s) {
		for (int i = 0; i < jsonObject.getJSONArray("fornecedores").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("fornecedores").getJSONObject(i);
			if(job.getString("CNPJ").equals(s)) {
				return i;
			}
		}
		return -1;
	}
	
	public ArrayList<Juridica> buscaNome(String n) {
		ArrayList<Juridica> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("fornecedores").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("fornecedores").getJSONObject(i);
			if(job.getString("nome").equalsIgnoreCase(n)) {
				Juridica f = gson.fromJson(job.toString(), Juridica.class);
				System.out.println(f.getEndereco().getRua());
				finds.add(f);
			}
		}
		return finds;
	}

	
	public ArrayList<Juridica> buscaCNPJ(String s) {
		ArrayList<Juridica> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("fornecedores").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("fornecedores").getJSONObject(i);
			if(job.getString("CNPJ").equals(s)) {
				Juridica f = gson.fromJson(job.toString(), Juridica.class);
				System.out.println(f.getEndereco().getRua());
				finds.add(f);
			}
		}
		return finds;
	}
	
}
