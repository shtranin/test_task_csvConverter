package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.ConvertibleCollection;
import org.eagleinvsys.test.converters.impl.CsvConverter;
import org.eagleinvsys.test.converters.impl.StandardCsvConverter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardCsvConverterTests {

    // TODO: implement JUnit 5 tests for StandardCsvConverter
    private List<Map<String,String>> getListOfMaps(){
        Map<String,String> map1 = new HashMap<String,String>();
        Map<String,String> map2 = new HashMap<String,String>();
        map1.put("First_name","Daniil");
        map1.put("Last_name","Shtranin");
        map1.put("CountryOfBirth","Russia");
        map2.put("First_name","Monica");
        map2.put("Last_name","Belucci");
        map2.put("CountryOfBirth","Italy");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(map1);
        list.add(map2);
        return list;
    }
    private List<Map<String,String>> getListWithNulls(){

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        list.add(null);
        list.add(null);
        return list;
    }

    @Test
    public void testStandardConverter() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream stream = new PrintStream(baos);
        StandardCsvConverter converter = new StandardCsvConverter(new CsvConverter());
        converter.convert(getListOfMaps(), stream);
        assertEquals("First_name,Last_name,CountryOfBirth\nDaniil,Shtranin,Russia\nMonica,Belucci,Italy\n",baos.toString());

    }
    @Test
    public void testCollectionWithNulls(){

        PrintStream defaultOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);
        StandardCsvConverter converter = new StandardCsvConverter(new CsvConverter());
        converter.convert(getListWithNulls(), stream);
        System.setOut(defaultOut);
        assertEquals("There is NULL in collection\n",baos.toString());
    }
}