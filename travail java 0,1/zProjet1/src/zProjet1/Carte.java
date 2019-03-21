package zProjet1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Carte {

	private  static final int LARGEUR_CARTE;
    private  static final int HAUTEUR_CARTE; 
    private static final ImageIcon ImageCarteBidon;
    
    private Enseigne enseigne;
	private ValeurCarte valeur; 
	
	private ImageIcon image;
	private int positionX;
	private int positionY;
	
	Rectangle rec;
	
	static {
		ImageCarteBidon = new ImageIcon("cartes\\1pique.gif");
		LARGEUR_CARTE= ImageCarteBidon.getIconWidth();
		HAUTEUR_CARTE= ImageCarteBidon.getIconHeight();
	}

	Carte(int positionX, int positionY, ImageIcon image) {
		this.positionX = positionX;
		this.positionY = positionY; 
		this.image = image;
		rec= new Rectangle(positionX,positionY,ImageCarteBidon.getIconWidth(),ImageCarteBidon.getIconHeight());
	
	}
	
	Carte(Enseigne enseigne, ValeurCarte valeur) {
		this.enseigne= enseigne;
		this.valeur = valeur;
	}
	
	Carte(Enseigne enseigne, ValeurCarte valeur,int positionX, int positionY, ImageIcon image){
		this.enseigne= enseigne;
		this.valeur = valeur;
		this.positionX = positionX;
		this.positionY = positionY; 
		this.image = image;
		rec= new Rectangle(positionX,positionY,ImageCarteBidon.getIconWidth(),ImageCarteBidon.getIconHeight());
	}
	
	public  void setPositionY(int y){
		this.positionY = y;
		rec= new Rectangle(positionX,positionY,ImageCarteBidon.getIconWidth(),ImageCarteBidon.getIconHeight());
	}
	
	
	public  void setPositionX(int x){
		this.positionX = x;
		rec= new Rectangle(positionX,positionY,ImageCarteBidon.getIconWidth(),ImageCarteBidon.getIconHeight());
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}
	
	public boolean estDansCarte(int x , int y ) {
		return (x >= positionX && x < positionX+LARGEUR_CARTE) && (y >= positionY && y < positionY+HAUTEUR_CARTE);
	}
	
	public void dessiner (Graphics g){
		
		image.paintIcon(null,g, positionX, positionY);
		
	}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public void setImageIcon( ImageIcon img) {
		this.image= img;
	}
	
	Rectangle getRec(){
		return rec;
	}
	  
	public String toString() {
		return " Carte ( "+ enseigne.toString()+ "," + valeur.toString()+ enseigne.getCouleur()+")";
		
	}

	public Enseigne getEnseigne() {
		return enseigne;
	}

	public ValeurCarte getValeur() {
		return valeur;
	}
	
}
