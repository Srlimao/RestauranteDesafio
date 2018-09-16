package server;

import java.util.HashMap;

public class TrataRequest {
	
	static void TrataRequest(String request) {
		String auxSeparaBarras[]=request.split("\\?");
		String functionRequest = auxSeparaBarras[0].substring(1);
		String parametros[] = auxSeparaBarras[1].split("&");
		HashMap<String, String> keyValue = new HashMap<String, String>();
		
		for(String param:parametros) {
			String params[] = param.split("=");
			keyValue.put(params[0], params[1]);
		}		
		
		if(functionRequest.equals("addVoto")) {
			String restName = (String)keyValue.get("Restaurante");
			String profName = (String)keyValue.get("Profissional");
		}
	}

}
