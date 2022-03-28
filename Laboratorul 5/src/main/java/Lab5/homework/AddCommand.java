package Lab5.homework;

import java.util.ArrayList;
import java.util.*;

public class AddCommand<Catalog> implements Serializable{
    private List<Item> items = new ArrayList<>();
    public AddCommand(){}
    public void add(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Item findById(String id) {
        return items.stream().filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
}
