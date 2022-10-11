package com.megashop.app.resources;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin("*")
public class CategoryResources {


    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "API Running!";
    }

}
