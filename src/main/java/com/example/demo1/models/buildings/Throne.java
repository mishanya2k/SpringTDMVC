package com.example.demo1.models.buildings;

import com.example.demo1.interfaces.Building;
import com.example.demo1.interfaces.TowerDefender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


public class Throne implements Building {

    @Autowired
    private TowerDefender towerDefender;
    private static final int level = 1;
    private int id;
    private String type = "Throne";

    public Throne() {
    }

    public Throne(int id, TowerDefender towerDefender) {
        this.id = id;
        this.towerDefender = towerDefender;
    }


    @Override
    public int getId() {
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
        else return towerDefender.getDamage() * 2;
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public TowerDefender getTowerDefender() {
        System.out.println("1232131231");
        return towerDefender;
    }

    @Override
    public void setTowerDefender(TowerDefender towerDefender) {
        this.towerDefender = towerDefender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
