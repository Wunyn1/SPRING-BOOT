package org.example.week_2.controller;

import org.example.week_2.model.Product;
import org.example.week_2.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Product> getProductByName(@RequestParam(required = false) String name){
        Product p = productService.getProductByName(name);
        if(p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(p);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product p = productService.getProductById(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(p);
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product){
        Product newProduct = productService.createNewProduct(product);
        return ResponseEntity.status(201).body(newProduct);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable long id){
        Product delProduct = productService.deleteProduct(id);
        if(delProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
