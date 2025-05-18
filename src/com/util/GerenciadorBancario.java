package com.util;

import com.bank.InstituicaoBancaria;
import com.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorBancario {
    private List<InstituicaoBancaria> bancos;

    public GerenciadorBancario(){
        this.bancos = new ArrayList<>();
    }

    public void adicionarBanco(InstituicaoBancaria banco){
        bancos.add(banco);
    }

    public InstituicaoBancaria buscarBanco(String nome) {
        return bancos.stream()
                .filter(b -> b.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }
    public boolean transferir(Conta origem, Conta destino, double valor) {
        if (origem.sacar(valor) == valor) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

}
