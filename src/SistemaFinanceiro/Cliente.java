package SistemaFinanceiro;

import java.util.HashSet;

public class Cliente {
    private String nome;
    private int id;

    private static int sequencial = 0;

    public Cliente(String nome) {
        this.nome = nome;
        this.id = sequencial++;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
