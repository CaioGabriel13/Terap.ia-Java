package com.example.projetofinaljava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegisterView extends AnchorPane {

    private TextField usernameField;
    private PasswordField passwordField;
    private Label errorLabel;
    private Button registerButton;
    private Button backButton;

    public RegisterView() {
        // Set background color
        setStyle("-fx-background-color: #f5f5f5;");

        // Register Form Container
        VBox formContainer = new VBox();
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setSpacing(20);
        formContainer.setStyle("-fx-background-color: white; -fx-padding: 40; -fx-border-radius: 5; -fx-background-radius: 5; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        Label titleLabel = new Label("Cadastro");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        VBox usernameBox = new VBox(10);
        usernameBox.setAlignment(Pos.CENTER_LEFT);
        Label usernameLabel = new Label("Usuário:");
        usernameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");
        usernameField = new TextField();
        usernameField.setPrefWidth(300);
        usernameField.setStyle("-fx-font-size: 14px; -fx-padding: 8;");
        usernameBox.getChildren().addAll(usernameLabel, usernameField);

        VBox passwordBox = new VBox(10);
        passwordBox.setAlignment(Pos.CENTER_LEFT);
        Label passwordLabel = new Label("Senha:");
        passwordLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #34495e;");
        passwordField = new PasswordField();
        passwordField.setPrefWidth(300);
        passwordField.setStyle("-fx-font-size: 14px; -fx-padding: 8;");
        passwordBox.getChildren().addAll(passwordLabel, passwordField);

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        registerButton = new Button("Cadastrar");
        registerButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 25; -fx-background-color: #388e3c; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3;");
        backButton = new Button("Voltar");
        backButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 25; -fx-background-color: #e0e0e0; -fx-font-weight: bold; -fx-background-radius: 3;");
        buttonBox.getChildren().addAll(registerButton, backButton);

        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold; -fx-font-size: 13px;");
        errorLabel.setMaxWidth(300);
        errorLabel.setWrapText(true);

        formContainer.getChildren().addAll(titleLabel, usernameBox, passwordBox, buttonBox, errorLabel);

        // Center the form container
        AnchorPane.setTopAnchor(formContainer, 150.0);
        AnchorPane.setBottomAnchor(formContainer, 150.0);
        AnchorPane.setLeftAnchor(formContainer, 250.0);
        AnchorPane.setRightAnchor(formContainer, 250.0);

        getChildren().add(formContainer);
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public Button getBackButton() {
        return backButton;
    }
}


