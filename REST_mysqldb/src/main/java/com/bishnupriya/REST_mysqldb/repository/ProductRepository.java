package com.bishnupriya.REST_mysqldb.repository;

import com.bishnupriya.REST_mysqldb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findByName(String name);


    @Query("SELECT CASE WHEN COUNT(p) >0 THEN TRUE ELSE FALSE END FROM Product p WHERE p.id = :id")
    Boolean isProductExistsById(Integer id);

}
