package com.megashop.app.service;

import com.megashop.app.entities.Customer;
import com.megashop.app.exceptions.ObjectCannotBeCreatedException;
import com.megashop.app.exceptions.ObjectNotFoundException;
import com.megashop.app.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class CustomerService  {

    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found! "+id));
    }

    public Customer createCustomer(Customer customer) {
        try {
            return repository.save(customer);
        } catch (Exception err) {
            throw new ObjectCannotBeCreatedException("");
        }
    }

    public void editAndSaveCustomer(Customer newEntity, Customer entityToChange) {
       var target = repository.findById(entityToChange
               .getId())
               .orElseThrow(() -> new ObjectNotFoundException("Object not found! "+entityToChange.getId()));
       editCustomer(newEntity, entityToChange);
       repository.save(newEntity);
    }

    public void deleteCustomer(Integer id) {
       repository.deleteById(id);
    }

    public void deleteAllCustomers() {
        repository.deleteAll();
    }

    public void editCustomer(Customer newC, Customer oldC) {
        oldC.setName(newC.getName());
        oldC.setEmail(newC.getEmail());
        oldC.setAddresses(newC.getAddresses());
        oldC.setTelephones(newC.getTelephones());
        oldC.setOrderList(newC.getOrderList());
        oldC.setCpfOrCnpj(newC.getCpfOrCnpj());
    }
}
