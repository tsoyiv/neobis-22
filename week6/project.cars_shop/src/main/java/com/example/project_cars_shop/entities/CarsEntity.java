package com.example.project_cars_shop.entities;
import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
            (name = "manufacturer", nullable = false)
    private String manufacturer;

    //todo
    public CarsEntity() {
    }

    public CarsEntity(Long id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
