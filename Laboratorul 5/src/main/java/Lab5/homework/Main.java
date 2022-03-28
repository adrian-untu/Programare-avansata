package Lab5.homework;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, NameException, Lab5.compulsory.NameException {
        testCreateSave();
        testLoadListView();
    }

    private static void testCreateSave() throws IOException, NameException, Lab5.compulsory.NameException {
        Catalog catalog = new Catalog("MyCatalog");
        var book = new Book("java17", "The Art of Computer Programming", "d:/books/programming/tacp.ps");
        var article = new Article("knuth23", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        catalog.add(book);
        catalog.add(article);
        System.out.println(catalog);
        ServiceCatalog.save(catalog, "d:/research/catalog.json");
    }

    private static void testLoadListView() throws InvalidCatalogException, IOException {
      /*Catalog catalog = LoadCommand.load("d:/research/catalog.json");
      System.out.println(catalog);*/
      //ListCommand.list("d:/research/catalog.json");//I have printed the catalog again, so it is seen that the path is working properly
        //ViewCommand.Open("d:/research/catalog.json");
    }//at this time, the commands only work one at a time, the exception returns mixed signals

}//the main function is taken from the course and the implementation is done around it