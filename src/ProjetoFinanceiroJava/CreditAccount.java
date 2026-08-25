package ProjetoFinanceiroJava;

class CreditAccount extends Account {

    private final double creditLimit; // Regra específica da filha

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