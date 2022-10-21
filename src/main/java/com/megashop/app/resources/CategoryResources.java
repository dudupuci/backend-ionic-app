package com.megashop.app.resources;


import com.megashop.app.entities.Category;
import com.megashop.app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category")
@CrossOrigin("*")
public class CategoryResources {

    @Autowired
    private CategoryService service;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> findAll() {
       List<Category> list = service.findAll();
       return ResponseEntity.ok().body(list);

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }

}
