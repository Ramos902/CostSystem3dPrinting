package sistemacustos;

public class ProjetoImpressao {

    private String nomeArquivoStl;
    private String descricao;
    private double gramasUtilizadas;
    private double horasImpressao;
    private Impressora3D impressora;
    private MaterialImpressao material;

    // Construtor
    public ProjetoImpressao(String nomeArquivoStl, String descricao, double gramasUtilizadas,
            double horasImpressao, Impressora3D impressora, MaterialImpressao material) {
        this.nomeArquivoStl = nomeArquivoStl;
        this.descricao = descricao;
        this.gramasUtilizadas = gramasUtilizadas;
        this.horasImpressao = horasImpressao;
        this.impressora = impressora;
        this.material = material;
    }

    // Getters
    public String getNomeArquivoStl() {
        return nomeArquivoStl;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getGramasUtilizadas() {
        return gramasUtilizadas;
    }

    public double getHorasImpressao() {
        return horasImpressao;
    }

    public Impressora3D getImpressora() {
        return impressora;
    }

    public MaterialImpressao getMaterial() {
        return material;
    }
}
