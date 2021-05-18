package com.lucas.butcher.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "id")
    private long id;
    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Butcher> butchers;

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }
}
