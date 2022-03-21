package Lab5.compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, NameException {
        testCreateSave();
        testLoad();
    }

    private static void testCreateSave() throws IOException, NameException {
        Catalog catalog = new Catalog("MyCatalog");
        var book = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps");
        var article = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        catalog.add(book);
        catalog.add(article);
        System.out.println(catalog);
        ServiceCatalog.save(catalog, "d:/research/catalog.json");
    }

    private static void testLoad() throws InvalidCatalogException, IOException {
        ServiceCatalog catalog = ServiceCatalog.load("d:/research/catalog.json");
        System.out.println(catalog);//I have printed the catalog again, so it is seen that the path is working properly
    }

}//the main function is taken from the course and the implementation is done around it
