package com.hamid.springcassandra.service;

import com.hamid.springcassandra.exception.ResourceNotFoundException;
import com.hamid.springcassandra.model.Product;
import com.hamid.springcassandra.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getById(Integer productId){
        return productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found" + productId));
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product updateProduct(Integer productId, Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        product.setName(productDetails.getName());
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product not found::: " + productId));
        productRepository.delete(product);
    }
}
