package com.model;

import com.model.interfaces.Transacoes;

public abstract class Conta implements Transacoes {
    protected String numero;
    protected double saldo;
    protected Cliente titular;

    public Conta(String numero, Cliente cliente){
      this.numero = numero;
      this.titular = cliente;
      this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }


    @Override
    public double sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return valor;
        }
        return 0;
    }

    @Override
    public double depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            return valor;
        }
        return 0;
    }


    public abstract String getTipoConta();
}
