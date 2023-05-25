package com.example.demo1.dao;

import com.example.demo1.interfaces.Building;
import com.example.demo1.models.Player;
import com.example.demo1.models.Playground;
import com.example.demo1.models.Wave;
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
    int power;
    private Player player = new Player();
    private Wave wave = new Wave();
    private Playground playground = new Playground();

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
        Tower newTower = new Tower(tower.getLevel(), tower.getType(),id++);
        if(getCash() > tower.getPrice()){
            buildings.add(newTower);
            player.setMoney(player.getMoney() - tower.getPrice());
        }
    }

    public void buyThrone(Throne throne){
        Throne newThrone = new Throne(id++, throne.getTowerDefender());
            if (getCash() > throne.getPrice()) {
                buildings.add(newThrone);
                player.setMoney(player.getMoney() - throne.getPrice());
            }

    }
    public Player getPlayer(){
        return player;
    }
    public int getPower(){
        power = 0;
        for(Building building:buildings){
            power += building.getDamage();
        }
        return power;
    }

    public int getPlaygroundGameCount(){
        playground.setGameCount(playground.getGameCount() + 1);
        return  playground.getGameCount();
    }
}
