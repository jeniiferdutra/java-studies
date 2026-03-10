
public class Main {

    // Criar uma aplicaçao para consultar a API ViaCEP
    // Menu para o usuário informar o cep para busca
    // Geraçao de um arquivo .JSON com os dados do endereço

    public static <Gson> void main(String[] args) {

        ConsultaCep consultaCep = new ConsultaCep();
        Endereco novoEndereco = consultaCep.buscaEndereco("03552050");
        System.out.println(novoEndereco);

    }
}