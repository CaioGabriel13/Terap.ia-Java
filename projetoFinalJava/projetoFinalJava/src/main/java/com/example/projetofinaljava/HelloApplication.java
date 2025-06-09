package com.example.projetofinaljava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        // Criar o controlador primeiro
        LoginController loginController = new LoginController(primaryStage);
        // Usar a view gerenciada pelo controlador
        LoginView loginView = loginController.getLoginView();
        stage.setTitle("Login");
        stage.setScene(new Scene(loginView));
        stage.show();
    }

    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }
}


