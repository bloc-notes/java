//Philippe Doyon

public class Exercise_Tableau {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tabMagique [][] = new int[4][4];
		
		Exercise_Tableau objExer = new Exercise_Tableau();
		
		objExer.DefinirTableau(tabMagique);
		objExer.TransposerMatrise(tabMagique);
		
		System.out.println(tabMagique[0][3]);
		
		for(int w=0;w<4;w++){
			for(int e = 0;e<4;e++){
				System.out.println(tabMagique[w][e]);
			}
		}
		
	}
	
	public void DefinirTableau(int [][] tabMagique){
		tabMagique[0][0] = 4;
		
		for(int q = 1;q <4; q++){
			tabMagique[0][q] = (tabMagique[0][q-1] * 3) - 1 ;
			
		}	
			
		for(int a=0;a<4;a++){
			for(int z=1;z<4;z++){
				tabMagique[z][a] = (tabMagique[z-1][a] *2) + a; 
			}
		}
	}
	
	public int SommeDuTableau(int [][] tabMagique){
		int intSomme = 0;
		
		for(int w=0;w<4;w++){
			for(int e = 0;e<4;e++){
				intSomme += tabMagique[e][w];
			}
		}
		
		return intSomme;
	}
	
	public void DoublerDiagonale(int [][] tabMagique){
		//grande diagonale
		for(int y= 0; y<4;y++){
			tabMagique[y][y] = tabMagique[y][y] * 2;
		}
		
		//petite diagonale
		int s = 3;
		for(int g = 0;g<4;g++){
			tabMagique[g][s] = tabMagique[g][s] * 2;
			s--;
		}
	}
	
	public void ChangerLigne(int[][] tabMagique){
		
		int [] tabTempo = new int [tabMagique.length];
		int [] tabTempo2 = new int [tabMagique.length];
		
		for(int r = 0;r<tabMagique.length;r++){
			tabTempo[r] = tabMagique[r][3];
			tabTempo2[r] = tabMagique[r][1];
		}
		
		for(int e = 0;e<4;e++){
			tabMagique[e][3] = tabMagique[e][0];
			tabMagique[e][0] = tabTempo[e];
			
			tabMagique[e][1] = tabMagique[e][2];
			tabMagique[e][2] = tabTempo2[e];
		}
		
	}
	
	public void TransposerMatrise(int[][] tabMagique){
		int intTempo= 0;
		int intLigne = 4;
		int intColonne =0;
		
		for(int c=intColonne;c<3;c++){
			for(int g = c+1;g<intLigne;g++){
				intTempo = tabMagique[c][g];
				tabMagique[c][g] = tabMagique[g][c];
				tabMagique[g][c] = intTempo;
				
				
			}
			intColonne++;
		}	
	}
}
