package org.example.perevozki.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.example.perevozki.JewerlyShop;
import org.example.perevozki.models.*;
import org.example.perevozki.services.*;

import java.io.IOException;
import java.util.Optional;

public class Manager {

    public static Stage currentStage;
    public static Stage lastStage;
    public static Stage editStage;
    public static customers currentCustomer;
    public static products currentProduct;
    public static orders currentOrder = new orders();

    public static CustomerServices customerServices = new CustomerServices();
    public static ProductServices productServices = new ProductServices();
    public static GemstoneServices gemstoneServices = new GemstoneServices();
    public static OrderServices orderServices = new OrderServices();
    public static RingSizeServices ringSizeServices = new RingSizeServices();
    public static DeliveryMethodServices deliveryMethodServices = new DeliveryMethodServices();

    public Manager() throws IOException {
    }

    public static void openLoginStage(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JewerlyShop.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Вход");
        stage.setScene(scene);
        stage.show();
        Manager.currentStage = stage;
    }

    public static void WarningMessage() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Закрыть окно");
        alert.setHeaderText("Вы хотите закрыть текущее окно?");
        alert.setContentText("Все несохраненные данные, будут утеряны! ");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            editStage.close();
        }
    }


    public static void MessageBox(String title,String header,String content,Alert.AlertType alertType){
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(header);
    alert.setContentText(content);
    alert.showAndWait();
}
public static void ErrorosMessageBox(String content){
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Ошибка!");
    alert.setHeaderText("Внимание!");
    alert.setContentText(content);
    alert.showAndWait();
}

public static void ShowWindow(String source,String title) throws IOException {
    if (currentStage != null)
        currentStage.hide();
    FXMLLoader fxmlLoader;
    fxmlLoader = new FXMLLoader(JewerlyShop.class.getResource(source));
    Scene scene = new Scene(fxmlLoader.load());
    scene.getStylesheets().add("base-styles.css");
    Stage stage = new Stage();
    stage.setTitle(title);
    stage.setScene(scene);
    stage.show();
    lastStage = currentStage;
    currentStage = stage;
    stage.setOnCloseRequest(e -> {
        if(lastStage == null) {
            try {
                openLoginStage(new Stage());
                return;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        lastStage.show();
        currentStage.close();
        currentStage = lastStage;
        lastStage =null;
    });
}

public static void ShowEditWindow(String source,String title) throws IOException {
    FXMLLoader fxmlLoader;
    fxmlLoader = new FXMLLoader(JewerlyShop.class.getResource(source));
    Scene scene = new Scene(fxmlLoader.load());
    scene.getStylesheets().add("base-styles.css");
    Stage stage = new Stage();
    stage.setTitle(title);
    stage.setScene(scene);
    editStage = stage;
    stage.showAndWait();
    stage.setOnCloseRequest(e -> {
        WarningMessage();
    });
}
}
