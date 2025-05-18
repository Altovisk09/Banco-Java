package com.model.interfaces;

import com.model.Conta;

public interface Transferiveis {
    public double transferenciaTED(double valor, Conta contaDestino);
    public double transferenciaPIX(double valor, Conta contaDestino);
}
