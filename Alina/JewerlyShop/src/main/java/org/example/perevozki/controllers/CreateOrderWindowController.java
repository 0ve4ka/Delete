package org.example.perevozki.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.perevozki.models.deliveryMethods;
import org.example.perevozki.models.ringSizes;
import org.example.perevozki.util.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateOrderWindowController implements Initializable {


    public ComboBox<ringSizes> ComboBoxRingSize;
    public TextField TextFieldQuantity;
    public ComboBox<deliveryMethods> ComboBoxDeliveryMethod;
    public TextField TextFieldDeliveryAddress;

    private List<ringSizes> ringSizesList = Manager.ringSizeServices.findAll();
    private List<deliveryMethods> deliveryMethodsList = Manager.deliveryMethodServices.findAll();

    @FXML
    void BtnCancelAction(ActionEvent event) {
        Manager.WarningMessage();
    }

    @FXML
    void BtnOkAction(ActionEvent event) throws IOException {
        String errors = checkInputData().toString();
        if(!errors.isEmpty()) {
            Manager.MessageBox("Ошибка!", "Ошибка ввода данных!", errors, Alert.AlertType.ERROR);
            return;
        }
        Manager.currentOrder.setRingSize(ComboBoxRingSize.getValue());
        Manager.currentOrder.setQuantity(Integer.parseInt(TextFieldQuantity.getText()));
        Manager.currentOrder.setDeliveryMethod(ComboBoxDeliveryMethod.getValue());
        Manager.currentOrder.setDeliveryAddress(TextFieldDeliveryAddress.getText());
        Manager.MessageBox("Заказ", "Удачно!", "Данные успешно сохранены!", Alert.AlertType.INFORMATION);
        Manager.orderServices.save(Manager.currentOrder);
    }

    StringBuilder checkInputData(){
        StringBuilder errors = new StringBuilder();
        if(TextFieldQuantity.getText().isEmpty())
            TextFieldQuantity.setText("1");
        if(ComboBoxDeliveryMethod.getValue() == null)
            errors.append("Способ доставки не указан\n");
        return errors;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ComboBoxRingSize.setItems(FXCollections.observableArrayList(ringSizesList));
        ComboBoxDeliveryMethod.setItems(FXCollections.observableArrayList(deliveryMethodsList));
        Manager.currentOrder.setCustomer(Manager.currentCustomer);
        Manager.currentOrder.setProduct(Manager.currentProduct);
    }




}
