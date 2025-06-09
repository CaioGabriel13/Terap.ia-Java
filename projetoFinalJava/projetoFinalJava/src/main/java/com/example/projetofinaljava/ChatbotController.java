package com.example.projetofinaljava;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.layout.AnchorPane;

public class ChatbotController {

    private ChatbotView chatbotView;
    private User user;
    private Chatbot chatbot = new Chatbot();
    private Stage primaryStage;

    public ChatbotController(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.chatbotView = new ChatbotView();
        initialize();
        attachEventHandlers();
    }

    public void setChatbotView(ChatbotView chatbotView) {
        this.chatbotView = chatbotView;
        initialize();
        attachEventHandlers();
    }

    private void initialize() {
        if (this.user != null) {
            chatbotView.getWelcomeLabel().setText("Bem vindo, " + user.getUsername() + "!");
        }
    }

    private void attachEventHandlers() {
        chatbotView.getSendButton().setOnAction(this::onSendButtonClick);
        chatbotView.getChatbotBtn().setOnAction(this::handleChatbot);
        chatbotView.getUserManagementBtn().setOnAction(this::handleUserManagement);
        chatbotView.getProductsBtn().setOnAction(this::handleProducts);
        chatbotView.getOrdersBtn().setOnAction(this::handleOrders);
        chatbotView.getAdsBtn().setOnAction(this::handleAds);
        chatbotView.getAppointmentsBtn().setOnAction(this::handleAppointments);
        chatbotView.getEditProfileBtn().setOnAction(this::handleEditProfile);
        chatbotView.getLogoutBtn().setOnAction(this::handleLogout);
    }

    private void onSendButtonClick(ActionEvent event) {
        String input = chatbotView.getInputField().getText().trim();

        if (input.isEmpty()) {
            // Visual feedback
            chatbotView.getInputField().setStyle("-fx-border-color: red; -fx-border-width: 1px;");
            chatbotView.getChatArea().appendText("Terap.ia: Por favor, digite sua mensagem antes de enviar.\n");

            // Remove the red border after 2 seconds
            new Timer().schedule(
                    new TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(() ->
                                    chatbotView.getInputField().setStyle(""));
                        }
                    },
                    2000
            );
            return;
        }

        // Reset any previous styling
        chatbotView.getInputField().setStyle("");

        chatbotView.getChatArea().appendText("Você: " + input + "\n");
        String response = chatbot.getResponse(input);
        chatbotView.getChatArea().appendText("Terap.ia: " + response + "\n");
        chatbotView.getInputField().clear();
    }

    private void navigateTo(AnchorPane view, String title) {
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
    }


    private void handleUserManagement(ActionEvent event) {
        UserManagementView userManagementView = new UserManagementView();
        UserManagementController userManagementController = new UserManagementController(primaryStage, this.user);
        userManagementController.setUserManagementView(userManagementView);
        navigateTo(userManagementView, "Gerenciar Usuários");
    }

    private void handleProducts(ActionEvent event) {
        // Implement when ProductsController is available
        chatbotView.getChatArea().appendText("Terap.ia: Funcionalidade de Produtos em breve.\n");
    }

    private void handleOrders(ActionEvent event) {
        // Implement when OrdersController is available
        chatbotView.getChatArea().appendText("Terap.ia: Funcionalidade de Pedidos em breve.\n");
    }

    private void handleAds(ActionEvent event) {
        AdsView adsView = new AdsView();
        AdsController adsController = new AdsController(primaryStage, this.user);
        adsController.setAdsView(adsView);
        navigateTo(adsView, "Anúncios");
    }

    private void handleAppointments(ActionEvent event) {
        AppointmentsView appointmentsView = new AppointmentsView();
        AppointmentsController appointmentsController = new AppointmentsController(primaryStage, this.user);
        appointmentsController.setAppointmentsView(appointmentsView);
        navigateTo(appointmentsView, "Agendamentos");
    }

    private void handleEditProfile(ActionEvent event) {
        EditProfileView editProfileView = new EditProfileView();
        EditProfileController editProfileController = new EditProfileController(primaryStage, this.user);
        editProfileController.setEditProfileView(editProfileView);
        navigateTo(editProfileView, "Editar Perfil");
    }

    private void handleLogout(ActionEvent event) {
        navigateTo(new LoginView(), "Login");
    }

    private void handleChatbot(ActionEvent event) {
        // Already on this page
    }

    public void setUser(User user) {
        this.user = user;
        initialize(); // Update view with new user data
    }
}


