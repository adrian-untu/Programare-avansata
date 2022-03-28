package Lab5.homework;

import java.util.List;

public class Book extends Item {
    private List<String> listAuthors;
    private int year;
    public Book(){}//default constructor required
    public Book(String id, String title, String location) throws NameException, Lab5.compulsory.NameException {
        super(id, title, location);
    }

    public List<String> getListAuthors() {
        return listAuthors;
    }

    public void setListAuthors(List<String> listAuthors) {
        this.listAuthors = listAuthors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}