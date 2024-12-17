package com.eilco.e_commerce.service;

import lombok.AllArgsConstructor;
import com.eilco.e_commerce.dto.ProductRequest;
import com.eilco.e_commerce.model.entities.Product;
import com.eilco.e_commerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public Product save(ProductRequest productRequest) {
        return repository.save(convertProductRequestToProduct(productRequest, null));
    }

    public Product update(ProductRequest productRequest, Long id) {
        return repository.save(convertProductRequestToProduct(productRequest, id));
    }

    public void deleteById(Long id) { repository.deleteById(id);}

    public Optional<Product> findById(Long id) { return repository.findById(id);}

    public List<Product> findAll() {return (List<Product>) repository.findAll();}

    private Product convertProductRequestToProduct(ProductRequest productRequest, Long id) {
        return Product.builder()
                .id(id)
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .description(productRequest.getDescription())
                .active(productRequest.isActive())
                .imageUrl(productRequest.getImageUrl())
                .build();
    }



}
