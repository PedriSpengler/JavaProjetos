# 📊 DataFlow Finance (CLI)

## 📝 Descrição do Projeto
O **DataFlow Finance** é um processador e gerenciador de transações financeiras via linha de comando (CLI). O sistema lê lotes de transações de arquivos locais, valida os dados, aplica regras de negócio usando conceitos avançados de Orientação a Objetos e estruturas de dados, e exporta um relatório financeiro consolidado.

Este projeto funciona como um consolidado para validar seus conhecimentos na linguagem, cobrindo desde conceitos básicos de OOP até recursos funcionais (Lambdas, Optionals), manipulação de coleções modernas e operações de entrada/saída (File I/O).

---

## 🎯 Conceitos Aplicados (Checklist do Mapa Mental)

### 1. Object-Oriented Programming (OOP)
- [ ] **Classes, Objects, Attributes, Methods:** Estrutura base do domínio.
- [ ] **Encapsulation & Access Specifiers:** Proteção do saldo e das configurações das contas.
- [ ] **Inheritance & Abstraction:** Classe abstrata `Account` com filhas `CheckingAccount` e `CreditAccount`.
- [ ] **Interfaces:** Implementação de contratos como `AccountManager` e `ReportGenerator`.
- [ ] **Static & Final Keywords:** Contadores estáticos para gerar IDs sequenciais e constantes (`final`) para taxas de transação.
- [ ] **Method Overloading / Overriding:** Sobrescrita do método de `processTransaction()` dependendo da regra da conta (ex: checar limite no crédito).

### 2. Estruturas e Modificadores
- [ ] **Records:** `TransactionRecord(String id, double amount, Category cat)` para ser um DTO imutável de transações lidas.
- [ ] **Enums:** `Category` (`FOOD`, `UTILITIES`, `INCOME`) e `Status` (`SUCCESS`, `DENIED`).
- [ ] **Method Chaining:** Padrão *Builder* (ex: `new ReportBuilder().withTitle("...").withData(...).build()`).

### 3. Collections (Coleções)
- [ ] **Queue / Dequeue:** Uma fila de processamento onde as transações lidas do arquivo são inseridas e consumidas sequencialmente.
- [ ] **Set:** Um `HashSet` com os IDs das transações para garantir que nenhuma transação seja processada ou debitada em duplicidade.
- [ ] **Map:** Um `HashMap` para agregar os totais processados, agrupando por categorias (ex: `Map<Category, Double>`).
- [ ] **List (ArrayList):** Manter o histórico consolidado na memória antes de exportar.

### 4. Tratamento de Erros e I/O
- [ ] **Exception Handling:** Lançamento de exceções customizadas (`InsufficientFundsException`, `InvalidFileFormatException`) com blocos `try-catch-finally`.
- [ ] **File & I/O Operations:** Leitura de um arquivo `transactions.csv` (usando classes de Input) e exportação de um `report.txt` (usando classes de Output).

### 5. Features Funcionais e Arquitetura
- [ ] **Lambda Expressions:** Utilização de `.stream().filter(t -> t.amount() > 0).forEach(...)` para varrer e filtrar coleções.
- [ ] **Optionals:** Ao buscar uma conta específica no sistema, retornar `Optional<Account>` em vez de nulo, tratando com `.orElseThrow(...)`.
- [ ] **Dependency Injection (Manual):** Passar o leitor de arquivos no construtor do seu `TransactionProcessor`, mantendo as classes desacopladas.

---

## 🛠️ Estrutura Sugerida de Pacotes

```text
src/
├── Main.java
├── exceptions/
│   ├── InsufficientFundsException.java
│   └── InvalidTransactionException.java
├── models/
│   ├── Account.java (Abstract)
│   ├── CheckingAccount.java
│   ├── CreditAccount.java
│   ├── TransactionRecord.java (Record)
│   └── TransactionCategory.java (Enum)
├── repositories/
│   ├── FileTransactionReader.java (I/O)
│   └── ReportWriter.java (I/O)
└── services/
    ├── TransactionProcessor.java
    └── ReportBuilder.java
```