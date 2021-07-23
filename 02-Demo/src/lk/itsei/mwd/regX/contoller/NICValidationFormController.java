package lk.itsei.mwd.regX.contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class NICValidationFormController {

    @FXML
    private TextField txtNIC;

    @FXML
    void btnValidation(ActionEvent event) {
        if (isValidNIC(txtNIC.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Valid NIC", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Invalid NIC", ButtonType.OK).show();
        }
    }

    private boolean isValidNIC(String input) {
        return input.matches("^\\d{9}[Vv]");
    }
}
