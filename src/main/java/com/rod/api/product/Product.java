package com.rod.api.product;

import com.rod.api.order.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = {"id"})

public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pno;
    private String name;
    private String company;
    private Integer price;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;

}
