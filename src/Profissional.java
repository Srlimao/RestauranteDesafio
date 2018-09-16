
public class Profissional {
	private String name;
	private String email;
	
	public Profissional(String nome,String email) {
		this.setName(nome);
		this.setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
