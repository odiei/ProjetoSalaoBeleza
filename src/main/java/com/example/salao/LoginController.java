package com.example.salao;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void handleButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authenticate(username, password)) {
            loadAppView();
        } else {
            System.out.println("Login failed!");
        }
    }

    @FXML
    private void handleMouseEntered() {
        // sem está dando erro
    }

    @FXML
    private void handleMouseExited() {
        // sem está dando erro
    }

    private boolean authenticate(String username, String password) {
        return "admin".equals(username) && "admin123".equals(password);
    }

    private void loadAppView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/salao/AppView.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
