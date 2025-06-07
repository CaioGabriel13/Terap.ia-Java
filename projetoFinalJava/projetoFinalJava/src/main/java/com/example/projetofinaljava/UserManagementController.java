package com.example.projetofinaljava;

import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

public class UserManagementController {

    private UserManagementView userManagementView;
    private UserStore userStore = new UserStore();
    private List<User> userList;
    private User user;
    private Stage primaryStage;

    public UserManagementController(Stage primaryStage, User user) {
        this.primaryStage = primaryStage;
        this.user = user;
        this.userManagementView = new UserManagementView();
        initialize();
        attachEventHandlers();
    }

    public void setUserManagementView(UserManagementView userManagementView) {
        this.userManagementView = userManagementView;
        initialize();
        attachEventHandlers();
    }

    private void initialize() {
        userList = userStore.getAllUsers();
        userManagementView.getUserListView().getItems().clear();
        for (User user : userList) {
            userManagementView.getUserListView().getItems().add(user.getUsername());
        }
        userManagementView.getErrorLabel().setText("");
    }

    private void attachEventHandlers() {
        userManagementView.getChatbotBtn().setOnAction(this::handleChatbot);
        userManagementView.getUserManagementBtn().setOnAction(this::handleUserManagement);
        userManagementView.getProductsBtn().setOnAction(this::handleProducts);
        userManagementView.getOrdersBtn().setOnAction(this::handleOrders);
        userManagementView.getAdsBtn().setOnAction(this::handleAds);
        userManagementView.getAppointmentsBtn().setOnAction(this::handleAppointments);
        userManagementView.getEditProfileBtn().setOnAction(this::handleEditProfile);
        userManagementView.getLogoutBtn().setOnAction(this::handleLogout);
        userManagementView.getAddUserBtn().setOnAction(this::handleAddUser);
        userManagementView.getEditUserBtn().setOnAction(this::handleEditUser);
        userManagementView.getDeleteUserBtn().setOnAction(this::handleDeleteUser);
    }

    private void handleUserManagement(ActionEvent event) {
        // Already on this page
    }

    private void handleProducts(ActionEvent event) {
        // TODO: Implement navigation to products page
        userManagementView.getErrorLabel().setText("Navegar para página de produtos");
    }

    private void handleOrders(ActionEvent event) {
        // TODO: Implement navigation to orders page
        userManagementView.getErrorLabel().setText("Navegar para página de pedidos");
    }

    private void handleAddUser(ActionEvent event) {
        try {
            TextInputDialog usernameDialog = new TextInputDialog();
            usernameDialog.setTitle("Adicionar Usuário");
            usernameDialog.setHeaderText("Digite o novo nome de usuário:");
            Optional<String> usernameResult = usernameDialog.showAndWait();
            if (!usernameResult.isPresent() || usernameResult.get().trim().isEmpty()) {
                userManagementView.getErrorLabel().setText("Nome de usuário obrigatório.");
                return;
            }
            String username = usernameResult.get().trim();
            if (userStore.getUser(username) != null) {
                userManagementView.getErrorLabel().setText("Nome de usuário já existe.");
                return;
            }
            TextInputDialog passwordDialog = new TextInputDialog();
            passwordDialog.setTitle("Adicionar Usuário");
            passwordDialog.setHeaderText("Digite a senha para o usuário:");
            Optional<String> passwordResult = passwordDialog.showAndWait();
            if (!passwordResult.isPresent() || passwordResult.get().trim().isEmpty()) {
                userManagementView.getErrorLabel().setText("Senha obrigatória.");
                return;
            }
            String password = passwordResult.get().trim();
            User newUser = new User(username, password);
            userStore.addUser(newUser);
            userManagementView.getUserListView().getItems().add(username);
            userManagementView.getErrorLabel().setText("");
        } catch (Exception e) {
            userManagementView.getErrorLabel().setText("Erro ao adicionar usuário.");
        }
    }

    private void handleEditUser(ActionEvent event) {
        try {
            String selected = userManagementView.getUserListView().getSelectionModel().getSelectedItem();
            if (selected == null) {
                userManagementView.getErrorLabel().setText("Selecione um usuário para editar.");
                return;
            }
            TextInputDialog dialog = new TextInputDialog(selected);
            dialog.setTitle("Editar Usuário");
            dialog.setHeaderText("Editar nome de usuário:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newName -> {
                if (newName.trim().isEmpty() || userStore.getUser(newName) != null) {
                    userManagementView.getErrorLabel().setText("Nome inválido ou já existe.");
                } else {
                    User user = userStore.getUser(selected);
                    userStore.removeUser(user);
                    user.setUsername(newName);
                    userStore.addUser(user);
                    userManagementView.getUserListView().getItems().set(userManagementView.getUserListView().getSelectionModel().getSelectedIndex(), newName);
                    userManagementView.getErrorLabel().setText("");
                }
            });
        } catch (Exception e) {
            userManagementView.getErrorLabel().setText("Erro ao editar usuário.");
        }
    }

    private void handleDeleteUser(ActionEvent event) {
        try {
            String selected = userManagementView.getUserListView().getSelectionModel().getSelectedItem();
            if (selected == null) {
                userManagementView.getErrorLabel().setText("Selecione um usuário para remover.");
                return;
            }
            User user = userStore.getUser(selected);
            userStore.removeUser(user);
            userManagementView.getUserListView().getItems().remove(selected);
            userManagementView.getErrorLabel().setText("");
        } catch (Exception e) {
            userManagementView.getErrorLabel().setText("Erro ao remover usuário.");
        }
    }

    private void navigateTo(AnchorPane view, String title) {
        primaryStage.setScene(new Scene(view));
        primaryStage.setTitle(title);
    }

    private void handleChatbot(ActionEvent event) { navigateTo(new ChatbotView(), "Chatbot"); }
    private void handleAds(ActionEvent event) { navigateTo(new AdsView(), "Anúncios"); }
    private void handleAppointments(ActionEvent event) { navigateTo(new AppointmentsView(), "Agendamentos"); }

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
        // Re-initialize view with user data if needed, or pass user to view constructor
    }
}


