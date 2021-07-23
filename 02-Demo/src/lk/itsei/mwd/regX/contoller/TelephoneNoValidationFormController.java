package lk.itsei.mwd.regX.contoller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class TelephoneNoValidationFormController {
    @FXML
    private JFXTextField txtTel;

    @FXML
    void btnValidation(ActionEvent event) {
        if (isValidTelephoneNumber(txtTel.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Valid Telephone Number", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Invalid Telephone Number", ButtonType.OK).show();
        }
    }

    private boolean isValidTelephoneNumber(String input) {
        return input.matches("^[1-9]\\d{2}\\.\\d{3}\\.\\d{4}");
    }
}
