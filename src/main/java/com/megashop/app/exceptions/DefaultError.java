package com.megashop.app.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DefaultError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer httpStatus;
    private String msg;
    private Long timeStamp;


}
