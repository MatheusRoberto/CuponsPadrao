package app;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import connection.FabricaConexao;
import dao.CupomDAOImpl;
import dao.FisicaDAOImpl;
import entities.Cupom;
import entities.Endereco;
import entities.Fisica;
import util.SalvaBanco;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		/*
		 * FisicaDAO fDAO = new FisicaDAO(); fDAO.setGson(gson); Fisica f = new
		 * Fisica(); f.setEmail("fernadas-b@gmail.com"); f.setCpf("314.046.659-51");
		 * f.setNome("Fernando Sanches"); f.setSenha("s4asaf6s5dasdw9");
		 * f.setTelefone("(42) 55996-4233"); Endereco e = new Endereco();
		 * e.setBairro("Centro"); e.setCEP("84025-632"); e.setNumero("536");
		 * e.setRua("Prefeiro Marcio Rosário"); f.setEndereco(e); fDAO.save(f);
		 */
		//CupomDAOImpl cDAO = new CupomDAOImpl();
		//cDAO.setGson(gson);
		//System.out.println(cDAO.buscaNome("Cupom no Restaurante Mana ").toString());
		Fisica f = new Fisica();
		f.setNome("Matheus");
		ArrayList<Fisica> fisicas = new ArrayList<>();
		fisicas.add(f);
		for (Fisica fisica : fisicas) {
			if(fisica.getNome().equals("Matheus")) {
				fisica.setNome("Matheus Roberto");
				break;
			}
		}
		System.out.println(fisicas.get(0).getNome() + " "+f.getNome());

	}

	public static void salvaBanco() {
		SalvaBanco sb = new SalvaBanco(FabricaConexao.getJSONObject());
		try {
			sb.salvarBanco();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
