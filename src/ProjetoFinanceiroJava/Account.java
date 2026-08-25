package ProjetoFinanceiroJava;

abstract public class Account implements AccountManager {

    // STATIC KEYWORD: variável global compartilhada entre todas as instancias (Gera IDs únicos).
    private static int globalAccountIdCounter = 1000;
    // FINAL KEYWORD: constante que não pode ter seu valor alterado após inicialização.
    protected final double MAINTENANCE_FEE = 15.00;

    // Atributos protegidos contra modificações do exterior.
    private final int accountID;
    private final String titular;
    protected double saldo; // Protected permite que classes filhas acessem, mas continua oculto fora do pacote.

    // Construtor
    public Account(String titular, float saldo) {
        this.titular = titular;
        this.saldo = saldo;
        // Incrementa o contador estático para garantir um ID único por conta
        accountID = ++globalAccountIdCounter;
    }

    // Getters
    public double getSaldo() {
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