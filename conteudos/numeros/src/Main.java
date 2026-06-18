import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Crie uma lista de números inteiros e utilize o método Collections.sort para ordená-la em ordem crescente. Em seguida, imprima a lista ordenada.

        List<Integer> numeros = new LinkedList<>();
        numeros.add(8);
        numeros.add(9);
        numeros.add(3);
        numeros.add(10);
        numeros.add(54);
        numeros.add(26);
        numeros.add(32);
        Collections.sort(numeros);
        System.out.println("Lista crescente:");
        System.out.println(numeros);

    }
}