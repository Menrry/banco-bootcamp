import java.util.ArrayList; // Adicionar import para ArrayList

public class Main {

    public static void main(String[] args) {
        // Criação de clientes
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Cliente diogo = new Cliente();
        diogo.setNome("Diogo");

        // Criação de contas
        Conta ccVenilton = new ContaCorrente(venilton);
        Conta poupancaVenilton = new ContaPoupanca(venilton);
        Conta ccDiogo = new ContaCorrente(diogo);

        // Associa as contas aos clientes (opcional, se você adicionar a lista de contas na classe Cliente)
        venilton.adicionarConta(ccVenilton);
        venilton.adicionarConta(poupancaVenilton);
        diogo.adicionarConta(ccDiogo);

        // Criação de um banco e adição de contas
        Banco meuBanco = new Banco();
        meuBanco.setNome("DioBank");
        meuBanco.setContas(new ArrayList<>()); // Inicializa a lista de contas
        meuBanco.getContas().add(ccVenilton);
        meuBanco.getContas().add(poupancaVenilton);
        meuBanco.getContas().add(ccDiogo);

        System.out.println("--- Operações Iniciais ---");
        ccVenilton.depositar(200);
        ccVenilton.imprimirExtrato();
        poupancaVenilton.imprimirExtrato();
        System.out.println("--------------------------");

        System.out.println("\n--- Transferência ---");
        ccVenilton.transferir(150, poupancaVenilton); // Saldo suficiente
        ccVenilton.imprimirExtrato();
        poupancaVenilton.imprimirExtrato();
        System.out.println("--------------------------");

        System.out.println("\n--- Tentativa de Saque com Saldo Insuficiente (Poupanca) ---");
        poupancaVenilton.sacar(1000); // Isso geraria "Saldo insuficiente!" se a validação fosse adicionada
        poupancaVenilton.imprimirExtrato();
        System.out.println("------------------------------------------------------------");

        System.out.println("\n--- Transferência entre clientes (via contas do banco) ---");
        ccVenilton.transferir(30, ccDiogo);
        ccVenilton.imprimirExtrato();
        ccDiogo.imprimirExtrato();
        System.out.println("----------------------------------------------------------");

        System.out.println("\n--- Contas no Banco ---");
        for (Conta conta : meuBanco.getContas()) {
            System.out.println("Agência: " + conta.getAgencia() + ", Número: " + conta.getNumero() + ", Titular: " + conta.cliente.getNome());
        }
    }
}
