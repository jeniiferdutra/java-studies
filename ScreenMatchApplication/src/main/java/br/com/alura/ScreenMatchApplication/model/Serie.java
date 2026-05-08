package br.com.alura.ScreenMatchApplication.model;

import br.com.alura.ScreenMatchApplication.service.ConsultaChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.Optional;
import java.util.OptionalDouble;

@Entity  // Essa classe vai ser uma tabela do banco de dados relacional
@Table(name = "series") // Comunicar pra JPA que eu vou colocar o nome da classe no plural (serieS)
public class Serie {

    @Id // Indicar pra JPA que esse é o meu id/chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco de dados cuidará de gerar esse num automaticamente (1, 2, 3...) toda vez que salvar uma nova série
    private Long id; // definir chave primária (indice unico)

    @Column(unique = true)// NAO pode ter duas series com o mesmo titulo
    // @Column(name = "nomeDaSerie") -> Se eu quiser informar pra JPA que eu quero mudar o nome titulo para `nomeDaSerie`
    private String titulo;
    private Integer totalTemporadas;
    private double avaliacao;

    @Enumerated(EnumType.STRING) // qual o tipo do meu enum
    private Categoria genero;

    private String atores;
    private String poster;
    private String sinopse;

    public Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);// Valor padrao caso tenha erro e nao consiga obter um valor de avaliacao
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim()); // pegar o primeiro genero
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = dadosSerie.sinopse();
        // this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim(); -> sem saldo para testar a traducao da IA
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'';
    }
}
