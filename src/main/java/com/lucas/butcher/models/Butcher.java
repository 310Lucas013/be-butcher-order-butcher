package com.lucas.butcher.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Butcher")
public class Butcher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "butcher", targetEntity = Schedule.class)
    private List<Schedule> scheduleList;
    @ManyToMany
    @JoinTable(
            name = "butcher_product",
            joinColumns = @JoinColumn(name = "Butcher_id"),
            inverseJoinColumns = @JoinColumn(name = "Product_id")
    )
    private List<Product> products;

    public Butcher() {

    }
}