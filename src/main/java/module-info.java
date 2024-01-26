module com.protocase.protocaselibrary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;

    opens com.protocase.protocaselibrary to javafx.fxml, com.google.gson;
    exports com.protocase.protocaselibrary;
    exports com.protocase.protocaselibrary.fundamental;
    opens com.protocase.protocaselibrary.fundamental to javafx.fxml, com.google.gson;
    exports com.protocase.protocaselibrary.interactive;
    opens com.protocase.protocaselibrary.interactive to javafx.fxml, com.google.gson;
    exports com.protocase.protocaselibrary.responsiveStuff;
    opens com.protocase.protocaselibrary.responsiveStuff to javafx.fxml, com.google.gson;
    exports com.protocase.protocaselibrary.management;
    opens com.protocase.protocaselibrary.management to javafx.fxml, com.google.gson;
}