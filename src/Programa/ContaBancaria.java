package Programa;

import javax.swing.JOptionPane;

import Programa.utilitarios.Utils;

public class ContaBancaria {
    
    private static int contadorDeContas = 1;

    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public ContaBancaria(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas++;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "ContaBancaria [numeroConta=" + this.getNumeroConta() + 
                ", Nome=" + this.pessoa.getNome() +
                ", CPF=" + this.pessoa.getCpf() +
                ", Email=" + this.pessoa.getEmail() + 
                ", saldo=" + Utils.doubleToString(this.getSaldo()) + "]";
    }

    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null, "Depósito realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar o depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Saque não realizado!");
        }
    }

    public void transferir(ContaBancaria contaParaDeposito, double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null, "Transferência realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a transferência!");

        }
    }
    
}
