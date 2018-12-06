package connection;

import java.io.InputStreamReader;
import java.io.Reader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class FabricaConexao {

	private static JSONObject jsonObject;
	
	private FabricaConexao() {
		// TODO Auto-generated constructor stub
		carregaObjeto();
	}

	public static JSONObject getJSONObject() {
		if(jsonObject == null)
			new FabricaConexao();
		return jsonObject;
	}

	private void carregaObjeto() {
		Reader in = new InputStreamReader(getClass().getResourceAsStream("/util/banco.json"));
		jsonObject = new JSONObject(new JSONTokener(in));
	}
	
}
