package com.example.demo1.models.defenders;

import com.example.demo1.interfaces.TowerDefender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Crossbowman implements TowerDefender {

    private int level;
    private String type = "Crossbowman";

    public Crossbowman(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getDamage() {
        if (level == 1)
            return 100;
        else if (level == 2)
            return 150;
        else
            return 200;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getPrice() {
        if(level == 1)
            return 100;
        else if(level == 2)
            return 120;
        else
            return 160;
    }

}
