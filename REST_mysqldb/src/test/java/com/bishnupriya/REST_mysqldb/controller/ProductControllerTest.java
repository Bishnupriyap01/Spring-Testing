package com.bishnupriya.REST_mysqldb.controller;

import com.bishnupriya.REST_mysqldb.entity.Product;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Integration testing


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {
    @LocalServerPort
    private int port;
    private String baseUrl = "http://localhost";

    @Autowired
    private  TestRestTemplate restTemplate;
    @Autowired
    private Testh2repo testh2repo;


    @BeforeEach
    public void setUp() {

        baseUrl = baseUrl.concat(":").concat(port + "");

    }

    @Test
    public void AddProduct() {
        baseUrl = baseUrl+"/addproduct";
        Product product = new Product(300, "fan2", 7.0);
        Product response = restTemplate.postForObject(baseUrl , product, Product.class);
        assertEquals("fan2", response.getName());
        assertEquals(1, testh2repo.findAll().size());
    }
    @Test
    @Sql(statements = "INSERT INTO PRODUCT (id,name, price) VALUES (873,'AC', 340.0)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT WHERE name='AC'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetProducts() {

        List<Product> products = restTemplate.getForObject("/products", List.class);
        assertEquals(3, products.size());
        assertEquals(3, testh2repo.findAll().size());
    }


    @Test
    @Sql(statements = "INSERT INTO PRODUCT (id,name, price) VALUES (345,'shoes',  999.8)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT WHERE id=1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdateProduct(){
        Product product = new Product(345, "shoe", 999.8);
        restTemplate.put(baseUrl+"/update/{id}", product, 2);
        Product productFromDB = testh2repo.findById(345).get();
        assertAll(
                () -> assertNotNull(productFromDB),
                () -> assertEquals(999.8, productFromDB.getPrice())
        );



    }

}