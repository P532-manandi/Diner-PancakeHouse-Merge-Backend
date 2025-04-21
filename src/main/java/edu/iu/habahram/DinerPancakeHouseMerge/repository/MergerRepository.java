package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergerRepository {

    public MergerRepository() {

    }

    private static Iterator<CompositeMenu> getMenus() {
        return Arrays.asList(new DinerMenu("Diner Menu", "Lunch"),
                new PancakeHouseMenu("Pancake House Menu", "Breakfast"),
                new CafeMenu("Cafe Menu", "Dinner")).iterator();
    }

    private static ArrayList<MenuItemRecord> iterateOverMenus(CompositeMenu allMenus) {
        ArrayList<MenuItemRecord> menuItemRecords = new ArrayList<>();
        Iterator<MenuComponent> iterator = allMenus.getIterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            if (menuComponent instanceof MenuItem menuItem) {
                MenuItemRecord menuItemRecord =
                        new MenuItemRecord(menuItem.getName(), menuItem.getDescription(),
                                menuItem.isVegetarian(), menuItem.getPrice());
                menuItemRecords.add(menuItemRecord);
            }
        }
        return menuItemRecords;
    }

    public List<MenuItemRecord> getMergedMenu() {
        Iterator<CompositeMenu> menus = getMenus();
        CompositeMenu allMenus = new CompositeMenu("All Menus", "All Menus Combined");
        while (menus.hasNext()) {
            CompositeMenu menu = menus.next();
            allMenus.add(menu);
        }
        return iterateOverMenus(allMenus);
    }

    public List<MenuItemRecord> getSpecificMenu(String menuType) {
        Iterator<CompositeMenu> allMenus = getMenus();
        CompositeMenu specificMenu = new CompositeMenu("Specific Menu", "Specific Menu");
        while (allMenus.hasNext()) {
            CompositeMenu menu = allMenus.next();
            if (menu.getDescription().contains(menuType)) {
                specificMenu.add(menu);
            }
        }
        return iterateOverMenus(specificMenu);

    }
}
