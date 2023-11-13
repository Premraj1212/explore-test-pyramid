package com.premraj.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


public class JsonHelper {

    private static ObjectMapper objectMapper = initObjectMapper();

    private static ObjectMapper initObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
    public  static <T> T convertJsonFileToObject(String filePath, Class<T> objectClass){
        try{
            return objectMapper.readValue(new File(filePath),objectClass);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
