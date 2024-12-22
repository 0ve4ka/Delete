package org.example.perevozki.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import org.example.perevozki.JewerlyShop;
import org.example.perevozki.models.products;

import java.io.IOException;

public class ProductCell extends ListCell<products> {
    private final Parent root;
    private ListProductCellController controller;

    public ProductCell() throws IOException {
        FXMLLoader loader = new FXMLLoader(JewerlyShop.class.getResource("product-cell-view.fxml"));
        root = loader.load();
        controller = loader.getController();
    }

    @Override
    protected void updateItem(products product, boolean b) {
        super.updateItem(product, b);
        if(b || product == null)
            setGraphic(null);
        else{
            try {
                controller.setCell(product);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            setGraphic(root);
        }
    }
}
