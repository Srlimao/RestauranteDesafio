
public class Restaurante {
	private String name;
	private String address;
	
	
	public Restaurante(String nome,String endereco) {
		setName(nome);
		setAddress(endereco);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
