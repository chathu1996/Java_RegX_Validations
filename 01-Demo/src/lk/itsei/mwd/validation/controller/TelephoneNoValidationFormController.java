package lk.itsei.mwd.validation.controller;

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
            new Alert(Alert.AlertType.CONFIRMATION, "Valid Telephone number", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Invalid Telephone Number", ButtonType.OK).show();
        }

    }

    private boolean isValidTelephoneNumber(String input){
        if (input.length() != 11) {
            return false;
        }
        String dash = input.substring(3, 4);
        if (!dash.equals("-")){
            return  false;
        }
        String number = input.replace("-", "");
        if (!isNumber(number) && number.length() == 9) {
            return false;
        }
        return  true;
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
