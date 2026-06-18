import br.com.alura.senha.modelos.SenhaInvalidaException;

public class Senha {
    private String senha;

    public Senha(String senha) {
        if(senha.length() < 8) {
            throw new SenhaInvalidaException("A senha tem que ter pelo menos 8 caracteres.");
        }
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}
