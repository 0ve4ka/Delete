package org.example.perevozki.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "metals",schema = "public")
public class metals {

    @Id
    @Column(name = "metal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long metalId;

    @Column(name = "title")
    private String title;

    @Column(name = "sample")
    private String sample;

    public Long getMetalId() {
        return metalId;
    }

    public String getTitle() {
        return title;
    }

    public String getSample() {
        return sample;
    }

    public void setMetalId(Long metalId) {
        this.metalId = metalId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(title,((metals) obj).title) &&
                Objects.equals(sample,((metals) obj).sample);

    }

    @Override
    public int hashCode() {
        return 17 * title.hashCode() + 31 * sample.hashCode();
    }
}
