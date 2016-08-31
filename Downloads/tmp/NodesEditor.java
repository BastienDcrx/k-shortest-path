/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package td7;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NodesEditor extends JPanel implements MouseListener {
  int nbrNoeuds = 0; // sert à connaitre le vrai nombre de noeuds "actifs"
  int x[] = new int[100], y[] = new int[100];
  //boolean matrice[][] = new boolean[100][100];

   static void initFrame(NodesEditor g) {
    g.addMouseListener(g);
    
    JFrame frame = new JFrame(g.getClass().getName().toString());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.add(g);
    frame.setVisible(true);      
  } 
  
  public static void main(String[] args) {
    // construction de l'interface graphique 
    initFrame(new NodesEditor());
  }

  // affichage (méthode appelée à chaque "rafraissiement" de la fenêtre
  public void paint(Graphics g) {
    // effacer le contenu de la fenêtre
    g.clearRect(0, 0, this.getWidth(), this.getHeight());
    for (int i = 0; i < nbrNoeuds; i++) {   
      g.fillOval(x[i] - 5, y[i] - 5, 10, 10); // trace un rond centré sur (x, y)
      g.drawString("" + i, x[i] + 5, y[i] - 5); // astuce le ""+ dans le 1er paramètre est pour transformer i en un String comme dans les affichages
    }
  }     

  // gestion des événements souris
  public void mouseClicked(MouseEvent e) {
     // recupération de la position actuelle de la souris
     x[nbrNoeuds] = e.getX(); 
     y[nbrNoeuds] = e.getY(); 
     nbrNoeuds++;
     System.out.println("MOUSE  " + nbrNoeuds);
     //updateUI();
     repaint();
  }
  
  public void mouseExited(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
}



