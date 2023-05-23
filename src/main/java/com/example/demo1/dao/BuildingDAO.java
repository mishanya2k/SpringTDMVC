package com.example.demo1.dao;

import com.example.demo1.interfaces.Building;
import com.example.demo1.interfaces.TowerDefender;
import com.example.demo1.models.Player;
import com.example.demo1.models.buildings.Throne;
import com.example.demo1.models.buildings.Tower;
import com.example.demo1.models.defenders.Archer;
import com.example.demo1.models.defenders.Crossbowman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingDAO {
    private Player player = new Player();
    private  TowerDefender towerDefender;

    private List<Crossbowman> crossbowmanList;
    private Building building = new Tower();
    private List<Archer> archerList;
    {
        crossbowmanList = new ArrayList<>();
        archerList = new ArrayList<>();
        crossbowmanList.add(new Crossbowman(1));
        crossbowmanList.add(new Crossbowman(2));
        crossbowmanList.add(new Crossbowman(3));
        archerList.add(new Archer(1));
        archerList.add(new Archer(2));
        archerList.add(new Archer(3));
    }
    public List<Archer> getArcherList(){
        return archerList;
    }
    public int getCash(){
        return player.getMoney();
    }
    public int getLives(){
        return player.getLives();
    }

    public List<Crossbowman> getCrossbowmanList(){
        return crossbowmanList;
    }

    public TowerDefender getTowerDefender() {
        System.out.println("12312");
        return towerDefender;
    }
    public void setArcherDefender(Archer archer){
        this.towerDefender = archer;
    }
    public void setCrossbowmanDefender(Crossbowman crossbowman){
        this.towerDefender = crossbowman;
    }
    public void buyArcher(Archer archer){
        System.out.println(archer.getType() + ' ' + archer.getDamage() + ' ' + archer.getLevel() + ' ' + archer.getPrice());
        if (player.getMoney() > archer.getPrice() && towerDefender==null) {
            player.setMoney(player.getMoney() - archer.getPrice());
        }
    }
    public void buyCrossbowman(Crossbowman crossbowman){
        if (player.getMoney() > crossbowman.getPrice()&& towerDefender==null) {
            player.setMoney(player.getMoney() - crossbowman.getPrice());
        }
    }
    public void sellArcher(Archer archer){
        player.setMoney(player.getMoney() + archer.getPrice());
        archer = null;
    }

    public void setTowerDefender(TowerDefender towerDefender) {
        this.towerDefender = towerDefender;
    }
}
