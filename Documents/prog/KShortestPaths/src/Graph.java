import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class Graph extends JPanel{

public static void main(String[] args) 
{
	initFrame("graph1.txt"); 
}

  int nbrNoeuds;
  ArrayList<Vertex> noeuds;
  int x[];
  int y[];
  boolean[][] adj_mx;
  
  
   static void initFrame(String file_graph) {
	   BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader("graphs/" + file_graph));
		
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		Graph g = new Graph();
	    JFrame frame = new JFrame(g.getClass().getName().toString());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600, 500);
	    frame.add(g);
	    frame.setVisible(true);      
  } 
	
  public void paint(Graphics g) {
    g.clearRect(0, 0, this.getWidth(), this.getHeight());
    for (int i = 0; i < nbrNoeuds; i++) {   
      g.fillOval(x[i] - 5, y[i] - 5, 10, 10);
      g.drawString("" + i, x[i] + 5, y[i] - 5);
      for(int j = 0; j < nbrNoeuds; j++) 
          if (adj_mx[i][j]) g.drawLine(x[i], y[i], x[j], y[j]);
	      
    }    
  }
}



