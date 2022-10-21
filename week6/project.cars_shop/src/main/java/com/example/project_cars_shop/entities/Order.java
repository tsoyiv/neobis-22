package com.example.project_cars_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarsEntity car;

    @Column(name = "sum", nullable = false)
    private Double sum;

    @Column(name = "km", nullable = false)
    private Double km;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
