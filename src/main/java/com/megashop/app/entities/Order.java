package com.megashop.app.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_order")
    private Date instant;
    // ?
    @OneToOne
    @JoinColumn(name = "costumer_id")
    private Customer costumer;
    private List<Product> list = new ArrayList<>();
}
