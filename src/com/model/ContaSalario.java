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
    public double transferenciaTED(double valor) {
        return 0;
    }

    @Override
    public double transferenciaPIX(double valor) {
        return 0;
    }
}
