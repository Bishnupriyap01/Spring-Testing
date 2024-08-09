package com.bishnupriya.REST_mysqldb.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.Name;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Product")

public class Product {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
}
