package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
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
        Iterator<MenuItem> dinerMenuIterator = dinerMenu.getIterator();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        Iterator<MenuItem> pancakeHouseMenuIterator = pancakeHouseMenu.getIterator();
        CafeMenu cafeMenu = new CafeMenu();
        Iterator<MenuItem> cafeMenuIterator = cafeMenu.getIterator();
        Iterator<Iterator<MenuItem>> menuIterators =
                Arrays.asList(dinerMenuIterator, pancakeHouseMenuIterator, cafeMenuIterator)
                        .iterator();
        List<MenuItem> mergedMenu = new java.util.ArrayList<>();
        while (menuIterators.hasNext()) {
            Iterator<MenuItem> currentIterator = menuIterators.next();
            while (currentIterator.hasNext()) {
                MenuItem menuItem = currentIterator.next();
                mergedMenu.add(menuItem);
            }
        }
        return mergedMenu;
    }
}
