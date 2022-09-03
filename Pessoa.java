package biblioteca;
//classe pessoa não é abstrata
public class Pessoa {
	private String nome;
	private String celular;
	private String email;
	private String endereco;
	
	public Pessoa(String nome, String celular, String email, String endereco) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
