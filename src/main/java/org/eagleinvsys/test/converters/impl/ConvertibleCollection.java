package org.eagleinvsys.test.converters.impl;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ConvertibleCollection implements org.eagleinvsys.test.converters.ConvertibleCollection {

    private final Collection<String> headers = new ArrayList<String>();
    private final Collection<org.eagleinvsys.test.converters.ConvertibleMessage> records = new ArrayList<org.eagleinvsys.test.converters.ConvertibleMessage>();




    public ConvertibleCollection(List<Map<String,String>> collectionToConvert) {
        try {
            for (Map<String, String> mapFromCollection : collectionToConvert) {
                if (headers.isEmpty()) {
                    headers.addAll(mapFromCollection.keySet());
                }
                records.add(new ConvertibleMessage(mapFromCollection));
            }
        }catch(NullPointerException e){
            System.out.print("There is NULL in collection");
        }
    }

    @Override
    public Collection<String> getHeaders() {
        return headers;
    }

    @Override
    public Iterable<org.eagleinvsys.test.converters.ConvertibleMessage> getRecords() {
        return records;
    }
}
