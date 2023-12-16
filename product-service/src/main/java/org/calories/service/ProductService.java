package org.calories.service;

import org.calories.entity.Product;
import org.calories.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product product) {
        Product prod = productRepository.findById(productId);

        if (prod != null) {
            return productRepository.update(prod);
        } else {

            return null;
        }
    }

    public void deleteById(Long id) {
        productRepository.delete(id);
    }
}