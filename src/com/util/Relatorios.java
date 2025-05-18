package com.util;

import com.model.Cliente;
import com.model.Conta;

import java.util.List;

public class Relatorios {

    public static void relatorioCliente(Cliente cliente) {
        System.out.println("Relatório do cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());

        cliente.getContas().forEach(conta -> {
            System.out.println("Tipo: " + conta.getTipoConta() + " | Número: " + conta.getNumero() + " | Saldo: R$" + conta.getSaldo());
        });

        double saldoTotal = cliente.getContas().stream()
                .mapToDouble(Conta::getSaldo)
                .sum();
        System.out.println("Saldo total do cliente: R$" + saldoTotal);
    }
}
