package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Vanilla Sky", 2001);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("The Profissional", 1998);
        meuFilme.avalia(10);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        meuFilme.avalia(7);
        Serie lost = new Serie("Lost", 2001);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            Filme filme = (Filme) item;
            System.out.println("Classificao " + filme.getClassificacao());
        }
    }
}
