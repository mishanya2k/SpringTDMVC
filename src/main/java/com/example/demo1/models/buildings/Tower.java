package com.example.demo1.models.buildings;

import com.example.demo1.interfaces.Building;
import com.example.demo1.interfaces.TowerDefender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


public class Tower implements Building {
    private int level;
    private  String type = "Tower";
    private int id;

    @Autowired
    private TowerDefender towerDefender;

    public Tower() {
    }

    public Tower(int id, int level, TowerDefender towerDefender) {
        this.id = id;
        this.level = level;
        this.towerDefender = towerDefender;
    }

    @Override
    public  int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type;
    }


    @Override
    public void dps() {
        System.out.println("level of tower/archer " + getLevel() + " " + towerDefender.getLevel() + "\n" +
                "damage of tower/archer " + getDamage() + " " + towerDefender.getDamage());
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getDamage() {
        if(towerDefender == null){
            return 0;
        }
        else if(level == 1)
            return towerDefender.getDamage() + 25;

        else if (level == 2)
            return towerDefender.getDamage() + 50;
        else
            return towerDefender.getDamage() + 100;

    }

    @Override
    public int getPrice() {
        if(level == 1)
            return 300;
        else if(level == 2)
            return 350;
        else
            return 400;

    }

    @Override
    public TowerDefender getTowerDefender() {

        return towerDefender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTowerDefender(TowerDefender towerDefender) {
        this.towerDefender = towerDefender;
    }

}
