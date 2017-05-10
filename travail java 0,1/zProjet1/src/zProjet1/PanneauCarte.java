package zProjet1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class PanneauCarte extends JPanel implements MouseListener, MouseMotionListener{   
	
	private Carte c;
	private int deplacementX;
	private int deplacementY;
	private int nouveauX;
	private int nouveauY;
    private int intSauvegardeX;
    private int intSauvegardeY;
    private int intColDeplace;
    
    boolean carteSelectionnee; 
    
    private Stack<Carte>[] st;
    private Carte[] tabCartecelluleVide = new Carte[4];
    private Carte[] tabCarteCelluleFinal = new Carte[4];
    
    private Rectangle[] tabHautGauche = new Rectangle[4];
    private Rectangle[] tabHautDroit = new Rectangle[4];
    
    private Boolean boohautBas;
    
    
    //Rectangle[] tabTempo = new Rectangle()[8];
    //Rectangle[] tab
	
	private static final long serialVersionUID = 1L;
	PanneauCarte(){
		setBackground(new Color(50,15,60));  
		//c = new Carte(10,20, new ImageIcon("cartes\\1pique.gif"));
		addMouseListener(this);
		addMouseMotionListener(this);
		st = new Stack[8];
		
		//Construit chaque carte
		ArrayList <Carte>  mesCartes= new ArrayList<Carte>();
	    for (ValeurCarte val : ValeurCarte.values())
	    {
	    	for(Enseigne ens:Enseigne.values()){
	    		mesCartes.add(new Carte(ens, val, 0, 0, new ImageIcon("cartes//" + (val.ordinal() +1) 
	    				+ ens + ".gif")));    		  		
	    	}    	
	    }
	    
	    // mélanger les cartes 
		Collections.shuffle(mesCartes);
		
		
		Iterator<Carte> it = mesCartes.iterator();
	
		int intPosX = 40;
		int intNbCarte = 7;
		
		//Insère carte dans le tableau de pile
		for(int a=0;a<st.length;a++){
			int intPosY = 190;
			st[a] = new Stack<Carte>();
			for(int s=0;s<intNbCarte;s++){
				st[a].push(it.next());
				st[a].lastElement().setPositionX(intPosX);
				st[a].lastElement().setPositionY(intPosY);
				
				intPosY+=40;
				
				//Tableau pour cellule vide de Gauche et cellule gagante droite
				Rectangle rect = new Rectangle(intPosX, 30, 72, 95);
				if(a>3) tabHautDroit[a-4] = rect;
				else{
					tabHautGauche[a] = rect;
				}
			}
			intPosX += (a ==3)?255:105;
			intNbCarte = (a>=3)?6:7;
		}
		
		
		//Donne valeur par défault au tableau de cellule final
		
		tabCarteCelluleFinal[0] = new Carte(Enseigne.COEUR, ValeurCarte.AS);
		tabCarteCelluleFinal[1] = new Carte(Enseigne.PIQUE, ValeurCarte.AS);
		tabCarteCelluleFinal[2] = new Carte(Enseigne.TREFLE, ValeurCarte.AS);
		tabCarteCelluleFinal[3] = new Carte(Enseigne.CARREAU, ValeurCarte.AS);				
	}
	
  public void  paintComponent (Graphics g){
	  
	  super.paintComponent(g); 
	  
	  int intDessinX = 40;
	  int intDessinY = 30;
	  int intYBas = 190;
	  
	  String[] TabChemin = {"coeur.gif","pique.gif","trefle.gif","carreau.gif"};
	  
	  for(int q=0;q<4;q++){
		  g.setColor(Color.CYAN);
		  g.drawRect(intDessinX, intDessinY, 72, 95);
		  g.drawRect(intDessinX, intYBas, 72, 95);
		  intDessinX+=105;
	  }
	  	  
	  intDessinX += 150;
	  
	  for(int w=0;w<4;w++){
		  Carte HautGauche = new Carte(intDessinX, intDessinY, new ImageIcon("cartes//" + TabChemin[w]));
		  
		  HautGauche.dessiner(g);
		  //g.drawRect(intDessinX, intDessinY, 72, 95);
		  g.drawRect(intDessinX, intYBas, 72, 95);

		  intDessinX+=105;
		  
	  }
	  
	  for (Stack<Carte> stack : st)
			for (Carte ct : stack)
				ct.dessiner(g);
	  
	  
	  //Dessine Carte de cellule vide
	  for(int l=0;l<4;l++){
		  if(tabCartecelluleVide[l] != null) tabCartecelluleVide[l].dessiner(g);
	  }
	  
	  
	  //Dessine carte de cellule final
	  for(int u= 0; u<tabCarteCelluleFinal.length;u++){  
		  if(tabCarteCelluleFinal[u].getPositionX() != 0) tabCarteCelluleFinal[u].dessiner(g);
	 
	  }
	  
	  
	  if ( carteSelectionnee){
		  c.dessiner(g);
	  }
  }

  	@Override
	public void mouseDragged(MouseEvent e) {
		if (carteSelectionnee){
	        
			nouveauX = e.getX() - deplacementX;
	        nouveauY = e.getY() - deplacementY;
	        
	       // on s'assure de ne pas envoyer la carte hors de la fenetre.
	        nouveauX = Math.max(nouveauX, 0);
	        nouveauX = Math.min(nouveauX, getWidth() - c.getImage().getIconWidth());
	        nouveauY = Math.max( nouveauY , 0);
	        nouveauY  = Math.min( nouveauY , getHeight() -c.getImage().getIconHeight());
	        
	        // nouvelles positions de la carte. 
	        c.setPositionX(nouveauX);
	        c.setPositionY(nouveauY);
	  
	        repaint();  //car la position a changé.
		
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {

		// position actuelle de la souris
		 int x = e.getX();   
	     int y = e.getY();
	     Boolean booCellVide = true;
	     Boolean booValide = false;
	     carteSelectionnee=false;
	    
	     // on vérifie si la souris sur  la carte
	      
	    
	     //Vérifie si la carte sélectionner est dans les cellules vides
	     for(int k=0;k<tabHautGauche.length;k++){
	    	 if(tabHautGauche[k].contains(x,y)){
	    		 carteSelectionnee=  true;
	    		 booCellVide = false;
	    		 boohautBas = true;
	    		 booValide=true;
	    		 
	    		 intColDeplace = k;
	    		 
	    		 c= tabCartecelluleVide[k];
	    		 
	    		 deplacementX = x - c.getPositionX();  
		    	 deplacementY = y - c.getPositionY();
	    	 }
	     }
	       
	     //Vérifie si la carte selectionner est dans le tableau de stack
	     for(int m=0;m<st.length && booCellVide;m++){    	 
	    	 if (st[m].lastElement().getRec().contains(x,y)){
		    	 carteSelectionnee= true;
		    	 boohautBas = false;
		    	 booValide=true;
		    	 
		    	 c=st[m].lastElement();
		    	 
		    	 intColDeplace = m;
		            	     
		    	 deplacementX = x - c.getPositionX();  
		    	 deplacementY = y - c.getPositionY();
		     }
	     }
	                       
	     intSauvegardeX = c.getPositionX();
	     intSauvegardeY = c.getPositionY();	                  
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		
		if(carteSelectionnee){
			Boolean booVersVide = booVersCellVide(x, y);
			Boolean booVersStack;
			Boolean booVersFinal;
			
			
			if(booVersVide == false){
				booVersStack = booVersStack(x, y);
				
				if(booVersStack ==false){
					booVersFinal = booVersCellFinal(x, y);
				}
			}
			
		}
		
		
		if(carteSelectionnee){
			c.setPositionX(intSauvegardeX);
			c.setPositionY(intSauvegardeY);
			carteSelectionnee = false;
		}
		
		repaint();
	}
    
	//Gestion des cartes en direction des cellules vides
	Boolean booVersCellVide(int x,int y){
		Boolean booValidation = false;
		
		for(int b=0;b<4;b++){			
			if(tabHautGauche[b].contains(x,y) && tabCartecelluleVide[b] == null){
				booValidation = true;
				carteSelectionnee = false;				
				
				//Départ CellVide
				if(boohautBas && (b != intColDeplace)){
					//Déplace la carte
					tabCartecelluleVide[b] = tabCartecelluleVide[intColDeplace];
					
					//Supprimer ancien emplacement carte
					tabCartecelluleVide[intColDeplace] = null;					
				}
				
				//Départ stack
				if(boohautBas == false){
					//Déplace la carte
					tabCartecelluleVide[b] = st[intColDeplace].lastElement();
					
					//Supprimer ancien emplacement carte
					st[intColDeplace].pop();
				}
				
				//Nouvelle coordonné			
				tabCartecelluleVide[b].setPositionX((int) tabHautGauche[b].getX());
				tabCartecelluleVide[b].setPositionY((int) tabHautGauche[b].getY());
			}
		}
					
		return booValidation;	
	}
	
	//Gestion des carte en direction du stack
	boolean booVersStack(int x, int y){
		Boolean booValide = false;
		
		for(int n=0;n<st.length;n++){
				
			int intXfutur = st[n].lastElement().getPositionX();
			int intYFutur = st[n].lastElement().getPositionY() + 40;
			
			
			if(!(st[n].isEmpty()) && st[n].lastElement().getRec().contains(x, y) && !(c.getEnseigne().getCouleur()
					.equals(st[n].lastElement().getEnseigne().getCouleur())) && c.getValeur().ordinal() + 1 == (st[n].lastElement().getValeur().ordinal())){
				booValide = true;
				carteSelectionnee = false;
				System.out.println("petit coquin");
				
				//if(st[])
				
				if(boohautBas){
					st[n].push(tabCartecelluleVide[intColDeplace]);
					
					st[n].lastElement().setPositionX(intXfutur);
					st[n].lastElement().setPositionY(intYFutur);
					
					tabCartecelluleVide[intColDeplace] = null;
				}
				else if(boohautBas == false){	
					st[n].push(st[intColDeplace].lastElement());
					
					st[n].lastElement().setPositionX(intXfutur);
					st[n].lastElement().setPositionY(intYFutur);
					st[intColDeplace].pop();
				}		
			}
		}
		
		return booValide;
	}
	
	//Gestion des carte en direction des cellules finals
	Boolean booVersCellFinal(int x, int y){
		Boolean booValidation = false;
		
		for(int h=0;h<4;h++){
			if(tabHautDroit[h].contains(x,y)){
				
				//Valide si une carte devrait être déposer dans les cellules finals
				
				if((tabCarteCelluleFinal[h].getValeur().ordinal() == 0 && c.getValeur().ordinal() == 0) && (tabCarteCelluleFinal[h].getEnseigne()
						.equals(c.getEnseigne()))){
							booValidation = true;
						}
				
				if(((tabCarteCelluleFinal[h].getValeur().ordinal() == 0 && c.getValeur().ordinal() == 0)&& (tabCarteCelluleFinal[h].getEnseigne()
						.equals(c.getEnseigne()))) && (tabCarteCelluleFinal[h].getValeur().ordinal() == 0 && c.getValeur().ordinal() != 0) ||
						((tabCarteCelluleFinal[h].getValeur().ordinal() + 1 == c.getValeur().ordinal()) &&(tabCarteCelluleFinal[h].getEnseigne()
						.equals(c.getEnseigne())))){
					
					carteSelectionnee = false;
					
					//Carte qui vient des cellules vides
					if(boohautBas == false){
						tabCarteCelluleFinal[h] = st[intColDeplace].lastElement();
						
						st[intColDeplace].pop();
					}
					else if(boohautBas){
						tabCarteCelluleFinal[h] = tabCartecelluleVide[intColDeplace];
						
						tabCartecelluleVide[intColDeplace] = null;
					}
					
					
					//Nouvelle possition
					
					tabCarteCelluleFinal[h].setPositionX((int)tabHautDroit[h].getX());
					tabCarteCelluleFinal[h].setPositionY((int)tabHautDroit[h].getY());
				}
			}
		}
		
		return booValidation;
	}
	
	
	
}
