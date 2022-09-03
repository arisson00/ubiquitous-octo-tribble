package biblioteca;

import java.util.Date;

public class Emprestimo {
	private Pessoa pessoa;
	private Livro livro;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	
	public Emprestimo(Pessoa pessoa, Livro livro) {
		this.pessoa = pessoa;
		this.livro = livro;
		this.dataEmprestimo = new Date();		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//this.dataEmprestimo = sdf.parse("01/02/2022");
	}
	
	public boolean devolver() {
		if (this.livro.devolver()) {
			this.dataDevolucao = new Date();
			return true;
		}
		return false;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}
