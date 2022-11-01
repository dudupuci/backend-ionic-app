package com.megashop.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CustomerType {

    FISIC_PERSON(1, "Fisic_Person"),
    JURIDIC_PERSON(2, "Juridic_Person");

    private Integer code;
    private String description;

    public static CustomerType toEnum(Integer code) {
        if (code == null) {
            return null;
        }
        for (CustomerType x : CustomerType.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Error captured: "+ code);
    }

    public static CustomerType toType(String description) {
        if (description == null) {
            return null;
        }
        for (CustomerType x : CustomerType.values()) {
            if (description.equals(x.getDescription())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Error captured: "+description);
    }
}
