package com.rod.api.attraction;


import jakarta.persistence.*;
import lombok.*;

@Entity(name="attraction")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Attraction {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @Builder(builderMethodName = "builder")
    public Attraction(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
