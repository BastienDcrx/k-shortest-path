import java.awt.event.*;

public class GraphExplorer extends BasicGraphEditor {

  public static void main(String[] args) { initFrame(new GraphExplorer()); }

  public void mouseClicked(MouseEvent e) {
    // bouton droit -> selection d'un noeud de départ pour les parcours
    if (e.getButton() == MouseEvent.BUTTON3) { 
       boolean trace[] = new boolean[nbrNoeuds];
       ParcoursProfondeur(lePlusProche(e.getX(), e.getY()),trace);        
       return; // on quite la méthode pour ne pas créer un noeud lors d'un clic droit
    }
    // clic bouton gauche (implicitement) -> création d'un nouveau noeud.
    super.mouseClicked(e);
  }

  void ParcoursProfondeur(int start, boolean[] trace) {
    System.out.println("visite de "+start);
    trace[start] = true;
    for (int i = 0; i < nbrNoeuds; i++)       
      if (adj_mx[start][i] && !trace[i]) ParcoursProfondeur(i,trace);
  }  
}
