package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class SalvaBanco {

	private JSONObject jsonObject;

	public SalvaBanco(JSONObject json) {
		// TODO Auto-generated constructor stub
		this.jsonObject = json;
	}

	public void salvarBanco() throws IOException {
		String file = System.getProperty("user.dir")+"/bin/util/banco.json";
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		bufferedWriter.write(jsonObject.toString());
		bufferedWriter.close();
		System.err.println("Banco salvo!");
	}

}
