package com.example.projetofinaljava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        LoginController loginController = new LoginController(stage);
        Scene loginScene = new Scene(loginController.getLoginView());
        stage.setTitle("Login");
        stage.setScene(loginScene);
        stage.show();
    }

    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }
}


