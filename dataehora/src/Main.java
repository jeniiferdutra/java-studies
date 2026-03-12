import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate dataCompra = LocalDate.now(); // Data de hoje
        LocalDate dataPrimeiraParcela = LocalDate.of(2026, 5, 15);
        LocalDate dataSegundaParcela = dataPrimeiraParcela.plusDays(30); // add 30 dias apos a primeira

        if(dataSegundaParcela.isEqual(LocalDate.now())) {
            System.out.println("Hoje é o dia do vencimento");
        } else {
            System.out.println("Ainda nao esta no dia do vencimento");
        }

        if(dataPrimeiraParcela.isBefore(LocalDate.now())) {
            System.out.println("Anterior dia do vencimento");
        } else {
            System.out.println("Superior ao dia do vencimento");
        }

        System.out.println("Data da compra: " + dataCompra);
        System.out.println("Data da primeira parcela: " + dataPrimeiraParcela);
        System.out.println("Data da segunda parcela: " + dataSegundaParcela);

        //FORMATAR PARA O PADRAO BRASILEIRO

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data da compra formatada: " + dataCompra.format(formato));

        // ORIENTADO A FUSO-HORÁRIO

        ZonedDateTime dataConclusaoCompra = ZonedDateTime.now();
        System.out.println("Data de conclusao da compra: " + dataConclusaoCompra);
        ZonedDateTime dataCompraNY = dataConclusaoCompra.withZoneSameInstant(
                ZoneId.of("America/New_York"));
        System.out.println("Data de conclusao da compra NY: " + dataCompraNY);

        // CALCULAR A DURAÇAO/HORAS

        LocalTime inicio = LocalTime.of(9,0);
        LocalTime fim = LocalTime.of(17,30);

        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Duraçao do expediente: " + duracao.toHours() +
                " horas e " + duracao.toMinutesPart() + " minutos.");

        // CALCULAR A DATA

        LocalDate dataPagamento = LocalDate.parse("2026-10-30");
        Period periodo = Period.between(dataCompra, dataPagamento);
        System.out.println("Diferença em dias: " + periodo.getDays() + periodo.getMonths());

        System.out.println("------------------------------------");

        //Você está desenvolvendo um sistema de log para um aplicativo de gerenciamento de tarefas. Sempre que uma nova tarefa é criada, o sistema deve registrar a data e a hora exatas do momento da criação.

        String tarefa = "Enviar relatório semanal";
        System.out.println(tarefa);
        LocalDate dataAtual = LocalDate.now();
        ZonedDateTime horaAtual = ZonedDateTime.now();
        System.out.println("Data Atual: " + dataAtual);
        System.out.println("Hora Atual: " + horaAtual);

        System.out.println("------------------------------------");

        // Você trabalha no setor de tecnologia de uma empresa que gera relatórios diários. Esses relatórios incluem informações como transações realizadas, atualizações de pedidos e registros de atendimento ao cliente. A equipe responsável pela análise dos relatórios solicitou que a data e a hora sejam exibidas em um formato mais familiar para os usuários brasileiros.

        DateTimeFormatter fomartoDataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHorarioBrasil = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Data do formato do Brasil: " + dataAtual.format(fomartoDataBrasil));
        System.out.println("Hora formatada do Brasil: " + horaAtual.format(formatoHorarioBrasil));
    }

}