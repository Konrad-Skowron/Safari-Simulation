package com.safari;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Savanna extends JPanel {

    public int turns;
    public int scale;
    public int size;
    public char[][] map;
    public static List<Animal> animals = new ArrayList<>();
    public static List<Carrion> carrions = new ArrayList<>();
    public Statistics stats = new Statistics();

    public Savanna(int size, int scale, int turns) {
        this.size = size;
        this.scale = scale;
        this.turns = turns;
        map = new char[size][size];
        JButton button = new JButton("stats");
        button.setBounds(scale * size - 77, scale * size - 30, 72, 25);
        button.addActionListener(e -> stats.showStats(stats));
        add(button);
    }

    public Dimension getPreferredSize() {
        return new Dimension(size * scale,size * scale);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(40,40,40));
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (map[x][y] == 'S') {
                    g.setColor(new Color(239,228,176));
                    g.fillRect(x * scale, y * scale, scale, scale);
                } else if (map[x][y] == 'W') {
                    g.setColor(new Color(116,204,244));
                    g.fillRect(x * scale, y * scale, scale, scale);
                } else if (map[x][y] == 'T') {
                    g.setColor(new Color(12, 174, 91));
                    g.fillRect(x * scale, y * scale, scale, scale);
                } else if (map[x][y] == 'H') {
                    g.setColor(new Color(92, 124, 137));
                    g.fillRect(x * scale, y * scale, scale, scale);
                } else if (map[x][y] == 'L') {
                    g.setColor(new Color(247, 166, 15));
                    g.fillRect(x * scale, y * scale, scale, scale);
                } else if (map[x][y] == 'V') {
                    g.setColor(new Color(148, 109, 52));
                    g.fillRect(x * scale, y * scale, scale, scale);
                } else if (map[x][y] == 'C') {
                    g.setColor(new Color(75, 0, 0));
                    g.fillRect(x * scale, y * scale, scale, scale);
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
        water_generate(amountW);
        tree_generate(amountT);
    }

    public void water_generate(int amount) {
        List<Integer> water = Arrays.asList(3, 5, 7, 7, 8, 8, 9, 9, 9, 9, 9, 8, 8, 7, 7, 5, 3);
        for (int k = 0; k < amount; k++) {
            int x = new Random().nextInt(size);
            int y = new Random().nextInt(size);
            for (Integer pixels : water) {
                int l = y, r = y;
                for (int j = 0; j < pixels; j++) {
                    try {
                        map[x][l] = 'W';
                    } catch (Exception e) {
//                        System.out.println("\nException caught");
                    }
                    try {
                        map[x][r] = 'W';
                    } catch (Exception e) {
//                        System.out.println("\nException caught");
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
            for (Integer pixels : trees) {
                int l = y, r = y;
                for (int j = 0; j < pixels; j++) {
                    try {
                        map[x][l] = 'T';
                    } catch (Exception e) {
//                        System.out.println("\nException caught");
                    }
                    try {
                        map[x][r] = 'T';
                    } catch (Exception e) {
//                        System.out.println("\nException caught");
                    }
                    l--;
                    r++;
                }
                x--;
            }
        }
    }

    public void pause(int s) {
        try {
            TimeUnit.MILLISECONDS.sleep(s);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void addHippo(int count) {
        for (int i = 0; i < count; i++) {
            Hippo hippo = new Hippo();
            do{
                hippo.setX(new Random().nextInt(size));
                hippo.setY(new Random().nextInt(size));
            }while (map[hippo.getX()][hippo.getY()] == 'T' || map[hippo.getX()][hippo.getY()] == 'H');          //Jeśli respi na drzewie to szuka innego miejsca

            hippo.setPrev(map[hippo.getX()][hippo.getY()]);
            animals.add(hippo);
            map[hippo.getX()][hippo.getY()] = 'H';
        }
    }       //addAnimal

    public void addLion(int count) {
        for (int i = 0; i < count; i++) {
            Lion lion = new Lion();
            do{
                lion.setX(new Random().nextInt(size));
                lion.setY(new Random().nextInt(size));
            }while (map[lion.getX()][lion.getY()] == 'T' || map[lion.getX()][lion.getY()] == 'W' || map[lion.getX()][lion.getY()] == 'H' || map[lion.getX()][lion.getY()] == 'L');          //Jeśli respi na drzewie lub wodzie to szuka innego miejsca

            lion.setPrev(map[lion.getX()][lion.getY()]);
            animals.add(lion);
            map[lion.getX()][lion.getY()] = 'L';
        }
    }

    public void addVulture(int count) {
        for (int i = 0; i < count; i++) {
            Vulture vulture = new Vulture();
            do{
                vulture.setX(new Random().nextInt(size));
                vulture.setY(new Random().nextInt(size));
            }while (map[vulture.getX()][vulture.getY()] == 'H' || map[vulture.getX()][vulture.getY()] == 'L' || map[vulture.getX()][vulture.getY()] == 'V');

            vulture.setPrev(map[vulture.getX()][vulture.getY()]);
            animals.add(vulture);
            map[vulture.getX()][vulture.getY()] = 'V';
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
            if(map[animal.getX()][animal.getY()] == 'T'){                 //Drzewo - Wszyscy ruszaja się jeszcze raz
                if(animal instanceof Vulture){                    //Vulture wchodzi
                    animal.setPrev(map[animal.getX()][animal.getY()]);
                    map[prevX][prevY] = prevPrev;
                    map[animal.getX()][animal.getY()] = animal.getName().charAt(0);
                }
                else{
                    animal.setX(prevX);
                    animal.setY(prevY);
                    animal.setPrev(prevPrev);
                    animalsMove(animal, prevX, prevY, prevPrev);
                }
            }
            else if(map[animal.getX()][animal.getY()] == 'S'){            //Piasek
                for(int i=animal.getX()-1; i<=animal.getX()+1; i++){
                    if (i < 0 || i > size - 1){
                        continue;
                    }
                    for (int j=animal.getY()-1; j<=animal.getY()+1; j++){
                        if (j < 0 || j > size - 1) {
                            continue;
                        }
                        if(map[i][j] == 'W'){
                            animal.drink();
                        }
                        if(map[i][j] == 'T'){
                            if(animal instanceof Hippo){
                                animal.eat();
                            }
                        }
                        if(map[i][j] == 'H'){
                            if(animal instanceof Lion){
                                animal.eat();
                                for(Animal hippoE : animals){
                                    if(hippoE.getX() == i && hippoE.getY() == j){
                                        ((Lion) animal).attack(hippoE);
                                    }
                                }
                            }
                        }
                        else if(map[i][j] == 'C'){                                          //O tu trzeba sie pobawić
                            if(animal instanceof Vulture){
                                animal.eat();
                                for(Carrion carrionE : carrions){
                                    if(carrionE.getX() == i && carrionE.getY() == j){
                                        carrionE.setDurabity(carrionE.getDurabity()-50);
                                    }
                                }
                            }
                        }
                    }
                }
                animal.setPrev(map[animal.getX()][animal.getY()]);
                map[prevX][prevY] = prevPrev;
                map[animal.getX()][animal.getY()] = animal.getName().charAt(0);
            }
            else if(map[animal.getX()][animal.getY()] == 'H' || map[animal.getX()][animal.getY()] == 'L' || map[animal.getX()][animal.getY()] == 'V' || map[animal.getX()][animal.getY()] == 'C'){            //Pole zwierza - losuje jeszcze raz
                animal.setX(prevX);
                animal.setY(prevY);
                animal.setPrev(prevPrev);
                k++;
                if(k == 9){
                    animal.setX(prevX);
                    animal.setY(prevY);
                    animal.setPrev(prevPrev);
                    return;
                }
                animalsMove(animal, prevX, prevY, prevPrev);
            }
            else if(map[animal.getX()][animal.getY()] == 'W'){            //Woda
                if(animal instanceof Hippo || animal instanceof Vulture){                    //Hipo i Vulture wchodzi
                    animal.drink();
                    animal.setPrev(map[animal.getX()][animal.getY()]);
                    map[prevX][prevY] = prevPrev;
                    map[animal.getX()][animal.getY()] = animal.getName().charAt(0);
                } else {                                          //Reszta ruszaja się jeszcze raz
                    animal.setX(prevX);
                    animal.setY(prevY);
                    animal.setPrev(prevPrev);
                    animalsMove(animal, prevX, prevY, prevPrev);
                }
            }
            k = 0;
        }catch (Exception e){
            animal.setX(prevX);
            animal.setY(prevY);
            animal.setPrev(prevPrev);
            animalsMove(animal, prevX, prevY, prevPrev);
        }
    }

    public void animalsMove() {
        while (3*turns > 0) {
            pause(250);
            for (Animal animal : animals) {
                if (turns % animal.getSpeed() == 0) {
                    if (animal.getHp() > 0) {
                        animalsMove(animal, animal.getX(), animal.getY(), animal.getPrev());
                        animal.lossStats();
                        animal.hp();
                    }
                    if (animal.getHp() <= 0) {
                        Carrion carrion = new Carrion(animal.getX(), animal.getY(), animal.getPrev());
                        carrions.add(carrion);
                        map[carrion.getX()][carrion.getY()] = 'C';
                        animal.setHp(0);
                        animal = null;
                    }
                }
            }
            for (Carrion carrion : carrions){
                if(carrion.getDurabity() <= 0){
                    map[carrion.getX()][carrion.getY()] = carrion.getPrev();
                    carrion = null;
                }
            }
            //pronHub();
            turns--;
            repaint();
            stats.update();
            pause(250);
        }
    }

    public static List<Animal> getAnimals() {
        return animals;
    }

    public static List<Carrion> getCarrions() {
        return carrions;
    }


    public static void main(String[] args) {
        Savanna savanna = new Savanna(64, 10, 999);
        savanna.setLayout(null);
        JFrame frame = new JFrame("Safari Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(savanna);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        savanna.map_initialization(4, 10);
        savanna.pause(500);
        savanna.addAnimals(4, 6, 2);
    }

}