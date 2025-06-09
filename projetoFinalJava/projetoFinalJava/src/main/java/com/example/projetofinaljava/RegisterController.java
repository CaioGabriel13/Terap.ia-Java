package com.example.projetofinaljava;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterController {

    private RegisterView registerView;
    private UserStore userStore = new UserStore();
    private Stage primaryStage;

    public RegisterController(Stage primaryStage) {
        this.primaryStage  = primaryStage;
        this.registerView  = new RegisterView();

        //  ← liga o botão “Voltar” para navegar de volta ao login
        registerView.getBackButton().setOnAction(e -> goToLogin());

        // se ainda não estiver fazendo aqui:
        primaryStage.setScene(new Scene(registerView));
        primaryStage.setTitle("Cadastro");
        primaryStage.show();
    }

    public void setRegisterView(RegisterView registerView) {
        this.registerView = registerView;
    }

    private void navigateTo(AnchorPane view, String title) {
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
    }


    private void attachEventHandlers() {
        registerView.getRegisterButton().setOnAction(this::onRegisterButtonClick);
        registerView.getBackButton().setOnAction(this::onBackButtonClick);
    }

    private void onRegisterButtonClick(ActionEvent event) {
        String username = registerView.getUsernameField().getText().trim();
        String password = registerView.getPasswordField().getText();

        // Verifica campos vazios
        if (username.isEmpty() || password.isEmpty()) {
            registerView.getErrorLabel().setText("Preencha todos os campos.");
            return;
        }

        // Validação de segurança da senha
        String passwordError = validatePassword(password);
        if (passwordError != null) {
            registerView.getErrorLabel().setText(passwordError);
            return;
        }

        // Tenta cadastrar usuário
        if (userStore.addUser(new User(username, password))) {
            goToChatbot(new User(username, password));
        } else {
            registerView.getErrorLabel().setText("Usuário já existe.");
        }
    }

    private void onBackButtonClick(ActionEvent event) {
        goToLogin();
    }

    private void goToChatbot(User user) {
        ChatbotView chatbotView = new ChatbotView();
        ChatbotController chatbotController = new ChatbotController(primaryStage, user);
        chatbotController.setChatbotView(chatbotView);
        primaryStage.setScene(new Scene(chatbotView));
        primaryStage.setTitle("Chatbot");
    }

    private void goToLogin() {
        // instancia o controller de login (que já seta a view)
        LoginController loginController = new LoginController(primaryStage);

        // pega a view do login e troca a cena
        primaryStage.setScene(new Scene(loginController.getLoginView()));
        primaryStage.setTitle("Login");
    }



    /**
     * Verifica se a senha atende aos critérios de segurança:
     * - Pelo menos 8 caracteres
     * - Pelo menos uma letra minúscula
     * - Pelo menos uma letra maiúscula
     * - Pelo menos um dígito
     * - Pelo menos um caractere especial (não letra e não dígito)
     *
     * Retorna null se a senha for válida; caso contrário, retorna a mensagem de erro.
     */
    private String validatePassword(String password) {
        if (password.length() < 8) {
            return "Senha deve ter ao menos 8 caracteres.";
        }
        if (!password.chars().anyMatch(Character::isLowerCase)) {
            return "Senha deve conter ao menos uma letra minúscula.";
        }
        if (!password.chars().anyMatch(Character::isUpperCase)) {
            return "Senha deve conter ao menos uma letra maiúscula.";
        }
        if (!password.chars().anyMatch(Character::isDigit)) {
            return "Senha deve conter ao menos um dígito.";
        }
        if (password.chars().allMatch(Character::isLetterOrDigit)) {
            return "Senha deve conter ao menos um caractere especial.";
        }
        return null;
    }
}


