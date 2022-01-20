package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.io.*;

    public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */

    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) {
        // TODO: implement
        try(OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
            int collectionSize = collectionToConvert.getHeaders().size();
            for (String headerFromCollection : collectionToConvert.getHeaders()) {
                if(--collectionSize != 0) {
                    writer.write(headerFromCollection + ",");
                }
                else{
                    writer.write(headerFromCollection);
                }
            }
            writer.write("\n");

            for (ConvertibleMessage message : collectionToConvert.getRecords()) {
                collectionSize = collectionToConvert.getHeaders().size();
                for (String record : collectionToConvert.getHeaders()) {
                    if(--collectionSize != 0) {
                    writer.write(message.getElement(record) + ",");
                }else{
                        writer.write(message.getElement(record));
                    }
            }
                writer.write("\n");
        }
        }catch (IOException e) {

            e.printStackTrace();
        }
    }
}
