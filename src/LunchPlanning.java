import java.util.ArrayList;
import java.util.List;

public class LunchPlanning {
	static List<Restaurante> restaurantes;
	static List<Profissional> profissionais;
	static List<Urna> urnas;
	public static void main(String[] args) {
		restaurantes = new ArrayList<Restaurante>();
		profissionais = new ArrayList<Profissional>();
		urnas = new ArrayList<Urna>();
		Restaurante rest1 = new Restaurante("Qoppa","LaSalle");
		Restaurante rest2 = new Restaurante("Panevino","Muck");
		Restaurante rest3 = new Restaurante("Gardenlake","Centro");		
		restaurantes.add(rest1);
		restaurantes.add(rest2);
		restaurantes.add(rest3);
		
		Profissional prof1 = new Profissional("WILL","wbasilveira@sispro.com");
		Profissional prof2 = new Profissional("TT","spbrazil@sispro.com");
		Profissional prof3 = new Profissional("VINI","vvribeiro@sispro.com");
		
		profissionais.add(prof1);
		profissionais.add(prof2);
		profissionais.add(prof3);
		Urna urna1 = new Urna();
		urnas.add(urna1);
		try {
			addVoto(urna1,prof1,rest1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			addVoto(urna1,prof1,rest1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			addVoto(urna1,prof2,rest1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			addVoto(urna1,prof2,rest1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(urna1.apuracaoVotos());
		
		
		
	}
	
	public static void addVoto(Urna urnaHoje,Profissional p, Restaurante r) throws Exception{
		if(urnaHoje.profJaVotou(p)) {
			throw new Exception(p.getName()+" já votou hj!");
		}else {
			urnaHoje.addVoto(new Voto(p,r));
			throw new Exception(p.getName()+" Votado!");
		}
	}

}
