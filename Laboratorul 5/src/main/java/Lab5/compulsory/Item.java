package Lab5.compulsory;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({@JsonSubTypes.Type(value = Article.class, name = "Article"), @JsonSubTypes.Type(value = Book.class, name = "Book") })
//these are required for the IntelliJ to work, it does not do the required things otherwise, as I have found with multiple internet searches
public abstract class Item implements Serializable {
    private static List<String> nameList;
    protected String id;
    protected String title;
    protected String location; //file name or Web page
    public Item(){}
    public Item(String id, String title, String location) throws NameException {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    static {
        nameList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public void setId(String id) throws NameException {
        if(!nameList.isEmpty() && nameList.contains(id))
            throw new NameException("The id already exists!");
        else {
            this.id = id;
            nameList.add(id);
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
