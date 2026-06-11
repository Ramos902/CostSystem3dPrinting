package sistemacustos;

public class Impressora3D {
    private String modelo;
    private double preco;
    private double potencia;
    private String imagem;
    private String descricao;

    // Construtor
    public Impressora3D(
            String modelo,
            double preco,
            double potencia,
            String imagem,
            String descricao) {
        this.modelo = modelo;
        this.preco = preco;
        this.potencia = potencia;
        this.imagem = imagem;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return modelo;
    }

    // Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
