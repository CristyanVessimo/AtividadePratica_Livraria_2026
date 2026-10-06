import java.util.Scanner;

/**
 * Classe principal para execução e teste das funcionalidades do sistema da Livraria.
 * 
 * @author Aluno - BSI (POO I)
 */
public class Main {
    private static Livraria livraria = new Livraria();

    public static void main(String[] args) {
        montaMenu();
    }

    private static void montaMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n=================================");
            System.out.println("   GERENCIAMENTO DE LIVRARIA");
            System.out.println("=================================");
            System.out.println("1. Incluir Livro");
            System.out.println("2. Buscar Livro por Título");
            System.out.println("3. Listar Livros por Ano (>= informado)");
            System.out.println("4. Excluir Livro por ISBN");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número inteiro.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Informe o ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Informe o Título: ");
                    String titulo = scanner.nextLine();
                    
                    int ano = 0;
                    while (true) {
                        System.out.print("Informe o Ano de Publicação: ");
                        try {
                            ano = Integer.parseInt(scanner.nextLine().trim());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Ano inválido! Digite um número inteiro.");
                        }
                    }

                    Livro novoLivro = new Livro(isbn, titulo, ano);
                    if (livraria.incluirLivro(novoLivro) == 1) {
                        System.out.println(">>> Sucesso: Livro incluído com sucesso!");
                    } else {
                        System.out.println(">>> Erro: Não foi possível incluir o livro (ISBN já cadastrado ou dados inválidos).");
                    }
                    break;

                case 2:
                    System.out.print("Informe o Título para busca: ");
                    String tituloBusca = scanner.nextLine();
                    Livro livroEncontrado = livraria.buscarLivro(tituloBusca);
                    if (livroEncontrado != null) {
                        System.out.println(">>> Livro Encontrado: " + livroEncontrado);
                    } else {
                        System.out.println(">>> Alerta: Nenhum livro encontrado com esse título.");
                    }
                    break;

                case 3:
                    System.out.print("Informe o ano mínimo para filtro: ");
                    int anoFiltro = 0;
                    try {
                        anoFiltro = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Ano inválido!");
                        break;
                    }
                    System.out.println("\n--- Livros Publicados em " + anoFiltro + " ou posterior ---");
                    livraria.listarLivros(anoFiltro);
                    break;

                case 4:
                    System.out.print("Informe o ISBN do livro a ser excluído: ");
                    String isbnExcluir = scanner.nextLine();
                    if (livraria.excluirLivro(isbnExcluir) == 1) {
                        System.out.println(">>> Sucesso: Livro excluído com sucesso!");
                    } else {
                        System.out.println(">>> Erro: Não foi possível excluir (ISBN não localizado).");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
