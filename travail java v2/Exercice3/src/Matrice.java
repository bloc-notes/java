public class Matrice {
	static long[][] lngTableau = new long[4][4];
	static long[][] lngCarreMagique = new long[5][5];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		remplirTableau();
		afficherTableau(lngTableau);
		
		System.out.println("Somme: " + sommeTableau());
		
		doubleDiagonale();
		afficherTableau(lngTableau);
	
		
		remplirTableau();
		afficherTableau(lngTableau);
		
		long[] lngPetit = petitElement();
		
		System.out.println("Plus petit :"  +  lngPetit[1] + " Colonne: " + lngPetit[0]);
		
		interchangeDonne();
		afficherTableau(lngTableau);
		*/
		/*
		remplirTableau();
		afficherTableau(lngTableau);
		
		transposeTableau();
		afficherTableau(lngTableau);
		*/
		
		carreMagique();
		System.out.println("------------------");
		afficherTableau(lngCarreMagique);
		
		System.out.println(verificationCarreMagique());
	}
	
	public static void remplirTableau(){
		
		for(int intX=0; intX < lngTableau[0].length;intX++){
			int intY = 0;
			if(intX == 0){
				lngTableau[0][0] = 4;
			}
			else{
				lngTableau[intX][intY] = lngTableau[intX - 1][0] + lngTableau[intX - 1][1] - intX;
			}
			
			for(intY=1; intY < lngTableau[0].length; intY++){
				lngTableau[intX][intY] = lngTableau[intX][intY - 1] * 2 + intX;
			}
		}
	}
	
	public static long sommeTableau(){
		int intSommes = 0;
		
		for(long[] ligne : lngTableau){
			for(long intElement: ligne){
				intSommes += intElement;
			}
		}
		return intSommes;
	}
	
	public static void doubleDiagonale(){
		int intY = lngTableau[0].length - 1;
		for(int intW = 0; intW < lngTableau[0].length;intW++){
			lngTableau[intW][intW] = lngTableau[intW][intW] * 2;
			
			lngTableau[intW][intY] = lngTableau[intW][intY] * 2;
			intY--;
		}
	}
	
	public static void afficherTableau(long[][] lngTableauPara){
		for(long[] ligne : lngTableauPara){
			for(long intElement: ligne){
				System.out.println(intElement);
			}
			System.out.println("***");
		}
	}
	
	public static long[] petitElement(){
		long[] intIndexElement = {0,0};
		long lngPlusPetit = Long.MAX_VALUE;
		
		for(int intX=0;intX<lngTableau[0].length;intX++){
			for(int intY=0;intY<lngTableau[0].length;intY++){
				if(lngTableau[intX][intY] < lngPlusPetit){
					lngPlusPetit = lngTableau[intX][intY];
					intIndexElement[0] = intX;
					intIndexElement[1] = lngPlusPetit;
				}
			}
		}
		
		return intIndexElement;
	}
	
	public static void interchangeDonne(){
		int intLimiteTempo = lngTableau[0].length / 2;
		long[][] lngTableauTempo = new long[intLimiteTempo][lngTableau[0].length];
		int intIndexInverse = lngTableau[0].length -1;
		
		transposeTableau();
		
		for(int intIndexTempo = 0; intIndexTempo< intLimiteTempo;intIndexTempo++){
			lngTableauTempo[intIndexTempo] = lngTableau[intIndexTempo];
		}
		
		for(int intX=0;intX < lngTableau[0].length;intX++){
			
			if(intX < intLimiteTempo){
				lngTableau[intX] = lngTableau[intIndexInverse];
				intIndexInverse--;
				System.out.println("bye");
			}
			else{
				if(((lngTableau[0].length % 2) != 0) && ( intX == intLimiteTempo)){
					intIndexInverse--;
					System.out.println("salut");
				}
				else{
					lngTableau[intX] = lngTableauTempo[intIndexInverse];
					intIndexInverse--;
					System.out.println("coucou");
					
				}
			}
		}
		
		transposeTableau();
	}
	
	public static void transposeTableau(){
		long lngTempo= 0;
		
		for(int c=0;c<lngTableau[0].length;c++){
			for(int intg = c+1;intg<lngTableau[0].length;intg++){
				lngTempo = lngTableau[c][intg];
				lngTableau[c][intg] = lngTableau[intg][c];
				lngTableau[intg][c] = lngTempo;	
			}
		}
	}
	
	public static void carreMagique(){
		int intIndexX = lngCarreMagique[0].length /2;
		int intIndexY = 0;
		
		lngCarreMagique[intIndexX][intIndexY] = 1;		
		
		for(int intNumeroInser = 2;intNumeroInser <= lngCarreMagique[0].length* lngCarreMagique[0].length;intNumeroInser++){
			intIndexX++;
			intIndexY--;
			try {
				if(lngCarreMagique[intIndexX][intIndexY] != 0){
					intIndexX--;
					intIndexY+=2;
				}
			} catch (Exception e) {
				// TODO: handle exception
				if(intIndexY < 0 && intIndexX == lngCarreMagique[0].length){
					intIndexX--;
					intIndexY+=2;
				}
				else if (intIndexY < 0) {
					intIndexY = lngCarreMagique[0].length -1;
				}
				else {
					intIndexX = 0;
				}
			}
			
			lngCarreMagique[intIndexX][intIndexY] = intNumeroInser;
		}
	}
	
	public static boolean verificationCarreMagique(){
		boolean booValide = true;
		long lngSommeVerification = 0;
		long lngDroiteTraiteeC = 0;
		long lngDroiteTraiteeL = 0;
		long lngDiagonaleP = 0;
		long lngDiagonaleS = 0;
		
		int intV = lngCarreMagique[0].length - 1;
		
		for(long lngElement:lngCarreMagique[0]){
			lngSommeVerification += lngElement;
		}
		
		//vérification ligne
		for(int x=0;x<lngCarreMagique[0].length;x++){
			for(int y=0;y<lngCarreMagique[0].length;y++){
				lngDroiteTraiteeL += lngCarreMagique[y][x];
				lngDroiteTraiteeC += lngCarreMagique[x][y];
			}
			lngDiagonaleP += lngCarreMagique[x][x];
			lngDiagonaleS += lngCarreMagique[x][intV];
			
			intV--;
			
			booValide = lngDroiteTraiteeC != lngSommeVerification ?false:true;
			booValide = lngDroiteTraiteeL != lngSommeVerification ?false:true;
			
			lngDroiteTraiteeC = 0;
			lngDroiteTraiteeL = 0;
		}
		booValide = lngDiagonaleP != lngSommeVerification ?false:true;
		booValide = lngDiagonaleS != lngSommeVerification ?false:true;
		
		return booValide;
	}

}
