package com.example.projetofinaljava;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class AdsController {

    private AdsView adsView;
    private User user;
    private Stage primaryStage;

    public AdsController(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.adsView = new AdsView();
        attachEventHandlers();
    }

    public void setAdsView(AdsView adsView) {
        this.adsView = adsView;
        attachEventHandlers();
    }

    private void attachEventHandlers() {
        adsView.getChatbotBtn().setOnAction(this::handleChatbot);
        adsView.getUserManagementBtn().setOnAction(this::handleUserManagement);
        adsView.getProductsBtn().setOnAction(this::handleProducts);
        adsView.getOrdersBtn().setOnAction(this::handleOrders);
        adsView.getAdsBtn().setOnAction(this::handleAds);
        adsView.getAppointmentsBtn().setOnAction(this::handleAppointments);
        adsView.getEditProfileBtn().setOnAction(this::handleEditProfile);
        adsView.getLogoutBtn().setOnAction(this::handleLogout);
    }

    private void navigateTo(AnchorPane view, String title) {
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle(title);
    }

    private void handleChatbot(ActionEvent event) {
        ChatbotView chatbotView = new ChatbotView();
        ChatbotController chatbotController = new ChatbotController(primaryStage, this.user);
        chatbotController.setChatbotView(chatbotView);
        navigateTo(chatbotView, "Chatbot");
    }

    private void handleUserManagement(ActionEvent event) {
        UserManagementView userManagementView = new UserManagementView();
        UserManagementController userManagementController = new UserManagementController(primaryStage, this.user);
        userManagementController.setUserManagementView(userManagementView);
        navigateTo(userManagementView, "Gerenciar Usuários");
    }

    private void handleProducts(ActionEvent event) {
        // Implement when ProductsController is available
        adsView.getSoonLabel().setText("Produtos - Em breve");
    }

    private void handleOrders(ActionEvent event) {
        // Implement when OrdersController is available
        adsView.getSoonLabel().setText("Pedidos - Em breve");
    }

    private void handleAds(ActionEvent event) {
        // Already on this page
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

    public void setUser(User user) {
        this.user = user;
        // Update view with new user data if needed
    }
}


