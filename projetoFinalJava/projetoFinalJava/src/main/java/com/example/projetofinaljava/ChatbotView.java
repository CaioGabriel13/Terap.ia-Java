package com.example.projetofinaljava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class ChatbotView extends AnchorPane {

    private Button chatbotBtn;
    private Button userManagementBtn;
    private Button productsBtn;
    private Button ordersBtn;
    private Button adsBtn;
    private Button appointmentsBtn;
    private Button editProfileBtn;
    private Button logoutBtn;
    private Label welcomeLabel;
    private TextArea chatArea;
    private TextField inputField;
    private Button sendButton;

    public ChatbotView() {
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

        // Chat Content
        VBox chatContent = new VBox();
        chatContent.setAlignment(Pos.TOP_CENTER);
        chatContent.setSpacing(15);
        AnchorPane.setTopAnchor(chatContent, 60.0);
        AnchorPane.setBottomAnchor(chatContent, 15.0);
        AnchorPane.setLeftAnchor(chatContent, 15.0);
        AnchorPane.setRightAnchor(chatContent, 15.0);

        welcomeLabel = new Label("Bem-vindo!");
        welcomeLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-weight: bold; -fx-font-size: 20;");

        chatArea = new TextArea();
        chatArea.setPrefWidth(770);
        chatArea.setPrefHeight(400);
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        chatArea.setStyle("-fx-font-size: 14px; -fx-control-inner-background: white; -fx-border-color: #bdc3c7;");

        HBox inputArea = new HBox(10);
        inputArea.setAlignment(Pos.CENTER_RIGHT);

        inputField = new TextField();
        inputField.setPrefWidth(650);
        inputField.setPromptText("Digite sua mensagem...");
        inputField.setStyle("-fx-font-size: 14px;");

        sendButton = new Button("Enviar");
        sendButton.setStyle("-fx-font-size: 14px; -fx-padding: 8 20; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #27ae60;");

        inputArea.getChildren().addAll(inputField, sendButton);

        chatContent.getChildren().addAll(welcomeLabel, chatArea, inputArea);

        getChildren().addAll(navBar, chatContent);
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

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public TextArea getChatArea() {
        return chatArea;
    }

    public TextField getInputField() {
        return inputField;
    }

    public Button getSendButton() {
        return sendButton;
    }
}


