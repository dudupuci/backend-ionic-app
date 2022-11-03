package com.megashop.app.service;

import com.megashop.app.entities.Address;
import com.megashop.app.exceptions.DefaultError;
import com.megashop.app.exceptions.ObjectNotFoundException;
import com.megashop.app.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Address create(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Error trying to find object: " + id));
    }

    public void deleteById(Integer id) {
        try {
            addressRepository.deleteById(id);
        } catch (Exception err) {
            throw new ObjectNotFoundException("Error trying to delete object: " + err.getMessage());
        }
    }

    public void deleteAll() {
        addressRepository.deleteAll();
    }

    public void editAndSaveAddress(Address newAddress, Address oldAddress) {
        var target = addressRepository.findById(oldAddress.getId())
                .orElseThrow(() -> new RuntimeException("Error captured! "));
        editAddress(newAddress, oldAddress);
        addressRepository.save(newAddress);
    }

    public void editAddress(Address newAddress, Address oldAddress) {
        oldAddress.setCity(newAddress.getCity());
        oldAddress.setCep(newAddress.getCep());
        oldAddress.setComplement(newAddress.getComplement());
        oldAddress.setDistrict(newAddress.getDistrict());
        oldAddress.setNumber(newAddress.getNumber());
        oldAddress.setStreetName(newAddress.getStreetName());
        oldAddress.setCustomer(newAddress.getCustomer());
    }

}
