package ProjetoCalculadoraIMCJava;

import java.util.Locale;
import java.util.Scanner;

// Um programa simples no console que pede o peso e a altura, calcula o resultado e exibe em qual categoria (abaixo do peso, ideal, sobrepeso, etc.) o usuário se encontra.
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        System.out.println("=== Bem-vindo(a) sua calculadora de IMC iniciou! ===");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Qual é o seu peso? (Exemplo: 70.5)");
        pessoa.setPeso(scanner.nextFloat());
        scanner.nextLine();
        System.out.println("Qual é a sua altura? (Exemplo: 1.70)");
        pessoa.setAltura(scanner.nextFloat());
        scanner.nextLine();

        double imc = pessoa.calcularIMC();

        System.out.printf("\nO IMC para alguém com %.2fkg e %.2fm é: %.2f%n",
                pessoa.getPeso(), pessoa.getAltura(), imc);

        Categoria categoria = pessoa.obterCategoriaIMC();
        System.out.println("A categoria do IMC é: " + categoria.getDescricao());

        scanner.close();
    }
}
