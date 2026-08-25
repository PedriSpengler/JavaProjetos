package ProjetoFinanceiroJava;

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