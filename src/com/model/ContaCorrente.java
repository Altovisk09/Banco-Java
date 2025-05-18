package com.model;

import com.model.interfaces.Transferiveis;

public class ContaCorrente extends Conta implements Transferiveis {

    public ContaCorrente(String numero, Cliente titular){
        super(numero, titular);
    }

    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }

    @Override
    public double transferenciaTED(double valor, Conta contaDestino) {
        double taxa = 5.0; // taxa fixa TED
        if (valor + taxa <= this.saldo && valor > 0) {
            this.saldo -= (valor + taxa);
            contaDestino.depositar(valor);
            return valor;
        }
        return 0; // falha na transferência
    }

    @Override
    public double transferenciaPIX(double valor, Conta contaDestino) {
        if (valor <= this.saldo && valor > 0) { // PIX sem taxa
            this.saldo -= valor;
            contaDestino.depositar(valor);
            return valor;
        }
        return 0;
    }
}
