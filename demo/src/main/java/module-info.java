module sistemacustos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens sistemacustos to javafx.fxml;
    exports sistemacustos;
}
