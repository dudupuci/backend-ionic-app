package com.megashop.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@ToString
@Table(name = "tb_state")
public class State implements Serializable {
    private static final long serialVersionUID = 1L;

    public State(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "state_name")
    private String name;

    @OneToMany(mappedBy = "state")
    @JsonIgnore
    private List<City> cities = new ArrayList<>();
}
