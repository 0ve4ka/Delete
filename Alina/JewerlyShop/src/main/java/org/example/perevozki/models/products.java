package org.example.perevozki.models;


import jakarta.persistence.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.perevozki.JewerlyShop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;

@Entity
@Table(name = "products",schema = "public")
public class products {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "type_product")
    private String typeProduct;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gemstone_id", nullable = false)
    private gemstones gemstone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "worker_id", nullable = false)
    private workers worker;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "metal_id", nullable = false)
    private metals metal;

    @Column(name = "quantity_of_products")
    private Integer quantityOfProducts;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "photo")
    private  byte[] photo;

    public String getFullName(){
        return typeProduct + ": " + title;
    }

    public Long getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public String getDescription() {
        return description;
    }

    public gemstones getGemstone() {
        return gemstone;
    }

    public workers getWorker() {
        return worker;
    }

    public metals getMetal() {
        return metal;
    }

    public Integer getQuantityOfProducts() {
        return quantityOfProducts;
    }

    public Integer getCost() {
        return cost;
    }

    public Image getPhoto() throws IOException {
        if (photo == null)
            return new Image(JewerlyShop.class.getResourceAsStream("picture.png"));
        BufferedImage capture = ImageIO.read(new ByteArrayInputStream(photo));
        return SwingFXUtils.toFXImage(capture, null);
    }

    public ImageView getImage() throws IOException {
        ImageView image = new ImageView();
        image.setImage(getPhoto());
        image.setFitHeight(60);
        image.setPreserveRatio(true);
        return image;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGemstone(gemstones gemstone) {
        this.gemstone = gemstone;
    }

    public void setWorker(workers worker) {
        this.worker = worker;
    }

    public void setMetal(metals metal) {
        this.metal = metal;
    }

    public void setQuantityOfProducts(Integer quantityOfProducts) {
        this.quantityOfProducts = quantityOfProducts;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setPhoto(Image photo) throws IOException {
        BufferedImage buf = SwingFXUtils.fromFXImage(photo, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(buf, "jpg", baos);
        byte[] bytes = baos.toByteArray();
        this.photo = bytes;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(title,((products) obj).title) &&
                Objects.equals(typeProduct,((products) obj).typeProduct) &&
                Objects.equals(metal,((products) obj).metal) &&
                Objects.equals(gemstone,((products) obj).gemstone) &&
                Objects.equals(cost,((products) obj).cost) ;
    }

    @Override
    public int hashCode() {
        return 17 * title.hashCode() + 17 * typeProduct.hashCode() + 17* metal.hashCode() +  31 * gemstone.hashCode() + 31 * cost.hashCode();
    }
}
