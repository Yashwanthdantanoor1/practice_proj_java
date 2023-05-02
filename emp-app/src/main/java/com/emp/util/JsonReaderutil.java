package com.emp.util;

import com.emp.domain.Currency;
import com.emp.domain.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonReaderutil {
    private JsonReaderutil(){

    }
    public static List<Employee> loademployees(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Employee>> type = new TypeReference<List<Employee>>() {};
        try {
            return objectMapper.readValue(JsonReaderutil.class.getResourceAsStream("/emp-data.json"),type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   public static Map<String, Currency> loadcurrency(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Map<String,Currency>> type = new TypeReference<>() {};
        try {
            return objectMapper.readValue(JsonReaderutil.class.getResourceAsStream("/common-currency.json"),type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
