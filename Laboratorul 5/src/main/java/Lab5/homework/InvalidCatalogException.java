package Lab5.homework;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file. Please change the destination/create the file.", ex);
    }
}