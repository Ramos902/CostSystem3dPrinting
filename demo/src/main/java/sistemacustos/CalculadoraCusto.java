package sistemacustos;

public class CalculadoraCusto {

    // Valores padrão usados nos cálculos
    private double valorKwh = 0.75;         // R$ por kWh
    private double valorHoraMaoObra = 10.0; // R$ por hora trabalhada
    private double horasUsoPorDia = 8.0;    // horas de uso diário da impressora
    private double custoManutencao = 2.50;  // R$ fixo por projeto

    // Custo do material (com taxa de falha de 10%)
    public double calcularCustoMaterial(ProjetoImpressao projeto) {
        double materialReal = projeto.getGramasUtilizadas() * 1.10;
        return materialReal * projeto.getMaterial().getCustoPorGrama();
    }

    // Custo de uso da máquina (amortização em 2 anos)
    public double calcularCustoMaquina(ProjetoImpressao projeto) {
        double horasTotais = 2 * 365 * horasUsoPorDia;
        double custoPorHora = projeto.getImpressora().getPreco() / horasTotais;
        return custoPorHora * projeto.getHorasImpressao();
    }

    // Custo de energia elétrica
    public double calcularCustoEnergia(ProjetoImpressao projeto) {
        double energiaKwh = (projeto.getImpressora().getPotencia() / 1000.0) * projeto.getHorasImpressao();
        return energiaKwh * valorKwh;
    }

    // Custo de mão de obra
    public double calcularCustoMaoObra(ProjetoImpressao projeto) {
        return projeto.getHorasImpressao() * valorHoraMaoObra;
    }

    // Manutenção fixa por projeto
    public double calcularManutencao(ProjetoImpressao projeto) {
        return custoManutencao;
    }

    // Custo total
    public double calcularCustoTotal(ProjetoImpressao projeto) {
        return calcularCustoMaterial(projeto)
             + calcularCustoMaquina(projeto)
             + calcularCustoEnergia(projeto)
             + calcularCustoMaoObra(projeto)
             + calcularManutencao(projeto);
    }

    // Valor de venda com 30% de margem de lucro
    public double calcularValorVenda(double custoTotal) {
        return custoTotal * 1.30;
    }
}
