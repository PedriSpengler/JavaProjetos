package ProjetoFinanceiroJava;

import java.util.List;
import java.util.Optional;

public class AccountService {

    // OPTIONAL: Evita NullPointerException se a conta não for encontrada
    public Optional<Account> buscarContaPorId(List<Account> contas, int idBusca) {
        return contas.stream()
                .filter(conta -> conta.getAccountID() == idBusca)
                .findFirst();
    }

    // LAMBDAS/STREAMS: Soma o saldo de todas as contas em uma única linha
    public double calcularPatrimonioTotal(List<Account> contas) {
        return contas.stream()
                .mapToDouble(Account::getSaldo)
                .sum();
    }
}