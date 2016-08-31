import java.awt.*;
import java.awt.event.*;

public class BasicGraphEditor extends NodesEditor {
  int debut =-1, fin = -1; // sert à stocker l'info' du noeud de départ et arrivée d'un lien
  boolean[][] adj_mx = new boolean[100][100];
	
  public static void main(String[] args) { initFrame(new BasicGraphEditor()); }

  // affichage (méthode appelée à chaque "rafraissiement" de la fenêtre
  public void paint(Graphics g) {
    // trace les noeuds
    super.paint(g);
    // trace les arêtes
    for(int i = 0; i < nbrNoeuds; i++)      
       for(int j = 0; j < nbrNoeuds; j++) 
         if (adj_mx[i][j]) g.drawLine(x[i], y[i], x[j], y[j]);        
  }     

  // gestion des événement souris
  public void mouseClicked(MouseEvent e) {
     super.mouseClicked(e);
     debut = fin = -1; // attention un clic c'est un "pressed" suivit d'un "released"
     // en mettant debut et fin à -1 on sait qu'il ne s'agit pas d'un "glissé déplacé", mais bien d'un clic.
  }

  public void mousePressed(MouseEvent e) {    
    debut = lePlusProche(e.getX(), e.getY());   
    System.out.println("Pressed  debut=" + debut);
  }

  public void mouseReleased(MouseEvent e) {
    fin = lePlusProche(e.getX(), e.getY());   
    System.out.println("released  fin=" + fin);
    if (debut != -1 && fin != -1 && fin != debut) {
       adj_mx[debut][fin] = true;
       adj_mx[fin][debut] = true;  // on considèrera un graphe symétrique       
    }
    repaint();
  }

  int lePlusProche(int pos_x, int pos_y) { // recherche du noeud le plus proche de la position (x, y)
    int j = -1, dist, min = 999999;    
    for(int i = 0; i < nbrNoeuds; i++) {
      // calcul de la distance (note : la racine carrée n'est pas utile pour trouver la plus faible distance)
      dist = (x[i] - pos_x) * (x[i] - pos_x) + (y[i] - pos_y) * (y[i] - pos_y);
      if (min >= dist) {
        min = dist;
        j = i;
      }
    } 
    System.out.println("j = " + j);
    return j;
  }
}
