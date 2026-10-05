module net.enter.yggdrasil {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.fxmlkit;


    opens net.enter.yggdrasil to javafx.fxml;
    exports net.enter.yggdrasil;
}