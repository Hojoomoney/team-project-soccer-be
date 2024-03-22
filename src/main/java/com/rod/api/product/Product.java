package com.rod.api.product;

import jakarta.persistence.*;
import lombok.*;

@Entity(name="products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer pno;
    private String name;
    private String company;
    private Integer price;

    @Builder(builderMethodName = "builder")
    public Product(int id, int pno, String name, String company, int price) {
        this.id = id;
        this.pno = pno;
        this.name = name;
        this.company = company;
        this.price = price;
    }
}
