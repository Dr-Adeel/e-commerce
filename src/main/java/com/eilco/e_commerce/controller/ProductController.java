package com.eilco.e_commerce.controller;

import com.eilco.e_commerce.dto.ProductRequest;
import com.eilco.e_commerce.dto.ProductResponse;
import com.eilco.e_commerce.model.entities.Product;
import com.eilco.e_commerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest) {
        return ProductResponse.builder().product(productService.save(productRequest)).build();
    }

    //correction ("/{id}")
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id){
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> List() {
        return productService.findAll();
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@RequestBody ProductRequest productRequest, @PathVariable("id") Long id){
        return ProductResponse.builder().product(productService.update(productRequest, id)).build();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteById(id);
    }
}
