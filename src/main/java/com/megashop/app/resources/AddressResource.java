package com.megashop.app.resources;


import com.megashop.app.entities.Address;
import com.megashop.app.entities.Category;
import com.megashop.app.service.AddressService;
import com.megashop.app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/address")
@CrossOrigin("*")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {
        List<Address> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    public ResponseEntity<Address> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
