package com.rod.api.product;

import com.rod.api.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "products")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String pname;
    @Column
    private Integer price;
    @Column
    private Integer stock;
    @Column
    private String description;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;
    @Builder(builderMethodName = "builder")
    public Product(Long id, List<Order> orders, String pname, Integer price, Integer stock, String description) {
        this.id = id;
        this.orders = orders;
        this.pname = pname;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }
}
