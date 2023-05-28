package Programa;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class AgenciaBancaria {
    
    static ArrayList<ContaBancaria> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<ContaBancaria>();
        operacoes();
    }

    public static void operacoes(){

        int operacao = 
            Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação ---" +
            
                    "|   Opção 1 - Criar Conta" +
                    "|   Opção 2 - Depositar" +
                    "|   Opção 3 - Sacar " +
                    "|   Opção 4 - Transferir " +
                    "|   Opção 5 - Listar " +
                    "|   Opção 6 - Sair "));

        switch(operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agência!");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
        pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
        pessoa.setEmail(JOptionPane.showInputDialog("Email: "));

        ContaBancaria conta = new ContaBancaria(pessoa);

        contasBancarias.add(conta);

        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

        operacoes();
    }

    private static ContaBancaria encontrarConta(int numeroConta) {
        ContaBancaria conta = null;
        if (contasBancarias.size() > 0) {
            for (ContaBancaria c: contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));

        ContaBancaria conta = encontrarConta(numeroConta);

        if (conta != null) {
            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor para depósito: "));
            conta.depositar(valorDeposito);
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
        operacoes();
    }

    public static void sacar() {

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));

        ContaBancaria conta = encontrarConta(numeroConta);
        if (conta != null) {
            Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Valor para saque: "));
            conta.sacar(valorSaque);
        } else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada!");
        }
        operacoes();
    }

    public static void transferir() {
        int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente: "));

        ContaBancaria contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Conta para transferência: "));

            ContaBancaria contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor para transferência: "));
                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                JOptionPane.showMessageDialog(null, "Conta não encontrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Conta não encontrada!");
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (ContaBancaria conta: contasBancarias) {
                JOptionPane.showMessageDialog(null, conta, null, 0, null);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
        }
        operacoes();
    }

}
