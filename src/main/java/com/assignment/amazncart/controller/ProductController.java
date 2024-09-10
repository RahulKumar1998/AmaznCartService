package com.assignment.amazncart.controller;

import com.assignment.amazncart.dto.ProductDTO;
import com.assignment.amazncart.entity.Products;
import com.assignment.amazncart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Create API
    @PostMapping()
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    //Update API
    @PostMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable("id") int id, @RequestBody Products product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    //Delete API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Get API
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam String promotion) {
        return new ResponseEntity<>(productService.getProducts(promotion), HttpStatus.OK);
    }


}
