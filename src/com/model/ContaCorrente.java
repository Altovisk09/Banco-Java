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
    public double transferenciaTED(double valor) {
        return 0;
    }

    @Override
    public double transferenciaPIX(double valor) {
        return 0;
    }
}
