# 📚 Portfólio de Projetos Java

Este repositório contém projetos práticos desenvolvidos para consolidar os estudos na linguagem Java. Os projetos foram estruturados para cobrir progressivamente os tópicos da linguagem, desde a sintaxe básica até conceitos avançados de Orientação a Objetos, Coleções e Programação Funcional.

---

## 1️⃣ DataFlow Finance (CLI)

### 📝 Descrição
* O **DataFlow Finance** é um processador e gerenciador de transações financeiras via linha de comando (CLI).[cite: 1]
* O sistema lê lotes de transações de arquivos locais, valida os dados, aplica regras de negócio usando conceitos avançados de Orientação a Objetos e estruturas de dados, e exporta um relatório financeiro consolidado.[cite: 1]
* Este projeto funciona como um consolidado para validar seus conhecimentos na linguagem, cobrindo desde conceitos básicos de OOP até recursos funcionais (Lambdas, Optionals), manipulação de coleções modernas e operações de entrada/saída (File I/O).[cite: 1]

### 🎯 Conceitos Aplicados (Checklist)
* **OOP Avançado:** Classes abstratas, herança, polimorfismo, interfaces e modificadores de acesso.
* **Estruturas e Modificadores:** Uso de `Records` para criar DTOs imutáveis, `Enums` para padronizar categorias e o padrão de projeto Builder (Method Chaining).[cite: 1]
* **Collections (Coleções):** Fila de processamento (`Queue`), garantia de não-duplicidade com `Set` e agregação de totais usando `Map`.[cite: 1]
* **Features Funcionais:** Utilização de `Lambda Expressions` para varrer e filtrar coleções, além de `Optionals` para evitar valores nulos.[cite: 1]
* **I/O e Tratamento de Erros:** Leitura de arquivos `.csv` e exportação de relatórios `.txt` combinados com blocos de exceções customizadas (`try-catch-finally`).[cite: 1]

---

## 2️⃣ Calculadora de IMC (Índice de Massa Corporal)

### 📝 Descrição
A **Calculadora de IMC** é um programa interativo de linha de comando (CLI) voltado para praticar os fundamentos essenciais e a lógica de programação inicial da linguagem. O sistema captura o peso e a altura do usuário, realiza o cálculo matemático do Índice de Massa Corporal e retorna a classificação de saúde (como peso normal, sobrepeso ou obesidade) de forma dinâmica.

### 🎯 Conceitos Aplicados (Checklist)
* **Basic Syntax & Data Types:** Uso de variáveis primitivas (`double`, `int`), tipagem forte e leitura de dados pelo teclado (usando a classe `Scanner`).
* **Math Operations:** Utilização de operadores aritméticos para implementar a fórmula do IMC (peso / altura²).
* **Conditionals:** Controle de fluxo intensivo usando `if`, `else if` e `else` para enquadrar o resultado matemático dentro das faixas de classificação de peso.
* **Loops:** Uso de laços de repetição (como `while` ou `do-while`) para criar um menu interativo, permitindo que o usuário realize novos cálculos sem que a aplicação seja encerrada.

---

## 🚀 Como Executar
1. Clone este repositório para a sua máquina local.
2. Abra a pasta raiz do projeto na sua IDE de preferência (recomendado: **IntelliJ IDEA**).
3. Cada projeto possui o seu próprio pacote e uma classe principal (`Main.java`). Navegue até o projeto desejado e execute o método `main`.
