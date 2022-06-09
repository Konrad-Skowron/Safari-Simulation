package com.safari;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Statistics extends JPanel {

  public JTextArea textArea;

  public Statistics() {
    this.textArea = new JTextArea(20, 30);
    textArea.setBackground(new Color(40,40,40));
    textArea.setForeground(new Color(102,255,102));
    JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    add(scrollBar);
  }

  public void update() {
    textArea.setText(null);
    for (Animal a : Savanna.getAnimals()) {
      textArea.append(a.getName() + ": { ");
      textArea.append("HP: " + a.getHp() + ", ");
      textArea.append("food: " + a.getFood() + ", ");
      textArea.append("water: " + a.getWater() + " }\n\n");
    }
  }

  public void showStats(Statistics stats) {
    JFrame frame = new JFrame("stats");
    frame.add(stats);
    frame.pack();
    frame.setVisible(true);
    frame.setResizable(false);
    stats.update();
  }
}
