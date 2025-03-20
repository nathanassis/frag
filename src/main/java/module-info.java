module com.frag {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.frag.controllers to javafx.fxml;
    exports com.frag;
}
