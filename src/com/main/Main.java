package com.main;

import com.bank.Agencia;
import com.bank.InstituicaoBancaria;
import com.model.Cliente;
import com.model.Conta;
import com.model.ContaCorrente;
import com.model.ContaSalario;
import com.model.interfaces.Transferiveis;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InstituicaoBancaria bradesco = new InstituicaoBancaria("Bradesco");
        InstituicaoBancaria santander = new InstituicaoBancaria("Santander");

        Agencia bradescoAg1 = new Agencia("0001");
        Agencia bradescoAg2 = new Agencia("0002");
        Agencia santanderAg1 = new Agencia("1234");
        Agencia santanderAg2 = new Agencia("1235");

        bradesco.adicionarAgencia(bradescoAg1);
        bradesco.adicionarAgencia(bradescoAg2);
        santander.adicionarAgencia(santanderAg1);
        santander.adicionarAgencia(santanderAg2);

        List<Conta> todasContas = new ArrayList<>();

        String[] nomes = {
                "Alice", "Bob", "Carlos",
                "Diana", "Eduardo", "Fernanda",
                "Gabriel", "Heloisa", "Igor",
                "Joana", "Kaio", "Laura"
        };

        String[] cpfs = {
                "111.111.111-11", "222.222.222-22", "333.333.333-33",
                "444.444.444-44", "555.555.555-55", "666.666.666-66",
                "777.777.777-77", "888.888.888-88", "999.999.999-99",
                "000.000.000-00", "101.101.101-10", "202.202.202-20"
        };

        // Criar contas misturando ContaCorrente e ContaSalario
        for (int i = 0; i < nomes.length; i++) {
            Cliente c = new Cliente(nomes[i], cpfs[i]);
            Conta conta;

            if (i % 2 == 0) { // pares = ContaCorrente
                conta = new ContaCorrente("C" + (i + 1), c);
            } else { // ímpares = ContaSalario
                conta = new ContaSalario("C" + (i + 1), c);
            }

            conta.depositar(1000);
            todasContas.add(conta);

            if (i < 3) bradescoAg1.adicionarConta(conta);
            else if (i < 6) bradescoAg2.adicionarConta(conta);
            else if (i < 9) santanderAg1.adicionarConta(conta);
            else santanderAg2.adicionarConta(conta);
        }

        // Realizar transferências usando TED e PIX diretamente

        // Alice (C1) TED para Bob (C2)
        transferenciaTED((Transferiveis) todasContas.get(0), todasContas.get(1), 200);

        // Diana (C4) PIX para Carlos (C3)
        transferenciaPIX((Transferiveis) todasContas.get(3), todasContas.get(2), 150);

        // Joana (C10) TED para Eduardo (C5)
        transferenciaTED((Transferiveis) todasContas.get(9), todasContas.get(4), 100);

        // Laura (C12) PIX para Igor (C9)
        transferenciaPIX((Transferiveis) todasContas.get(11), todasContas.get(8), 50);

        // Gabriel (C7) TED para Alice (C1)
        transferenciaTED((Transferiveis) todasContas.get(6), todasContas.get(0), 300);

        // Mostrar saldo final por agência
        System.out.println("\n==== Bradesco Agência 0001 ====");
        bradescoAg1.exibirContas();

        System.out.println("\n==== Bradesco Agência 0002 ====");
        bradescoAg2.exibirContas();

        System.out.println("\n==== Santander Agência 1234 ====");
        santanderAg1.exibirContas();

        System.out.println("\n==== Santander Agência 1235 ====");
        santanderAg2.exibirContas();
    }

    private static void transferenciaTED(Transferiveis origem, Conta destino, double valor) {
        double resultado = origem.transferenciaTED(valor, destino);
        if (resultado > 0) {
            System.out.println("TED de " + valor + " realizada de " + ((Conta) origem).getTitular().getNome() + " para " + destino.getTitular().getNome());
        } else {
            System.out.println("Falha na TED de " + ((Conta) origem).getTitular().getNome());
        }
    }

    private static void transferenciaPIX(Transferiveis origem, Conta destino, double valor) {
        double resultado = origem.transferenciaPIX(valor, destino);
        if (resultado > 0) {
            System.out.println("PIX de " + valor + " realizado de " + ((Conta) origem).getTitular().getNome() + " para " + destino.getTitular().getNome());
        } else {
            System.out.println("Falha no PIX de " + ((Conta) origem).getTitular().getNome());
        }
    }
}
