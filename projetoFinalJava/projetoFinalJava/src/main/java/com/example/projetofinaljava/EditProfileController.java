package com.example.projetofinaljava;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;

public class EditProfileController {

    private EditProfileView editProfileView;
    private User user;
    private UserStore userStore = new UserStore();
    private Stage primaryStage;

    public EditProfileController(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.editProfileView = new EditProfileView();
        initialize();
        attachEventHandlers();
    }

    public void setEditProfileView(EditProfileView editProfileView) {
        this.editProfileView = editProfileView;
        initialize();
        attachEventHandlers();
    }

    private void initialize() {
        if (this.user != null) {
            editProfileView.getUsernameField().setText(user.getUsername());
            editProfileView.getPasswordField().setText(user.getPassword());
        }
        editProfileView.getStatusLabel().setText("");
    }

    private void attachEventHandlers() {
        editProfileView.getChatbotBtn().setOnAction(this::handleChatbot);
        editProfileView.getUserManagementBtn().setOnAction(this::handleUserManagement);
        editProfileView.getProductsBtn().setOnAction(this::handleProducts);
        editProfileView.getOrdersBtn().setOnAction(this::handleOrders);
        editProfileView.getAdsBtn().setOnAction(this::handleAds);
        editProfileView.getAppointmentsBtn().setOnAction(this::handleAppointments);
        editProfileView.getEditProfileBtn().setOnAction(this::handleEditProfile);
        editProfileView.getLogoutBtn().setOnAction(this::handleLogout);
        editProfileView.getSaveButton().setOnAction(this::handleSave);
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
        editProfileView.getStatusLabel().setText("Navegar para página de produtos");
        editProfileView.getStatusLabel().setTextFill(Color.BLACK);
    }

    private void handleOrders(ActionEvent event) {
        // Implement when OrdersController is available
        editProfileView.getStatusLabel().setText("Navegar para página de pedidos");
        editProfileView.getStatusLabel().setTextFill(Color.BLACK);
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
        // Already on this page
    }

    private void handleLogout(ActionEvent event) {
        navigateTo(new LoginView(), "Login");
    }

    private void handleChatbot(ActionEvent event) {
        ChatbotView chatbotView = new ChatbotView();
        ChatbotController chatbotController = new ChatbotController(primaryStage, this.user);
        chatbotController.setChatbotView(chatbotView);
        navigateTo(chatbotView, "Chatbot");
    }

    private void handleSave(ActionEvent event) {
        if (user == null) {
            editProfileView.getStatusLabel().setText("Nenhum usuário carregado");
            editProfileView.getStatusLabel().setTextFill(Color.RED);
            return;
        }
        String oldUsername = user.getUsername();
        String newUsername = editProfileView.getUsernameField().getText();
        String newPassword = editProfileView.getPasswordField().getText();
        if (newUsername.isEmpty() || newPassword.isEmpty()) {
            editProfileView.getStatusLabel().setText("Preencha todos os campos");
            editProfileView.getStatusLabel().setTextFill(Color.RED);
            return;
        }
        if (!oldUsername.equals(newUsername)) {
            userStore.removeUser(user);
            user.setUsername(newUsername);
            user.setPassword(newPassword);
            userStore.addUser(user);
        } else {
            user.setPassword(newPassword);
            userStore.saveUsers();
        }
        editProfileView.getStatusLabel().setText("Perfil atualizado!");
        editProfileView.getStatusLabel().setTextFill(Color.GREEN);
    }

    public void setUser(User user) {
        this.user = user;
        initialize(); // Update view with new user data
    }
}


