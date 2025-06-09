package com.example.projetofinaljava;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class AppointmentsController {

    private AppointmentsView appointmentsView;
    private User user;
    private Stage primaryStage;

    public AppointmentsController(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.appointmentsView = new AppointmentsView();
        attachEventHandlers();
    }

    public void setAppointmentsView(AppointmentsView appointmentsView) {
        this.appointmentsView = appointmentsView;
        attachEventHandlers();
    }

    private void attachEventHandlers() {
        appointmentsView.getChatbotBtn().setOnAction(this::handleChatbot);
        appointmentsView.getUserManagementBtn().setOnAction(this::handleUserManagement);
        appointmentsView.getProductsBtn().setOnAction(this::handleProducts);
        appointmentsView.getOrdersBtn().setOnAction(this::handleOrders);
        appointmentsView.getAdsBtn().setOnAction(this::handleAds);
        appointmentsView.getAppointmentsBtn().setOnAction(this::handleAppointments);
        appointmentsView.getEditProfileBtn().setOnAction(this::handleEditProfile);
        appointmentsView.getLogoutBtn().setOnAction(this::handleLogout);
    }

    private void navigateTo(AnchorPane view, String title) {
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
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
        appointmentsView.getSoonLabel().setText("Produtos - Em breve");
    }

    private void handleOrders(ActionEvent event) {
        // Implement when OrdersController is available
        appointmentsView.getSoonLabel().setText("Pedidos - Em breve");
    }

    private void handleAds(ActionEvent event) {
        AdsView adsView = new AdsView();
        AdsController adsController = new AdsController(primaryStage, this.user);
        adsController.setAdsView(adsView);
        navigateTo(adsView, "Anúncios");
    }

    private void handleAppointments(ActionEvent event) {
        // Already on this page
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


