package org.example.perevozki.controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.example.perevozki.models.orders;
import org.example.perevozki.util.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class OrdersWindowController implements Initializable {

    @FXML
    public TableColumn<orders, ImageView> photoTC;
    @FXML
    public TableColumn<orders,String> ProductTC;
    @FXML
    public TableColumn<orders, String> CostTC;
    @FXML
    public TableColumn<orders,String> DeliveryMethodTC;
    @FXML
    public TableColumn<orders, String> AddressTC;
    @FXML
    public TableView<orders> TWOrders;

    public Label labelCurrentCount;
    public TextField TFSearch;


    private List<orders> ordersList = Manager.orderServices.findAll();
    final Integer currentCount = ordersList.size();
    private List<String> sort = new ArrayList<>();

    @FXML
    private ComboBox<String> CBSort;


    @FXML
    void MenuItemDeleteAction(ActionEvent event) {
        orders orderSelect = TWOrders.getSelectionModel().getSelectedItem();
        if(orderSelect == null)
            Manager.MessageBox("Удаление","Внимание!","Для того, чтобы удалить заказ, выделите его!", Alert.AlertType.INFORMATION);
        else{
            orders.WarningMessageDelete(orderSelect);
            initData();
        }
    }
  void updateData(List<orders> ordersList){
        TWOrders.getItems().clear();
        ObservableList<orders> trips = FXCollections.observableArrayList(ordersList);
        TWOrders.setItems(trips);
        labelCurrentCount.setText(ordersList.size() + " записей из " + currentCount);
    }

//
    private void initData(){
        if(TFSearch.getText().isEmpty()) {
            ordersList = Manager.orderServices.findAll();
            ordersList = ordersList.stream().filter(order -> order.getCustomer().equals(Manager.currentCustomer)).toList();
        }
        updateData(ordersList);
        labelCurrentCount.setText(ordersList.size() + " записей из " + currentCount);
    }
//
    @FXML
    void TFSearchAction(ActionEvent event) {
        ordersList = ordersList.stream().filter(order -> order.getProduct().getFullName().toLowerCase().contains(TFSearch.getText().toLowerCase())).toList();
        initData();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        photoTC.setCellValueFactory(cellData -> {
            try {
                return new SimpleObjectProperty<>(cellData.getValue().getProduct().getImage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ProductTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct().getFullName()));
        CostTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullCost() + " руб."));
        DeliveryMethodTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDeliveryMethod().getTitle()));
        AddressTC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDeliveryAddress()));
        sort.add("По умолчанию");
        sort.add("По возрастанию");
        sort.add("По убыванию");
        CBSort.setItems(FXCollections.observableArrayList(sort));
    }
//
    public void CBSortAction(ActionEvent actionEvent) {
         if(CBSort.getValue().equals("По возрастанию")){
             ordersList = ordersList.stream().sorted(Comparator.comparing(order -> order.getProduct().getFullName())).toList();
            updateData(ordersList);
        }
        if(CBSort.getValue().equals("По убыванию")){
            ordersList = ordersList.stream().sorted(Comparator.comparing(order -> order.getProduct().getFullName())).toList().reversed();
            updateData(ordersList);
        }
       else
            initData();
    }


    public void MenuItemBackAction(ActionEvent actionEvent) throws IOException {
        Manager.ShowWindow("products-view.fxml","Продукты");
    }
}
