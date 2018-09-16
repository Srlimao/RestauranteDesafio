import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Urna {
	public Date voteDate;
	private HashMap<String, String> votoMap = new HashMap<String, String>();
	private HashMap<String, Integer> votosCount = new HashMap<String, Integer>();

	public Urna() {
		voteDate = new Date();
	}
	
	public String addVoto(String votante, String rest) {
		if(votoMap.containsKey(votante)) {
			return (votante+" já votou hoje");
		}else {
			votoMap.put(votante, rest);
			if(votosCount.containsKey(rest)) {
		        Integer count = (Integer)votosCount.get(rest);
		        votosCount.put(rest, new Integer(count.intValue() + 1));
		      } else {
		    	  votosCount.put(rest, new Integer(1));
		      }
			
		}
		return votante+" votou!";
		
	}
	
	public String getGanhador() {
		return votosCount.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
	}
	
	public String apuracaoVotos() {
		
		
		return getGanhador()+" votos: "+votosCount.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();

	}

}
