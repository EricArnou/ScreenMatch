package com.gmail.ericarnou68.screenMatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter{
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T extractData(String json, Class<T> classGeneric) {
        try {
            return mapper.readValue(json, classGeneric);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
