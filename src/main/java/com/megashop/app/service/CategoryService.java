package com.megashop.app.service;

import com.megashop.app.entities.Category;
import com.megashop.app.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public List<Category> findAll() {
       return repository.findAll();
    }

    public Category findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error trying to find ID: " + id));

    }

    public Category insertCategory(Category category) {
        try {
            return repository.save(category);
        } catch (Exception err) {
            throw new RuntimeException("Error: "+ err.getMessage());
        }
    }

    public Category updateCategory(Category newC, Category oldC) {
        oldC.setName(newC.getName());
        oldC.setProductsList(newC.getProductsList());
        return newC;
    }

    public Category updateAndSaveCategory(Integer id, Category newC) {
        try {
            Category oldC = repository.findById(id).get();
            updateCategory(newC, oldC);
            return repository.save(newC);
        } catch (Exception err) {
            throw new RuntimeException("Error: "+ err.getMessage());
        }
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void deleteAll(List<Category> list) {
        repository.deleteAll(list);
    }



}
