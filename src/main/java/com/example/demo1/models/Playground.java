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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Playground {

    @Autowired
    private List<Building> listOfBuildings;
    private int power;


}
