package com.example.demo1.models.defenders;


import com.example.demo1.interfaces.TowerDefender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



public class Archer implements TowerDefender {
    private int level;
    private String type = "Archer";

    public Archer(int level) {
        this.level = level;
    }

    @Override
    public int getDamage() {
        if (level == 1)
            return 10;
        else if (level == 2)
            return 20;
        else
            return 40;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getPrice() {
        if(level == 1)
            return 20;
        else if(level == 2)
            return 30;
        else
            return 40;
    }
}
