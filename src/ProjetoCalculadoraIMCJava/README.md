# 📊 Calculadora de IMC em Java

Aplicação de console desenvolvida em Java para cálculo do **Índice de Massa Corporal (IMC)** e classificação automática do resultado de acordo com as faixas da Organização Mundial da Saúde (OMS).

Projeto prático focado na consolidação dos fundamentos da linguagem Java e princípios básicos de Programação Orientada a Objetos (POO).

---

## 🚀 Funcionalidades

- Leitura de peso (kg) e altura (m) via console.
- Cálculo da relação massa/estatura usando fórmula padrão do IMC:
  $$\text{IMC} = \frac{\text{peso}}{\text{altura}^2}$$
- Classificação do resultado utilizando enumerações (`Enum`).
- Exibição formatada dos dados e da categoria correspondente.

---

## 🧠 Conceitos e Boas Práticas Aplicadas

- **Entrada e Saída:** Utilização da classe `Scanner` com configuração de `Locale.US` para suporte a pontos decimais.
- **Encapsulamento:** Atributos privados na classe `Pessoa` com métodos de acesso (`getters` e `setters`).
- **Segurança de Tipos (Type Safety):** Uso de `Enum` (`Categoria`) para mapeamento e categorização das faixas de IMC, evitando *magic strings*.
- **Separação de Responsabilidades:** Divisão clara entre entrada/saída (`Main`), modelo de dados (`Pessoa`) e regras de classificação (`Categoria`).

---

## 📁 Estrutura do Projeto

```text
src/
└── ProjetoCalculadoraIMCJava/
    ├── Main.java         # Ponto de entrada (interação via console)
    ├── Pessoa.java       # Entidade que encapsula peso, altura e cálculo
    └── Categoria.java    # Enum com as faixas de classificação da OMS
```

---

## 📋 Tabela de Classificação do IMC

| Faixa de IMC | Classificação |
| :--- | :--- |
| Abaixo de 18.5 | Abaixo do peso |
| 18.5 a 24.9 | Peso ideal |
| 25.0 a 29.9 | Sobrepeso |
| 30.0 a 34.9 | Obesidade Grau I |
| 35.0 a 39.9 | Obesidade Grau II |
| 40.0 ou mais | Obesidade Grau III |

---

## 🛠️ Como Executar

### Pré-requisitos
- **Java Development Kit (JDK)** versão 17 ou superior instalado.

### Passo a passo
1. Clone o repositório ou faça o download dos arquivos:
   ```bash
   git clone [https://github.com/SEU-USUARIO/calculadora-imc-java.git](https://github.com/SEU-USUARIO/calculadora-imc-java.git)
   cd calculadora-imc-java
   ```

2. Compile os arquivos Java:
   ```bash
   javac -d bin src/ProjetoCalculadoraIMCJava/*.java
   ```

3. Execute a aplicação:
   ```bash
   java -cp bin ProjetoCalculadoraIMCJava.Main
   ```

---

## 💻 Exemplo de Uso

```text
=== Bem-vindo(a) sua calculadora de IMC iniciou! ===
Qual é o seu peso? (Exemplo: 70.5): 78.5
Qual é a sua altura? (Exemplo: 1.70): 1.75

O IMC para alguém com 78.50kg e 1.75m é: 25.63
A categoria do IMC é: Sobrepeso
```