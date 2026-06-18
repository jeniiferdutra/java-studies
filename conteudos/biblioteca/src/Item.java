public class Item implements Comparable<Item>{
    private String titulo;
    private int id;
    private int ano;

    public Item(String titulo, int id, int ano) {
        this.titulo = titulo;
        this.id = id;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void exibirDetalhes() {
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("ID: " + this.getId());
        System.out.println("Ano de lançamento: " + this.getAno());
    }

    @Override
    public int compareTo(Item outroItem) {
        return Integer.compare(this.ano, outroItem.ano);
    }
}
