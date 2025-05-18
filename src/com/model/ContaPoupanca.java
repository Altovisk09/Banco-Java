package com.model;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(String numero, Cliente titular){
        super(numero, titular);
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }
}
