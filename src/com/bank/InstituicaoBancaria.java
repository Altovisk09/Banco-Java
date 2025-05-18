package com.bank;

import java.util.ArrayList;
import java.util.List;

public class InstituicaoBancaria {
    private String nome;
    private List<Agencia> agencias;

    public InstituicaoBancaria(String nome){
        this.nome = nome;
        this.agencias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void adicionarAgencia(Agencia agencia){
    agencias.add(agencia);
    }

    public Agencia buscarAgencia(String codigo){
        return agencias.stream().filter(agencia -> agencia.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
}
