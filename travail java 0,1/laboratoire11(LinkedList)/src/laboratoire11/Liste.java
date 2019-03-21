package laboratoire11;

import java.util.Iterator;
import java.util.LinkedList;

public class Liste {
	public Liste(String strNom) {
		this.strNom = strNom;
	}
	String strNom;
	LinkedList<Object> maListe = new LinkedList<Object>();
	
	public boolean estVide(){
		return(maListe.isEmpty());
	}
	
	public void insererEnTete(Object obj){
		maListe.addFirst(obj);
	}
	
	public void insererEnQueue(Object obj){
		maListe.addLast(obj);
	}
	
	Object retirerDeTete(){
		if(estVide() == true){
			try{
			throw new ListeVideException(strNom);
			}catch(ListeVideException e){
				return(e.toString());
			}
		}
		else
		 return(maListe.removeFirst() + " retiré");
	}
	
	Object retirerDeQueue(){
		if(estVide() == true){
			try{
				throw new ListeVideException(strNom);
			}catch(ListeVideException e){
				return(e.toString());
			}
		}
		else
			return(maListe.removeLast() + " retiré");
	}
	
	public void parcourirAvecIterateur(){
		Iterator<Object> it = maListe.iterator();
		
		System.out.println("Affichage liste");
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public void parcourirAvecIndex(){
		System.out.println("Affichage liste");
		
		for(int x = 0; x< maListe.size();x++){
			System.out.println(maListe.get(x));
		}
	}
	
	public void concatener(Liste l2){
		maListe.addAll(l2.getMaListe());
	}

	public LinkedList<Object> getMaListe() {
		return maListe;
	}
}