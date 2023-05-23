package com.example.demo1.dao;

import com.example.demo1.interfaces.Building;
import com.example.demo1.interfaces.TowerDefender;
import com.example.demo1.models.Player;
import com.example.demo1.models.buildings.Throne;
import com.example.demo1.models.buildings.Tower;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaygroundDAO {
    private List<Building> buildings;
    private List<Tower> towerList;
    private List<Throne> throneList;
    private static int id = 0;
    private Player player = new Player();

    {
        buildings = new ArrayList<>();
        buildings.add(new Tower(id++,1,null));
        towerList = new ArrayList<>();
        throneList = new ArrayList<>();
        towerList.add(new Tower(id++,1,null));
        towerList.add(new Tower(id++,2,null));
        towerList.add(new Tower(id++,3,null));
        throneList.add(new Throne(id++,null));

    }
    public List<Building> getBuildings(){
        return buildings;
    }

    public List<Tower> getTowerList(){
        return towerList;
    }
    public List<Throne> getThroneList(){
        return throneList;
    }
       public Building getById(int id){
        return buildings.stream().filter(building->building.getId() == id).findAny().orElse(null);
    }

    public int getCash(){
        return player.getMoney();
    }

    public int getLives(){
        return player.getLives();
    }

    public void buyTower(Tower tower){
        if(getCash() > tower.getPrice()){
            buildings.add(tower);
            player.setMoney(player.getMoney() - tower.getPrice());
        }
    }

    public void buyThrone(Throne throne){
            if (getCash() > throne.getPrice()) {
                buildings.add(throne);
                player.setMoney(player.getMoney() - throne.getPrice());
            }

    }

}
