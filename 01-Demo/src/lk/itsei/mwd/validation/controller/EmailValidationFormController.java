package lk.itsei.mwd.validation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class EmailValidationFormController {
    @FXML
    private TextField txtEmail;

    @FXML
    void btnEmailValidation(ActionEvent event) {
        String value = txtEmail.getText();
        if (isValidEmail(value)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Valid Email", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Invalid Email", ButtonType.OK).show();
        }
    }

    private boolean isValidEmail(String input) {
        if (input.length() < 5) {
            return false;
        }
        String split[] = input.split("@");
        if (split.length != 2) {
            return false;
        }
        if (isValidEmailPart(split[0]) && isValidEmailPart(split[1])) {
            if (split[1].contains(".")) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidEmailPart(String input) {
        if (input.startsWith(".") || input.endsWith(".")) {
            return false;
        }
        if (input.contains("..")) {
            return false;
        }
        String stringWithoutPeriod = input.replaceAll("[.]", "");
        return isNumberOfLetter(stringWithoutPeriod);
    }

    private boolean isNumberOfLetter(String input) {
        char chars[] = input.toCharArray();
        for (char aChar: chars) {
            if (!Character.isLetterOrDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

}
