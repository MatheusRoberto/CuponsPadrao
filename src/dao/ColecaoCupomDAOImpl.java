package dao;

import java.util.ArrayList;
import org.json.JSONObject;

import com.google.gson.Gson;

import connection.FabricaConexao;
import entities.ColecaoCupom;

public class ColecaoCupomDAOImpl implements ColecaoCupomDAO{

	private static JSONObject jsonObject = FabricaConexao.getJSONObject();
	private Gson gson;

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void save(ColecaoCupom cc) {
		JSONObject ColecaoCupom = new JSONObject(gson.toJson(cc));
		ColecaoCupomDAOImpl.jsonObject.append("colecoes", ColecaoCupom);
	}

	public void remove(ColecaoCupom cc) {
		for (int i = 0; i < jsonObject.getJSONArray("colecoes").length(); i++) {
			JSONObject jsob = jsonObject.getJSONArray("colecoes").getJSONObject(i);
			if (jsob.getString("nome").equals(cc.getNome()) &&
					jsob.getString("versao").equals(cc.getVersao())) {
				jsonObject.getJSONArray("colecoes").remove(i);
				break;
			}
		}
	}

	public ColecaoCupom busca(ColecaoCupom cc) {
		JSONObject jsob = new JSONObject(gson.toJson(cc));
		for (int i = 0; i < jsonObject.getJSONArray("colecoes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("colecoes").getJSONObject(i);
			if(job.equals(jsob)) {
				return gson.fromJson(job.toString(), ColecaoCupom.class);
			}
		}
		return null;
	}
	
	public void editar(ColecaoCupom cc) {
		int index = buscaNomeVerEditar(cc.getNome(), cc.getVersao()) ; 
		ColecaoCupomDAOImpl.jsonObject.getJSONArray("colecoes").put(index, gson.toJson(cc));
	}
	
	private int buscaNomeVerEditar(String n, String v) {
		for (int i = 0; i < jsonObject.getJSONArray("colecoes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("colecoes").getJSONObject(i);
			if(job.getString("nome").equals(n) &&
					job.getString("versao").equals(v)) {
				return i;
			}
		}
		return -1;
	}

	
	public ArrayList<ColecaoCupom> buscaNome(String n) {
		ArrayList<ColecaoCupom> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("colecoes").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("colecoes").getJSONObject(i);
			if(job.getString("nome").equals(n)) {
				ColecaoCupom cc = gson.fromJson(job.toString(), ColecaoCupom.class);
				finds.add(cc);
			}
		}
		return finds;
	}
	
}
