package com.example.demo1.models;
import com.example.demo1.interfaces.Building;
import com.example.demo1.models.buildings.Tower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Playground {
    public Playground() {
    }

    public Playground(List<Building> listOfBuildings, int power, int gameCount) {
        this.listOfBuildings = listOfBuildings;
        this.gameCount = gameCount;
    }

    @Autowired
    private List<Building> listOfBuildings;
    private int gameCount = 0;

    public List<Building> getListOfBuildings() {
        return listOfBuildings;
    }

    public void setListOfBuildings(List<Building> listOfBuildings) {
        this.listOfBuildings = listOfBuildings;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

}
