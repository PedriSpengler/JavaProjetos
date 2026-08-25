package ProjetoFinanceiroJava;

import java.util.*;

public class TransactionProcessor {

    public static void main(String[] args) {

        // 1. QUEUE: Fila para armazenar as transações
        Queue<TransactionRecord> queue = new LinkedList<>();

        queue.offer(new TransactionRecord("TX001", 50.0, Category.FOOD));
        queue.offer(new TransactionRecord("TX002", 20.0, Category.UTILITIES));
        queue.offer(new TransactionRecord("TX001", 50.0, Category.FOOD));      // Transação DUPLICADA
        queue.offer(new TransactionRecord("TX003", 100.0, Category.UTILITIES));
        queue.offer(new TransactionRecord("TX004", 30.0, Category.FOOD));

        // 2. SET: Conjunto para guardar os IDs já processados e evitar duplicatas
        Set<String> processedIds = new HashSet<>();

        // 3. MAP: Dicionário para agrupar as transações usando o Enum Category direto como chave!
        Map<Category, List<TransactionRecord>> groupedTransactions = new HashMap<>();

        // 4. PROCESSAMENTO (Dequeue)
        System.out.println("Iniciando o processamento...\n");

        while (!queue.isEmpty()) {
            // Retira o próximo elemento da fila (Dequeue)
            TransactionRecord currentTx = queue.poll();

            // 1. Verifica no Set se essa transação já foi processada
            if (processedIds.contains(currentTx.id())) {
                System.out.println("Ignorando duplicata: " + currentTx.id());
                continue; // Pula para a próxima iteração, ignorando o resto do código abaixo
            }

            // 2. Marca a transação como processada adicionando o ID no Set
            processedIds.add(currentTx.id());

            // 3. Adiciona a transação no Map.
            // O computeIfAbsent verifica se a Categoria já existe. Se não existir, cria a lista.
            groupedTransactions
                    .computeIfAbsent(currentTx.category(), key -> new ArrayList<>())
                    .add(currentTx);

            System.out.println("Processada: " + currentTx.id());
        }

        // 5. EXIBINDO O RESULTADO FINAL
        System.out.println("\n--- Resumo Agrupado por Categoria ---");
        for (Map.Entry<Category, List<TransactionRecord>> entry : groupedTransactions.entrySet()) {
            System.out.println("Categoria: " + entry.getKey());

            for (TransactionRecord tx : entry.getValue()) {
                System.out.println("   -> " + tx);
            }
        }
    }
}