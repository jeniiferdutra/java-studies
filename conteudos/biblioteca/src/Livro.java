public class Livro extends Item {
    private String autor;

    public Livro(String titulo, int id, int ano, String autor) {
        super(titulo, id, ano);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Autor: " + this.getAutor());
    }
}
