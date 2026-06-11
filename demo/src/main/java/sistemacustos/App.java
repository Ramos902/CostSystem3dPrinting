package sistemacustos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sistemacustos.Enum.DensidadeEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private List<Impressora3D> impressoras = new ArrayList<>();
    private List<MaterialImpressao> materiais = new ArrayList<>();

    private ComboBox<Impressora3D> comboImpressora;
    private ImageView imageView;
    private Label labelDescricaoImpressora;

    // ação do ComboBox de impressoras para atualizar a imagem e descrição
    private void atualizarImagemEDescricao() {
        Impressora3D selecionada = comboImpressora.getValue();
        if (selecionada != null) {
            String path = "/" + selecionada.getImagem();
            var stream = getClass().getResourceAsStream(path);
            imageView.setImage(new Image(stream));
            labelDescricaoImpressora.setText(selecionada.getDescricao());
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Inicialização dos dados
        // Impressoras
        impressoras.add(new Impressora3D("Ender 3", 1500.0, 350, "ender3.jpg", "Impressora ótima para iniciantes"));
        impressoras.add(new Impressora3D("Creality K1", 3500.0, 500, "crealityk1.jpg", "Ideal para produção"));
        impressoras.add(new Impressora3D("Bambu Lab A1", 4200.0, 400, "bambulaba1.jpg", "Excelente precisão"));
        // Materiais
        materiais.add(new MaterialImpressao("PLA baixa densidade", DensidadeEnum.BAIXA, 0.08));
        materiais.add(new MaterialImpressao("PLA média densidade", DensidadeEnum.MEDIA, 0.12));
        materiais.add(new MaterialImpressao("PLA alta densidade", DensidadeEnum.ALTA, 0.18));

        // Labels do Projeto
        // ComboBox de impressoras
        Label labelImpressora = new Label("Impressora:");
        this.comboImpressora = new ComboBox<>();
        comboImpressora.getItems().addAll(impressoras);
        comboImpressora.getSelectionModel().selectFirst();

        // Campo nome do arquivo STL
        Label labelArquivoSTL = new Label("Nome do arquivo STL:");
        TextField textArquivoSTL = new TextField();
        textArquivoSTL.setPromptText("Ex: meu_projeto.stl");
        // Campo de descrição do projeto
        Label labelDescricao = new Label("Descrição do Projeto:");
        TextArea textDescricao = new TextArea();
        textDescricao.setPrefRowCount(4);
        textDescricao.setWrapText(true);
        // Campo quantidade de material
        Label labelQuantidade = new Label("Quantidade de Material (g):");
        TextField textQuantidade = new TextField();
        textQuantidade.setPromptText("Ex: 100");
        // ComboBox tempo de impressão
        Label labelTempo = new Label("Tempo de Impressão (horas):");
        TextField textTempo = new TextField();
        textTempo.setPromptText("Ex: 2.5");
        // ComboBox de materiais
        Label labelMaterial = new Label("Material:");
        ComboBox<MaterialImpressao> comboMaterial = new ComboBox<>();
        comboMaterial.getItems().addAll(materiais);
        comboMaterial.getSelectionModel().selectFirst();
        // Botão calcular custo
        Button btnCalcular = new Button("Calcular Custo");

        // Coluna Esquerda
        VBox leftColumn = new VBox();
        leftColumn.setSpacing(20);
        leftColumn.setPadding(new Insets(10));

        // Adicionar os elementos à coluna esquerda
        leftColumn.getChildren().addAll(
                labelImpressora, comboImpressora,
                labelArquivoSTL, textArquivoSTL,
                labelDescricao, textDescricao,
                labelQuantidade, textQuantidade,
                labelTempo, textTempo,
                labelMaterial, comboMaterial,
                btnCalcular);

        // Coluna Direita
        VBox rightColumn = new VBox();
        rightColumn.setSpacing(10);
        rightColumn.setPadding(new Insets(10));

        // Imagem da impressora
        this.imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        // Label para descrição da impressora
        this.labelDescricaoImpressora = new Label("Selecione uma impressora");

        // Resultado do custo
        Label resultadoMaterial = new Label("Custo do material: -");
        Label resultadoMaquina = new Label("Custo da máquina: -");
        Label resultadoEnergia = new Label("Custo de energia: -");
        Label resultadoMaoObra = new Label("Custo de mão de obra: -");
        Label resultadoManutencao = new Label("Custo de manutenção: -");
        Label resultadoTotal = new Label("Custo total: -");
        Label resultadoVenda = new Label("Valor de venda sugerido: -");

        // Adicionar os elementos à coluna direita
        rightColumn.getChildren().addAll(
                imageView,
                labelDescricaoImpressora,
                resultadoMaterial,
                resultadoMaquina,
                resultadoEnergia,
                resultadoMaoObra,
                resultadoManutencao,
                resultadoTotal,
                resultadoVenda);

        comboImpressora.setOnAction(e -> atualizarImagemEDescricao());

        // Carrega a imagem da primeira impressora ao iniciar
        atualizarImagemEDescricao();

        // Quando clicar em calcular
        btnCalcular.setOnAction(e -> {
            try {
                Impressora3D impressora = comboImpressora.getValue();
                MaterialImpressao material = comboMaterial.getValue();
                double gramas = Double.parseDouble(textQuantidade.getText());
                double horas = Double.parseDouble(textTempo.getText());

                ProjetoImpressao projeto = new ProjetoImpressao(
                        textArquivoSTL.getText(),
                        textDescricao.getText(),
                        gramas,
                        horas,
                        impressora,
                        material);

                CalculadoraCusto calc = new CalculadoraCusto();

                double custoMaterial = calc.calcularCustoMaterial(projeto);
                double custoMaquina = calc.calcularCustoMaquina(projeto);
                double custoEnergia = calc.calcularCustoEnergia(projeto);
                double custoMaoObra = calc.calcularCustoMaoObra(projeto);
                double custoManutencao = calc.calcularManutencao(projeto);
                double custoTotal = calc.calcularCustoTotal(projeto);
                double valorVenda = calc.calcularValorVenda(custoTotal);

                resultadoMaterial.setText(String.format("Custo do material: R$ %.2f", custoMaterial));
                resultadoMaquina.setText(String.format("Custo da máquina: R$ %.2f", custoMaquina));
                resultadoEnergia.setText(String.format("Custo de energia: R$ %.2f", custoEnergia));
                resultadoMaoObra.setText(String.format("Custo de mão de obra: R$ %.2f", custoMaoObra));
                resultadoManutencao.setText(String.format("Custo de manutenção: R$ %.2f", custoManutencao));
                resultadoTotal.setText(String.format("Custo total: R$ %.2f", custoTotal));
                resultadoVenda.setText(String.format("Valor de venda sugerido: R$ %.2f", valorVenda));

            } catch (NumberFormatException ex) {
                // Avisa o usuário se digitou algo inválido nos campos numéricos
                resultadoTotal.setText("Erro: verifique os campos de gramas e horas.");
            }
        });

        // Caixa (Div) Horizontal principal
        HBox root = new HBox();
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        // Adicionar as colunas ao layout principal
        root.getChildren().addAll(leftColumn, rightColumn);
        root.minWidthProperty().set(root.getPrefWidth());
        root.minHeightProperty().set(root.getPrefHeight());

        scene = new Scene(root, root.getPrefWidth(), root.getPrefHeight());
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Sistema de Cálculo de Custos - Impressora 3D");
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}