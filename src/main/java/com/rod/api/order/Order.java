package com.rod.api.order;

import com.rod.api.product.Product;
import com.rod.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity
public class Order {

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer orderAmount;

    @Column
    private LocalDateTime orderDate;

    @Builder(builderMethodName = "builder")
    public Order(Long id, User user, Product product, Integer orderAmount, LocalDateTime orderDate) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.orderAmount = orderAmount;
        this.orderDate = orderDate;
    }

}
