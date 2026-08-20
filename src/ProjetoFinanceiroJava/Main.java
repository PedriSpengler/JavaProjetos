package ProjetoFinanceiroJava;

// INTERFACE
interface AccountManager {
    void deposit(double amount);
    boolean withdraw(double amount);
    void printStatement();
}

abstract class Account implements AccountManager {

    // STATIC KEYWORD: variável global compartilhada entre todas as instancias (Gera IDs únicos).
    private static int globalAccountIdCounter = 1000;
    // FINAL KEYWORD: constante que não pode ter seu valor alterado após inicialização.
    protected final double MAINTENANCE_FEE = 15.00;

    // Atributos protegidos contra modificações do exterior.
    private int accountID;
    private String titular;
    protected float saldo; // Protected permite que classes filhas acessem, mas continua oculto fora do pacote.

    // Construtor
    public Account(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
        // Incrementa o contador estático para garantir um ID único por conta
        accountID = ++globalAccountIdCounter;
    }

    // Getters
    public float getSaldo() {
        return this.saldo;
    }

    public String getTitular() {
        return this.titular;
    }

    public int getAccountID() {
        return this.accountID;
    }

    // Implementação base dos métodos da Interface
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            saldo += amount;
            System.out.println("Depósito de R$" + amount + " realizado com sucesso.");
        }
        else {
            throw new IllegalArgumentException("O depósito deve ser positivo!");
        }
    }

    public abstract void applyMaintenanceFee();
}

// Herança
class CheckingAccount extends Account {

    public CheckingAccount(String titular, float saldo) {
        super(titular, saldo);
    }
    // Saque
    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && saldo >= amount) {
            saldo -= amount;
            System.out.println("Saque de R$" + amount + " aprovado. Saldo atual: R$" + saldo);
            return true;
        }
        System.out.println("Saque negado: Saldo insuficiente.");
        return false;
    }
    // Taxa de manutenção
    @Override
    public void applyMaintenanceFee(){
        saldo -= MAINTENANCE_FEE;
        System.out.println("Taxa de manutenção (R$" + MAINTENANCE_FEE + ") debitada da Conta Corrente.");
    }
    // Printa todas as informações da Conta Corrente
    @Override
    public void printStatement(){
        System.out.println("--- Conta Corrente --- | Titular: " + getTitular() + " | Saldo: R$" + getSaldo());
    }
}


// Herança
class CreditAccount extends Account {

    private double creditLimit; // Regra específica da filha

    public CreditAccount(String titular, float saldoInicial, double creditLimit) {
        super(titular, saldoInicial);
        this.creditLimit = creditLimit;
    }

    // Getter
    public double getCreditLimit(){
        return this.creditLimit;
    }

    // POLIMORFISMO (Sobrescrita/Override): Conta de crédito permite sacar além do saldo, até o limite.
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && (saldo + creditLimit) >= amount) {
            saldo -= amount;
            System.out.println("Saque de R$" + amount + " aprovado utilizando limite. Saldo atual: R$" + saldo);
            return true;
        }
        System.out.println("Saque negado: Limite de crédito excedido.");
        return false;
    }
    // Taxa de manutenção
    @Override
    public void applyMaintenanceFee() {
        // Exemplo: Conta de crédito pode ter uma regra de taxa diferente (isenta ou multiplicada)
        double fee = MAINTENANCE_FEE * 1.5;
        saldo -= fee;
        System.out.println("Taxa de manutenção de crédito (R$" + fee + ") debitada.");
    }
    // Printa todas as informações da Conta de Crédito
    @Override
    public void printStatement() {
        System.out.println("--- Conta de Crédito --- | Titular: " + getTitular() +
                " | Saldo: R$" + getSaldo() + " | Limite: R$" + creditLimit);
    }
}

public class Main {
    public static void main(String [] args) {
        // Instanciando uma conta corrente e conta de crédito.
        Account cCorrente = new CheckingAccount("Pedro Joaquim", 900.40f);
        CreditAccount cCredito = new CreditAccount("Maria Rita", 780.98f, 3000);

        System.out.println("[#] CONTA CORRENTE: " + cCorrente.getTitular() + ", SALDO INICIAL: R$" + cCorrente.getSaldo() + ", ID da CONTA: " + cCorrente.getAccountID());
        System.out.println("[#] CONTA CRÉDITO: " + cCredito.getTitular() + ", SALDO INICIAL: R$" + cCredito.getSaldo() + ", ID da CONTA: " + cCredito.getAccountID() + ", LIMITE DE CRÉDITO: " + cCredito.getCreditLimit());

        // Depósitos na conta corrente e de crédito.
        System.out.println("[DEPÓSITO CONTA CORRENTE]");
        cCorrente.deposit(100.60);
        System.out.println("[DEPÓSITO CONTA CRÉDITO]");
        cCredito.deposit(800.02);

        // Verificando o saldo depois do depósito nas contas.
        System.out.println("[#] SALDO CONTA CORRENTE: R$" + cCorrente.getSaldo());
        System.out.println("[#] SALDO CONTA DE CRÉDITO: R$" + cCredito.getSaldo());

        // Sacando dinheiro das contas.
        System.out.println("[SAQUE CONTA CORRENTE]");
        cCorrente.withdraw(930);
        System.out.println("[SAQUE CONTA DE CRÉDITO]");
        cCredito.withdraw(900);

        // Verificando o saldo depois do saque nas contas.
        System.out.println("[#] SALDO CONTA CORRENTE: R$" + cCorrente.getSaldo());
        System.out.println("[#] SALDO CONTA DE CRÉDITO: R$" + cCredito.getSaldo());

        // Aplicando a taxa de manutenção nas contas.
        System.out.println("[APLICAÇÃO TAXA CONTA CORRENTE]");
        cCorrente.applyMaintenanceFee();
        System.out.println("[APLICAÇÃO TAXA CONTA DE CRÉDITO]");
        cCredito.applyMaintenanceFee();

        cCorrente.printStatement();
        cCredito.printStatement();
    }

}
