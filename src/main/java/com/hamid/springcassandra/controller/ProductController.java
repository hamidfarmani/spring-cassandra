package com.hamid.springcassandra.controller;


import com.hamid.springcassandra.model.Product;
import com.hamid.springcassandra.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        product = productService.createProduct(product);
        return product;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer productId){
        Product product = productService.getById(productId);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAll();
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
                                                 @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
