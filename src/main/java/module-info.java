module co.edu.uniquindio.empresatransporte.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.empresatransporte.demo1 to javafx.fxml;
    exports co.edu.uniquindio.empresatransporte.demo1;
    exports co.edu.uniquindio.empresatransporte.demo1.util;
    opens co.edu.uniquindio.empresatransporte.demo1.util to javafx.fxml;
}