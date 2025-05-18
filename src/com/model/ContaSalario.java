package com.model;

import com.model.interfaces.Transferiveis;

public class ContaSalario extends Conta implements Transferiveis {
    public ContaSalario(String numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public String getTipoConta() {
        return "Conta Salário";
    }

    @Override
    public double transferenciaTED(double valor, Conta contaDestino) {
        double taxa = 5.0;
        if (valor + taxa <= this.saldo && valor > 0) {
            this.saldo -= (valor + taxa);
            contaDestino.depositar(valor);
            return valor;
        }
        return 0; // falha na transferência
    }

    // Conta salário não permite PIX
    @Override
    public double transferenciaPIX(double valor, Conta contaDestino) {
        System.out.println("PIX não disponível para Conta Salário");
        return 0;
    }
}
