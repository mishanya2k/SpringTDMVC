package com.example.demo1.dao;

import com.example.demo1.models.Player;
import com.example.demo1.models.Playground;
import com.example.demo1.models.Wave;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PlayDAO {
    private Wave wave;
    private final PlaygroundDAO playgroundDAO;
    Playground playground = new Playground();
    private Player player = new Player();
    private int wavePower = 0;

    public PlayDAO(PlaygroundDAO playgroundDAO) {
        this.playgroundDAO = playgroundDAO;
    }

    public void setWavePower() {
        wavePower = playground.getGameCount() * 25 + 30;
    }

    public int getWavePower() {
        Random random = new Random();
        int randomNum = random.nextInt(10);
        wavePower = (playground.getGameCount() * 25 + 30) + randomNum;
        return wavePower;
    }
    public int getGameCount(){
        return playground.getGameCount();
    }

    public String play() {
        if (player.getLives() == 0) {
            return "U cant play anymore";
        } else {
            playground.setGameCount(getGameCount() + 1);
            if (getWavePower() < playgroundDAO.getPower()) {
                player.setMoney(player.getMoney() + 50);
                return "You win";
            } else {
                player.setLives(player.getLives() - 1);
                player.setMoney(player.getMoney() + 25);
                return "You Lose";
            }
        }
    }
}
