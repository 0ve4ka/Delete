package org.example.perevozki.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "gemstones",schema = "public")
public class gemstones {

    public gemstones(){}

    public gemstones(String title, Long id ){
        this.title = title;
        gemstoneId = id;
    }


    @Id
    @Column(name = "gemstone_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gemstoneId;

    @Column(name = "title")
    private String title;

    @Column(name = "type_of_stone")
    private String typeOfStone;

    @Column(name = "color")
    private String color;

    @Column(name = "shape_of_the_cut")
    private String shapeOfTheCut;

    @Column(name = "size")
    private String size;

    public String getSize() {
        return size;
    }

    public String getShapeOfTheCut() {
        return shapeOfTheCut;
    }

    public String getColor() {
        return color;
    }

    public String getTypeOfStone() {
        return typeOfStone;
    }

    public String getTitle() {
        return title;
    }

    public Long getGemstoneId() {
        return gemstoneId;
    }

    @Override
    public String toString() {
        return title;
    }

    public void setGemstoneId(Long gemstoneId) {
        this.gemstoneId = gemstoneId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTypeOfStone(String typeOfStone) {
        this.typeOfStone = typeOfStone;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setShapeOfTheCut(String shapeOfTheCut) {
        this.shapeOfTheCut = shapeOfTheCut;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(title,((gemstones) obj).title) &&
                Objects.equals(typeOfStone,((gemstones) obj).typeOfStone) &&
                Objects.equals(color,((gemstones) obj).color) &&
                Objects.equals(shapeOfTheCut,((gemstones) obj).shapeOfTheCut) &&
                Objects.equals(size,((gemstones) obj).size);
    }

    @Override
    public int hashCode() {
        return 17 * title.hashCode() + 17 * typeOfStone.hashCode() + 31 * color.hashCode() + 31 * shapeOfTheCut.hashCode() + 17 * size.hashCode();
    }


}
