package com.api.utils;

import java.util.Map;

public interface Client <T> {

    public T get(String endpoint);
    public T get(String endpoint, Map<String, String> params);
}
