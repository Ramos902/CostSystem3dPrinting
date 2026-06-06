package sistemacustos;

public class MaterialImpressao {
    private String tipoMaterial;
    private Enum densidade;
    private double custo;

    // Construtor
    public MaterialImpressao(
            String tipoMaterial,
            Enum densidade,
            double custo) {
        this.tipoMaterial = tipoMaterial;
        this.densidade = densidade;
        this.custo = custo;
    }

    // Getters And Setters
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public int getDensidade() {
        return densidade;
    }

    public void setDensidade(int densidade) {
        this.densidade = densidade;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
