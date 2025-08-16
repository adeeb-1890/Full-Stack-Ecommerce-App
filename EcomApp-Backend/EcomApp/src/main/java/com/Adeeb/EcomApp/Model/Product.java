package com.Adeeb.EcomApp.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String name;
    private String desc;
    private String Brand;
    private BigDecimal price;
    private String prodCategory;
    private boolean available;
    private Date releaseDate;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageDate;


    public void setImageName(String originalFilename) {
    }

    public void setImageType(String contentType) {
    }

    public void setImageDate(byte[] bytes) {
    }
}
