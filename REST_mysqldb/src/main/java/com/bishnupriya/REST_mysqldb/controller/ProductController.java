package com.bishnupriya.REST_mysqldb.controller;

import com.bishnupriya.REST_mysqldb.entity.Product;
import com.bishnupriya.REST_mysqldb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProduct( @PathVariable int id){
        return productService.getProductById(id);

    }
    @GetMapping("/products/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);

    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> checkProductExists(@PathVariable Integer id) {
        Boolean exists = productService.isProductExistsById(id);
        return ResponseEntity.ok(exists);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id,  @RequestBody Product product ){
        return productService.updateProduct( id, product);
    }
    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteById(id);

    }
}
