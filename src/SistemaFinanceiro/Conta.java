package SistemaFinanceiro;

public abstract class Conta {
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double limiteDeposito;
    protected double limiteTransferencia;

    private static int sequencial = 0;


    public Conta(int agencia, Cliente cliente, double limiteDeposito, double limiteTransferencia){
        this.agencia = agencia;
        this.cliente = cliente;
        this.numero = sequencial++;
        this.limiteDeposito = limiteDeposito;
        this.limiteTransferencia = limiteTransferencia;
    }

    public void sacar(double valor){
        try{
            if(valor > saldo) throw new BancoException("Saldo insuficiente");
            if(valor <= 0) throw new BancoException("Valor inválido");
            saldo -= valor;
            //extrato();
        }catch (BancoException e){
            System.err.println(e.getMessage());
        }
    }
    public void depositar(double valor){
        try {
            if(valor > limiteDeposito) throw new BancoException("Limite de deposito excedido");
            if(valor <= 0) throw new BancoException("Valor inválido");
            saldo += valor;
            //extrato();
        }catch (BancoException e){
            System.err.println(e.getMessage());
        }
    }

    public void transferir(double valor, Conta destinatario){
        try {
            if(valor > limiteTransferencia) throw new BancoException("Limite de tranferência excedido");
            if(valor <= 0) throw new BancoException("Valor inválido");
            saldo -= valor;
            destinatario.receberTransferencia(valor);
        }catch (BancoException e){
            System.err.println(e.getMessage());
        }
    }

    public void receberTransferencia(double valor){
        saldo += valor;
    }

    public abstract void extrato();

    public double getSaldo(){
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getLimiteDeposito() {
        return limiteDeposito;
    }

    public double getLimiteTransferencia() {
        return limiteTransferencia;
    }

    public void setLimiteDeposito(double limiteDeposito) {
        this.limiteDeposito = limiteDeposito;
    }

    public void setLimiteTransferencia(double limiteTransferencia) {
        this.limiteTransferencia = limiteTransferencia;
    }
}
