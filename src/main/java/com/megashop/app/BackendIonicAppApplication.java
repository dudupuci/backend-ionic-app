package com.megashop.app;

import com.megashop.app.entities.Category;
import com.megashop.app.repository.CategoryRepository;
import com.megashop.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BackendIonicAppApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BackendIonicAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null, "Calcados", null);
        Category category2 = new Category(null, "Roupas", null);
        Category category3 = new Category(null, "Eletronicos", null);


        repository.saveAll(Arrays.asList(category,category2, category3));





    }
}
