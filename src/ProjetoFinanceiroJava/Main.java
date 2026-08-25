package ProjetoFinanceiroJava;

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

        System.out.println("\n[CRIANDO TRANSAÇÕES COM RECORD E ENUM]");
        // Utilizando o Record e Enum criados
        TransactionRecord transacao1 = new TransactionRecord("TXN-001", 100.60, Category.INCOME);
        TransactionRecord transacao2 = new TransactionRecord("TXN-002", 930.00, Category.UTILITIES);

        System.out.println(transacao1);
        System.out.println(transacao2);

        System.out.println("\n[GERANDO RELATÓRIO COM METHOD CHAINING / BUILDER]");
        // Utilizando o Method Chaining
        String relatorioDados = "Transação: " + transacao1.id() + " | Valor: R$" + transacao1.amount() + " | Categoria: " + transacao1.category();

        String report = new ReportBuilder()
                .withHeader("Relatório Financeiro Diário")
                .withData(relatorioDados)
                .withFooter("Gerado pelo Sistema Financeiro Java")
                .build();

        System.out.println(report);
    }

}
