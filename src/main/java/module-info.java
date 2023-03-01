module com.mycompany.currency.calculatorfxml {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.currency.calculatorfxml to javafx.fxml;
    exports com.mycompany.currency.calculatorfxml;
}
