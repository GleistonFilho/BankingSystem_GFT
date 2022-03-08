package SistemaFinanceiro;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int agencia, Cliente cliente, double limiteDeposito, double limiteTransferencia) {
        super(agencia, cliente, limiteDeposito, limiteTransferencia);
    }

    @Override
    public void extrato() {
        System.out.println("Conta Poupança #" + String.format("%05d", numero));
        System.out.println("Cliente: " + cliente.getNome() + "; Id: " + String.format("%08d", cliente.getId()));
        System.out.println("*----------------------------------------------*");
        System.out.println("Saldo atual: " + String.format("%.2f R$", saldo));
    }
}
