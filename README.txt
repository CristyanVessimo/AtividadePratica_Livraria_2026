==================================================
ATIVIDADE PRÁTICA - JAVA COLLECTIONS (LIVRARIA)
Disciplina: Programação Orientada a Objetos I
Curso: Bacharelado em Sistemas de Informação
==================================================

ESTRUTURA DO PROJETO:
- Livro.java: Entidade de dados (isbn, titulo, anoPublicacao) com construtores, getters/setters e toString.
- Livraria.java: Gerenciamento da coleção (List<Livro>) com regras de negócio (incluir sem duplicar ISBN, buscar por título, listar por ano >= filtro e excluir por ISBN).
- Main.java: Interface de linha de comando com o método montaMenu() para testes interativos.

COMO COMPILAR E EXECUTAR:
1. Abra o terminal na pasta onde os arquivos .java estão salvos.
2. Compile os arquivos Java com o comando:
   javac *.java

3. Execute o programa principal com o comando:
   java Main
