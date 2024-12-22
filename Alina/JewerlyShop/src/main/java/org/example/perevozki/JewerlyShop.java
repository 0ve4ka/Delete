package org.example.perevozki;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.perevozki.util.Manager;

import java.io.IOException;

public class JewerlyShop extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       Manager.openLoginStage(stage);
    }

    public static void main(String[] args) {
        launch();

   }
}