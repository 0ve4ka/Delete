package org.example.perevozki.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.perevozki.models.products;

import java.io.IOException;

public class ListProductCellController {
    @FXML
    public ImageView ImageViewProduct;
    @FXML
    public Label LableFullName;
    @FXML
    public Label LableDescription;
    @FXML
    public Label LableWorker;
    @FXML
    public Label LableGemstone;
    @FXML
    public Label LablePrice;


    public void setCell(products product) throws IOException {
        ImageViewProduct.setImage(product.getPhoto());
        LableFullName.setText(product.getFullName());
        LableDescription.setText(product.getDescription());
        LableWorker.setText("Мастер: " + product.getWorker().getInitial());
        if(product.getGemstone() == null) {
            LableGemstone.setText("");
        }
        else
            LableGemstone.setText("Камень: "+product.getGemstone().getTitle());
        LablePrice.setText("Стоимость: "+ product.getCost().toString() + " руб.");
    }
}
