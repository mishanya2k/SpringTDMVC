package com.example.demo1.interfaces;

public interface Building {
    void dps();

    int getLevel();
    int getDamage();
    int getPrice();
    int getId();

    String getType();
    TowerDefender getTowerDefender();

    void setTowerDefender(TowerDefender towerDefender);

}
