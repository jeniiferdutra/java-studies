import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Personagem personagem01 = new Personagem("Mago", 100, 60);
        Personagem personagem02 = new Personagem("Guerreiro", 89, 88);

        Random gerador = new Random(); //

        while (personagem01.getVida() > 0 && personagem02.getVida() > 0) {
            int numeroGerado = gerador.nextInt(100);

            if (numeroGerado % 2 == 0) {
                int novaVida = personagem02.getVida() - personagem01.getAtaque();
                personagem02.setVida(novaVida);
                System.out.println(personagem01.getNome() + " ataca! " + personagem02.getNome() + " agora tem " + personagem02.getVida() + " de vida.");
            } else {
                int novaVida = personagem01.getVida() - personagem02.getAtaque();
                personagem01.setVida(novaVida);
                System.out.println(personagem02.getNome() + " ataca! " + personagem01.getNome() + " agora tem " + personagem01.getVida() + " de vida.");
            }
            System.out.println(personagem01.toString());
            System.out.println(personagem02.toString());
        }
    }
}