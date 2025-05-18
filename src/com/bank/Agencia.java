package com.bank;

import com.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private String codigo;
    private List<Conta> contas;

    public Agencia(String codigo){
        this.codigo = codigo;
        this.contas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
    public void exibirContas() {
        contas.forEach(conta -> {
            System.out.println("Conta: " + conta.getNumero());
            System.out.println("Titular: " + conta.getTitular().getNome());
            System.out.println("Saldo: R$" + conta.getSaldo());
            System.out.println("Tipo: " + conta.getTipoConta());
            System.out.println("----------------------");
        });

    }
    public Conta buscarConta(String numeroConta){
        return contas.stream().filter(conta -> conta.getNumero().equals(numeroConta)).findFirst().orElse(null);
    }
}
