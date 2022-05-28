package com.safari;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
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
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (map[x][y] == 'H') {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x, y, 3, 3);
                }
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (map[x][y] == 'C') {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, 3, 3);
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
                animal.food -= 5;
                animal.water--;

                int temp_x = animal.x;
                int temp_y = animal.y;

                if (animal.food <= 0 || animal.water <= 0){
                    animal = null;

                    Carrion carrion = new Carrion(temp_x, temp_y);
                    carrions.add(carrion);
                    map[carrion.x][carrion.y] = 'C';
                }
                else{
                    map[animal.x][animal.y] = 'S';
                    animal.move();
                    try {
                        map[animal.x][animal.y] = 'H';
                    } catch (Exception e) {
                        map[temp_x][temp_y] = 'H';
                        animal.x = temp_x;
                        animal.y = temp_y;
                    }
                }
            }
            for (Carrion carrion : carrions){
                carrion.time--;
                if(carrion.time <= 0){
                    map[carrion.x][carrion.y] = 'S';
                    carrion = null;
                }
            }
            pronHub();
            repaint();
            i--;
        }
    }

    public void pronHub(){
            for (int i=0; i<animals.size(); i++){
                for (int j=0; j<animals.size(); j++){
                    if(animals.get(i).x == animals.get(j).x && animals.get(j).x == animals.get(j).x){
                        if((animals.get(i).sex == 'F' && animals.get(j).sex == 'M') || (animals.get(i).sex == 'M' && animals.get(j).sex == 'F')){
                            Hippo hippo = new Hippo(animals.get(i).x, animals.get(i).y);
                            animals.add(hippo);
                            map[hippo.x][hippo.y] = 'H';
                        }
                    }
                }
            }
    }

    public static void main(String[] args) {
        Savanna savanna = new Savanna(300);
        JFrame frame = new JFrame("Safari Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(savanna);
        frame.setSize(savanna.size, savanna.size + 30);
        frame.setVisible(true);

        savanna.map_initialization();
        savanna.pause(1);
        savanna.addHippo(20000);
    }
}
