package Lab5.homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ListCommand {
    public ListCommand(){}
    public static void list(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.readValue(new File(path), Catalog.class));
    }
}
