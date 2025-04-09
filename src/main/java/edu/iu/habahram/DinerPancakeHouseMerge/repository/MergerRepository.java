package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MergerRepository {
    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;

    public MergerRepository(DinerRepository dinerRepository,
                            PancakeHouseRepository pancakeHouseRepository) {

        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }


    public List<MenuItem> getMergedMenu() {
        MenuItem[] dinerMenu = dinerRepository.getTheMenu();
        List<MenuItem> pancakeHouseMenu = pancakeHouseRepository.getTheMenu();
        List<MenuItem> combinedMenu = new ArrayList<>();
        combinedMenu.addAll(List.of(dinerMenu));
        combinedMenu.addAll(pancakeHouseMenu);
        return combinedMenu;
    }
}
