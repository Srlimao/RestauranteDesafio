import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Urna {
	private Date voteDate;
	private List<Voto> votos;

	public Urna() {
		voteDate = new Date();
		votos = new ArrayList<Voto>();
	}
	
	public Date getVoteDate() {
		return voteDate;
	}
	
	public List<Voto> getVotos() {
		return votos;
	}
	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
	
	public void addVoto(Voto v) {
		votos.add(v);
	}

	public boolean profJaVotou(Profissional p) {
		for(Voto voto:votos) {
			if(voto.getProfissional() == p) {
				return true;
			}
		}
		return false;
		
	}
	
	public String apuracaoVotos() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
	      String word ;
		for(Voto voto:votos) {
			word = voto.getRestaurante().getName();
			if(map.containsKey(word)) {
		        Integer count = (Integer)map.get(word);
		        map.put(word, new Integer(count.intValue() + 1));
		      } else {
		        map.put(word, new Integer(1));
		      }
		}
		ArrayList<String> arraylist = new ArrayList<String>(map.keySet());
	    Collections.sort(arraylist);
	    String key = (String)arraylist.get(0);
	    Integer count = (Integer)map.get(key);
	    return count+" "+key;
	}

}
