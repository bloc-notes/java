//Philippe Doyon
public class CarreMagique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		int [][] TabMagique = new int[5][5];
		
		for(int a = 0;a<TabMagique.length;a++){
			for(int s = 0; s< TabMagique.length;s++){
				TabMagique[a][s] = 0;
			}		
		}
		
		CarreMagique objCM = new CarreMagique();
		
		objCM.ConstruitCarreMagique(TabMagique);
		
		System.out.println("Validation = " + objCM.ValideCarreMagique(TabMagique));
		
		for(int a = 0;a<TabMagique.length;a++){
			System.out.print("\n");
			for(int s = 0; s< TabMagique.length;s++){
				System.out.print(TabMagique[a][s] + " ");
			}		
		}
		
	}
	
	public void ConstruitCarreMagique(int [][] TabMagique){		
		int intDernierLigne = 0;
		int intDernierColonne = Math.round(TabMagique.length / 2);
		
		TabMagique[intDernierLigne][intDernierColonne] = 1;
		
		for(int q = 2; q<= TabMagique.length * TabMagique.length ;q++){
			
			//déborde diagonale
			if((intDernierLigne - 1 == -1) && (intDernierColonne + 1 == TabMagique.length)){
				TabMagique[intDernierLigne +1][intDernierColonne] = q;
				intDernierLigne++;
			}
			//deborde cote
			else if((intDernierColonne + 1) == TabMagique.length){
				TabMagique[intDernierLigne - 1][0] = q;
				intDernierLigne--;
				intDernierColonne = 0;
			}
			//deborde haut
			else if((intDernierLigne - 1) == -1){
				TabMagique[TabMagique.length - 1][intDernierColonne + 1] = q;
				intDernierLigne = TabMagique.length - 1;
				intDernierColonne++;
			}
			//emplacement deja pri
			else if(TabMagique[intDernierLigne - 1][intDernierColonne + 1] != 0){
				TabMagique[intDernierLigne + 1][intDernierColonne] = q;
				intDernierLigne++;
			}
			//correct
			else {
				TabMagique[intDernierLigne - 1][intDernierColonne + 1] = q;
				intDernierLigne--;
				intDernierColonne++;
			}
		}
	}
	
	public boolean ValideCarreMagique(int [][] TabMagique){
		boolean booValide = true;
		
		int [][] TabValidation = new int[2][TabMagique.length + 1];
		
		//ligne
		for(int z = 0; z < TabMagique.length;z++){
			for(int c = 0;c< TabMagique.length;c++){
				TabValidation[0][z] += TabMagique[z][c];
			}
		}
		
		//colonne
		for(int v = 0; v<TabMagique.length;v++){
			for(int b = 0; b<TabMagique.length;b++){
				TabValidation[1][b] += TabMagique[b][v];
			}
		}
		
		//grande diagonale
		for(int r = 0; r<TabMagique.length;r++){
			TabValidation[0][TabMagique.length] += TabMagique[r][r];
		}
		
		//petite diagonale
		int s = TabMagique.length - 1;
		for(int p = 0; p<TabMagique.length;p++){
			TabValidation[1][TabMagique.length] += TabMagique[p][s];
			s--;
		}
		
		
		
		//validation
		for(int u = 0; u < 2;u++){
			for(int o = 0; o <= TabMagique.length; o++){
				System.out.print(TabValidation[u][o] + " ");
				if(TabValidation[0][0] != TabValidation[u][o]){
					booValide = false;
				}
			}
			System.out.println();
		}
		return booValide;
	}
}
