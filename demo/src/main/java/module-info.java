module sistemacustos {
    requires javafx.controls;
    requires javafx.fxml;

    opens sistemacustos to javafx.fxml;
    exports sistemacustos;
}
