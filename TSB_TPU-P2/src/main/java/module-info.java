module tsb_tpup2.tsb_tpup2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens tsb_tpup2.tsb_tpup2 to javafx.fxml;
    exports tsb_tpup2.tsb_tpup2;
    exports tsb_tpup2.tsb_tpup2.Clases;
    opens tsb_tpup2.tsb_tpup2.Clases to javafx.fxml;
    exports tsb_tpup2.tsb_tpup2.Clases.View;
    opens tsb_tpup2.tsb_tpup2.Clases.View to javafx.fxml;
    exports tsb_tpup2.tsb_tpup2.Tests;
    exports tsb_tpup2.tsb_tpup2.Clases.Model;
    opens tsb_tpup2.tsb_tpup2.Clases.Model to javafx.fxml;
}