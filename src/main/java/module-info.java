module com.frag {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;

    opens com.frag.views to javafx.fxml;
    exports com.frag;
}
