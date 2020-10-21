package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentException extends RuntimeException {
    private String message;
}
