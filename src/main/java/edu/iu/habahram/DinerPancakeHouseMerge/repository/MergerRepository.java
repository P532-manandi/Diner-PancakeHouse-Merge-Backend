package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public class MergerRepository {

    public MergerRepository() {

    }

    private static Iterator<Menu> getMenus() {
        return Arrays.asList(new DinerMenu(), new PancakeHouseMenu(), new CafeMenu()).iterator();
    }

    public List<MenuItem> getMergedMenu() {
        Iterator<Menu> menus = getMenus();
        List<MenuItem> mergedMenu = new java.util.ArrayList<>();
        while (menus.hasNext()) {
            Iterator<MenuItem> currentMenuIterator = menus.next().getIterator();
            while (currentMenuIterator.hasNext()) {
                MenuItem menuItem = currentMenuIterator.next();
                mergedMenu.add(menuItem);
            }
        }
        return mergedMenu;
    }
}
