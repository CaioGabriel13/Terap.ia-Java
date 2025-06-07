package com.example.projetofinaljava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class UserManagementView extends AnchorPane {

    private Button chatbotBtn;
    private Button userManagementBtn;
    private Button productsBtn;
    private Button ordersBtn;
    private Button adsBtn;
    private Button appointmentsBtn;
    private Button editProfileBtn;
    private Button logoutBtn;
    private ListView<String> userListView;
    private Button addUserBtn;
    private Button editUserBtn;
    private Button deleteUserBtn;
    private Label errorLabel;

    public UserManagementView() {
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
        mainContent.setAlignment(Pos.TOP_CENTER);
        mainContent.setSpacing(15);
        AnchorPane.setTopAnchor(mainContent, 55.0);
        AnchorPane.setBottomAnchor(mainContent, 15.0);
        AnchorPane.setLeftAnchor(mainContent, 15.0);
        AnchorPane.setRightAnchor(mainContent, 15.0);

        Label titleLabel = new Label("Gerenciamento de Usuários");
        titleLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-weight: bold; -fx-font-size: 20;");

        // User List
        VBox userListBox = new VBox(8);
        userListBox.setStyle("-fx-background-color: #ecf0f1; -fx-padding: 10; -fx-background-radius: 5;");
        userListBox.setPrefHeight(400);

        Label userListLabel = new Label("Lista de Usuários:");
        userListLabel.setStyle("-fx-text-fill: #34495e; -fx-font-weight: bold;");

        userListView = new ListView<>();
        userListView.setStyle("-fx-control-inner-background: white;");
        userListView.setPrefHeight(350);

        userListBox.getChildren().addAll(userListLabel, userListView);

        // Action Buttons
        HBox actionButtonBox = new HBox(15);
        actionButtonBox.setAlignment(Pos.CENTER);

        addUserBtn = new Button("Adicionar Usuário");
        addUserBtn.setStyle("-fx-font-size: 12px; -fx-padding: 8 16; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #2ecc71; -fx-min-width: 120;");

        editUserBtn = new Button("Editar Usuário");
        editUserBtn.setStyle("-fx-font-size: 12px; -fx-padding: 8 16; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #3498db; -fx-min-width: 120;");

        deleteUserBtn = new Button("Remover Usuário");
        deleteUserBtn.setStyle("-fx-font-size: 12px; -fx-padding: 8 16; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 3; -fx-background-color: #e74c3c; -fx-min-width: 120;");

        actionButtonBox.getChildren().addAll(addUserBtn, editUserBtn, deleteUserBtn);

        // Status Message
        errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold;");

        mainContent.getChildren().addAll(titleLabel, userListBox, actionButtonBox, errorLabel);

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

    public ListView<String> getUserListView() {
        return userListView;
    }

    public Button getAddUserBtn() {
        return addUserBtn;
    }

    public Button getEditUserBtn() {
        return editUserBtn;
    }

    public Button getDeleteUserBtn() {
        return deleteUserBtn;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }
}


