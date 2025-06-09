package com.example.projetofinaljava;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    private LoginView loginView;
    private UserStore userStore = new UserStore();
    private Stage primaryStage;

    public LoginController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.loginView    = new LoginView();
        // só configure handlers:
        loginView.getLoginButton().setOnAction(e -> handleLogin());
        loginView.getRegisterButton().setOnAction(e -> goToRegister());
        // NÃO tocar no primaryStage aqui!
    }

    private void navigateTo(AnchorPane view, String title) {
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
    }


    public LoginView getLoginView() {
        return loginView;
    }


    private void handleLogin() {
        String username = loginView.getUsernameField().getText();
        String password = loginView.getPasswordField().getText();
        User user = userStore.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            goToChatbot(user);
        } else {
            loginView.getErrorLabel().setText("Usuário ou senha incorretos");
        }
    }

    private void attachEventHandlers() {
        loginView.getLoginButton().setOnAction(e -> handleLogin());
        loginView.getRegisterButton().setOnAction(this::onRegisterButtonClick);
    }


    private void onRegisterButtonClick(ActionEvent event) {
        goToRegister();
    }

    private void goToChatbot(User user) {
        ChatbotView chatbotView = new ChatbotView();
        ChatbotController chatbotController = new ChatbotController(primaryStage, user);
        chatbotController.setChatbotView(chatbotView);
        primaryStage.setScene(new Scene(chatbotView));
        primaryStage.setTitle("Chatbot");
    }

    private void goToRegister() {
        // cria a view e o controller de cadastro
        RegisterView       registerView       = new RegisterView();
        RegisterController registerController = new RegisterController(primaryStage);

        // troca a cena
        primaryStage.setScene(new Scene(registerView));
        primaryStage.setTitle("Cadastro");
    }

}


