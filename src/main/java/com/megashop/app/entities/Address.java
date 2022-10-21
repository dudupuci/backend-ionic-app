package com.megashop.app.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "local_number")
    private String number;
    @Column(name = "complement")
    private String complement;
    @Column(name = "district")
    private String district;
    @Column(name = "cep")
    private String cep;

    @OneToOne
    private Customer customer;
}
