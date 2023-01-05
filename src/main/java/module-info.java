module com.example.calculator3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.calculator3 to javafx.fxml;
    exports com.example.calculator3;
}