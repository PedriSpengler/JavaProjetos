package ProjetoCalculadoraIMCJava;

public enum Categoria {
    ABAIXO_DO_PESO("Abaixo do peso"),
    PESO_IDEAL("Peso ideal"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_GRAU_1("Obesidade Grau I"),
    OBESIDADE_GRAU_2("Obesidade Grau II"),
    OBESIDADE_GRAU_3("Obesidade Grau III");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria classificar(double imc) {
        if (imc < 18.5f) return ABAIXO_DO_PESO;
        if (imc < 25.0f) return PESO_IDEAL;
        if (imc < 30.0f) return SOBREPESO;
        if (imc < 35.0f) return OBESIDADE_GRAU_1;
        if (imc < 40.0f) return OBESIDADE_GRAU_2;
        return OBESIDADE_GRAU_3;
    }
}