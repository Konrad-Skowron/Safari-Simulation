package com.safari;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
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
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'C') {
                    g.setColor(Color.RED);
                    g.fillRect(x*10, y*10, 10, 10);
                }
                else if (map[x][y] == 'T') {
                    g.setColor(new Color(66,105,47));
                    g.fillRect(x*10, y*10, 10, 10);
                }
            }
        }
    }

    public void map_initialization() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                map[x][y] = 'S';
            }
        }
        tree_generate(size);
    }

    public void tree_generate(int size){
        int treeAmount = new Random().nextInt(4)+3;

        for(int i=0; i<treeAmount; i++){
            int first = new Random().nextInt(size);
            int second = new Random().nextInt(size);
            for(int j=first-2; j<first+2; j++){
                for (int k=second-2; k<second+2; k++){
                    try {
                        map[j][k] = 'T';
                    }
                    catch (Exception e){

                    }
                }
            }
        }
    }
    public void iftree(Animal animal, int x, int y){
        try{
            animal.move();
            if(map[animal.x][animal.y] == 'T'){
                animal.x = x;
                animal.y = y;
                iftree(animal, x, y);
            }
            else {
                map[x][y] = 'S';
                map[animal.x][animal.y] = 'H';
            }
        }
        catch (Exception e){
            animal.x = x;
            animal.y = y;
            iftree(animal, x, y);
        }
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
            Hippo hippo = new Hippo(size);
            animals.add(hippo);
            map[hippo.x][hippo.y] = 'H';
        }
        repaint();
        animalsMove();
    }

    public void animalsMove() {
        int i = 9999;
        while (i > 0) {
            pause(1);
            for (Animal animal : animals) {
                if (animal.food <= 0 || animal.water <= 0){
                    Carrion carrion = new Carrion(animal.x, animal.y);
                    carrions.add(carrion);
                    map[carrion.x][carrion.y] = 'C';

                    animal = null;
                    System.gc();
                }
                else{
                    iftree(animal, animal.x, animal.y);
                    animal.food -= 20;
                    animal.water--;
                }
            }
            for (Carrion carrion : carrions){
                carrion.time--;
                if(carrion.time <= 0){
                    map[carrion.x][carrion.y] = 'S';
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

        savanna.map_initialization();
        savanna.pause(1);
        savanna.addHippo(8);
    }
}
