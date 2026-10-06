/**
 * Classe que representa um Livro na Livraria.
 * 
 * @author Aluno - BSI (POO I)
 */
public class Livro {
    private String isbn;
    private String titulo;
    private int anoPublicacao;

    public Livro() {
    }

    public Livro(String isbn, String titulo, int anoPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Título: " + titulo + " | Ano de Publicação: " + anoPublicacao;
    }
}
