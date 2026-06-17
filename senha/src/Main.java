import br.com.alura.senha.modelos.SenhaInvalidaException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite sua senha: ");
        String senhaDigitada = leitura.nextLine();

        try {
            Senha password = new Senha(senhaDigitada);
            System.out.println("Cadastrado com sucesso!");
        } catch (SenhaInvalidaException s) {
            System.out.println(s.getMessage());
        }
    }
}