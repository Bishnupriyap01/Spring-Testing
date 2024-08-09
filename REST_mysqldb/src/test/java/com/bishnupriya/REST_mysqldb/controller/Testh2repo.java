package com.bishnupriya.REST_mysqldb.controller;

import com.bishnupriya.REST_mysqldb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Testh2repo extends JpaRepository<Product,Integer> {
}
