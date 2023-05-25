package com.example.demo1.models;




public class Player {

    private static int money = 500;
    private static int lives = 10;

    public Player() {
    }
    public Player(int lives,int money){
        this.lives = lives;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
