package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

import com.google.gson.Gson;

import connection.FabricaConexao;
import entities.Compra;
import entities.Fisica;
import entities.Pagamento;

public class CompraDAOImpl implements CompraDAO{

	private static JSONObject jsonObject = FabricaConexao.getJSONObject();
	private Gson gson;

	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void save(Compra cc) {
		JSONObject Compra = new JSONObject(gson.toJson(cc));
		CompraDAOImpl.jsonObject.append("compras", Compra);
	}

	public void remove(Compra cc) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < jsonObject.getJSONArray("compras").length(); i++) {
			JSONObject jsob = jsonObject.getJSONArray("compras").getJSONObject(i);
			if (gson.fromJson(jsob.getString("fisica"), Fisica.class).equals(cc.getFisica()) &&
					jsob.getString("dataVenda").equals(sdf.format(cc.getDataVenda())) &&
					gson.fromJson(jsob.getString("pagamento"), Pagamento.class).equals(cc.getPagamento())) {
				jsonObject.getJSONArray("compras").remove(i);
				break;
			}
		}
	}

	public Compra busca(Compra cc) {
		JSONObject jsob = new JSONObject(gson.toJson(cc));
		for (int i = 0; i < jsonObject.getJSONArray("compras").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("compras").getJSONObject(i);
			if(job.equals(jsob)) {
				return gson.fromJson(job.toString(), Compra.class);
			}
		}
		return null;
	}
	
	public void editar(Compra cc) {
		int index = buscaFisDatPagEditar(cc.getFisica(), cc.getDataVenda(), cc.getPagamento()) ; 
		CompraDAOImpl.jsonObject.getJSONArray("compras").put(index, gson.toJson(cc));
	}
	
	private int buscaFisDatPagEditar(Fisica f, Date d, Pagamento p) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < jsonObject.getJSONArray("compras").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("compras").getJSONObject(i);
			if(gson.fromJson(job.getString("fisica"), Fisica.class).equals(f) &&
					job.getString("dataVenda").equals(sdf.format(d)) &&
					gson.fromJson(job.getString("pagamento"), Pagamento.class).equals(p)) {
				return i;
			}
		}
		return -1;
	}

	
	public ArrayList<Compra> buscaFisica(Fisica f) {
		ArrayList<Compra> finds = new ArrayList<>();
		for (int i = 0; i < jsonObject.getJSONArray("compras").length(); i++) {
			JSONObject job = jsonObject.getJSONArray("compras").getJSONObject(i);
			if(gson.fromJson(job.getString("fisica"), Fisica.class).equals(f)) {
				Compra cc = gson.fromJson(job.toString(), Compra.class);
				finds.add(cc);
			}
		}
		return finds;
	}
	
}
