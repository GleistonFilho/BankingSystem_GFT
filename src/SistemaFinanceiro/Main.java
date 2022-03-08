package SistemaFinanceiro;

public class Main {
    public static void main(String[] args) {
        Banco bancoTest = new Banco();

        bancoTest.addCliente(new Cliente("Ana"));
        bancoTest.addCliente(new Cliente("Bernardo"));
        bancoTest.addCliente(new Cliente("Carlos"));

        bancoTest.abrirContaCorrente(0, 0, 10000, 10000);
        bancoTest.abrirContaCorrente(0, 1, 10000, 10000);
        bancoTest.abrirContaCorrente(0, 2, 10000, 10000);

        bancoTest.abrirContaPoupanca(0, 0, 10000, 10000);

        Conta anaContaCorrente = bancoTest.getContasDoCliente(0).get(0);
        Conta bernardoContaCorrente = bancoTest.getContasDoCliente(1).get(1);
        anaContaCorrente.depositar(1000);
        anaContaCorrente.transferir(500, bernardoContaCorrente);


        bancoTest.printContas();
    }
}
