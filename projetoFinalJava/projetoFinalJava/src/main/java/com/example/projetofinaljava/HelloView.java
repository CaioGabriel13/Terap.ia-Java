package com.example.projetofinaljava;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HelloView extends VBox {

    private Label welcomeText;
    private Button helloButton;

    public HelloView() {
        setAlignment(Pos.CENTER);
        setSpacing(20.0);
        setPadding(new Insets(20.0, 20.0, 20.0, 20.0));

        welcomeText = new Label();
        helloButton = new Button("Olá!");

        getChildren().addAll(welcomeText, helloButton);
    }

    public Label getWelcomeText() {
        return welcomeText;
    }

    public Button getHelloButton() {
        return helloButton;
    }
}


