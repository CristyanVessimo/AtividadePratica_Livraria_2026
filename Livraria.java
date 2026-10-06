import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar a coleção de livros.
 * 
 * @author Cristyan Véssimo Gomes de Oliveria - BSI (POO I)
 */
public class Livraria {
    private List<Livro> livros;

    public Livraria() {
        this.livros = new ArrayList<>();
    }

    /**
     * Inclui um novo livro na coleção se o ISBN não for duplicado.
     * 
     * @param livro Objeto Livro a ser incluído.
     * @return 1 se o livro foi incluído com sucesso, 0 caso contrário.
     */
    public int incluirLivro(Livro livro) {
        if (livro == null || livro.getIsbn() == null || livro.getIsbn().trim().isEmpty()) {
            return 0;
        }

        for (Livro l : livros) {
            if (l.getIsbn().equalsIgnoreCase(livro.getIsbn().trim())) {
                return 0; // ISBN já cadastrado
            }
        }

        livros.add(livro);
        return 1; // Sucesso
    }

    /**
     * Busca um livro pelo seu título exato (case-insensitive).
     * 
     * @param titulo Título do livro procurado.
     * @return Objeto Livro se encontrado, ou null caso contrário.
     */
    public Livro buscarLivro(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return null;
        }

        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return l;
            }
        }
        return null;
    }

    /**
     * Lista no console os livros publicados a partir do ano informado (anoPublicacao >= ano).
     * 
     * @param ano Ano limite inferior para o filtro.
     */
    public void listarLivros(int ano) {
        boolean encontrou = false;
        for (Livro l : livros) {
            if (l.getAnoPublicacao() >= ano) {
                System.out.println(l);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro localizado com ano de publicação >= " + ano + ".");
        }
    }

    /**
     * Exclui um livro da coleção com base no seu ISBN.
     * 
     * @param isbn ISBN do livro a ser excluído.
     * @return 1 se o livro foi excluído com sucesso, 0 caso contrário.
     */
    public int excluirLivro(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            return 0;
        }

        for (Livro l : livros) {
            if (l.getIsbn().equalsIgnoreCase(isbn.trim())) {
                livros.remove(l);
                return 1; // Sucesso
            }
        }
        return 0; // Livro não encontrado
    }
}
