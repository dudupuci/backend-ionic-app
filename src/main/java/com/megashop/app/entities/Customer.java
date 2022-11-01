package com.megashop.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megashop.app.enums.CustomerType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tb_costumer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    public Customer(Integer id, String name, String email, String cpfOrCnpj, CustomerType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.type = type.getDescription().toUpperCase();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Integer id;
    @Setter
    @Column(name = "name")
    private String name;
    @Setter
    @Column(name = "email")
    private String email;
    @Setter
    @Column(name = "cpf_or_cnpj")
    private String cpfOrCnpj;
    @Column(name = "customer_type")
    private String type;
    @Setter
    @OneToMany(mappedBy = "customer")

    private List<Address> addresses = new ArrayList<>();

    @Setter
    @ElementCollection
    @CollectionTable(name = "telephones")
    private Set<String> telephones = new HashSet<>();

    @Setter
    @Transient
    private List<Order> orderList = new ArrayList<>();

    private void setCustomerType(CustomerType type) {
        this.type = type.getDescription().toUpperCase();
    }

    private CustomerType getCustomerType() {
        return CustomerType.toType(type.toUpperCase());
    }

}
