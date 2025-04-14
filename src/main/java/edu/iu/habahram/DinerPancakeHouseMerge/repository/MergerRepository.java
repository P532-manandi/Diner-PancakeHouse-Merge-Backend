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


    public List<MenuItem> getMergedMenu() {
        DinerMenu dinerMenu = new DinerMenu();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        CafeMenu cafeMenu = new CafeMenu();
        Iterator<Menu> menuIterators =
                Arrays.asList(dinerMenu, pancakeHouseMenu, cafeMenu).iterator();
        List<MenuItem> mergedMenu = new java.util.ArrayList<>();
        while (menuIterators.hasNext()) {
            Iterator<MenuItem> currentMenuIterator = menuIterators.next().getIterator();
            while (currentMenuIterator.hasNext()) {
                MenuItem menuItem = currentMenuIterator.next();
                mergedMenu.add(menuItem);
            }
        }
        return mergedMenu;
    }
}
