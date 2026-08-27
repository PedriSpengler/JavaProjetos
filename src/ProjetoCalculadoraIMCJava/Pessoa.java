package ProjetoCalculadoraIMCJava;

public class Pessoa {
    private float peso;
    private float altura;

    // construtor
    public Pessoa() {}

    // Getter peso
    public float getPeso() {
        return this.peso;
    }
    // Getter altura
    public float getAltura() {
        return this.altura;
    }
    // Setter peso
    public void setPeso(float peso) {
        this.peso = peso;
    }
    // Setter altura
    public void setAltura(float altura) {
        this.altura = altura;
    }

    // metodo calcular IMC
    public double calcularIMC() {
        if (altura <= 0) return 0;
        return (peso / Math.pow(altura, 2));
    }

    public Categoria obterCategoriaIMC() {
        return Categoria.classificar(this.calcularIMC());
    }
}

