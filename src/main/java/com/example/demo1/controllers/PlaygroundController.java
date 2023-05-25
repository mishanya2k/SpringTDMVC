package com.example.demo1.controllers;

import com.example.demo1.dao.BuildingDAO;
import com.example.demo1.dao.PlaygroundDAO;
import com.example.demo1.interfaces.Building;
import com.example.demo1.models.buildings.Throne;
import com.example.demo1.models.buildings.Tower;
import com.example.demo1.models.defenders.Archer;
import com.example.demo1.models.defenders.Crossbowman;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@AllArgsConstructor
public class PlaygroundController {

    private final PlaygroundDAO playgroundDAO;
    private final BuildingDAO buildingDAO;

    //стартовая страница
    @GetMapping("/")
    public String start() {
        return "starter";
    }

//добавляем на форму список вышек, которые у нас есть, параметры, и вышки, которые есть в магазине(2 листа)
    @GetMapping("/playground")
    public String goToPlayground(Model model) {
        model.addAttribute("buildings", playgroundDAO.getBuildings());
        model.addAttribute("parameters", playgroundDAO);
        model.addAttribute("throneBuildings", playgroundDAO.getThroneList());
        model.addAttribute("towerBuildings", playgroundDAO.getTowerList());
        return "playground";
    }
//принимаем post запросы, в теле которых лежит либо тавер либо трон, и соответствующим образом добавляем в список купленных, изменяем баланс
    @PostMapping("/playground")
    public String buyTower(@ModelAttribute("towerBuildings") Tower tower,
                           @ModelAttribute("throneBuildings") Throne throne,
                           @RequestParam("button") String button) {
        if ("button1".equals(button))
            playgroundDAO.buyTower(tower);
        else if("button2".equals(button))
            playgroundDAO.buyThrone(throne);

        return "redirect:/playground";
    }

    @GetMapping("/playground/tower/{id}")
    public String getBuildingById(@PathVariable("id") int id, Model model) {
        model.addAttribute("parameters",buildingDAO);
        model.addAttribute("chosenbuilding", playgroundDAO.getById(id));
        model.addAttribute("defender",playgroundDAO.getById(id).getTowerDefender());
        model.addAttribute("archers", buildingDAO.getArcherList());
        model.addAttribute("crossbowmans",buildingDAO.getCrossbowmanList());
        return "showByIndex";
    }

    @PostMapping("/playground/tower/{id}")
    public String buyDefender(@PathVariable("id") int id,@ModelAttribute("archers") Archer archer,
                              @ModelAttribute("crossbowmans")Crossbowman crossbowman,@RequestParam("button") String button){
        if ("button1".equals(button) && playgroundDAO.getById(id).getTowerDefender() == null
                && playgroundDAO.getCash() >= archer.getPrice()) {
            playgroundDAO.getById(id).setTowerDefender(archer);
            buildingDAO.buyArcher(archer);
        }
        else if("button2".equals(button) && playgroundDAO.getById(id).getTowerDefender() == null
                && playgroundDAO.getCash() >= crossbowman.getPrice()) {
            playgroundDAO.getById(id).setTowerDefender(crossbowman);
            buildingDAO.buyCrossbowman(crossbowman);
        } else if ("button3".equals(button) && playgroundDAO.getById(id).getTowerDefender() != null){
            if(playgroundDAO.getById(id).getTowerDefender() instanceof Archer){
                System.out.println("money archer " + archer.getPrice());
                buildingDAO.sellArcher(archer);
            } else if (playgroundDAO.getById(id).getTowerDefender() instanceof Crossbowman) {
                buildingDAO.sellCrossbowman(crossbowman);
            }
            playgroundDAO.getById(id).setTowerDefender(null);
        }

        return "redirect:/playground/tower/{id}";

    }
}
//    @PostMapping("/play/result")
//    public String play(@ModelAttribute )







