package ProjetoFinanceiroJava;

// INTERFACE
public interface AccountManager {
    void deposit(double amount);
    boolean withdraw(double amount);
    void printStatement();
}
