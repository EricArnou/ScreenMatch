package com.gmail.ericarnou68.screenMatch.service;

public interface IDataConverter {
    <T> T extractData(String json, Class<T> classGeneric);
}
