package com.example.projetofinaljava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(primaryStage);
        // No need to set loginView explicitly here as it's created in the controller's constructor
        stage.setTitle("Login");
        stage.setScene(new Scene(loginView));
        stage.show();
    }

    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }
}


