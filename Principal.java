import java.text.SimpleDateFormat;
import java.util.Scanner;

import biblioteca.Biblioteca;
import biblioteca.Emprestimo;
import biblioteca.Livro;
import biblioteca.Pessoa;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		Pessoa pessoa;
		Livro livro;
		String nome, titulo;
		int opcao, opcao2;
		
		do {
			opcao = menu(teclado);
			switch (opcao) {
			case 1: // Pessoa
				do {
					opcao2 = menuCadastro(teclado, "PESSOA");
					switch (opcao2) {
					case 1: 
						System.out.println("\n\n*** Inserir Pessoa ***\n");
						pessoa = receberPessoa(teclado);
						biblioteca.adicionarPessoa(pessoa);
						break;
					case 2: 
						System.out.println("\n\n*** Procurar Pessoa ***\n");
						System.out.print("Digite o nome: ");
						limparBuffer(teclado);
						nome = teclado.nextLine();
						pessoa = biblioteca.buscarPessoa(nome);
						if (pessoa != null)
							mostrarPessoa(pessoa);
						else
							System.out.println("Pessoa nao localizada!!!");
						break;
					case 3: 
						System.out.println("\n\n*** Listar Pessoas ***\n");
						for (Pessoa pes : biblioteca.getPessoas())
							mostrarPessoa(pes);
						break;
					case 4: 
						System.out.println("\n\n*** Excluir Pessoa ***\n");
						System.out.print("Digite o nome: ");
						limparBuffer(teclado);
						nome = teclado.nextLine();
						if (biblioteca.excluirPessoa(nome))
							System.out.println("Excluido com sucesso!!!");
						else
							System.out.println("Pessoa nao localizada!!! Nao excluida!!!");
						break;
					case 5: 
						System.out.println("\n\n*** Editar Pessoa ***\n");
						System.out.print("Digite o nome: ");
						limparBuffer(teclado);
						nome = teclado.nextLine();
						pessoa = biblioteca.buscarPessoa(nome);
						if (pessoa != null) {
							mostrarPessoa(pessoa);
							editarPessoa(teclado, pessoa);
						}
						else
							System.out.println("Pessoa nao localizada!!!");
					}
				} while (opcao2 != 0);				
				break;
			case 2: // Livro
				do {
					opcao2 = menuCadastro(teclado, "LIVRO");
					switch (opcao2) {
					case 1: 
						System.out.println("\n\n*** Inserir Livro ***\n");
						livro = receberLivro(teclado);
						biblioteca.adicionarLivro(livro);
						break;
					case 2: 
						System.out.println("\n\n*** Procurar Livro ***\n");
						System.out.print("Digite o titulo: ");
						limparBuffer(teclado);
						titulo = teclado.nextLine();
						livro = biblioteca.buscarLivro(titulo);
						if (livro != null)
							mostrarLivro(livro);
						else
							System.out.println("Livro nao localizado!!!");
						break;
					case 3: 
						System.out.println("\n\n*** Listar Livros ***\n");
						for (Livro liv : biblioteca.getLivros())
							mostrarLivro(liv);
						break;
					case 4: 
						System.out.println("\n\n*** Excluir Livro ***\n");
						System.out.print("Digite o titulo: ");
						limparBuffer(teclado);
						titulo = teclado.nextLine();
						if (biblioteca.excluirLivro(titulo))
							System.out.println("Excluido com sucesso!!!");
						else
							System.out.println("Nao excluido!!!");
						break;
					case 5: 
						System.out.println("\n\n*** Editar Livro ***\n");
						System.out.print("Digite o autor: ");
						limparBuffer(teclado);
						titulo = teclado.nextLine();
						livro = biblioteca.buscarLivro(titulo);
						if (livro != null) {
							mostrarLivro(livro);
							editarLivro(teclado, livro);
						}
						else
							System.out.println("Livro nao localizado!!!");
					}
				} while (opcao2 != 0);				
				break;
			case 3: // Emprestimo
				do {
					opcao2 = menuEmprestimo(teclado);
					switch (opcao2) {
					case 1: // Emprestar
						System.out.println("\n\n*** Emprestar ***\n");
						System.out.print("Digite o nome da pessoa: ");
						limparBuffer(teclado);
						nome = teclado.nextLine();
						pessoa = biblioteca.buscarPessoa(nome);
						if (pessoa != null) {
							mostrarPessoa(pessoa);							
							System.out.print("Digite o titulo do livro: ");
							titulo = teclado.nextLine();
							livro = biblioteca.buscarLivro(titulo);
							if (livro != null) {
								mostrarLivro(livro);
								if (biblioteca.emprestar(pessoa, livro))
									System.out.println("Emprestado com sucesso!!!");
								else
									System.out.println("Nao emprestado!!!");
							}
							else
								System.out.println("Livro nao localizado!!!");							
						}
						else
							System.out.println("Pessoa nao localizada!!!");
						break;
					case 2: // Devolver
						System.out.println("\n\n*** Devolver ***\n");
						System.out.print("Digite o nome da pessoa: ");
						limparBuffer(teclado);
						nome = teclado.nextLine();
						pessoa = biblioteca.buscarPessoa(nome);
						if (pessoa != null) {
							mostrarPessoa(pessoa);							
							System.out.print("Digite o titulo do livro: ");
							titulo = teclado.nextLine();
							livro = biblioteca.buscarLivro(titulo);
							if (livro != null) {
								mostrarLivro(livro);
								if (biblioteca.devolver(pessoa, livro))
									System.out.println("Devolvido com sucesso!!!");
								else
									System.out.println("Devolucao nao realizada!!!");
							}
							else
								System.out.println("Livro nao localizado!!!");							
						}
						else
							System.out.println("Pessoa nao localizada!!!");
						break;
					case 3: // Listar
						System.out.println("\n\n*** Listar Emprestimos ***\n");
						for (Emprestimo emp : biblioteca.getEmprestimos())
							mostrarEmprestimo(emp);
					}
				} while (opcao2 != 0);				
			}
		} while (opcao != 0);
		teclado.close();
	}
	
	public static int menu(Scanner teclado) {
		int opcao;
		System.out.println("\n\n*** BIBLIOTECA ***\n");
		System.out.println("1. Pessoa");
		System.out.println("2. Livro");
		System.out.println("3. Emprestimo");
		System.out.println("0. Sair\n");
		System.out.print("Digite sua opcao: ");
		opcao = teclado.nextInt();
		return opcao;
	}
	
	public static int menuCadastro(Scanner teclado, String entidade) {
		int opcao;
		System.out.println("\n\n*** "+ entidade +" ***\n");
		System.out.println("1. Inserir");
		System.out.println("2. Procurar");
		System.out.println("3. Listar");
		System.out.println("4. Excluir");
		System.out.println("5. Editar");
		System.out.println("0. Voltar\n");
		System.out.print("Digite sua opcao: ");
		opcao = teclado.nextInt();
		return opcao;
	}
	
	public static int menuEmprestimo(Scanner teclado) {
		int opcao;
		System.out.println("\n\n*** EMPRESTIMO ***\n");
		System.out.println("1. Emprestar");
		System.out.println("2. Devolver");
		System.out.println("3. Listar");
		System.out.println("0. Voltar\n");
		System.out.print("Digite sua opcao: ");
		opcao = teclado.nextInt();
		return opcao;
	}
	
	public static Pessoa receberPessoa(Scanner teclado) {
		Pessoa contato;
		String nome, celular, email, endereco;
		System.out.print("Digite o nome....: ");
		limparBuffer(teclado);
		nome = teclado.nextLine();
		System.out.print("Digite o celular.: ");
		celular = teclado.nextLine();
		System.out.print("Digite o e-mail..: ");
		email = teclado.nextLine();
		System.out.print("Digite o endereco: ");
		endereco = teclado.nextLine();
		contato = new Pessoa(nome, celular, email, endereco);
		return contato;
	}	

	public static void mostrarPessoa(Pessoa contato) {
		System.out.println("Nome....: "+ contato.getNome());
		System.out.println("Celular.: "+ contato.getCelular());
		System.out.println("E-mail..: "+ contato.getEmail());
		System.out.println("Endereco: "+ contato.getEndereco());
	}	

	public static void editarPessoa(Scanner teclado, Pessoa contato) {
		System.out.print("Digite o nome....: ");
		contato.setNome(teclado.nextLine());
		System.out.print("Digite o celular.: ");
		contato.setCelular(teclado.nextLine());
		System.out.print("Digite o e-mail..: ");
		contato.setEmail(teclado.nextLine());
		System.out.print("Digite o endereco: ");
		contato.setEndereco(teclado.nextLine());
	}	

	public static Livro receberLivro(Scanner teclado) {
		Livro livro;
		String titulo, autor;
		System.out.print("Digite o titulo: ");
		limparBuffer(teclado);
		titulo = teclado.nextLine();
		System.out.print("Digite o autor.: ");
		autor = teclado.nextLine();
		livro = new Livro(titulo, autor);
		return livro;
	}	

	public static void mostrarLivro(Livro contato) {
		System.out.println("Titulo: "+ contato.getTitulo());
		System.out.println("Autor.: "+ contato.getAutor());
	}

	public static void editarLivro(Scanner teclado, Livro livro) {
		System.out.print("Digite o titulo: ");
		livro.setTitulo(teclado.nextLine());
		System.out.print("Digite o autor.: ");
		livro.setAutor(teclado.nextLine());
	}	
	
	public static void mostrarEmprestimo(Emprestimo emprestimo) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Pessoa....: "+ emprestimo.getPessoa().getNome());
		System.out.println("Livro.....: "+ emprestimo.getLivro().getTitulo());
		System.out.println("Emprestimo: "+ sdf.format(emprestimo.getDataEmprestimo()));
		if (emprestimo.getDataDevolucao() == null)
			System.out.println("Devolucao.: NAO DEVOLVIDO");
		else
			System.out.println("Devolucao.: "+ sdf.format(emprestimo.getDataDevolucao()));
	}

	public static void limparBuffer(Scanner teclado) {
		if (teclado.hasNext())
			teclado.nextLine();
	}

}