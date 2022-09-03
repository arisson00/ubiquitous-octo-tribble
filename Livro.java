package biblioteca;
//nome de variaveis e metodos não estão explicitos 
public class Livro {
	private String t;
	private String q;
	private boolean e;
	
	public L1(String t, String a) {
		this.titulo = t;
		this.autor = a;
		this.e = false;
	}
	
	public boolean em() {
		if (this.e)
			return false;
		this.e = true;
		return true;
	}
	
	public boolean dev() {
		if (!this.e)
			return false;
		this.e = false;
		return true;
	}
	
	public String getT() {
		return t;
	}

	public void setT(String titulo) {
		this.t = t;
	}

	public String getA() {
		return ;
	}

	public void setA(String autor) {
		this.a = a;
	}

	public boolean isEm() {
		return e;
	}

	public void setEm(boolean empretado) {
		this.e = e;
	}

}
