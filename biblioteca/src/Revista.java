public class Revista extends Item {
    private int edicao;

    public Revista(String titulo, int id, int ano, int edicao) {
        super(titulo, id, ano);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Ediçao: " + this.getEdicao());
    }
}
