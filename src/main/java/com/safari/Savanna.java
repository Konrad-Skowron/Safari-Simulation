package com.safari;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Savanna extends JPanel {

    public int size;
    public char[][] map;
    public List<Animal> animals = new ArrayList<>();
    public List<Carrion> carrions = new ArrayList<>();

    public Savanna(int size) {
        this.size = size;
        map = new char[size][size];
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (map[x][y] == 'S') {
                    g.setColor(new Color(239,228,176,255));
                    g.fillRect(x*10, y*10, 10, 10);
                }
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (map[x][y] == 'H') {
                    g.setColor(Color.GRAY);
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'L') {
                    g.setColor(Color.ORANGE);
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'V') {
                    g.setColor(Color.WHITE);
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'C') {
                    g.setColor(Color.BLACK);
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'T') {
                    g.setColor(new Color(12, 174, 91));
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'W') {
                    g.setColor(new Color(116,204,244));
                    g.fillRect(x*10, y*10, 10, 10);
                }
            }
        }
    }

    public void map_initialization(int amountW, int amountT) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                map[x][y] = 'S';
            }
        }
        water_generate(4);
        tree_generate(5);
    }

    public void water_generate(int amount) {
        List<Integer> water = Arrays.asList(3, 5, 7, 7, 8, 8, 9, 9, 9, 9, 9, 8, 8, 7, 7, 5, 3);
        for (int k = 0; k < amount; k++) {
            int x = new Random().nextInt(size);
            int y = new Random().nextInt(size);
            for (int i = 0; i < water.size(); i++) {
                int l = y, r = y;
                for (int j = 0; j < water.get(i); j++) {
                    try {
                        map[x][l] = 'W';
                    } catch (Exception e) {

                    }
                    try {
                        map[x][r] = 'W';
                    } catch (Exception e) {

                    }
                    l--;
                    r++;
                }
                x--;
            }
        }
    }

    public void tree_generate(int amount){
        List<Integer> trees = Arrays.asList(3, 4, 4, 4, 4, 4, 3);
        for (int k = 0; k < amount; k++) {
            int x = new Random().nextInt(size);
            int y = new Random().nextInt(size);
            for (int i = 0; i < trees.size(); i++) {
                int l = y, r = y;
                for (int j = 0; j < trees.get(i); j++) {
                    try {
                        map[x][l] = 'T';
                    } catch (Exception e) {

                    }
                    try {
                        map[x][r] = 'T';
                    } catch (Exception e) {

                    }
                    l--;
                    r++;
                }
                x--;
            }
        }
    }

    public void drink(Animal animal){                   //drink będzie dla wszystkich zwierząt
        animal.water += 25;
        if (animal.water > 100)   {animal.water = 100;}
    }

    public void eat(Animal animal){                     //jedzenie dla poszczególnych zwierząt inne
        animal.food += 25;
        if(animal.food > 100)   {animal.food = 100;}
    }

    public void pause(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void addHippo(int count) {
        for (int i = 0; i < count; i++) {
            Hippo hippo = new Hippo();
            do{
                hippo.x = new Random().nextInt(size);
                hippo.y = new Random().nextInt(size);
            }while (map[hippo.x][hippo.y] == 'T' || map[hippo.x][hippo.y] == 'H');          //Jeśli respi na drzewie to szuka innego miejsca

            hippo.prev = map[hippo.x][hippo.y];
            animals.add(hippo);
            map[hippo.x][hippo.y] = 'H';
        }
    }

    public void addLion(int count) {
        for (int i = 0; i < count; i++) {
            Lion lion = new Lion();
            do{
                lion.x = new Random().nextInt(size);
                lion.y = new Random().nextInt(size);
            }while (map[lion.x][lion.y] == 'T' || map[lion.x][lion.y] == 'W' || map[lion.x][lion.y] == 'H' || map[lion.x][lion.y] == 'L');          //Jeśli respi na drzewie lub wodzie to szuka innego miejsca

            lion.prev = map[lion.x][lion.y];
            animals.add(lion);
            map[lion.x][lion.y] = 'L';
        }
    }
    public void addVulture(int count) {
        for (int i = 0; i < count; i++) {
            Vulture vulture = new Vulture();
            do{
                vulture.x = new Random().nextInt(size);
                vulture.y = new Random().nextInt(size);
            }while (map[vulture.x][vulture.y] == 'H' || map[vulture.x][vulture.y] == 'L' || map[vulture.x][vulture.y] == 'V');

            vulture.prev = map[vulture.x][vulture.y];
            animals.add(vulture);
            map[vulture.x][vulture.y] = 'V';
        }
    }
    public void addAnimals(int amountH, int amountL, int amountV){
        addHippo(amountH);
        addLion(amountL);
        addVulture(amountV);
        repaint();
        animalsMove();
    }
    int k;
    public void animalsMove(Animal animal, int prevX, int prevY, char prevPrev){        //pamiętać o jedzeniu i piciu!
        try{
            animal.move();
            if(map[animal.x][animal.y] == 'T'){                 //Drzewo - Wszyscy ruszaja się jeszcze raz
                animal.x = prevX;
                animal.y = prevY;
                animal.prev = prevPrev;
                animalsMove(animal, prevX, prevY, prevPrev);
            }
            else if(map[animal.x][animal.y] == 'S'){            //Piasek
                for(int i=animal.x-1; i<=animal.x+1; i++){
                    if(i < 1 || i > 63){
                        continue;
                    }
                    for (int j=animal.y-1; j<=animal.y+1; j++){
                        if(j < 1 || j > 63){
                            continue;
                        }
                        if(map[i][j] == 'W'){
                            drink(animal);
                        }
                        if(map[i][j] == 'T'){
                            if(animal instanceof Hippo){
                                eat(animal);
                            }
                        }
                        if(map[i][j] == 'H'){
                            if(animal instanceof Lion){
                                eat(animal);
                                for(Animal hippoE : animals){
                                    if(hippoE.x == i && hippoE.y == j){
                                        hippoE.setHp(0);
                                    }
                                }
                            }
                        }
                        else if(map[i][j] == 'C'){                                          //O tu trzeba sie pobawić
                            if(animal instanceof Vulture){
                                eat(animal);
                            }
                        }
                    }
                }
                animal.prev = map[animal.x][animal.y];
                map[prevX][prevY] = prevPrev;
                map[animal.x][animal.y] = animal.getName().charAt(0);
            }

            else if(map[animal.x][animal.y] == 'H' || map[animal.x][animal.y] == 'L' || map[animal.x][animal.y] == 'V' || map[animal.x][animal.y] == 'C'){            //Pole zwierza - losuje jeszcze raz
                animal.x = prevX;
                animal.y = prevY;
                animal.prev = prevPrev;
                k++;
                if(k == 9){
                    animal.x = prevX;
                    animal.y = prevY;
                    animal.prev = prevPrev;
                    return;
                }
                animalsMove(animal, prevX, prevY, prevPrev);

            }

            else if(map[animal.x][animal.y] == 'W'){            //Woda
                if(animal instanceof Hippo){                    //Hipo wchodzi
                    drink(animal);
                    animal.prev = map[animal.x][animal.y];
                    map[prevX][prevY] = prevPrev;
                    map[animal.x][animal.y] = 'H';
                }
                else {                                          //Reszta ruszaja się jeszcze raz
                    animal.x = prevX;
                    animal.y = prevY;
                    animal.prev = prevPrev;
                    animalsMove(animal, prevX, prevY, prevPrev);
                }
            }
            k=0;
        }catch (Exception e){
            animal.x = prevX;
            animal.y = prevY;
            animal.prev = prevPrev;
            animalsMove(animal, prevX, prevY, prevPrev);
        }
    }

    public void animalsMove() {
        int i = 999;
        while (i > 0) {
            pause(1);
            for (Animal animal : animals) {
                if(animal.hp > 0){
                    animalsMove(animal, animal.x, animal.y, animal.prev);

                    animal.food -= 5;           //funkcja, można dodać jeszcze losowe tracenie statów/przypisać rózne dla zwierząt w klasie
                    animal.water -= 10;

                    if(animal.food <= 0 ){
                        animal.hp -= 10;
                    }
                    if (animal.water <= 0 ){
                        animal.hp -= 10;
                    }
                }
                if (animal.hp <= 0){
                    Carrion carrion = new Carrion(animal.x, animal.y, animal.prev);
                    carrions.add(carrion);
                    map[carrion.x][carrion.y] = 'C';
                    animal.hp = 0;
                    animal = null;
                }
            }
            for (Carrion carrion : carrions){
                carrion.time--;
                if(carrion.time <= 0){
                    map[carrion.x][carrion.y] = carrion.prev;
                    carrion = null;
                }
            }
            //pronHub();
            repaint();
            i--;
        }
    }

    public void pronHub(){
        for (int i=0; i<animals.size(); i++){
            for (int j=0; j<animals.size(); j++){
                if(animals.get(i).x == animals.get(j).x && animals.get(j).x == animals.get(j).x){
                    if((animals.get(i).sex == 'F' && animals.get(j).sex == 'M') || (animals.get(i).sex == 'M' && animals.get(j).sex == 'F')){
                        try{
                            Hippo hippo = new Hippo(animals.get(i).x, animals.get(i).y);
                            animals.add(hippo);
                            map[hippo.x][hippo.y] = 'H';
                        }
                        catch(Exception e){
                        }
                        if(animals.get(i).x == 0 || animals.get(i).x == animals.size()-1){
                            animals.get(i).x--;
                            animals.get(j).x++;

                        }
                        else if(animals.get(i).y == 0 || animals.get(i).y == animals.size()-1){
                            animals.get(i).y--;
                            animals.get(j).y++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Savanna savanna = new Savanna(64);
        JFrame frame = new JFrame("Safari Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(savanna);
        frame.setSize(savanna.size*10+13, savanna.size*10 + 38);
        frame.setVisible(true);

        savanna.map_initialization(4, 10);
        savanna.pause(1);
        savanna.addAnimals(20, 20, 5);
    }
}