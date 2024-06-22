package designpatterns;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Structural design pattern
 * Compose objects into Tree like Structure
 * Clients interacts with interface or abstract object to deal with single or
 * composite objects
 */

abstract class MenuComponent {
    String name;

    public MenuComponent() {

    }

    public MenuComponent(String name) {
        this.name = name;
    }
}

class MenuItem extends MenuComponent {
    public MenuItem(String name) {
        super(name);
    }
}

class Menu extends MenuComponent {

    List<MenuComponent> items;

    public Menu(String name) {
        super(name);
        this.items= new ArrayList<>();
    }

    public void addItem(MenuComponent menuComponent) {
        this.items.add(menuComponent);
    }

    public MenuComponent removeMenuComponent(MenuComponent menuComponent) {
        return null;
    }

    public List<MenuComponent> getItems(){
        return items;
    }
}

public class CompositeClient{

    public static void main(String[] args) {
        Menu menu = new Menu("Menu");
        Menu fileObj = new Menu("File");
        Menu editObj = new Menu("Edit");

        menu.addItem(fileObj);
        fileObj.addItem(new MenuItem("Open"));
        fileObj.addItem(new MenuItem("Save"));
        menu.addItem(editObj);
        editObj.addItem(new MenuItem("Undo"));
        editObj.addItem(new MenuItem("Redo"));
        editObj.addItem(new MenuItem("Cut"));

        Iterator<MenuComponent> itrObj =  menu.items.iterator();

        while(itrObj.hasNext()){
            System.out.println(itrObj.next().name);
        }


    }
}
