package com.megashop.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CustomerType {

    FISIC_PERSON(1, "Fisic Person"),
    JURIDIC_PERSON(2, "Juridic Person");

    private Integer code;
    private String description;
}
