package ProjetoFinanceiroJava;

// Implementação do Padrão Builder com Method Chaining
class ReportBuilder {
    private String header;
    private String data;
    private String footer;

    public ReportBuilder withHeader(String header) {
        this.header = header;
        return this; // Retorna a própria instância para permitir o encadeamento
    }

    public ReportBuilder withData(String data) {
        this.data = data;
        return this;
    }

    public ReportBuilder withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    // Metodo final que constroi e retorna o objeto complexo (neste caso, uma String formatada)
    public String build() {
        return "==========================\n" +
                "CABEÇALHO: " + (header != null ? header : "Sem cabeçalho") + "\n" +
                "--------------------------\n" +
                "DADOS: \n" + (data != null ? data : "Sem dados") + "\n" +
                "--------------------------\n" +
                "RODAPÉ: " + (footer != null ? footer : "Sem rodapé") + "\n" +
                "==========================";
    }
}