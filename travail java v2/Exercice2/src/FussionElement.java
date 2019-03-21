
public class FussionElement {
	static int intTab[] = {2,3,4,5,6,7,10,16,36,38,42};
	static int intTab2[] = {1,3,9,25,26,27};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intTabFussion[] = new int[intTab.length + intTab2.length];
		
		int intIndexTab1 = 0;
		int intIndexTab2 = 0;
		
		for(int k=0;k<intTabFussion.length-1;k++){
			if(intIndexTab1 == -1){
				intTabFussion[k] = intTab2[intIndexTab2];
				intIndexTab2++;
			}
			else if(intIndexTab2 == -1){
				intTabFussion[k] = intTab[intIndexTab1];
				intIndexTab1++;
			}
			else if (intTab[intIndexTab1]<intTab2[intIndexTab2]) {
				intTabFussion[k] = intTab[intIndexTab1];
				intIndexTab1++;
			}
			else if (intTab[intIndexTab1] > intTab2[intIndexTab2]) {
				intTabFussion[k] = intTab2[intIndexTab2];
				intIndexTab2++;
			}
			else{
				intTabFussion[k] = intTab[intIndexTab1];		
				intTabFussion[k+1] = intTab2[intIndexTab2];
				
				intIndexTab2++;
				intIndexTab1++;
				k++;
			}
			
			if(intIndexTab1 == intTab.length){
				intIndexTab1 = -1;
			}
			
			if(intIndexTab2 == intTab2.length){
				intIndexTab2 = -1;
			}
		}
		
		for(int d = 0; d<intTabFussion.length -1;d++){
			System.out.println(intTabFussion[d]);
		}
	}

}
