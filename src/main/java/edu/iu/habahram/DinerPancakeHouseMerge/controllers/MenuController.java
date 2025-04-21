package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {
    private final MergerRepository mergerRepository;

    public MenuController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> merge() {
        return mergerRepository.getMergedMenu();
    }

    @GetMapping("/vegetarian")
    public List<MenuItemRecord> mergeVegetarian() {
        return mergerRepository.getMergedMenu().stream().filter(MenuItemRecord::vegetarian)
                .toList();
    }

    @GetMapping("/breakfast")
    public List<MenuItemRecord> mergeBreakfast() {
        return mergerRepository.getSpecificMenu("Breakfast");
    }

    @GetMapping("/lunch")
    public List<MenuItemRecord> mergeLunch() {
        return mergerRepository.getSpecificMenu("Lunch");
    }

    @GetMapping("/supper")
    public List<MenuItemRecord> mergeDinner() {
        return mergerRepository.getSpecificMenu("Dinner");
    }

}
