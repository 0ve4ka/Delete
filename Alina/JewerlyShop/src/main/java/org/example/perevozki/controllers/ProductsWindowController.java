package org.example.perevozki.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.perevozki.models.gemstones;
import org.example.perevozki.models.products;
import org.example.perevozki.util.Manager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class ProductsWindowController implements Initializable {

    @FXML
    public ComboBox<gemstones> CBFilter;
    @FXML
    public TextField TFSearch;
    @FXML
    public ComboBox<String> CBSort;
    @FXML
    public Label labelCurrentCount;
    @FXML
    private ListView<products> ListViewProducts;

    private List<products> productsList = Manager.productServices.findAll();
    private final Integer currentCount = productsList.size();
    private List<gemstones> gemstonesList = Manager.gemstoneServices.findAll();
    private List<products> FilterList;
    private List<String> sort = new ArrayList<>();
    @FXML
    void MenuItemOrders(ActionEvent event) throws IOException {
        Manager.ShowWindow("orders-view.fxml","Заказы");
    }


    @FXML
    void TFSearchAction(ActionEvent event) {
        if(CBFilter.getValue() == null || CBFilter.getValue().getGemstoneId() == 0){
            productsList = Manager.productServices.findAll();
            productsList = productsList.stream().filter(products -> products.getFullName().toLowerCase().contains(TFSearch.getText().toLowerCase())).toList();
        }
        else
            productsList = FilterList.stream().filter(products -> products.getFullName().toLowerCase().contains(TFSearch.getText().toLowerCase())).toList();
        initData();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       initData();
       gemstonesList.add(0,new gemstones("Все",0L));
       CBFilter.setItems(FXCollections.observableArrayList(gemstonesList));
       sort.add("По умолчанию");
       sort.add("По возрастанию");
       sort.add("По убыванию");
       CBSort.setItems(FXCollections.observableArrayList(sort));
    }

    void updateData(List<products> productList){
        ListViewProducts.getItems().clear();
        for(products product: productList)
            ListViewProducts.getItems().add(product);
        ListViewProducts.setCellFactory(cell -> {
            try {
                return new ProductCell();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        labelCurrentCount.setText(productsList.size() + " записей из " + currentCount);
    }

    private void initData(){
        if(TFSearch.getText().isEmpty())
            if(CBFilter.getValue() == null || CBFilter.getValue().getGemstoneId() == 0)
                productsList = Manager.productServices.findAll();
        updateData(productsList);
        labelCurrentCount.setText(productsList.size() + " записей из " + currentCount);
    }
    @FXML
    public void CBSortAction(ActionEvent actionEvent) {
        if(CBSort.getValue().equals("По возрастанию")){
            productsList = productsList.stream().sorted(Comparator.comparing(products::getFullName)).toList();
            updateData(productsList);
        }
        if(CBSort.getValue().equals("По убыванию")){
            productsList = productsList.stream().sorted(Comparator.comparing(products::getFullName)).toList().reversed();
            updateData(productsList);
        }
       else
            initData();
    }
    @FXML
    public void CBFilterAction(ActionEvent actionEvent) {
        if(CBFilter.getValue().getGemstoneId() == 0){
            initData();
            FilterList = new ArrayList<>();
        }
        else {
            productsList = Manager.productServices.findAll();
            productsList = productsList.stream().filter(gemstone -> CBFilter.getValue().equals(gemstone.getGemstone())).toList();
            FilterList = productsList;
            updateData(productsList);
        }
    }

    public void BtnCreateOrderAction(ActionEvent actionEvent) throws IOException {
        if(ListViewProducts.getSelectionModel().getSelectedItem() == null)
            Manager.MessageBox("Заказ","Внимание!","Для того, чтобы заказать продукт, выделите его!", Alert.AlertType.INFORMATION);
        else {
            Manager.currentProduct = ListViewProducts.getSelectionModel().getSelectedItem();
            Manager.ShowEditWindow("create-order-view.fxml","Заказать");
        }
    }
}
