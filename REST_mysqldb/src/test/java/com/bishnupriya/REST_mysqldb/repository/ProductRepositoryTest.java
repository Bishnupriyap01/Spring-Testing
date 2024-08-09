package com.bishnupriya.REST_mysqldb.repository;

import com.bishnupriya.REST_mysqldb.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void isProductExistsById() {
        Product product = new Product(900, "fan", 45.8);
         productRepository.save(product);
         Boolean actual = productRepository.isProductExistsById(900);
         assertThat(actual).isTrue();


    }
    @AfterEach

    public void tearDown() {
        System.out.println("tearing down");
        productRepository.deleteById(900);
    }
    @BeforeEach

    public void setUP() {
        System.out.println("Setting up");

    }
}