package com.megashop.app;

import com.megashop.app.entities.*;
import com.megashop.app.enums.CustomerType;
import com.megashop.app.repository.*;
import com.megashop.app.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BackendIonicAppApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendIonicAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null, "Calcados", null);
        Category category2 = new Category(null, "Roupas", null);
        Category category3 = new Category(null, "Eletronicos", null);

        Product product = new Product(null, "Camiseta", 150.00);
        Product product2 = new Product(null, "Tenis Vans", 350.00);
        Product product3 = new Product(null, "Iphone 14", 8350.00);
        List<Product> products = new ArrayList<>();
        products.addAll(Arrays.asList(product, product2, product3));

        category.setProductsList(products);
        category2.setProductsList(Arrays.asList(product2));

        repository.saveAllAndFlush(Arrays.asList(category, category2, category3));

        product.getCategories().add(category);
        product2.getCategories().addAll(Arrays.asList(category, category2));
        product3.getCategories().add(category);

        productRepository.saveAllAndFlush(Arrays.asList(product, product2, product3));

        State state = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");

        stateRepository.saveAll(Arrays.asList(state, state2));

        City city = new City(null, "Uberlândia", state);
        City city2 = new City(null, "São Paulo", state2);

        cityRepository.saveAll(Arrays.asList(city, city2));

        Customer customer = new Customer(null, "Maria", "maria@gmail.com", "14799944219", CustomerType.FISIC_PERSON);
        customer.getTelephones().addAll(Arrays.asList("(38)999887766", "(38)99776644"));
        Customer customer2 = new Customer(null, "Pedro", "pedro@gmail.com", "87488844991", CustomerType.FISIC_PERSON);
        customer2.getTelephones().addAll(Arrays.asList("(44)99667711", "(44)981123091"));
        Customer customer3 = new Customer(null, "João", "joao@gmail.com", "34577744287", CustomerType.FISIC_PERSON);
        customer3.getTelephones().addAll(Arrays.asList("(41)99112266", "(41)99775500"));

        customerRepository.saveAllAndFlush(Arrays.asList(customer, customer2, customer3));


        Address address = new Address(null, "Rua das Flores", "940", "Sobrado", "Jardim Iguacu", "87000-420", city, customer);
        Address address2 = new Address(null, "Rua da Alegria", "1209", "Casa", "Jardim Santa Helena", "85900-560", city2, customer2);
        Address address3 = new Address(null, "Rua da Paz", "512", "Prox. Igreja de Esquina", "Distrito Azul", "87050-450", city, customer3);

        addressRepository.saveAll(Arrays.asList(address, address2, address3));


    }
}
