package SistemaFinanceiro;

import java.util.ArrayList;
import java.util.HashMap;

public class Banco {
    private HashMap<Integer, HashMap<Integer, Conta>> contas;
    private HashMap<Integer, Cliente> clientes;

    public Banco(){
        contas = new HashMap<Integer, HashMap<Integer, Conta>>();
        clientes = new HashMap<Integer, Cliente>();
    }

    public void addCliente(Cliente cliente){
        try {
            if(clientes.keySet().contains(cliente.getId())) throw new BancoException("Id do cliente já existe");
            clientes.put(cliente.getId(), cliente);
        }catch (BancoException e){
            System.out.println(e.getMessage());
        }
    }

    public void abrirContaCorrente(int agencia, Cliente cliente, double limiteDeposito, double limiteTransferencia){
        int id = cliente.getId();
        Conta conta = new ContaCorrente(agencia, cliente, limiteDeposito, limiteTransferencia);
        if(!contas.keySet().contains(id)) contas.put(id, new HashMap<Integer, Conta>());
        contas.get(id).put(conta.getNumero(), conta);
    }
    public void abrirContaPoupanca(int agencia, Cliente cliente, double limiteDeposito, double limiteTransferencia){
        int id = cliente.getId();
        Conta conta = new ContaPoupanca(agencia, cliente, limiteDeposito, limiteTransferencia);
        if(!contas.keySet().contains(id)) contas.put(id, new HashMap<Integer, Conta>());
        contas.get(id).put(conta.getNumero(), conta);
    }
    public void abrirContaCorrente(int agencia, int clienteId, double limiteDeposito, double limiteTransferencia){
        int id = clienteId;
        Conta conta = new ContaCorrente(agencia, clientes.get(id), limiteDeposito, limiteTransferencia);
        if(!contas.keySet().contains(id)) contas.put(id, new HashMap<Integer, Conta>());
        contas.get(id).put(conta.getNumero(), conta);
    }
    public void abrirContaPoupanca(int agencia, int clienteId, double limiteDeposito, double limiteTransferencia){
        int id = clienteId;
        Conta conta = new ContaPoupanca(agencia, clientes.get(id), limiteDeposito, limiteTransferencia);
        if(!contas.keySet().contains(id)) contas.put(id, new HashMap<Integer, Conta>());
        contas.get(id).put(conta.getNumero(), conta);
    }

    public void printContas(){
        for(HashMap.Entry<Integer, HashMap<Integer, Conta>> entry : contas.entrySet()){
            System.out.println("Cliente: " + clientes.get(entry.getKey()).getNome());
            System.out.println("*----------------------------------------------*");
            for(Conta conta : entry.getValue().values()){
                conta.extrato();
                System.out.println("*----------------------------------------------*");
            }
            System.out.println();
        }
    }

    public HashMap<Integer, Conta> getContasDoCliente(int id){
        return contas.get(id);
    }
    public HashMap<Integer, Conta> getContasDoCliente(Cliente cliente){
        return contas.get(cliente.getId());
    }
}
