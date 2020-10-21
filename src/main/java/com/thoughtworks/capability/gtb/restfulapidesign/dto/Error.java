package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private Integer code;
    private String message;
}
