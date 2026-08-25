package ProjetoFinanceiroJava;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;

// Exceção customizada
class InvalidTransactionFormatException extends Exception {
    public InvalidTransactionFormatException(String message) { super(message); }
}

public class FileService {
    // Lê de um arquivo real
    public static void carregarTransacoes(String caminho, Queue<TransactionRecord> queue) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                // Exemplo de CSV: TX001,50.0,FOOD
                queue.offer(new TransactionRecord(dados[0], Double.parseDouble(dados[1]), Category.valueOf(dados[2])));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Formato inválido no arquivo.");
        }
    }
}