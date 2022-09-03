package biblioteca;

import java.util.ArrayList;
import java.util.List;
// classe boblioteca esta com letra minuscula 
public class biblioteca {
	private List<Pessoa> pessoas;
	private List<Livro> livros;
	private List<Emprestimo> emprestimos;

	public biblioteca() {
		this.pessoas = new ArrayList<Pessoa>();
		this.livros = new ArrayList<Livro>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	public boolean emprestar(Pessoa pessoa, Livro livro) {
		if (livro.emprestar()) {
			Emprestimo emprestimo = new Emprestimo(pessoa, livro);
			this.emprestimos.add(emprestimo);
			return true;
		}
		return false;
	}
	
	public boolean devolver(Pessoa pessoa, Livro livro) {
		for (Emprestimo emp : this.emprestimos) {
			if ((emp.getPessoa() == pessoa) && (emp.getLivro() == livro)) {
				if ((emp.getDataDevolucao() == null) && (emp.devolver()))
					return true;
				else
					System.out.println("Ja foi devolvido em "+ emp.getDataDevolucao());
			}
		}
		return false;
	}
	
	public void adicionarPessoa(Pessoa contato) {
		this.pessoas.add(contato);
	}
	
	public Pessoa buscarPessoa(String nome) {
		for (Pessoa cont : this.pessoas)
			if (cont.getNome().equals(nome)) // if (cont.getNome() == nome)
				return cont;
		return null;
	}
	
	public boolean excluirPessoa(String nome) {
		Pessoa contato = this.buscarPessoa(nome);
		if (contato == null)
			return false;
		this.pessoas.remove(contato);
		return true;
	}

	public void adicionarLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	public Livro buscarLivro(String titulo) {
		for (Livro liv : this.livros)
			if (liv.getTitulo().equals(titulo))
				return liv;
		return null;
	}
	
	public boolean excluirLivro(String titulo) {
		Livro livro = this.buscarLivro(titulo);
		if ((livro == null) || (livro.isEmpretado()))
			return false;
		this.livros.remove(livro);
		return true;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

}
