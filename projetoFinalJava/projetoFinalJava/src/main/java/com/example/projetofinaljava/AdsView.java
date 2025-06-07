package com.example.projetofinaljava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class AdsView extends AnchorPane {

    private Button chatbotBtn;
    private Button userManagementBtn;
    private Button productsBtn;
    private Button ordersBtn;
    private Button adsBtn;
    private Button appointmentsBtn;
    private Button editProfileBtn;
    private Button logoutBtn;
    private Label soonLabel;

    public AdsView() {
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

        // Main Content
        VBox mainContent = new VBox();
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setSpacing(20);
        AnchorPane.setTopAnchor(mainContent, 60.0);
        AnchorPane.setBottomAnchor(mainContent, 60.0);
        AnchorPane.setLeftAnchor(mainContent, 60.0);
        AnchorPane.setRightAnchor(mainContent, 60.0);

        soonLabel = new Label("Anúncios - Em breve");
        soonLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-weight: bold; -fx-font-size: 24;");

        // Placeholder for future content
        VBox placeholderBox = new VBox(15);
        placeholderBox.setAlignment(Pos.CENTER);
        placeholderBox.setStyle("-fx-border-color: #bdc3c7; -fx-border-radius: 5; -fx-padding: 20;");

        Label placeholderLabel = new Label("Esta funcionalidade estará disponível em breve");
        placeholderLabel.setStyle("-fx-text-fill: #7f8c8d; -fx-font-size: 16;");

        ProgressIndicator progressIndicator = new ProgressIndicator(-1.0);

        placeholderBox.getChildren().addAll(placeholderLabel, progressIndicator);

        mainContent.getChildren().addAll(soonLabel, placeholderBox);

        getChildren().addAll(navBar, mainContent);
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

    public Label getSoonLabel() {
        return soonLabel;
    }
}


