package org.eagleinvsys.test.converters.impl;

import java.util.Map;

public class ConvertibleMessage implements org.eagleinvsys.test.converters.ConvertibleMessage {
    Map<String,String> elements;

    public ConvertibleMessage(Map<String, String> str) {
        elements = str;
    }

    @Override
    public String getElement(String elementId) {
        return elements.get(elementId);
    }
}
