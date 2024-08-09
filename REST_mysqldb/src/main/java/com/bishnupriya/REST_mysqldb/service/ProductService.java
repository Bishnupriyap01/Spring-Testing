package com.bishnupriya.REST_mysqldb.service;

import com.bishnupriya.REST_mysqldb.entity.Product;
import com.bishnupriya.REST_mysqldb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private  final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteById(int id) {
        if (!productRepository.existsById(id)) {
            return "Product doesn't exist";
        }
        productRepository.deleteById(id);
        return "Product deleted";
    }

    public Product updateProduct(int id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            return null; // Or throw an exception if preferred
        }
        Product existingProduct = optionalProduct.get();
        existingProduct.setName(productDetails.getName());
        existingProduct.setPrice(productDetails.getPrice());
        return productRepository.save(existingProduct);
    }
    public Boolean isProductExistsById(int id){
        return productRepository.isProductExistsById(id);
    }
}
