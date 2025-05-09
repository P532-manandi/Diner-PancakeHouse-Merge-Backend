package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeMenu extends MenuComponent {
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;
    private CompositeIterator iterator;

    public CompositeMenu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<MenuItem> getItems() {
        ArrayList<MenuItem> items = new ArrayList<>();
        for (MenuComponent menuComponent : menuComponents) {
            if (menuComponent instanceof MenuItem) {
                items.add((MenuItem) menuComponent);
            } else if (menuComponent instanceof CompositeMenu) {
                ArrayList<MenuItem> subItems = ((CompositeMenu)menuComponent).getItems();
                items.addAll(subItems);
            }
        }
        return items;
    }

    public Iterator<MenuComponent> getIterator() {
        if(iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}