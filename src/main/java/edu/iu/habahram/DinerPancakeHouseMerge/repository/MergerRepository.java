package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MergerRepository {

    public MergerRepository() {

    }


    public List<MenuItem> getMergedMenu() {
        DinerMenu dinerMenu = new DinerMenu();
        DinerMenuIterator dinerMenuIterator = dinerMenu.getIterator();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        PancakeHouseMenuIterator pancakeHouseMenuIterator = pancakeHouseMenu.getIterator();
        List<MenuItem> mergedMenu = new java.util.ArrayList<>();
        while (dinerMenuIterator.hasNext()) {
            MenuItem menuItem = dinerMenuIterator.next();
            mergedMenu.add(menuItem);
        }
        while (pancakeHouseMenuIterator.hasNext()) {
            MenuItem menuItem = pancakeHouseMenuIterator.next();
            mergedMenu.add(menuItem);
        }
        return mergedMenu;
    }
}
