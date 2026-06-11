package sistemacustos;

import sistemacustos.Enum.DensidadeEnum;

public class MaterialImpressao {
    private String tipoMaterial;
    private DensidadeEnum densidade;
    private double custoPorGrama;
    

    // Construtor
    public MaterialImpressao(
            String tipoMaterial,
            DensidadeEnum densidade,
            double custo) {
        this.tipoMaterial = tipoMaterial;
        this.densidade = densidade;
        this.custoPorGrama = custo;
    }

    @Override
    public String toString() {
        return tipoMaterial;
    }

    // Getters And Setters
    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public DensidadeEnum getDensidade() {
        return densidade;
    }

    public void setDensidade(DensidadeEnum densidade) {
        this.densidade = densidade;
    }

    public double getCustoPorGrama() {
        return custoPorGrama;
    }

    public void setCustoPorGrama(double custoPorGrama) {
        this.custoPorGrama = custoPorGrama;
    }
}
