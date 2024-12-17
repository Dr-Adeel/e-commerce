package com.eilco.e_commerce.service;

import com.eilco.e_commerce.dto.CategoryRequest;
import com.eilco.e_commerce.model.entities.Category;
import com.eilco.e_commerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository repository;

    public Category save(CategoryRequest categoryRequest) {
        return repository.save(convertCateoryRequestToCategory(categoryRequest, null));
    }

    public Category update(CategoryRequest categoryRequest, Long id) {
        return repository.save(convertCateoryRequestToCategory(categoryRequest, id));
    }

    public void deleteById(Long id) { repository.deleteById(id);}

    public Optional<Category> findById(Long id) { return repository.findById(id);}

    public List<Category> findAll() {return (List<Category>) repository.findAll();}

    private Category convertCateoryRequestToCategory(CategoryRequest categoryRequest, Long id) {
        return Category.builder()
                .id(id)
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .imageUrl(categoryRequest.getImageUrl())
                .build();
    }



}
