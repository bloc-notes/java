
public class TriBulle {
	static int intTab[] = {26,45,12,6,-33,0,6,22,17,20};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Boolean booNouveauPassage = false;
		 int intVariableTempo;
		 do {
			 booNouveauPassage = false;
			 
			 for(int q=0;q<intTab.length -1;q++){
				 if(intTab[q]>intTab[q+1]){
					 intVariableTempo = intTab[q];
					 intTab[q] = intTab[q+1];
					 intTab[q+1] = intVariableTempo;
					 booNouveauPassage = true;
				 }
			 }
		 } while (booNouveauPassage);
		 
		 for(int w=0;w<intTab.length;w++){
			 System.out.println(intTab[w]);
		 }
	}
}
