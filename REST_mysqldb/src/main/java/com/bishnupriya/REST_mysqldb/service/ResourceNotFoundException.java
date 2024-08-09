package com.bishnupriya.REST_mysqldb.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResourceNotFoundException extends  RuntimeException {
    public ResourceNotFoundException(String message) {

       super(message);
       System.out.println(message);

    }

}
