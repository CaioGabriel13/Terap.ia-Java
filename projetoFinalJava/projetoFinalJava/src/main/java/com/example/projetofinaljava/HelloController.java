package com.example.projetofinaljava;

import javafx.event.ActionEvent;

public class HelloController {

    private HelloView helloView;

    public HelloController() {
        this.helloView = new HelloView();
        attachEventHandlers();
    }

    public HelloView getHelloView() {
        return helloView;
    }

    private void attachEventHandlers() {
        helloView.getHelloButton().setOnAction(this::onHelloButtonClick);
    }

    private void onHelloButtonClick(ActionEvent event) {
        helloView.getWelcomeText().setText("Bem-vindo ao aplicativo JavaFX!");
    }
}


