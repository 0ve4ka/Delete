package org.example.perevozki.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.perevozki.models.customers;
import org.example.perevozki.util.Manager;

import java.io.IOException;
import java.util.List;

public class LoginViewController {

    private List<customers> customersList = Manager.customerServices.findAll();

    @FXML
    private TextField TFLogin;

    @FXML
    private TextField TFPassword;

    @FXML
    void BtnCancelAction(ActionEvent event) {
        Manager.currentStage.close();
    }

    @FXML
    void BtnOkAction(ActionEvent event) throws IOException {
        for(customers customer: customersList)
            if (TFLogin.getText().equals(customer.getEmail()) && TFPassword.getText().equals(customer.getPassword())){
                Manager.currentCustomer = customer;
                Manager.ShowWindow("products-view.fxml","Продукты");
                break;
            }
            else
               Manager.ErrorosMessageBox("Логин или пароль введён не верно!");
        }
    }


