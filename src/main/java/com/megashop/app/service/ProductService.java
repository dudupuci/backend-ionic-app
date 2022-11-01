package com.megashop.app.service;

import com.megashop.app.entities.Product;
import com.megashop.app.entities.Product;
import com.megashop.app.repository.ProductRepository;
import com.megashop.app.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findAll(List<Product> list) {
        list = repository.findAll();
        return list;
    }

    public Product findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error trying to find ID: " + id));

    }

    public Product insertProduct(Product Product) {
        try {
            return repository.save(Product);
        } catch (Exception err) {
            throw new RuntimeException("Error: "+ err.getMessage());
        }
    }

    public Product updateProduct(Product newP, Product oldP) {
        oldP.setName(newP.getName());
        oldP.setCategories(newP.getCategories());
        oldP.setPrice(newP.getPrice());
        return newP;
    }

    public Product updateAndSaveProduct(Integer id, Product newP) {
        try {
            Product oldC = repository.findById(id).get();
            updateProduct(newP, oldC);
            return repository.save(newP);
        } catch (Exception err) {
            throw new RuntimeException("Error: "+ err.getMessage());
        }
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void deleteAll(List<Product> list) {
        repository.deleteAll(list);
    }



}
