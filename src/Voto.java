import java.util.Date;

public class Voto {
	private Profissional profissional;
	private Restaurante restaurante;
	private Date diaVoto;
	
	
	public Voto(Profissional prof,Restaurante rest) {
		setProfissional(prof);
		setRestaurante(rest);
		setDiaVoto(new Date());
		
	}


	public Date getDiaVoto() {
		return diaVoto;
	}


	public void setDiaVoto(Date diaVoto) {
		this.diaVoto = diaVoto;
	}


	public Restaurante getRestaurante() {
		return restaurante;
	}


	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}


	public Profissional getProfissional() {
		return profissional;
	}


	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
}
