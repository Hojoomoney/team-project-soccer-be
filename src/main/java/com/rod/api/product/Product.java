package com.rod.api.product;

import com.rod.api.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer pno;
    @Column
    private String name;
    @Column
    private String company;
    @Column
    private Integer price;
    @OneToMany(mappedBy = "product")
    private List<Order> orders;

    @Builder(builderMethodName = "builder")
    public Product(int id, int pno, String name, String company, int price) {
        this.id = id;
        this.pno = pno;
        this.name = name;
        this.company = company;
        this.price = price;
    }
}
