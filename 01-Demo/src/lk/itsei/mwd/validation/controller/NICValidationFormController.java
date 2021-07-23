package lk.itsei.mwd.validation.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class NICValidationFormController {
    @FXML
    private JFXTextField txtNIC;

    @FXML
    void btnValidation(ActionEvent event) {
        if (isValidNIC(txtNIC.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Valid NIC", ButtonType.OK).show();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION, "Invalid NIC", ButtonType.OK).show();
        }
    }

    private boolean isValidNIC (String input) {
        if (input.length() != 10) {
            return  false;
        }
        String number = input.substring(0, 9);
        if (!isNumber(number)) {
            return false;
        }
        if (!input.substring(9,10).equalsIgnoreCase("v")) {
            return false;
        }
        return true;
    }

    private boolean isNumber(String input) {
        char chars[] = input.toCharArray();
        for (char aChar:chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }
}
