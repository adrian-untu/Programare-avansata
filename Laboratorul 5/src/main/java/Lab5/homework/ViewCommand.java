package Lab5.homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ViewCommand {
     public ViewCommand(){}

    public static void Open(String path) throws InvalidCatalogException, IOException{
        Desktop desktop = Desktop.getDesktop();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(new File(path), ServiceCatalog.class);
         desktop.open(new File(path));
    }
}
