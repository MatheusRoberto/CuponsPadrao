package dao;

import java.util.ArrayList;
import org.json.JSONObject;

import com.google.gson.Gson;

import connection.FabricaConexao;
import entities.Cupom;
import entities.Juridica;

public class CupomDAOImpl implements CupomDAO {

	private static JSONObject jsonObject = FabricaConexao.getJSONObject();
	private Gson gson;

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void save(Cupom cc) {
		JSONObject Cupom = new JSONObject(gson.toJson(cc));
		CupomDAOImpl.jsonObject.append("cupons", Cupom);
	}

	public void remove(Cupom cc) {
		for (int i = 0; i < jsonObject.getJSONArray("cupons").length(); i++) {
			JSONObject jsob = jsonObject.getJSONArray("cupons").getJSONObject(i);
			if (jsob.getString("nome").equals(cc.getNome()) &&
					jsob.getString("promocao").equals(cc.getPromocao())) {
				jsonObject.getJSONArray("cupons").remove(i);
				break;
			}
		}
	}

	public Cupom busca(Cupom cc) {
		JSONObject jsob = new JSONObject(gson.toJson(cc));
		for (int i = 0; i < jsonObject.getJSONArray("cupons").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("cupons").getJSONObject(i);
			if(job.equals(jsob)) {
				return gson.fromJson(job.toString(), Cupom.class);
			}
		}
		return null;
	}
	
	public void editar(Cupom cc) {
		int index = buscaNomeCodVerEditar(cc.getNome(), cc.getPromocao()) ; 
		CupomDAOImpl.jsonObject.getJSONArray("cupons").put(index, gson.toJson(cc));
	}
	
	private int buscaNomeCodVerEditar(String n, String p) {
		for (int i = 0; i < jsonObject.getJSONArray("cupons").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("cupons").getJSONObject(i);
			if(job.getString("nome").equals(n) &&
					job.getString("promocao").equals(p)) {
				return i;
			}
		}
		return -1;
	}

	
	public ArrayList<Cupom> buscaNome(String n) {
		ArrayList<Cupom> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("cupons").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("cupons").getJSONObject(i);
			if(job.getString("nome").contains(n)) {
				Cupom cc = gson.fromJson(job.toString(), Cupom.class);
				System.out.println(job.getBoolean("validado"));
				finds.add(cc);
			}
		}
		return finds;
	}
	
	public ArrayList<Cupom> buscaJuridica(Juridica j) {
		ArrayList<Cupom> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("cupons").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("cupons").getJSONObject(i);
			Juridica juridica = gson.fromJson(job.get("fornecedor").toString(), Juridica.class);
			if(juridica.equals(j)) {
				Cupom cc = gson.fromJson(job.toString(), Cupom.class);
				finds.add(cc);
			}
		}
		return finds;
	}
	
}
