package com.bishnupriya.REST_mysqldb.service;

import com.bishnupriya.REST_mysqldb.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    private ProductService productService;
    @BeforeEach
    void setUp(){
        this.productService = new ProductService(this.productRepository);
    }

    @Test
    void getProducts() {
        productService.getProducts();
        verify(productRepository).findAll();
    }
}