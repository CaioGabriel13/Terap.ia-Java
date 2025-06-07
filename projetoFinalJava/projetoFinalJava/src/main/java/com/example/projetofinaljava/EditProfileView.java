package com.example.projetofinaljava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class EditProfileView extends AnchorPane {

    private Button chatbotBtn;
    private Button userManagementBtn;
    private Button productsBtn;
    private Button ordersBtn;
    private Button adsBtn;
    private Button appointmentsBtn;
    private Button editProfileBtn;
    private Button logoutBtn;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button saveButton;
    private Label statusLabel;

    public EditProfileView() {
        setPrefWidth(800);
        setPrefHeight(600);

        // Navigation Bar
        HBox navBar = new HBox();
        navBar.setAlignment(Pos.CENTER);
        navBar.setSpacing(10);
        navBar.setStyle("-fx-background-color: #2c3e50;");
        navBar.setPrefHeight(50);
        AnchorPane.setLeftAnchor(navBar, 0.0);
        AnchorPane.setRightAnchor(navBar, 0.0);
        AnchorPane.setTopAnchor(navBar, 0.0);
        navBar.setPadding(new Insets(10, 15, 10, 15));

        chatbotBtn = new Button("Chatbot");
        chatbotBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #27ae60;");

        userManagementBtn = new Button("Gerenciar Usuários");
        userManagementBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2980b9;");

        productsBtn = new Button("Produtos");
        productsBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2980b9;");

        ordersBtn = new Button("Pedidos");
        ordersBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2980b9;");

        adsBtn = new Button("Anúncios");
        adsBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2980b9;");

        appointmentsBtn = new Button("Agendamentos");
        appointmentsBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2980b9;");

        editProfileBtn = new Button("Editar Perfil");
        editProfileBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2980b9;");

        Region spacer = new Region();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        logoutBtn = new Button("Sair");
        logoutBtn.setStyle("-fx-font-size: 12px; -fx-padding: 5 10; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #e74c3c;");

        navBar.getChildren().addAll(chatbotBtn, userManagementBtn, productsBtn, ordersBtn, adsBtn, appointmentsBtn, editProfileBtn, spacer, logoutBtn);

        // Edit Profile Form
        VBox formContainer = new VBox();
        formContainer.setAlignment(Pos.CENTER);
        formContainer.setSpacing(20);
        AnchorPane.setTopAnchor(formContainer, 100.0);
        AnchorPane.setBottomAnchor(formContainer, 100.0);
        AnchorPane.setLeftAnchor(formContainer, 200.0);
        AnchorPane.setRightAnchor(formContainer, 200.0);

        Label titleLabel = new Label("Editar Perfil");
        titleLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-weight: bold; -fx-font-size: 24;");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label("Username:");
        usernameLabel.setStyle("-fx-font-size: 14px;");
        GridPane.setConstraints(usernameLabel, 0, 0);

        usernameField = new TextField();
        usernameField.setStyle("-fx-font-size: 14px;");
        GridPane.setConstraints(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        passwordLabel.setStyle("-fx-font-size: 14px;");
        GridPane.setConstraints(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        passwordField.setStyle("-fx-font-size: 14px;");
        GridPane.setConstraints(passwordField, 1, 1);

        gridPane.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField);

        saveButton = new Button("Salvar");
        saveButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 25; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #27ae60;");

        statusLabel = new Label();
        statusLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        formContainer.getChildren().addAll(titleLabel, gridPane, saveButton, statusLabel);

        getChildren().addAll(navBar, formContainer);
    }

    public Button getChatbotBtn() {
        return chatbotBtn;
    }

    public Button getUserManagementBtn() {
        return userManagementBtn;
    }

    public Button getProductsBtn() {
        return productsBtn;
    }

    public Button getOrdersBtn() {
        return ordersBtn;
    }

    public Button getAdsBtn() {
        return adsBtn;
    }

    public Button getAppointmentsBtn() {
        return appointmentsBtn;
    }

    public Button getEditProfileBtn() {
        return editProfileBtn;
    }

    public Button getLogoutBtn() {
        return logoutBtn;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }
}


