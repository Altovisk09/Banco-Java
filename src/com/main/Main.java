package com.main;

import com.bank.Agencia;
import com.bank.InstituicaoBancaria;
import com.model.Cliente;
import com.model.Conta;
import com.model.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // === CRIANDO BANCOS ===
        InstituicaoBancaria bradesco = new InstituicaoBancaria("Bradesco");
        InstituicaoBancaria santander = new InstituicaoBancaria("Santander");

        // === CRIANDO AGENCIAS ===
        //Bradesco
        Agencia bradescoAg1 = new Agencia("0001");
        Agencia bradescoAg2 = new Agencia("0002");
        bradesco.adicionarAgencia(bradescoAg1);
        bradesco.adicionarAgencia(bradescoAg2);
        //Santander
        Agencia santanderAg1 = new Agencia("1234");
        Agencia santanderAg2 = new Agencia("1235");
        santander.adicionarAgencia(santanderAg1);
        santander.adicionarAgencia(santanderAg2);

        // === CRIANDO CLIENTES ===
        List<Conta> todasContas = new ArrayList<>();

        String[] nomes = {
                "Alice", "Bob", "Carlos",     // Bradesco Ag 1
                "Diana", "Eduardo", "Fernanda", // Bradesco Ag 2
                "Gabriel", "Heloisa", "Igor",  // Santander Ag 1
                "Joana", "Kaio", "Laura"       // Santander Ag 2
        };

        String[] cpfs = {
                "111.111.111-11", "222.222.222-22", "333.333.333-33",
                "444.444.444-44", "555.555.555-55", "666.666.666-66",
                "777.777.777-77", "888.888.888-88", "999.999.999-99",
                "000.000.000-00", "101.101.101-10", "202.202.202-20"
        };

        // Distribuir os clientes entre agências
        for (int i = 0; i < nomes.length; i++) {
            Cliente c = new Cliente(nomes[i], cpfs[i]);
            Conta conta = new ContaCorrente("C" + (i + 1), c);
            conta.depositar(1000); // depósito inicial

            todasContas.add(conta);

            if (i < 3) bradescoAg1.adicionarConta(conta);
            else if (i < 6) bradescoAg2.adicionarConta(conta);
            else if (i < 9) santanderAg1.adicionarConta(conta);
            else santanderAg2.adicionarConta(conta);
        }

        // === FAZENDO TRANSFERÊNCIAS SIMPLES ENTRE CONTAS ===
        // Alice (C1) transfere 200 para Bob (C2)
        transfere(todasContas.get(0), todasContas.get(1), 200);

        // Diana (C4) transfere 150 para Carlos (C3)
        transfere(todasContas.get(3), todasContas.get(2), 150);

        // Joana (C10) transfere 100 para Eduardo (C5)
        transfere(todasContas.get(9), todasContas.get(4), 100);

        // Laura (C12) transfere 50 para Igor (C9)
        transfere(todasContas.get(11), todasContas.get(8), 50);

        // Gabriel (C7) transfere 300 para Alice (C1)
        transfere(todasContas.get(6), todasContas.get(0), 300);

        // === SALDOS FINAIS POR AGÊNCIA ===
        System.out.println("\n==== Bradesco Agência 0001 ====");
        bradescoAg1.exibirContas();

        System.out.println("\n==== Bradesco Agência 0002 ====");
        bradescoAg2.exibirContas();

        System.out.println("\n==== Santander Agência 1234 ====");
        santanderAg1.exibirContas();

        System.out.println("\n==== Santander Agência 1235 ====");
        santanderAg2.exibirContas();
    }

    private static void transfere(Conta origem, Conta destino, double valor) {
        if (origem.sacar(valor) > 0) {
            destino.depositar(valor);
            System.out.println("Transferência de " + valor + " realizada de " +
                    origem.getTitular().getNome() + " para " + destino.getTitular().getNome());
        } else {
            System.out.println("Transferência falhou: saldo insuficiente em " + origem.getTitular().getNome());
        }
    }
}
