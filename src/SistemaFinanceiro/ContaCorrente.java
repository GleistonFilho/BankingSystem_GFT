package SistemaFinanceiro;

public class ContaCorrente extends Conta{

    public ContaCorrente(int agencia, Cliente cliente, double limiteDeposito, double limiteTransferencia) {
        super(agencia, cliente, limiteDeposito, limiteTransferencia);
    }

    @Override
    public void extrato() {
        System.out.println("Conta Corrente #" + String.format("%05d", numero));
        System.out.println("Cliente: " + cliente.getNome() + "; Id: " + String.format("%08d", cliente.getId()));
        System.out.println("Saldo atual: " + String.format("%.2f R$", saldo));
    }
}
